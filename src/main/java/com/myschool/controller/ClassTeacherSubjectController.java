package com.myschool.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myschool.entity.ClassTeacherSubjectEntity;
import com.myschool.service.ClassTeacherSubjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "ClassTeacherSubject CRUD", description = "Manage ClassTeacherSubjects list")
@RequestMapping("/myschool")
public class ClassTeacherSubjectController {
	
	private static final Logger logger = LogManager.getLogger(ClassTeacherSubjectController.class);
	
	@Autowired
	private ClassTeacherSubjectService classTeacherSubjectService;

	
	@ApiOperation(value = "View a list of class teacher subjects", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/classteachersubjects")
	private List<ClassTeacherSubjectEntity> getSchools() {
		return classTeacherSubjectService.getClassTeacherSubjects();
	}

	// Single item
	@ApiOperation(value = "View a class teacher subjects", response = Iterable.class)
	@GetMapping("/classteachersubjects/{id}")
	ClassTeacherSubjectEntity getSchool(@PathVariable Long id) {
		
		return classTeacherSubjectService.getClassTeacherSubject(id);
	}

	@ApiOperation(value = "Create a new class teacher subject", nickname = "Create class teacher subject")
	@PostMapping(value = "/classteachersubjects", headers = "Accept=application/json", produces = "application/json")
	private ResponseEntity<ClassTeacherSubjectEntity> saveClassTeacherSubject(@RequestBody ClassTeacherSubjectEntity ClassTeacherSubject) {
		
		logger.info("ClassTeacherSubjectEntity saved sucessfully::::::::::::::::::" );
		return new ResponseEntity<ClassTeacherSubjectEntity>(classTeacherSubjectService.saveClassTeacherSubject(ClassTeacherSubject),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Update/Create a  class teacher subject", nickname = "UpdateOrCreate class teacher subject")
	@PutMapping("/classteachersubjects/{id}")
	ClassTeacherSubjectEntity updateClassTeacherSubject(@RequestBody ClassTeacherSubjectEntity newClassTeacherSubject, @PathVariable Long id) {
		return classTeacherSubjectService.replaceClassTeacherSubject(newClassTeacherSubject, id);
	}

	@ApiOperation(value = "Delete a  class teacher subject", nickname = "Deleteclass teacher subject")
	@DeleteMapping("/classteachersubjects/{id}")
	void deleteclassTeacherSubject(@PathVariable Long id) {
		logger.info("ClassTeacherSubject deleted with id:::::::::::"+id );
		classTeacherSubjectService.deleteclassTeacherSubject(id);
	}
}
