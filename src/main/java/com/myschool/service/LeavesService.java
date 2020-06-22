package com.myschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myschool.repository.LeavesRepository;

@Service
public class LeavesService {
	
	@Autowired
	private LeavesRepository leavesrepo;

}
