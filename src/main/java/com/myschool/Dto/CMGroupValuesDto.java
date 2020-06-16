package com.myschool.Dto;

import java.io.Serializable;

public class CMGroupValuesDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long CmGroupId;
	private String CmGroupName;
	private String CmGroupDescription;
	private Long groupId;

	private Long id;
	private String name;
	private String description;
	private boolean isActive;

	public CMGroupValuesDto() {
	}

	public CMGroupValuesDto(Long cmGroupId, String cmGroupName, String cmGroupDescription, Long groupId, Long id,
			String name, String description, boolean isActive) {
		super();
		CmGroupId = cmGroupId;
		CmGroupName = cmGroupName;
		CmGroupDescription = cmGroupDescription;
		this.groupId = groupId;
		this.id = id;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
	}

	public Long getCmGroupId() {
		return CmGroupId;
	}

	public void setCmGroupId(Long cmGroupId) {
		CmGroupId = cmGroupId;
	}

	public String getCmGroupName() {
		return CmGroupName;
	}

	public void setCmGroupName(String cmGroupName) {
		CmGroupName = cmGroupName;
	}

	public String getCmGroupDescription() {
		return CmGroupDescription;
	}

	public void setCmGroupDescription(String cmGroupDescription) {
		CmGroupDescription = cmGroupDescription;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
