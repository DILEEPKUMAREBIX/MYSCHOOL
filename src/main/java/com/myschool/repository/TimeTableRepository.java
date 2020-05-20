package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.TimeTableEntity;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTableEntity, Long> {

}
