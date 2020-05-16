package com.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myschool.Dto.CMGroupValuesDto;
import com.myschool.service.CommonService;
import com.myschool.service.SchoolService;
import com.myschool.service.UserService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "other operations", description = "other operations")
@RequestMapping("/myschool")
public class CommonController {

	@Autowired
	private SchoolService schoolservice;

	@Autowired
	private UserService userservice;
	
	@Autowired
	private CommonService commonservice;

	@GetMapping(value = "/schoolscount")
	public ResponseEntity<Long>  getSchoolsCount() {
		return new ResponseEntity<Long>(schoolservice.getSchoolsCount(), HttpStatus.OK);

	}
	@GetMapping(value = "/userscount")
	public ResponseEntity<Long> getUsersCount() {
		return new ResponseEntity<Long>(userservice.getUserCount(), HttpStatus.OK);		
	}
	
	@GetMapping(value = "/groupdata")
	public ResponseEntity<List<CMGroupValuesDto>> getGroupValueData(){
		return new ResponseEntity<List<CMGroupValuesDto>>(commonservice.getGroupValueData(), HttpStatus.OK);
	}

}
