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

import com.myschool.entity.AttendanceEntity;
import com.myschool.service.AttendanceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/myAttendance")
public class AttendanceController {

	private static final Logger logger = LogManager.getLogger(AttendanceController.class);
	
	@Autowired
	private AttendanceService attendenceservice;
	
	@ApiOperation(value = "View a list of available attendance", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/attendance")
	private List<AttendanceEntity> getAllAttendances() {
		List<AttendanceEntity> attendancelist=attendenceservice.getattendences();
		logger.info("controller list of Attendances :::::::::::" );
		return attendancelist;
	}

	// Single item
	@ApiOperation(value = "View a Attendance", response = Iterable.class)
	@GetMapping("/Attendances/{id}")
	AttendanceEntity getAttendance(@PathVariable Long id) {
		
		AttendanceEntity Attendance=	attendenceservice.getattendence(id);
		
		logger.info("controller selected Attendance details with id:::::::::::"+id );
		return Attendance;
	}

	@ApiOperation(value = "Create a new Attendance", nickname = "CreateAttendance")
	@PostMapping(value = "/Attendances", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<AttendanceEntity> saveAttendance(@RequestBody AttendanceEntity Attendance) {
		AttendanceEntity attendenceobj=attendenceservice.saveattendence(Attendance);
		logger.info("controller Attendance saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<AttendanceEntity>(attendenceobj, HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  Attendance", nickname = "UpdateOrCreateAttendance")
	@PutMapping("/Attendances/{id}")
	AttendanceEntity updateAttendance(@RequestBody AttendanceEntity newAttendance, @PathVariable Long id) {
		
		AttendanceEntity attendenceobj1=attendenceservice.updatedattendence(newAttendance, id);
		logger.info("controller Attendance updated with id:::::::::::"+id );
		
		return attendenceobj1;
	}

	@ApiOperation(value = "Delete a  Attendance", nickname = "DeleteAttendance")
	@DeleteMapping("/Attendances/{id}")
	void deleteAttendance(@PathVariable Long id) {
		logger.info("controller Attendance deleted with id:::::::::::"+id );
		attendenceservice.deleteattenadnce(id);;
	}
}
