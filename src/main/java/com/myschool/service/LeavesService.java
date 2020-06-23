package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.LeavesEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.LeavesRepository;

@Service
public class LeavesService {
	
	@Autowired
	private LeavesRepository leavesrepo;

	
	private static final Logger logger = LogManager.getLogger(LeavesService.class);


	public List<LeavesEntity> getLeaves() {
		logger.info("service list of Leaves :::::::::::");
		return leavesrepo.findAll();
	}

	public LeavesEntity getLeave(@PathVariable Long id) {
		logger.info("service selected Leave details with id:::::::::::" + id);
		return leavesrepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public LeavesEntity saveLeave(LeavesEntity Leave) {
		logger.info("service Leave saved sucessfully::::::::::::::::::");
		return leavesrepo.save(Leave);
	}

	public LeavesEntity updatedLeave(@RequestBody LeavesEntity newLeave, @PathVariable Long id) {
		logger.info("service Leave updated with id:::::::::::" + id);
		return leavesrepo.findById(id).map(Leave -> {
			Leave.setLeaveDate(newLeave.getLeaveDate());
			Leave.setDescription(newLeave.getDescription());
			Leave.setUserId(newLeave.getUserId());
			Leave.setSchoolIdno(newLeave.getSchoolIdno());
			Leave.setIsActive(newLeave.getIsActive());
			Leave.setCreatedBy(newLeave.getCreatedBy());
			return leavesrepo.save(Leave);

		}).orElseGet(() -> {
			return leavesrepo.save(newLeave);
		});
	}

	public void deleteLeave(@PathVariable Long id) {
		logger.info("service Leave deleted with id:::::::::::" + id);
		leavesrepo.deleteById(id);
	}

	
}
