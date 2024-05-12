package com.sms.views;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	
	public Student() {
		
	}
	
	private Integer rollNumber;
	
	private String firstName;
	
	private String lastName;
	
	private Long phoneNumber;
	
	private String emailId;

}
