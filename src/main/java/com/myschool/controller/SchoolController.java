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

import com.myschool.entity.SchoolEntity;
import com.myschool.service.SchoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "School CRUD", description = "Manage Schools list")
@RequestMapping("/myschool")
@CrossOrigin
public class SchoolController {
	
	private static final Logger logger = LogManager.getLogger(SchoolController.class);

	@Autowired
	private SchoolService schoolService;

	@ApiOperation(value = "View a list of available schools", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/schools")
	private List<SchoolEntity> getSchools() {
		logger.info("controller list of schools :::::::::::" );
		return schoolService.getSchools();
	}

	// Single item
	@ApiOperation(value = "View a school", response = Iterable.class)
	@GetMapping("/schools/{id}")
	SchoolEntity getSchool(@PathVariable Long id) {
		logger.info("controller selected school details with id:::::::::::"+id );
		return schoolService.getSchool(id);
	}

	@ApiOperation(value = "Create a new school", nickname = "CreateSchool")
	@PostMapping(value = "/schools", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<SchoolEntity> saveSchool(@RequestBody SchoolEntity school) {
		
		logger.info("controller school saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<SchoolEntity>(schoolService.saveSchool(school), HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  school", nickname = "UpdateOrCreateSchool")
	@PutMapping("/schools/{id}")
	SchoolEntity updateSchool(@RequestBody SchoolEntity newSchool, @PathVariable Long id) {
		logger.info("controller school updated with id:::::::::::"+id );
		
		return schoolService.updatedSchool(newSchool, id);
	}

	@ApiOperation(value = "Delete a  school", nickname = "DeleteSchool")
	@DeleteMapping("/schools/{id}")
	void deleteSchool(@PathVariable Long id) {
		logger.info("controller school deleted with id:::::::::::"+id );
		schoolService.deleteEmployee(id);
	}

}
