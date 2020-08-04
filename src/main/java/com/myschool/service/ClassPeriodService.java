package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myschool.entity.ClassPeriodEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.ClassPeriodRepository;

@Service
public class ClassPeriodService {

	private static final Logger logger = LogManager.getLogger(ClassPeriodService.class);

	@Autowired
	private ClassPeriodRepository classPeriodRepo;

	public List<ClassPeriodEntity> getclassperiods() {
		logger.info("service list of classPeriods :::::::::::");
		return classPeriodRepo.findAll();	}

	public ClassPeriodEntity getClassPeriod(Long id) {
		logger.info("service selected classPeriod details with id:::::::::::" + id);
		return classPeriodRepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));

	}

	public ClassPeriodEntity saveClassPeriod(ClassPeriodEntity classPeriod) {
		logger.info("service classPeriod saved sucessfully::::::::::::::::::");
		return classPeriodRepo.save(classPeriod);
	}

	public ClassPeriodEntity updatedClassPeriod(ClassPeriodEntity newClassPeriod, Long id) {
		logger.info("service classPeriod updated with id:::::::::::" + id);
		return classPeriodRepo.findById(id).map(classPeriod -> {
			classPeriod.setClassId(newClassPeriod.getClassId());
			classPeriod.setSchoolIdno(newClassPeriod.getSchoolIdno());
			classPeriod.setSectionId(newClassPeriod.getSectionId());
			classPeriod.setIsActive(newClassPeriod.getIsActive());
			classPeriod.setStartTime(newClassPeriod.getStartTime());
			classPeriod.setEndTime(newClassPeriod.getEndTime());
			classPeriod.setPeriodIdno(newClassPeriod.getPeriodIdno());
			return classPeriodRepo.save(classPeriod);

		}).orElseGet(() -> {
			return classPeriodRepo.save(newClassPeriod);
		});
	}

	public void deleteClassPeriod(Long id) {
		logger.info("service classPeriod deleted with id:::::::::::" + id);
		classPeriodRepo.deleteById(id);
	}



}
