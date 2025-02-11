package com.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myschool.dto.CMGroupValuesDto;
import com.myschool.entity.CMGroupEntity;

@Repository
public interface CMGroupRepository extends JpaRepository<CMGroupEntity, Long> {

	String cmgroupdata = "SELECT NEW com.myschool.dto.CMGroupValuesDto"
			+ "(cg.groupId,cg.name,cg.description,cv.groupId,cv.valueId,cv.name,cv.description,cv.isActive)"
			+ " FROM CMGroupEntity cg JOIN CMValueEntity cv ON cg.groupId=cv.groupId";

	@Query(cmgroupdata)
	List<CMGroupValuesDto> getAllGroupValueData();
}
