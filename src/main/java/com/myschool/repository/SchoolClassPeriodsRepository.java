package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.SchoolClassPeriodsEntity;

@Repository
public interface SchoolClassPeriodsRepository extends JpaRepository<SchoolClassPeriodsEntity, Long>{

}
