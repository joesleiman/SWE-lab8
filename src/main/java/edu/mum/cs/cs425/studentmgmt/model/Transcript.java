package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transcripts")
public class Transcript {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transcriptId;
	private String degreeTitle;
	
	@OneToOne(mappedBy = "transcript", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OneToOne
    //@JoinColumn(name="student_id", nullable = false, unique = true)
    private Student student;
	  
	public Transcript(String degreeTitle) {
		super();
		this.degreeTitle = degreeTitle;
	}
	

    public Transcript(String degreeTitle, Student student) {
        this.degreeTitle = degreeTitle;
        this.student = student;
    }

    public Transcript(Long transcriptId, String degreeTitle, Student student) {
        this.transcriptId = transcriptId;
        this.degreeTitle = degreeTitle;
        this.student = student;
    }
    
	public Transcript() {
		super();
	}


	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
	
	public Student getStudent() {
		return this.student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	

    @Override
    public String toString() {
        return "Transcript{" +
                "degreeTitle='" + degreeTitle + '\'' +
                '}';
    }
	
}
