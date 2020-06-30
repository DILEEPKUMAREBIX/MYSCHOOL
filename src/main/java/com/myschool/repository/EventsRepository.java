package com.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myschool.entity.EventsEntity;

@Repository
public interface EventsRepository extends JpaRepository<EventsEntity, Long> {

	//EventsEntity  findByFoldername(String foldername);
}
