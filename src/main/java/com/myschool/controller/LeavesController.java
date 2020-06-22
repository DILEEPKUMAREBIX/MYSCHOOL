package com.myschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myschool.service.LeavesService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "LeavesController", description = "LeavesController")
@RequestMapping("/myschool")
@CrossOrigin
public class LeavesController {
	
	@Autowired
	private LeavesService leavesservice;

}
