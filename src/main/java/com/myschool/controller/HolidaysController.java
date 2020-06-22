package com.myschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myschool.service.HolidaysService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "HolidaysController", description = "HolidaysController")
@RequestMapping("/myschool")
@CrossOrigin
public class HolidaysController {
	
	@Autowired
	private HolidaysService holidaysservice;

}
