package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.SchoolClassPeriodsEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.SchoolClassPeriodsRepository;

@Service
public class SchoolClassPeriodsService {

	
	@Autowired 
private SchoolClassPeriodsRepository schoolclassperiodrepo;	
	
	private static final Logger logger = LogManager.getLogger(SchoolService.class);


	public List<SchoolClassPeriodsEntity> getschoolclassperiod() {
		logger.info("controller list of schools :::::::::::");
		return schoolclassperiodrepo.findAll();
	}

	public SchoolClassPeriodsEntity getschoolclassperiod(@PathVariable Long id) {
		logger.info("service selected school details with id:::::::::::" + id);
		return schoolclassperiodrepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public SchoolClassPeriodsEntity saveschoolclassperiod(SchoolClassPeriodsEntity schoolclassperiod) {
		logger.info("service school saved sucessfully::::::::::::::::::");
		return schoolclassperiodrepo.save(schoolclassperiod);
	}

	public SchoolClassPeriodsEntity updatedschoolclassperiod(@RequestBody SchoolClassPeriodsEntity newschoolclassperiod, @PathVariable Long id) {
		logger.info("service school updated with id:::::::::::" + id);
		return schoolclassperiodrepo.findById(id).map(schoolclassperiod -> {
			schoolclassperiod.setCount(newschoolclassperiod.getCount());
			return schoolclassperiodrepo.save(schoolclassperiod);

		}).orElseGet(() -> {
			return schoolclassperiodrepo.save(newschoolclassperiod);
		});
	}

	public void deleteschoolclassperiod(@PathVariable Long id) {
		logger.info("service school deleted with id:::::::::::" + id);
		schoolclassperiodrepo.deleteById(id);
	}
}
