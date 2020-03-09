package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.service.ClassroomService;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;
import edu.mum.cs.cs425.studentmgmt.service.TranscriptService;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {
	@Autowired
	private StudentService studentService;

	@Autowired
	private TranscriptService transcriptService;

	@Autowired
	private ClassroomService classroomService;

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// Create 3 new classrooms
		Classroom cr1 = new Classroom("McLaughlin building", "M105");
		Classroom cr2 = new Classroom("Verrill Hall", "V29");
		Classroom cr3 = new Classroom("Dreier Building", "#3");

		// Create 5 new Transcripts
		Transcript tr1 = new Transcript("BS Computer Science");
		Transcript tr2 = new Transcript("MS Computer Science");
		Transcript tr3 = new Transcript("BS Mathematics");
		Transcript tr4 = new Transcript("PhD Vedic Science");
		Transcript tr5 = new Transcript("MA Film Production");

		// Create 5 new students
		Student s1 = new Student(980001L, "John", "Smith", 3.94f, LocalDate.of(2018, 10, 24), tr1);
		Student s2 = new Student(980002L, "Anna-Marie", "Jones", 3.05f, LocalDate.of(2019, 3, 15), tr2);
		Student s3 = new Student(980003L, "Peter", "Harrington", 2.90f, LocalDate.of(2018, 10, 24), tr3);
		Student s4 = new Student(980004L, "Ducarmel", "Saint-Jean", 3.77f, LocalDate.of(2018, 10, 24), tr4);
		Student s5 = new Student(980005L, "Mary", "Washington", 3.26f, LocalDate.of(2019, 3, 13), tr5);

		tr1.setStudent(s1);
		tr2.setStudent(s2);
		tr3.setStudent(s3);
		tr4.setStudent(s4);
		tr5.setStudent(s5);

		Classroom[] classrooms = { cr1, cr2, cr3 };
		Student[] students = { s1, s2, s3, s4, s5 };

		for (Student s : students) {
			Student newStudent = addNewStudent(s);
		}
		createClassrooms(classrooms);
		assignStudentsToClassrooms();
		studentService.getAllStudents().forEach(System.out::println);
		 printListOfHonorRollStudents();
	}

	private Student addNewStudent(Student s) {
		Transcript newTranscript = transcriptService.save(s.getTranscript());
		return newTranscript.getStudent();
	}

	private void createClassrooms(Classroom[] classrooms) {
		for (Classroom cr : classrooms) {
			classroomService.save(cr);
		}
	}

	private void assignStudentsToClassrooms() {
		Classroom cr1 = classroomService.getClassroomById(1);
		Student s1 = studentService.getStudentById(1L);
		Student s2 = studentService.getStudentById(2L);
		Student s3 = studentService.getStudentById(3L);
		s1.setClassroom(cr1);
		s2.setClassroom(cr1);
		s3.setClassroom(cr1);
		studentService.updateStudent(cr1, s1.getStudentId());
		studentService.updateStudent(cr1, s2.getStudentId());
		studentService.updateStudent(cr1, s3.getStudentId());
		Classroom cr3 = classroomService.getClassroomById(3);
		Student s4 = studentService.getStudentById(4L);
		s4.setClassroom(cr3);
		studentService.updateStudent(cr3, s4.getStudentId());
	}
	
	private void printListOfHonorRollStudents() {
        System.out.println("List of Honor-roll students with a CGPA of 3.0+");
        System.out.println("=============================================");
        studentService.getPassingStudentsOnly()
                .stream()
                .map(s -> s.getFirstName()+ ", " + s.getLastName() + ", " + s.getCgpa())
                .forEach(System.out::println);
    }

}
