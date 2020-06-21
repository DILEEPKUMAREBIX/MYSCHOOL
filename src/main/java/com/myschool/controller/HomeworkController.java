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

import com.myschool.entity.HomeWorkEntity;
import com.myschool.service.HomeWorkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Homework Controller", description = "Manage homeworks list")
@RequestMapping("/myschool")
@CrossOrigin
public class HomeworkController {
	
	private static final Logger logger = LogManager.getLogger(HomeworkController.class);
	
	@Autowired
	private HomeWorkService homeworkservice;
	


	@ApiOperation(value = "View a list of homeworks", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/homework")
	private List<HomeWorkEntity> gethomeworks() {
		List<HomeWorkEntity> homeworklist=homeworkservice.gethomeworks();
		logger.info("controller list of homeworks :::::::::::" );
		return homeworklist;
	}

	// Single item
	@ApiOperation(value = "View a homework", response = Iterable.class)
	@GetMapping("/homework/{id}")
	HomeWorkEntity gethomework(@PathVariable Long id) {
		
		HomeWorkEntity homework=	homeworkservice.gethomework(id);
		
		logger.info("controller selected homework details with id:::::::::::"+id );
		return homework;
	}

	@ApiOperation(value = "Create a new homework", nickname = "Createhomework")
	@PostMapping(value = "/homework", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<HomeWorkEntity> savehomework(@RequestBody HomeWorkEntity homework) {
		HomeWorkEntity homeworkobj=homeworkservice.savehomework(homework);
		logger.info("controller homework saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<HomeWorkEntity>(homeworkobj, HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  homework", nickname = "UpdateOrCreatehomework")
	@PutMapping("/homework/{id}")
	HomeWorkEntity updatehomework(@RequestBody HomeWorkEntity newhomework, @PathVariable Long id) {
		
		HomeWorkEntity homeworkobj1=homeworkservice.updatedhomework(newhomework, id);
		logger.info("controller homework updated with id:::::::::::"+id );
		
		return homeworkobj1;
	}

	@ApiOperation(value = "Delete a  homework", nickname = "Deletehomework")
	@DeleteMapping("/homework/{id}")
	void deletehomework(@PathVariable Long id) {
		logger.info("controller homework deleted with id:::::::::::"+id );
		homeworkservice.deletehomework(id);
	}


}
