package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.HolidaysEntity;

@Repository
public interface HolidaysRepository extends JpaRepository<HolidaysEntity, Long> {

}
