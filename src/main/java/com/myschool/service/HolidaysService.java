package com.myschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myschool.repository.HolidaysRepository;

@Service
public class HolidaysService {
	
	@Autowired
	private HolidaysRepository holidaysrepo;

}
