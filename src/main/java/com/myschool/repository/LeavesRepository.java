package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.LeavesEntity;

@Repository
public interface LeavesRepository extends JpaRepository<LeavesEntity, Long> {

}
