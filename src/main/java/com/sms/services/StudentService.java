package com.sms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entities.StudentEntity;
import com.sms.mappers.StudentMapper;
import com.sms.repositories.StudentRepository;
import com.sms.views.Student;

@Service
public class StudentService implements IStudentService {
	
	private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

	@Override
	public List<StudentEntity> createStudents(List<Student> students) {
        List<StudentEntity> entities = StudentMapper.mapViewsToEntities(students);
		return studentRepository.saveAll(entities);
	}

	@Override
	public StudentEntity findStudentByRollNumber(Integer rollNumber) {

		return studentRepository.findByRollNumber(rollNumber);
	}

}
