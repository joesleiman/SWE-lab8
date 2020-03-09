package edu.mum.cs.cs425.studentmgmt.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student s) {
		return studentRepository.save(s);
	}

	@Override
	public List<Student> getPassingStudentsOnly() {
		return studentRepository.findStudentsWithCgpaGreaterThan3(3.0f);
	}

	@Override
	public List<Student> getLatestStudents() {
		return studentRepository.findStudentsByStudentNumberGreaterThan(980002);
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public void updateStudent(Classroom classroom, long studentId) {
		studentRepository.update(classroom, studentId);
	}

}
