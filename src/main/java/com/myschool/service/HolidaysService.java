package com.myschool.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myschool.entity.HolidaysEntity;
import com.myschool.exceptions.SchoolNotFoundException;
import com.myschool.repository.HolidaysRepository;

@Service
public class HolidaysService {

	@Autowired
	private HolidaysRepository holidaysrepo;

	private static final Logger logger = LogManager.getLogger(HolidaysService.class);

	public List<HolidaysEntity> getHolidays() {
		logger.info("service list of Holidays :::::::::::");
		return holidaysrepo.findAll();
	}

	public HolidaysEntity getHoliday(@PathVariable Long id) {
		logger.info("service selected Holiday details with id:::::::::::" + id);
		return holidaysrepo.findById(id).orElseThrow(() -> new SchoolNotFoundException(id));
	}

	public HolidaysEntity saveHoliday(HolidaysEntity Holiday) {
		logger.info("service Holiday saved sucessfully::::::::::::::::::");
		return holidaysrepo.save(Holiday);
	}

	public HolidaysEntity updatedHoliday(@RequestBody HolidaysEntity newHoliday, @PathVariable Long id) {
		logger.info("service Holiday updated with id:::::::::::" + id);
		return holidaysrepo.findById(id).map(Holiday -> {
			Holiday.setHolidayDate(newHoliday.getHolidayDate());
			Holiday.setDescription(newHoliday.getDescription());
			Holiday.setHolidayDate(newHoliday.getHolidayDate());
			Holiday.setSchoolIdno(newHoliday.getSchoolIdno());
			Holiday.setCreatedBy(newHoliday.getCreatedBy());
			Holiday.setCreatedDate(newHoliday.getCreatedDate());
			return holidaysrepo.save(Holiday);

		}).orElseGet(() -> {
			return holidaysrepo.save(newHoliday);
		});
	}

	public void deleteHoliday(@PathVariable Long id) {
		logger.info("service Holiday deleted with id:::::::::::" + id);
		holidaysrepo.deleteById(id);
	}


}
