package com.myschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myschool.Dto.CMGroupValuesDto;
import com.myschool.repository.CMGroupRepository;

@Service
public class CommonService {
	
	@Autowired
	private CMGroupRepository cmgrouprepo;
	
	public List<CMGroupValuesDto> getGroupValueData() {
		return cmgrouprepo.getAllGroupValueData();
	}
	
	
}
