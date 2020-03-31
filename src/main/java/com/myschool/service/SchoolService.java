package com.myschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myschool.entity.SchoolEntity;
import com.myschool.repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepo;

	public List<SchoolEntity> getSchools() {
		return schoolRepo.findAll();
	}

	public SchoolEntity saveSchool(SchoolEntity school) {
		return schoolRepo.save(school);
	}
}
