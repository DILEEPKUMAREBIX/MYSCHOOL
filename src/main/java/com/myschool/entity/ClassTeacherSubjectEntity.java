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
@Table(name = "classteachersubject", schema = "myschool")
//@Data
public class ClassTeacherSubjectEntity extends AuditingEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated product ID")
	private Long classTeacherSubjectId;

	@Column(name = "YEAR")
	private String year;

	@Column(name = "ISACTIVE")
	private Boolean isActive;

	@Column(name = "CLASSID")
	private Long classId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSID", insertable = false, updatable = false)
	private CMValueEntity userClassId;

	@Column(name = "TEACHERUSERID")
	private Long teacheruserId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "TEACHERUSERID", insertable = false, updatable = false)
	private UserEntity classteacheruser;

	@Column(name = "SUBJECTID")
	private Long subjectId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SUBJECTID", insertable = false, updatable = false)
	private CMValueEntity Subject;

	public Long getClassTeacherSubjectId() {
		return classTeacherSubjectId;
	}

	public void setClassTeacherSubjectId(Long classTeacherSubjectId) {
		this.classTeacherSubjectId = classTeacherSubjectId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public CMValueEntity getUserClassId() {
		return userClassId;
	}

	public void setUserClassId(CMValueEntity userClassId) {
		this.userClassId = userClassId;
	}

	public Long getTeacheruserId() {
		return teacheruserId;
	}

	public void setTeacheruserId(Long teacheruserId) {
		this.teacheruserId = teacheruserId;
	}

	public UserEntity getClassteacheruser() {
		return classteacheruser;
	}

	public void setClassteacheruser(UserEntity classteacheruser) {
		this.classteacheruser = classteacheruser;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public CMValueEntity getSubject() {
		return Subject;
	}

	public void setSubject(CMValueEntity subject) {
		Subject = subject;
	}



}
