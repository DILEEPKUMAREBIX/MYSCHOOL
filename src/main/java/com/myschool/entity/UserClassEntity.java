package com.myschool.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "userclass", schema = "myschool")
//@Data
public class UserClassEntity extends AuditingEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated ID")
	private Long userclassId;

	@Column(name = "ACADEMICYEAR")
	private String academicYear;

	@Column(name = "ISACTIVE")
	private Boolean isActive;

	@Column(name = "USERID")
	private Long userId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USERID", insertable = false, updatable = false)
	private UserEntity user;

	@Column(name = "CLASSID")
	private Long classId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSID", insertable = false, updatable = false)
	private CMValueEntity userClass;

	@Column(name = "SECTIONID")
	private Long sectionId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SECTIONID", insertable = false, updatable = false)
	private CMValueEntity section;

	public Long getUserclassId() {
		return userclassId;
	}

	public void setUserclassId(Long userclassId) {
		this.userclassId = userclassId;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public CMValueEntity getUserClass() {
		return userClass;
	}

	public void setUserClass(CMValueEntity userClass) {
		this.userClass = userClass;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public CMValueEntity getSection() {
		return section;
	}

	public void setSection(CMValueEntity section) {
		this.section = section;
	}

}
