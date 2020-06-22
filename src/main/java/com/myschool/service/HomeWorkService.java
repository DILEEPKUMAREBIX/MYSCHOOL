package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myschool.entity.HomeWorkEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.HomeWorkRepository;

@Service
public class HomeWorkService {

	private static final Logger logger = LogManager.getLogger(HomeWorkService.class);
	
	@Autowired
	private HomeWorkRepository homeworkrepo;

	public List<HomeWorkEntity> gethomeworks() {
		logger.info("service list of homeworks :::::::::::");
		return homeworkrepo.findAll();
	}

	public HomeWorkEntity gethomework(Long id) {
		logger.info("service selected homework details with id:::::::::::" + id);
		return homeworkrepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public HomeWorkEntity savehomework(HomeWorkEntity homework) {
		logger.info("service homework saved sucessfully::::::::::::::::::");
		return homeworkrepo.save(homework);
	}

	public HomeWorkEntity updatedhomework(HomeWorkEntity newhomework, Long id) {
		logger.info("service homework updated with id:::::::::::" + id);
		return homeworkrepo.findById(id).map(homework -> {
			homework.setDescription(newhomework.getDescription());
			homework.setHomeWorkDate(newhomework.getHomeWorkDate());
			homework.setSchoolIdno(newhomework.getSchoolIdno());
			homework.setClassId(newhomework.getClassId());
			homework.setSubjectId(newhomework.getSubjectId());
			homework.setSectionId(newhomework.getSectionId());
			homework.setCreatedBy(newhomework.getCreatedBy());
			homework.setCreatedDate(newhomework.getCreatedDate());
			return homeworkrepo.save(homework);

		}).orElseGet(() -> {
			return homeworkrepo.save(newhomework);
		});
	}

	public void deletehomework(Long id) {
		logger.info("service homework deleted with id:::::::::::" + id);
		homeworkrepo.deleteById(id);
	}


}
