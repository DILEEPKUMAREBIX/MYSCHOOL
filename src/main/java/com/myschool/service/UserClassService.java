package com.myschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.UserClassEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.UserClassRepository;

@Service
public class UserClassService {

	@Autowired
	private UserClassRepository userClassRepo;

	public List<UserClassEntity> getUserClasses() {
		return userClassRepo.findAll();
	}

	public UserClassEntity getuserClass(@PathVariable Long id) {
		return userClassRepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public UserClassEntity saveUserClass(UserClassEntity userclass) {
		return userClassRepo.save(userclass);
	}

	public UserClassEntity replaceUserClass(@RequestBody UserClassEntity newuserclass, @PathVariable Long id) {
		return userClassRepo.findById(id).map(userclass -> {
			userclass.setAcademicYear(newuserclass.getAcademicYear());
			userclass.setClassId(newuserclass.getClassId());
			userclass.setSection(newuserclass.getSection());

			return userClassRepo.save(userclass);
		}).orElseGet(() -> {
			return userClassRepo.save(newuserclass);
		});
	}

	public void deleteUserClass(@PathVariable Long id) {
		userClassRepo.deleteById(id);
	}

}
