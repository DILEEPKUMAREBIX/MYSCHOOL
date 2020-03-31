package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.SchoolEntity;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

}
