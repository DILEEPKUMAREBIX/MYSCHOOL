package com.myschool.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "attendance", schema = "myschool")
//@Data
public class AttendanceEntity extends AuditingEntity{

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated product ID")
	private Long attendenceId;
	
	@Column(name = "ISACTIVE")
	private boolean isActive;
	
	@Column(name = "ISPRESENT")
	private boolean isPrasent;
	
	@Column(name = "PERIODNO")
	private Long periodNo;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PERIODNO", insertable = false, updatable = false)
	private UserClassEntity periodName;
	
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "USERCLASSID")
	private Long userClassId;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USERCLASSID", insertable = false, updatable = false)
	private UserClassEntity userClassName;
	
	@Column(name = "CLASSTEACHERSUBJECTID")
	private Long classTeacherSubjectid;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSTEACHERSUBJECTID", insertable = false, updatable = false)
	private ClassTeacherSubjectEntity classTeacherSubjectName;

	public Long getAttendenceId() {
		return attendenceId;
	}

	public void setAttendenceId(Long attendenceId) {
		this.attendenceId = attendenceId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isPrasent() {
		return isPrasent;
	}

	public void setPrasent(boolean isPrasent) {
		this.isPrasent = isPrasent;
	}

	public Long getPeriodNo() {
		return periodNo;
	}

	public void setPeriodNo(Long periodNo) {
		this.periodNo = periodNo;
	}

	public UserClassEntity getPeriodName() {
		return periodName;
	}

	public void setPeriodName(UserClassEntity periodName) {
		this.periodName = periodName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getUserClassId() {
		return userClassId;
	}

	public void setUserClassId(Long userClassId) {
		this.userClassId = userClassId;
	}

	public UserClassEntity getUserClassName() {
		return userClassName;
	}

	public void setUserClassName(UserClassEntity userClassName) {
		this.userClassName = userClassName;
	}

	public Long getClassTeacherSubjectid() {
		return classTeacherSubjectid;
	}

	public void setClassTeacherSubjectid(Long classTeacherSubjectid) {
		this.classTeacherSubjectid = classTeacherSubjectid;
	}

	public ClassTeacherSubjectEntity getClassTeacherSubjectName() {
		return classTeacherSubjectName;
	}

	public void setClassTeacherSubjectName(ClassTeacherSubjectEntity classTeacherSubjectName) {
		this.classTeacherSubjectName = classTeacherSubjectName;
	}

	
	
	
}
