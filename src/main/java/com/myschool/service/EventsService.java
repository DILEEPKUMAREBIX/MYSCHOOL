package com.myschool.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.myschool.entity.EventsEntity;
import com.myschool.repository.EventsRepository;

@Service
@Transactional
public class EventsService {

	private static String SUFFIX = "/";

	@Value("${aws.Consolelink}")
	private String endpointUrl;

	@Value("${aws.bucket}")
	private String bucketName;

	@Autowired
	private AmazonS3 s3client;

	@Autowired
	EventsService eventsservice;

	@Autowired
	EventsRepository eventsrepo;

	@Transactional
	public boolean uploadFile(MultipartFile[] Files,String foldername) {

		boolean isFlag=true;
		for(MultipartFile file:Files) {
			try {
				File file1 = convertMultiPartToFile(file);
				String fileName = generateFileName(file);
				String fileNamewithfolder = foldername + SUFFIX + fileName;
				uploadFileTos3bucket(fileNamewithfolder, file1);
				file1.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isFlag;
	}


	public List<String> getAllFilesInFolder(String foldername) {
		String filrUrl="";
		if (!SUFFIX.endsWith(SUFFIX)) {
			SUFFIX += SUFFIX;
		}
		List<String> keys = new ArrayList<>();
		List<String> fileurls = new ArrayList<>();
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
				.withBucketName(bucketName).withPrefix(foldername+SUFFIX);

		ObjectListing objects = s3client.listObjects(listObjectsRequest); 
		for (;;) {
			List<S3ObjectSummary> summaries = objects.getObjectSummaries();
			if
			(summaries.size() < 1) {
				break;
			} summaries.forEach(s ->
			keys.add(s.getKey())); objects = s3client.listNextBatchOfObjects(objects); }
		for(String key:keys) {
			filrUrl=endpointUrl+SUFFIX+bucketName+SUFFIX+key;
			fileurls.add(filrUrl);
		}
		fileurls.remove(0);
		return fileurls;    
	}


	public String createFolder(EventsEntity newevent) {

		String foldername=eventsservice.saveEventDetails(newevent);
		
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				foldername + SUFFIX, emptyContent, metadata);
		// send request to S3 to create folder
		s3client.putObject(putObjectRequest);
		return foldername;
	}


	public String saveEventDetails(EventsEntity newevent) {
		String foldername=
				
				
				newevent.getSchoolIdno()+"."
				+newevent.getClassId()+"."+newevent.getSectionId()+"."+newevent.getEventName();

		EventsEntity event=new EventsEntity();
		event.setSchoolIdno(newevent.getSchoolIdno());
		event.setClassId(newevent.getClassId());
		event.setSectionId(newevent.getSectionId());
		event.setEventName(newevent.getEventName());
		event.setEventDate(newevent.getEventDate());
		event.setFoldername(foldername);
		eventsrepo.save(event);
		return foldername;
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	private void uploadFileTos3bucket(String fileName, File file) {
		s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public String deleteFileFromFolder(String filename,String foldername) { 
		String bucket=bucketName+SUFFIX+foldername;
		//String fileName =fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
		s3client.deleteObject(new DeleteObjectRequest(bucket, filename)); 
		System.out.println("image deleted");
		return "Deleted file name :"+filename;
	}

	public String deleteFolder( String foldername) {
		EventsEntity event=eventsrepo.findByFoldername(foldername);
	eventsrepo.deleteById(event.getEventId());
		for (S3ObjectSummary listOfFolders : s3client.listObjects(bucketName,foldername).getObjectSummaries()){
			s3client.deleteObject(bucketName, listOfFolders.getKey());
		}
		
		return "Deleted folder name :"+foldername +"with id :"+event.getEventId();
	}


	public List<EventsEntity> findAll() {
		return eventsrepo.findAll();
	}

}
