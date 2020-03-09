package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long studentId;
    @Column(name="student_number", unique = true, nullable = false)
	private Long studentNumber;
	@Column(name="first_name", nullable=false)
	private String firstName;
	private String middleName;
	@Column(name="last_name", nullable=false)
	private String lastName;
	private float cgpa;
	private LocalDate dateOfEnrollment;
	
	@OneToOne
	@JoinColumn(name="transcript_id", nullable = false, unique = true)
	private Transcript transcript;
	
	 @ManyToOne()
	 @JoinColumn(name = "classroom_id", nullable = true)
	 private Classroom classroom;
	 
	public Student(Long studentNumber, String firstName, String middleName, String lastName,
			float cgpa, LocalDate dateOfEnrollment, Transcript transcript) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
	}
	
	public Student(Long studentNumber, String firstName, String lastName,
			float cgpa, LocalDate dateOfEnrollment, Transcript transcript) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
	}

	public Student(Long studentNumber, String firstName, String lastName, Float cgpa,
			LocalDate dateOfEnrollment, Transcript transcript, Classroom cr) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		this.classroom = cr;
	}
	
	public Student(Long studentId, Long studentNumber, String firstName, String lastName,
			LocalDate dateOfEnrollment, Transcript transcript, Classroom cr) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfEnrollment = dateOfEnrollment;
		this.transcript = transcript;
		this.classroom = cr;
	}
	
	public Student() {
		super();
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}
	
	public Transcript getTranscript() {
	     return transcript;
	}

	public void setTranscript(Transcript transcript) {
	    this.transcript = transcript;
	}
	
	public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber=" + studentNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", " + transcript +
                ", " + classroom +
                '}';
    }
	
}

