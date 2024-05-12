package com.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entities.StudentEntity;
import com.sms.services.IStudentService;
import com.sms.views.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping
	public List<StudentEntity> createStudents(@RequestBody List<Student> students) {
		return studentService.createStudents(students);
	}

	@GetMapping("/{rollNumber}")
	public StudentEntity findStudentByRollNumber(@PathVariable Integer rollNumber) {
		return studentService.findStudentByRollNumber(rollNumber);
	}
}