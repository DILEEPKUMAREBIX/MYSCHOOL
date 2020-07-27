package com.myschool.dto;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myschool.entity.AddressEntity;
import com.myschool.entity.CMValueEntity;
import com.myschool.entity.SchoolEntity;

import lombok.Data;

@Data
public class UserEntityDto {

	private Long userId;

	private String firstName;

	private String lastName;

	private Boolean isActive;

	private String fatherName;

	private String motherName;
	
	private Blob image;

	private String userName;

	//private String password;

	private String email;

	private String phone;

	private String roles;

	private String permissions;
	
	private String idProof;

	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date dateOfBirth;
	
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date joiningDate;
	
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date endingDate;
	
	private SchoolEntity school;
	
	private CMValueEntity category;
	
	private CMValueEntity gender;

	private CMValueEntity religion;
	
	private CMValueEntity caste;

	private AddressEntity address;

	public List<String> getRolesList() {
		if (this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<String>();
	}

	public List<String> getPermissionsList() {
		if (this.permissions.length() > 0) {
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<String>();
	}

	
	
}
