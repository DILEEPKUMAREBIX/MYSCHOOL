package com.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myschool.service.EventsService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "event images operations", description = "event images operations")
@RequestMapping("/myschool")
@CrossOrigin
public class EventsController {
	

@Autowired
	private EventsService eventservice;
	
	 @SuppressWarnings("unused")
	@PostMapping("/uploadFile")
	    public ResponseEntity<String>  uploadFile(@RequestParam(value = "file") MultipartFile[] files) {
	String msg="";
	boolean	isFlag= eventservice.uploadFile(files);
	if(isFlag=true) {
		  msg="files uploaded successfully";
		 return new ResponseEntity<String>(msg ,HttpStatus.OK);
	}else {
		 msg="files not uploaded";
		 return new ResponseEntity<String>(msg ,HttpStatus.EXPECTATION_FAILED);
	}

		
	        
	    }
	 
	 @GetMapping("/allfiles")
	 public ResponseEntity<List<String>> listAllFiles(){
	   return new ResponseEntity<List<String>>( eventservice.listFiles(),HttpStatus.OK);
	 }
}
