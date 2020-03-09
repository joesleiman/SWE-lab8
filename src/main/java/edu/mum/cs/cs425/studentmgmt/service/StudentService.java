package edu.mum.cs.cs425.studentmgmt.service;

import java.util.List;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student save(Student s);
	List<Student> getPassingStudentsOnly();
	List<Student> getLatestStudents();
	Student getStudentById(long id);
	void updateStudent(Classroom classroom, long studentId);
}
