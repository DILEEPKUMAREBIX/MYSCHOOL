package com.myschool.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myschool.entity.UserEntity;
import com.myschool.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "User CRUD", description = "Manage Users")
@RequestMapping("/myschool")
@CrossOrigin
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ApiOperation(value = "View a list of available users", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/users")
	private List<UserEntity> getUsers() {
		logger.info("controller list of users::::::::::::::::");
		return userService.getUsers();
	}

	// Single item
	@ApiOperation(value = "View a user", response = Iterable.class)
	@GetMapping("/users/{id}")
	UserEntity getUser(@PathVariable Long id) {
		logger.info("controller get user with id::::::::::::" + id);
		return userService.getUser(id);
	}

	@ApiOperation(value = "Create a new user", nickname = "Create User")
	@PostMapping(value = "/users", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
		logger.info("controller user saved sucessfully:::::::::::::");
		return new ResponseEntity<UserEntity>(userService.saveUser(user), HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  user", nickname = "UpdateOrCreateUser")
	@PutMapping("/users/{id}")
	UserEntity updateUser(@RequestBody UserEntity newUser, @PathVariable Long id) {
		logger.info("controller user updated with id :::::::::::" + id);
		return userService.updateUser(newUser, id);
	}

	@ApiOperation(value = "Delete a user", nickname = "Delete User")
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		logger.info("controller user daleted with id :::::::::" + id);
		userService.deleteUser(id);
	}

	@ApiOperation(value = "fileupload to save user data", nickname = "fileupload to save user data")
	@PostMapping(value = "/users/usersupload")
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file
			/* @ModelAttribute UserEntity userentity */) {
		boolean isFlag = userService.saveDatafromUploadedfile(file);
		String msg;
		if (isFlag) {
			msg = "file uploaded successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			msg = "file uploaded not done,please try again";
			return new ResponseEntity<String>(msg, HttpStatus.EXPECTATION_FAILED);
		}

	}

}
