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
@Table(name="timetable",schema = "myschool")
public class TimeTableEntity extends AuditingEntity{
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated product ID")
	private Long timeTableId;
	
	@Column(name = "ISACTIVE")
	private boolean isActive;
	
	@Column(name="PERIODNO")
	private Long periodNo;
	
	
	
	@Column(name="CLASSTEACHERSUBJECTID")
	private Long classTeachersubjectId;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSTEACHERSUBJECTID",insertable = false,updatable = false)
	private ClassTeacherSubjectEntity classTeachersubject;

	public Long getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(Long timeTableId) {
		this.timeTableId = timeTableId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getPeriodNo() {
		return periodNo;
	}

	public void setPeriodNo(Long periodNo) {
		this.periodNo = periodNo;
	}

	

	public Long getClassTeachersubjectId() {
		return classTeachersubjectId;
	}

	public void setClassTeachersubjectId(Long classTeachersubjectId) {
		this.classTeachersubjectId = classTeachersubjectId;
	}

	public ClassTeacherSubjectEntity getClassTeachersubject() {
		return classTeachersubject;
	}

	public void setClassTeachersubject(ClassTeacherSubjectEntity classTeachersubject) {
		this.classTeachersubject = classTeachersubject;
	}
	
	
	

}
