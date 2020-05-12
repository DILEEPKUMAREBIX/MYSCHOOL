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

	@Autowired
	private UserService userService;

	@ApiOperation(value = "View a list of available users", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/users")
	private List<UserEntity> getUsers() {
		return userService.getUsers();
	}

	// Single item
	@ApiOperation(value = "View a user", response = Iterable.class)
	@GetMapping("/users/{id}")
	UserEntity getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}

	@ApiOperation(value = "Create a new user", nickname = "Create User")
	@PostMapping(value = "/users", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
		return new ResponseEntity<UserEntity>(userService.saveUser(user), HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  user", nickname = "UpdateOrCreateUser")
	@PutMapping("/users/{id}")
	UserEntity updateUser(@RequestBody UserEntity newUser, @PathVariable Long id) {
		return userService.updateUser(newUser, id);
	}

	@ApiOperation(value = "Delete a user", nickname = "Delete User")
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
