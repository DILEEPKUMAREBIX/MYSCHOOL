package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.ClassPeriodEntity;

@Repository
public interface ClassPeriodRepository extends JpaRepository<ClassPeriodEntity,Long> {

}
