package edu.mum.cs.cs425.studentmgmt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query("select s from Student s where s.cgpa >= ?1 order by s.lastName")
    List<Student> findStudentsWithCgpaGreaterThan3(float cgpa);

    List<Student> findStudentsByStudentNumberGreaterThan(long studentNumber);
    
//    List<Student> findAllCgpa
    
    @Modifying
    @Query("update Student s set s.classroom = ?1 where s.studentId = ?2")
    void update(Classroom classroom, long id);
}
