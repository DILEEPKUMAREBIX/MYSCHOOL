package com.myschool.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myschool.entity.SchoolClassPeriodsEntity;
import com.myschool.service.SchoolClassPeriodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "schoolclassperiods CRUD", description = "Manage schoolclassperiods list")
@RequestMapping("/myschool")
public class SchoolClassPeriodsController {

	@Autowired
	private SchoolClassPeriodsService schoolclassperiodsservice;
	
	private static final Logger logger = LogManager.getLogger(SchoolClassPeriodsController.class);


	@ApiOperation(value = "View a list of available schoolclassperiods", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/schools")
	private List<SchoolClassPeriodsEntity> getschoolclassperiods() {
		List<SchoolClassPeriodsEntity> schoolclassperiodlist=schoolclassperiodsservice.getschoolclassperiod();
		logger.info("controller list of schools :::::::::::" );
		return schoolclassperiodlist;
	}

	// Single item
	@ApiOperation(value = "View a school", response = Iterable.class)
	@GetMapping("/schools/{id}")
	SchoolClassPeriodsEntity getSchool(@PathVariable Long id) {
		
		SchoolClassPeriodsEntity schoolclassperiod=	schoolclassperiodsservice.getschoolclassperiod(id);
		
		logger.info("controller selected schoolclassperiod details with id:::::::::::"+id );
		return schoolclassperiod;
	}

	@ApiOperation(value = "Create a new schoolclassperiod", nickname = "Createschoolclassperiod")
	@PostMapping(value = "/schools", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<SchoolClassPeriodsEntity> saveschoolclassperiod(@RequestBody SchoolClassPeriodsEntity schoolclassperiod) {
		SchoolClassPeriodsEntity schoolclassperiodobj=schoolclassperiodsservice.saveschoolclassperiod(schoolclassperiod);
		logger.info("controller school saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<SchoolClassPeriodsEntity>(schoolclassperiodobj, HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  schoolclassperiod", nickname = "UpdateOrCreateschoolclassperiod")
	@PutMapping("/schools/{id}")
	SchoolClassPeriodsEntity updateschoolclassperiod(@RequestBody SchoolClassPeriodsEntity newschoolclassperiod, @PathVariable Long id) {
		
		SchoolClassPeriodsEntity schoolclassperiodobj1=schoolclassperiodsservice.updatedschoolclassperiod(newschoolclassperiod, id);
		logger.info("controller school updated with id:::::::::::"+id );
		
		return schoolclassperiodobj1;
	}

	@ApiOperation(value = "Delete a  school", nickname = "DeleteSchool")
	@DeleteMapping("/schools/{id}")
	void deleteschoolclassperiod(@PathVariable Long id) {
		logger.info("controller school deleted with id:::::::::::"+id );
		schoolclassperiodsservice.deleteschoolclassperiod(id);
	}

}
