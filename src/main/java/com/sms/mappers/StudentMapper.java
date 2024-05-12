package com.sms.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.sms.entities.StudentEntity;
import com.sms.views.Student;

public class StudentMapper {
	
	public static StudentEntity mapViewToEntity(Student student) {
		StudentEntity entity = new StudentEntity();
		if(Objects.nonNull(student)) {
			BeanUtils.copyProperties(student, entity);
		}
		return entity;
	}
	
	public static List<StudentEntity> mapViewsToEntities(List<Student> students){
		List<StudentEntity> entities = new ArrayList<>();
		if(!CollectionUtils.isEmpty(students)) {
			for(Student student : students) {
				entities.add(mapViewToEntity(student));
			}
		}
		return entities;
	}

}
