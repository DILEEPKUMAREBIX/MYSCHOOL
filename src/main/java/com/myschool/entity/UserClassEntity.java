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
import lombok.Data;

@Entity
@Table(name = "userclass", schema = "myschool")
@Data
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

	@OneToOne( cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USERID", insertable = false, updatable = false)
	private UserClassEntity userId;

	@OneToOne( cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSID")
	private CMValueEntity classId;
	
	@OneToOne( cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SECTIONID")
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


	
	
	public UserClassEntity getUserId() {
		return userId;
	}


	public void setUserId(UserClassEntity userId) {
		this.userId = userId;
	}


	public CMValueEntity getClassId() {
		return classId;
	}


	public void setClassId(CMValueEntity classId) {
		this.classId = classId;
	}


	public CMValueEntity getSection() {
		return section;
	}


	public void setSection(CMValueEntity section) {
		this.section = section;
	}


	
}
