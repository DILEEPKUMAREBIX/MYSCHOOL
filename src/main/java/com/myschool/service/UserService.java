package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.UserEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.UserRepository;

@Service
public class UserService {
	
	private static final Logger logger = LogManager.getLogger(UserService.class);


	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<UserEntity> getUsers() {
		logger.info("service list of users::::::::::::::");
		return userRepo.findAll();
	}

	public UserEntity getUser(@PathVariable Long id) {
		logger.info("service getting user with id:::::::::::::"+id);
		return userRepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public UserEntity saveUser(UserEntity user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	public UserEntity updateUser(@RequestBody UserEntity newUser, @PathVariable Long id) {
		logger.info("service user updated with id::::::::::"+id);
		return userRepo.findById(id).map(user -> {
			//			school.setName(newSchool.getName());
			//			school.setAddress(newSchool.getAddress());
			// school.setTypeId(newSchool.getTypeId());
			return userRepo.save(user);
		}).orElseGet(() -> {
			// newSchool.setSchoolId(id);
			return userRepo.save(newUser);
		});
	}

	public void deleteUser(@PathVariable Long id) {
		logger.info("service user deleted with id::::::::::"+id);
		userRepo.deleteById(id);
	}

	public Long getUserCount() {
		Long count=userRepo.count();
		logger.info("service total no of users ::::::::::"+count);
return count;
	}
}
