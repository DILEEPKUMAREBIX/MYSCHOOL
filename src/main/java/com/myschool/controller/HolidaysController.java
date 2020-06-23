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


import com.myschool.entity.HolidaysEntity;
import com.myschool.service.HolidaysService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "HolidaysController", description = "HolidaysController")
@RequestMapping("/myschool")
@CrossOrigin
public class HolidaysController {
	
	@Autowired
	private HolidaysService holidaysservice;

	private static final Logger logger = LogManager.getLogger(HolidaysController.class);


	@ApiOperation(value = "View a list of available Holidays", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/Holidays")
	private List<HolidaysEntity> getHolidays() {
		List<HolidaysEntity> Holidaylist=holidaysservice.getHolidays();
		logger.info("controller list of Holidays :::::::::::" );
		return Holidaylist;
	}

	// Single item
	@ApiOperation(value = "View a Holiday", response = Iterable.class)
	@GetMapping("/Holidays/{id}")
	HolidaysEntity getHoliday(@PathVariable Long id) {
		
		HolidaysEntity Holiday=	holidaysservice.getHoliday(id);
		
		logger.info("controller selected Holiday details with id:::::::::::"+id );
		return Holiday;
	}

	@ApiOperation(value = "Create a new Holiday", nickname = "CreateHoliday")
	@PostMapping(value = "/Holidays", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<HolidaysEntity> saveHoliday(@RequestBody HolidaysEntity Holiday) {
		HolidaysEntity Holidayobj=holidaysservice.saveHoliday(Holiday);
		logger.info("controller Holiday saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<HolidaysEntity>(Holidayobj, HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  Holiday", nickname = "UpdateOrCreateHoliday")
	@PutMapping("/Holidays/{id}")
	HolidaysEntity updateHoliday(@RequestBody HolidaysEntity newHoliday, @PathVariable Long id) {
		
		HolidaysEntity Holidayobj1=holidaysservice.updatedHoliday(newHoliday, id);
		logger.info("controller Holiday updated with id:::::::::::"+id );
		
		return Holidayobj1;
	}

	@ApiOperation(value = "Delete a  Holiday", nickname = "DeleteHoliday")
	@DeleteMapping("/Holidays/{id}")
	void deleteHoliday(@PathVariable Long id) {
		logger.info("controller Holiday deleted with id:::::::::::"+id );
		holidaysservice.deleteHoliday(id);
	}

}
