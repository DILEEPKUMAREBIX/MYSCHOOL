package com.myschool.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myschool.entity.TimeTableEntity;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTableEntity, Long> {
	
	
	String timetabledata = "SELECT t FROM TimeTableEntity t WHERE t.timeTableDate "
			+ "BETWEEN :startdate AND :enddate ORDER BY t.timeTableDate";
		@Query(timetabledata)
	List<TimeTableEntity> getAllTimetableData(Date startdate,Date enddate);
}


