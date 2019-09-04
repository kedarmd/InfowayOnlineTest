package com.infoway.Dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public interface StudentDao {
	
	public boolean insertStudent(Student student);
	public boolean updateStudent(Student student);
	public ArrayList<Student> getAllStudent();
	public ArrayList<Student> getStudent(String no);
	
	

}
