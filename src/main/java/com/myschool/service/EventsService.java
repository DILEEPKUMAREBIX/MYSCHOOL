package com.myschool.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
@Transactional
public class EventsService {


	@Value("${aws-s3.Consolelink}")
	private String endpointUrl;

	@Value("${aws-s3.bucket}")
	private String bucketName;

	@Autowired
	private AmazonS3 s3client;

	@Transactional
	public boolean uploadFile(MultipartFile[] Files) {
		boolean isFlag=true;
		for(MultipartFile file:Files) {
			try {
				File file1 = convertMultiPartToFile(file);
				String fileName = generateFileName(file);
				uploadFileTos3bucket(fileName, file1);
				file1.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return isFlag;


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

	/*
	 * public String deleteFileFromS3Bucket(String fileUrl) { String fileName =
	 * fileUrl.substring(fileUrl.lastIndexOf("/") + 1); s3client.deleteObject(new
	 * DeleteObjectRequest(bucketName, fileName)); return "Successfully deleted"; }
	 */
	public List<String> listFiles() {
		String fileUrl="";
		ListObjectsRequest listObjects = 
				new ListObjectsRequest()
				.withBucketName(bucketName);
		List<String> fileurls = new ArrayList<>();
		ObjectListing objects = s3client.listObjects(listObjects);
		while (true) {
			List<S3ObjectSummary> summaries = objects.getObjectSummaries();
			if (summaries.size() < 1) {
				break;
			}
			for (S3ObjectSummary item : summaries) {
				fileUrl = endpointUrl + "/" + bucketName + "/" + item.getKey();
				fileurls.add(fileUrl);
			}
			objects = s3client.listNextBatchOfObjects(objects);
		}
		return fileurls;
	}
}
