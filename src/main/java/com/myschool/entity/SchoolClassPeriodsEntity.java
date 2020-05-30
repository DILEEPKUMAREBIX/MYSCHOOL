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
@Table(name = "schoolclassperiods", schema = "myschool")
public class SchoolClassPeriodsEntity extends AuditingEntity{

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated product ID")
	private Long classPeriodId;

	@Column(name="COUNT")
	private Long count;

	@Column(name="ISACTIVE")
	private boolean isActive;

	@Column(name="SCHOOLID")
	private Long schoolId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="SCHOOLID",insertable = false,updatable = false)
	private SchoolEntity schoolName;

	@Column(name="CLASSID")
	private Long classId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSID",insertable = false,updatable = false)
	private CMValueEntity classname;

	@Column(name="SECTIONID")
	private Long sectionId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="SECTIONID",insertable = false,updatable = false)
	private CMValueEntity sectionName;

	public Long getClassPeriodId() {
		return classPeriodId;
	}

	public void setClassPeriodId(Long classPeriodId) {
		this.classPeriodId = classPeriodId;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
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

	public CMValueEntity getClassname() {
		return classname;
	}

	public void setClassname(CMValueEntity classname) {
		this.classname = classname;
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
