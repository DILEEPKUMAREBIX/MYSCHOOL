package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.UserClassEntity;

@Repository
public interface UserClassRepository extends JpaRepository<UserClassEntity, Long> {

}
