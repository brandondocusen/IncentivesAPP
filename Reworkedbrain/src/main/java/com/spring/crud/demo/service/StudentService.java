package com.spring.crud.demo.service;


import com.spring.crud.demo.model.Student;

import java.util.List;

public interface StudentService {
	
	List<Student> getAll();

	List<Student> getStudentByFirstName(String firstName);

	Student getOneStudentByFirstName(String firstName);

	List<Student> getStudentByFirstNameLike(String firstName);

	Student getStudentById(int ro);
	
	Student getStudentByLastName(String lastName);

	List<Student> getStudentByMarksGreaterThan(int marks);
	
	List<Student> getStudentByCondition(Student student);
	
	Student saveStudent(Student student);

	Student updateStudent(int rollNo, Student student);

	void deleteStudent(int rollNo);

}
