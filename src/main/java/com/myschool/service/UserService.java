package com.myschool.service;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.myschool.entity.UserEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.UserRepository;
import com.myschool.utils.UserServiceUtils;

@Service
@Transactional
public class UserService {

	private static final Logger logger = LogManager.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceUtils UserServiceUtils;

	public List<UserEntity> getUsers() {
		logger.info("service list of users::::::::::::::");
		return userRepo.findAll();
	}

	public UserEntity getUser(@PathVariable Long id) {
		logger.info("service getting user with id:::::::::::::" + id);
		return userRepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public UserEntity saveUser(UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	public UserEntity updateUser(@RequestBody UserEntity newUser, @PathVariable Long id) {
		logger.info("service user updated with id::::::::::" + id);
		return userRepo.findById(id).map(user -> {
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setFatherName(newUser.getFatherName());
			user.setMotherName(newUser.getMotherName());
			user.setImage(newUser.getImage());
			user.setUserName(newUser.getUserName());
			user.setPassword(newUser.getPassword());
			user.setEmail(newUser.getEmail());
			user.setPhone(newUser.getPhone());
			user.setRoles(newUser.getRoles());
			user.setGenderId(newUser.getGenderId());
			user.setPermissions(newUser.getPermissions());
			user.setDateOfBirth(newUser.getDateOfBirth());
			user.setJoiningDate(newUser.getJoiningDate());
			user.setEndingDate(newUser.getEndingDate());
			user.setSchoolId(newUser.getSchoolId());
			user.setCategoryId(newUser.getCategoryId());
			user.setCreatedBy(newUser.getCreatedBy());
			user.setCreatedDate(newUser.getCreatedDate());
			user.setAddress(newUser.getAddress());
			return userRepo.save(user);
		}).orElseGet(() -> {
			return userRepo.save(newUser);
		});
	}

	public void deleteUser(@PathVariable Long id) {
		logger.info("service user deleted with id::::::::::" + id);
		userRepo.deleteById(id);
	}

	public Long getUserCount() {
		Long count = userRepo.count();
		logger.info("service total no of users ::::::::::" + count);
		return count;
	}

	@Transactional
	public boolean saveDatafromUploadedfile(MultipartFile file) {
		boolean isFlag = false;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		if (extension.equalsIgnoreCase("json")) {
			isFlag = UserServiceUtils.readDataFromJson(file);
		} else if (extension.equalsIgnoreCase("xlsx") || extension.equalsIgnoreCase("xls")) {
			isFlag = UserServiceUtils.readDataFromExecl(file);
		} /*
			 * else if(extension.equalsIgnoreCase("csv")) {
			 * isFlag=UserServiceUtils.readDataFromCSV(file); }
			 */
		return isFlag;
	}

}
