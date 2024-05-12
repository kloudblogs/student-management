package com.sms.services;

import java.util.List;

import com.sms.entities.StudentEntity;
import com.sms.views.Student;

public interface IStudentService {
	
	List<StudentEntity> createStudents(List<Student> students);

	StudentEntity findStudentByRollNumber(Integer rollNumber);
}
