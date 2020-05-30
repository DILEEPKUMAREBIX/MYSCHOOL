package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.AttendanceEntity;

@Repository
public interface AttendanceReopsitory extends JpaRepository<AttendanceEntity, Long> {

}
