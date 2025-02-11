package com.myschool.entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user", schema = "myschool")
//@Data
public class UserEntity extends AuditingEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated ID")
	private Long userId;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "ISACTIVE")
	private Boolean isActive;

	@Column(name = "FATHERNAME")
	private String fatherName;

	@Column(name = "MOTHERNAME")
	private String motherName;
	
	@Column(name = "IMAGE")
	@Lob
	private Blob image;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ROLES")
	private String roles;

	@Column(name = "PERMISSIONS")
	private String permissions;
	
	@Column(name = "IDPROOF")
	private String idProof;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date dateOfBirth;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "JOININGDATE")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date joiningDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ENDINGDATE",nullable = true)
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date endingDate;
	
	@Column(name = "SCHOOLID")
	private Long schoolId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(unique = true, name = "SCHOOLID", insertable = false, updatable = false)
	private SchoolEntity school;
	
	@Column(name = "CATEGORYID")
	private Long categoryId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CATEGORYID", insertable = false, updatable = false)
	private CMValueEntity category;
	
	@Column(name = "GENDERID")
	private Long genderId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "GENDERID", insertable = false, updatable = false)
	private CMValueEntity gender;
	
	@Column(name = "RELIGIONID")
	private Long religionId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "RELIGIONID", insertable = false, updatable = false)
	private CMValueEntity religion;
	
	@Column(name = "CASTEID")
	private Long casteId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CASTEID", insertable = false, updatable = false)
	private CMValueEntity caste;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "ADDRESSID")
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public SchoolEntity getSchool() {
		return school;
	}

	public void setSchool(SchoolEntity school) {
		this.school = school;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public CMValueEntity getCategory() {
		return category;
	}

	public void setCategory(CMValueEntity category) {
		this.category = category;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public CMValueEntity getGender() {
		return gender;
	}

	public void setGender(CMValueEntity gender) {
		this.gender = gender;
	}

	public Long getReligionId() {
		return religionId;
	}

	public void setReligionId(Long religionId) {
		this.religionId = religionId;
	}

	public CMValueEntity getReligion() {
		return religion;
	}

	public void setReligion(CMValueEntity religion) {
		this.religion = religion;
	}

	public Long getCasteId() {
		return casteId;
	}

	public void setCasteId(Long casteId) {
		this.casteId = casteId;
	}

	public CMValueEntity getCaste() {
		return caste;
	}

	public void setCaste(CMValueEntity caste) {
		this.caste = caste;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	
	
}