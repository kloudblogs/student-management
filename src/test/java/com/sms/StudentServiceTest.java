package com.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.sms.entities.StudentEntity;
import com.sms.repositories.StudentRepository;
import com.sms.services.StudentService;
import com.sms.views.Student;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentServiceTest {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @BeforeAll
    public void setUp() {
        // Create a mock instance of StudentRepository
        studentRepository = mock(StudentRepository.class);
        // Create an instance of StudentService with the mock repository
        studentService = new StudentService(studentRepository);
    }

    @Test
    public void testCreateStudents() {
        // Prepare test data
        List<Student> students = new ArrayList<>();
        students.add(new Student(100, "Saina", "Biswal", 8884630004L, "saina.biswal@gmail.com"));

        // Mock behavior of studentRepository.saveAll()
        List<StudentEntity> savedEntities = new ArrayList<>();
        savedEntities.add(new StudentEntity(1, 100, "Saina", "Biswal", 8884630004L, "saina.biswal@gmail.com"));
        when(studentRepository.saveAll(savedEntities)).thenReturn(savedEntities);

        // Call the method to be tested
        List<StudentEntity> resultEntities = studentService.createStudents(students);

        // Verify the result
        assertEquals(0, resultEntities.size());
    }

    @Test
    public void testFindStudentByRollNumber() {
        // Prepare test data
        Integer rollNumber = 100;
        StudentEntity expectedEntity = new StudentEntity(1, 100, "Saina", "Biswal", 8884630004L, "saina.biswal@gmail.com");

        // Mock behavior of studentRepository.findByRollNumber()
        when(studentRepository.findByRollNumber(rollNumber)).thenReturn(expectedEntity);

        // Call the method to be tested
        StudentEntity resultEntity = studentService.findStudentByRollNumber(rollNumber);

        // Verify the result
        assertEquals(expectedEntity, resultEntity);
    }
}

