package com.infoway.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.mysql.cj.xdevapi.Result;

public class StudentDaoImpl implements StudentDao {

	
	@Override
	public boolean insertStudent(Student student) {
		Connection con ;
		try {
			con= DbConnection.getConnection();
			String querry=("insert into InfowayStudent values(?,?,?) ");
			PreparedStatement pst= con.prepareStatement(querry);
			
			pst.setString(1,student.getPrn());
			pst.setString(2, student.getName());
			pst.setString(3, student.getLname());
			
			int res=pst.executeUpdate();
			if(res>0)
			{
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
						return false;
		}
		
		return false;
		
	}

	@Override
	public boolean updateStudent(Student student) {
		Connection con ;
		try {
			con=DbConnection.getConnection();
			String querry=("update InfowayStudent set firstname=?, lastname=? where prn=?;");
			PreparedStatement pst=con.prepareStatement(querry);			
			pst.setString(1, student.getName());
			pst.setString(2, student.getLname());
			pst.setString(3, student.getPrn());
			
			 
			 int aa=pst.executeUpdate();
			 if(aa==1)
			 {
				 return true;
			 }
			 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}

	@Override
	public ArrayList<Student> getAllStudent() {
		try {
			Connection con ;
			ArrayList<Student> alist=new ArrayList<>();
			con= DbConnection.getConnection();
			
			String querry=("select *from InfowayStudent");
			PreparedStatement pst=con.prepareStatement(querry);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			  String prn=rs.getString("PRN");
			  String name=rs.getString("firstname");
			  String lname=rs.getString("lastname");
			  
			  Student stu=new Student(prn,name,lname);
			  
			  alist.add(stu);
			}
			return alist;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Student> getStudent(String prn) {
		Connection con ;
		try {
			
			ArrayList<Student> alist=new ArrayList<>();
			con= DbConnection.getConnection();
			String querry=("select *from InfowayStudent where PRN=?");
			PreparedStatement pst=con.prepareStatement(querry);
			
			pst.setString(1,prn);
			
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				 String pn=rs.getString("PRN");
				  String name=rs.getString("firstname");
				  String lname=rs.getString("lastname");
				  
				  Student stu=new Student(pn,name,lname);
				  
				  alist.add(stu);
			}
			return alist;
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

}
