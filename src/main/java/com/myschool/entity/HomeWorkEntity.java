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

@Entity
@Table(name = "homework")
public class HomeWorkEntity extends AuditingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long homeWorkId;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "HOMEWORK_DATE")
	private Date homeWorkDate;
	
	@Column(name="ISACTIVE")
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
	
	@Column(name = "SUBJECTID")
	private Long subjectId;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SUBJECTID", insertable = false, updatable = false) 
	private CMValueEntity subjectName;
	
	@Column(name = "SECTIONID")
	private Long sectionId;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SECTIONID", insertable = false, updatable = false) 
	private CMValueEntity sectionName;

	public Long getHomeWorkId() {
		return homeWorkId;
	}

	public void setHomeWorkId(Long homeWorkId) {
		this.homeWorkId = homeWorkId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getHomeWorkDate() {
		return homeWorkDate;
	}

	public void setHomeWorkDate(Date homeWorkDate) {
		this.homeWorkDate = homeWorkDate;
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

	public void setSchoolName(SchoolEntity schooName) {
		this.schoolName = schooName;
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

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public CMValueEntity getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(CMValueEntity subjectName) {
		this.subjectName = subjectName;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	
	
	
}
