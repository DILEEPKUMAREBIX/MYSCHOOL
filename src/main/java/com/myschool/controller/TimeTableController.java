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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myschool.entity.TimeTableEntity;
import com.myschool.service.TimeTableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "timetable CRUD", description = "Manage timetable list")
@RequestMapping("/myschool")
public class TimeTableController {

	private static final Logger logger = LogManager.getLogger(TimeTableController.class);
	
	@Autowired
	private TimeTableService timetableservice;

	@ApiOperation(value = "View a list of available timetables", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/timetables")
	private List<TimeTableEntity> gettimetables() {
		List<TimeTableEntity> timetablelist=timetableservice.gettimetables();
		logger.info("controller list of timetables :::::::::::" );
		return timetablelist;
	}

	// Single item
	@ApiOperation(value = "View a timetable", response = Iterable.class)
	@GetMapping("/timetables/{id}")
	TimeTableEntity gettimetable(@PathVariable Long id) {
		
		TimeTableEntity timetable=	timetableservice.gettimetable(id);
		
		logger.info("controller selected timetable details with id:::::::::::"+id );
		return timetable;
	}

	@ApiOperation(value = "Create a new timetable", nickname = "Createtimetable")
	@PostMapping(value = "/timetables", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<TimeTableEntity> savetimetable(@RequestBody TimeTableEntity timetable) {
		TimeTableEntity timetableobj=timetableservice.savetimetable(timetable);
		logger.info("controller timetable saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<TimeTableEntity>(timetableobj, HttpStatus.OK);
	}

	/*
	 * @ApiOperation(value = "Update/Create a  timetable", nickname =
	 * "UpdateOrCreatetimetable")
	 * 
	 * @PutMapping("/timetables/{id}") TimeTableEntity updatetimetable(@RequestBody
	 * TimeTableEntity newtimetable, @PathVariable Long id) {
	 * 
	 * TimeTableEntity timetableobj1=timetableservice.updatedtimetable(newtimetable,
	 * id); logger.info("controller timetable updated with id:::::::::::"+id );
	 * 
	 * return timetableobj1; }
	 */
	@ApiOperation(value = "Delete a  timetable", nickname = "Deletetimetable")
	@DeleteMapping("/timetables/{id}")
	void deletetimetable(@PathVariable Long id) {
		logger.info("controller timetable deleted with id:::::::::::"+id );
		timetableservice.deletetimetable(id);
	}

}
