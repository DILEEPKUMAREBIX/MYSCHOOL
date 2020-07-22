package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.myschool.entity.TimeTableEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.TimeTableRepository;

@Service
public class TimeTableService {
	
	private static final Logger logger = LogManager.getLogger(TimeTableService.class);

	
	@Autowired
	private TimeTableRepository timetablerepo;
	
	public List<TimeTableEntity> gettimetables() {
		logger.info("controller list of timetables :::::::::::");
		return timetablerepo.findAll();
	}

	public TimeTableEntity gettimetable(@PathVariable Long id) {
		logger.info("service selected timetable details with id:::::::::::" + id);
		return timetablerepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public TimeTableEntity savetimetable(TimeTableEntity timetable) {
		logger.info("service timetable saved sucessfully::::::::::::::::::");
		return timetablerepo.save(timetable);
	}

	/*
	 * public TimeTableEntity updatedtimetable(@RequestBody TimeTableEntity
	 * newtimetable, @PathVariable Long id) {
	 * logger.info("service timetable updated with id:::::::::::" + id); return
	 * timetablerepo.findById(id).map(timetable -> {
	 * timetable.setPeriodNo(newtimetable.getPeriodNo());; return
	 * timetablerepo.save(timetable);
	 * 
	 * }).orElseGet(() -> { return timetablerepo.save(newtimetable); }); }
	 */
	public void deletetimetable(@PathVariable Long id) {
		logger.info("service timetable deleted with id:::::::::::" + id);
		timetablerepo.deleteById(id);
	}
}
