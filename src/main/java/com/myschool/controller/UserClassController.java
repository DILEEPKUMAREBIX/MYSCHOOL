package com.myschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myschool.entity.UserClassEntity;
import com.myschool.service.UserClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "UserClass CRUD", description = "Manage Users Class")
@RequestMapping("/myschool")
@CrossOrigin
public class UserClassController {

	@Autowired
	private UserClassService userClassService;
	
	@ApiOperation(value = "View user classs", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/userclass")
	private List<UserClassEntity> getUserClass() {
		return userClassService.getUserClasses();
	}

	// Single item
	@ApiOperation(value = "View a user class ", response = Iterable.class)
	@GetMapping("/userclass/{id}")
	UserClassEntity getUserClass(@PathVariable Long id) {
		return userClassService.getuserClass(id);
	}

	@ApiOperation(value = "Create a new user class", nickname = "Create userclass")
	@PostMapping(value = "/userclass", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<UserClassEntity> saveUserClass(@RequestBody UserClassEntity userclass) {
		return new ResponseEntity<UserClassEntity>(userClassService.saveUserClass(userclass), HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  userclass", nickname = "UpdateOrCreate userclass")
	@PutMapping("/userclass/{id}")
	UserClassEntity updateUserClass(@RequestBody UserClassEntity newuserclass, @PathVariable Long id) {
		return userClassService.replaceUserClass(newuserclass, id);
	}

	@ApiOperation(value = "Delete a  userclass", nickname = "Delete userclass")
	@DeleteMapping("/userclass/{id}")
	void deleteSchool(@PathVariable Long id) {
		userClassService.deleteUserClass(id);;
	}
	
}
