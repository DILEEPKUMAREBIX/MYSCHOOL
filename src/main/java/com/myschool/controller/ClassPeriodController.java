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

import com.myschool.entity.ClassPeriodEntity;
import com.myschool.service.ClassPeriodService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "ClassPeriod CRUD", description = "Manage classperiod list")
@RequestMapping("/myschool")
@CrossOrigin(origins ="http://localhost:4200")
public class ClassPeriodController {
	
	private static final Logger logger = LogManager.getLogger(ClassPeriodController.class);

	@Autowired
	private ClassPeriodService classperiodservice;

	@ApiOperation(value = "View a list of classperiods", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/classperiod")
	private List<ClassPeriodEntity> getclassperiod() {
		List<ClassPeriodEntity> ClassPeriodlist=classperiodservice.getclassperiods();
		logger.info("controller list of classperiod :::::::::::" );
		return ClassPeriodlist;
	}

	// Single item
	@ApiOperation(value = "View a ClassPeriod", response = Iterable.class)
	@GetMapping("/classperiod/{id}")
	ClassPeriodEntity getClassPeriod(@PathVariable Long id) {
		
		ClassPeriodEntity ClassPeriod=	classperiodservice.getClassPeriod(id);
		
		logger.info("controller selected ClassPeriod details with id:::::::::::"+id );
		return ClassPeriod;
	}

	@ApiOperation(value = "Create a new ClassPeriod", nickname = "CreateClassPeriod")
	@PostMapping(value = "/classperiod", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<ClassPeriodEntity> saveClassPeriod(@RequestBody ClassPeriodEntity ClassPeriod) {
		ClassPeriodEntity ClassPeriodobj=classperiodservice.saveClassPeriod(ClassPeriod);
		logger.info("controller ClassPeriod saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<ClassPeriodEntity>(ClassPeriodobj, HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  ClassPeriod", nickname = "UpdateOrCreateClassPeriod")
	@PutMapping("/classperiod/{id}")
	ClassPeriodEntity updateClassPeriod(@RequestBody ClassPeriodEntity newClassPeriod, @PathVariable Long id) {
		
		ClassPeriodEntity ClassPeriodobj1=classperiodservice.updatedClassPeriod(newClassPeriod, id);
		logger.info("controller ClassPeriod updated with id:::::::::::"+id );
		
		return ClassPeriodobj1;
	}

	@ApiOperation(value = "Delete a  ClassPeriod", nickname = "DeleteClassPeriod")
	@DeleteMapping("/classperiod/{id}")
	void deleteClassPeriod(@PathVariable Long id) {
		logger.info("controller ClassPeriod deleted with id:::::::::::"+id );
		classperiodservice.deleteClassPeriod(id);
	}

}
