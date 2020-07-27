package com.myschool.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="classperiod",schema = "myschool")
//@Data
public class ClassPeriodEntity {

	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated ID")
	private Long classPeriodId;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "STARTTIME")
	@JsonFormat(pattern = "hh:mm:ss")
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "ENDTIME")
	@JsonFormat(pattern = "hh:mm:ss")
	private Date endTime;
	
	@Column(name = "ISACTIVE")
	private Boolean isActive;
	
	@Column(name = "SCHOOLID")
	private Long schoolIdno;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SCHOOLID", insertable = false, updatable = false)
	private SchoolEntity schoolName;
	
	@Column(name = "CLASSID")
	private Long classId;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSID", insertable = false, updatable = false) 
	private CMValueEntity className;
	
	@Column(name = "SECTIONID")
	private Long sectionId;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SECTIONID", insertable = false, updatable = false) 
	private CMValueEntity sectionName;

	public Long getClassPeriodId() {
		return classPeriodId;
	}

	public void setClassPeriodId(Long classPeriodId) {
		this.classPeriodId = classPeriodId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getSchoolIdno() {
		return schoolIdno;
	}

	public void setSchoolIdno(Long schoolIdno) {
		this.schoolIdno = schoolIdno;
	}

	public SchoolEntity getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(SchoolEntity schoolName) {
		this.schoolName = schoolName;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public CMValueEntity getClassName() {
		return className;
	}

	public void setClassName(CMValueEntity className) {
		this.className = className;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public CMValueEntity getSectionName() {
		return sectionName;
	}

	public void setSectionName(CMValueEntity sectionName) {
		this.sectionName = sectionName;
	}
	

	
}
