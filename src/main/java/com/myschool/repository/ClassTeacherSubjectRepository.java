package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.ClassTeacherSubjectEntity;

@Repository
public interface ClassTeacherSubjectRepository extends JpaRepository<ClassTeacherSubjectEntity, Long> {

}
