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
import org.springframework.web.bind.annotation.RestController;

import com.myschool.entity.LeavesEntity;
import com.myschool.service.LeavesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "LeavesController", description = "LeavesController")
@RequestMapping("/myschool")
@CrossOrigin
public class LeavesController {
	
	@Autowired
	private LeavesService leavesservice;

	
	private static final Logger logger = LogManager.getLogger(LeavesController.class);

	@ApiOperation(value = "View a list of available Leaves", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/Leaves")
	private List<LeavesEntity> getLeaves() {
		List<LeavesEntity> Leavelist=leavesservice.getLeaves();
		logger.info("controller list of Leaves :::::::::::" );
		return Leavelist;
	}

	// Single item
	@ApiOperation(value = "View a Leave", response = Iterable.class)
	@GetMapping("/Leaves/{id}")
	LeavesEntity getLeave(@PathVariable Long id) {
		
		LeavesEntity Leave=	leavesservice.getLeave(id);
		
		logger.info("controller selected Leave details with id:::::::::::"+id );
		return Leave;
	}

	@ApiOperation(value = "Create a new Leave", nickname = "CreateLeave")
	@PostMapping(value = "/Leaves", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<LeavesEntity> saveLeave(@RequestBody LeavesEntity Leave) {
		LeavesEntity Leaveobj=leavesservice.saveLeave(Leave);
		logger.info("controller Leave saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<LeavesEntity>(Leaveobj, HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  Leave", nickname = "UpdateOrCreateLeave")
	@PutMapping("/Leaves/{id}")
	LeavesEntity updateLeave(@RequestBody LeavesEntity newLeave, @PathVariable Long id) {
		
		LeavesEntity Leaveobj1=leavesservice.updatedLeave(newLeave, id);
		logger.info("controller Leave updated with id:::::::::::"+id );
		
		return Leaveobj1;
	}

	@ApiOperation(value = "Delete a  Leave", nickname = "DeleteLeave")
	@DeleteMapping("/Leaves/{id}")
	void deleteLeave(@PathVariable Long id) {
		logger.info("controller Leave deleted with id:::::::::::"+id );
		leavesservice.deleteLeave(id);
	}

}
