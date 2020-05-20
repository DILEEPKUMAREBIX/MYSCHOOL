package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.AttendanceEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.AttendanceReopsitory;

@Service
public class AttendanceService {
	
	private static final Logger logger = LogManager.getLogger(AttendanceService.class);
	
	@Autowired
	private AttendanceReopsitory attaendancerepo;
	
	public List<AttendanceEntity> getattendences() {
		logger.info("controller list of attendences :::::::::::");
		return attaendancerepo.findAll();
	}

	public AttendanceEntity getattendence(@PathVariable Long id) {
		logger.info("service selected attendence details with id:::::::::::" + id);
		return attaendancerepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public AttendanceEntity saveattendence(AttendanceEntity attendence) {
		logger.info("service attendence saved sucessfully::::::::::::::::::");
		return attaendancerepo.save(attendence);
	}

	public AttendanceEntity updatedattendence(@RequestBody AttendanceEntity newattendence, @PathVariable Long id) {
		logger.info("service attendence updated with id:::::::::::" + id);
		return attaendancerepo.findById(id).map(attendence -> {
			attendence.setDate(newattendence.getDate());
			attendence.setPeriodNo(newattendence.getPeriodNo());
			return attaendancerepo.save(attendence);

		}).orElseGet(() -> {
			return attaendancerepo.save(newattendence);
		});
	}

	public void deleteattenadnce(@PathVariable Long id) {
		logger.info("service attendence deleted with id:::::::::::" + id);
		attaendancerepo.deleteById(id);
	}
	

}
