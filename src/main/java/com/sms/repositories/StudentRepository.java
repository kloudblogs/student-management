package com.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	StudentEntity findByRollNumber(Integer rollNumber);
    
}

