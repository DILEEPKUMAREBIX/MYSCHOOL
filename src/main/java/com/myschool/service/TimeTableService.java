package com.myschool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.TimeTableEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.TimeTableRepository;

@Service
public class TimeTableService {

	private static final Logger logger = LogManager.getLogger(TimeTableService.class);


	@Autowired
	private TimeTableRepository timetablerepo;

	public Map<Date, List<TimeTableEntity>> gettimetables(Date startdate,Date enddate) {
		logger.info("service list of timetables :::::::::::");
		
		List<TimeTableEntity> timetablelist=timetablerepo.getAllTimetableData(startdate, enddate);
		Map<Date, List<TimeTableEntity>> timetablemap = new HashMap<>();
		
		
		for(TimeTableEntity timetable:timetablelist){
			Date date = timetable.getTimeTableDate();
		    

			timetablemap.computeIfAbsent(date, k -> new ArrayList<>()).add(timetable);
		}
		
		
		return timetablemap ;
	}

	public TimeTableEntity gettimetable(@PathVariable Long id) {
		logger.info("service selected timetable details with id:::::::::::" + id);
		return timetablerepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public TimeTableEntity savetimetable(TimeTableEntity timetable) {
		logger.info("service timetable saved sucessfully::::::::::::::::::");
		return timetablerepo.save(timetable);
	}


	public TimeTableEntity updatedtimetable(@RequestBody TimeTableEntity
			newtimetable, @PathVariable Long id) {
		logger.info("service timetable updated with id:::::::::::" + id); return
				timetablerepo.findById(id).map(timetable -> {
					timetable.setTimeTableDate(newtimetable.getTimeTableDate());
					timetable.setIsActive(newtimetable.getIsActive());
					timetable.setSchoolIdno(newtimetable.getSchoolIdno());
					timetable.setClassId(newtimetable.getClassId());
					timetable.setSectionId(newtimetable.getSectionId());
					timetable.setSubjectId(newtimetable.getSubjectId());
					timetable.setClassPeriodId(newtimetable.getClassPeriodId());
					timetable.setClassTeacherSubjctId(newtimetable.getClassTeacherSubjctId());	 
					; return
							timetablerepo.save(timetable);

				}).orElseGet(() -> { return timetablerepo.save(newtimetable); }); }

	public void deletetimetable(@PathVariable Long id) {
		logger.info("service timetable deleted with id:::::::::::" + id);
		timetablerepo.deleteById(id);
	}
}
