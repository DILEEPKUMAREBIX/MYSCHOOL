package com.myschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.SchoolEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepo;

	public List<SchoolEntity> getSchools() {
		return schoolRepo.findAll();
	}

	public SchoolEntity getSchool(@PathVariable Long id) {
		return schoolRepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public SchoolEntity saveSchool(SchoolEntity school) {
		return schoolRepo.save(school);
	}

	public SchoolEntity replaceEmployee(@RequestBody SchoolEntity newSchool, @PathVariable Long id) {
		return schoolRepo.findById(id).map(school -> {
			school.setName(newSchool.getName());
			school.setAddress(newSchool.getAddress());
			school.setTypeId(newSchool.getTypeId());
			return schoolRepo.save(school);
		}).orElseGet(() -> {
			// newSchool.setSchoolId(id);
			return schoolRepo.save(newSchool);
		});
	}

	public void deleteEmployee(@PathVariable Long id) {
		schoolRepo.deleteById(id);
	}
}
