package com.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	 @PostMapping("/uploadFile")
	    public ResponseEntity<List<String>>  uploadFile(@RequestParam(value = "file") MultipartFile[] files) {
	        return new ResponseEntity<List<String>>( eventservice.uploadFile(files),HttpStatus.OK);
	    }

}
