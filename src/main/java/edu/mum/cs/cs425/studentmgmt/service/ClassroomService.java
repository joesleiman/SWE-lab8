package edu.mum.cs.cs425.studentmgmt.service;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;

public interface ClassroomService {
	public Classroom save(Classroom cr);
	public Classroom getClassroomById(int id);
}
