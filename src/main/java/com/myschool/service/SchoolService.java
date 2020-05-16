package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.SchoolEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.SchoolRepository;

@Service
public class SchoolService {

	private static final Logger logger = LogManager.getLogger(SchoolService.class);

	@Autowired
	private SchoolRepository schoolRepo;

	public List<SchoolEntity> getSchools() {
		logger.info("controller list of schools :::::::::::");
		return schoolRepo.findAll();
	}

	public SchoolEntity getSchool(@PathVariable Long id) {
		logger.info("service selected school details with id:::::::::::" + id);
		return schoolRepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public SchoolEntity saveSchool(SchoolEntity school) {
		logger.info("service school saved sucessfully::::::::::::::::::");
		return schoolRepo.save(school);
	}

	public SchoolEntity updatedSchool(@RequestBody SchoolEntity newSchool, @PathVariable Long id) {
		logger.info("service school updated with id:::::::::::" + id);
		return schoolRepo.findById(id).map(school -> {
			school.setName(newSchool.getName());
			school.setAddress(newSchool.getAddress());
			school.setTypeId(newSchool.getTypeId());
			return schoolRepo.save(school);

		}).orElseGet(() -> {
			return schoolRepo.save(newSchool);
		});
	}

	public void deleteEmployee(@PathVariable Long id) {
		logger.info("service school deleted with id:::::::::::" + id);
		schoolRepo.deleteById(id);
	}

	public Long getSchoolsCount() {
		Long count = schoolRepo.count();
		logger.info("service total schools count:::::::::::" + count);
		return count;
	}
}
