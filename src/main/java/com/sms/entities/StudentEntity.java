package com.sms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class StudentEntity {
	
	public StudentEntity() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer rollNumber;

	private String firstName;

	private String lastName;

	private Long phoneNumber;

	private String emailId;

}
