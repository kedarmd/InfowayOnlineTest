package com.infoway.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.AddQuestion;
import com.model.MCQ;
import com.model.Student;

public class AddQuestionDaoImpl implements AddQuestionDao  {

	@Override
	public boolean insertFromExcel(ArrayList<MCQ> alist) {
		Connection con;
		StringBuffer question;
		String a,b,c,d,answer=null;
		String querry[]=new String[alist.size()];
		try {
			
			con= DbConnection.getConnection();
		Statement st=con.createStatement();
		int i=0;
			for(MCQ s:alist)
			{
				question=s.getQuestion();
				a=s.getA();
				b=s.getB();
				c=s.getC();
				d=s.getD();
				answer=s.getAns();
				//answer="a";
				
			 querry[i]="insert into addquestion values(default,'"+question+"','"+a+"','"+b+"','"+c+"','"+d+"','"+answer+"')";
			 st.addBatch(querry[i]);
			i=i+1;
			 
			}
			
			int res[]=st.executeBatch();
			return true;
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}



}

