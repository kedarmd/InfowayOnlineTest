package com.infoway;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.infoway.Dao.DbConnection;
import com.infoway.Dao.StudentDao;
import com.infoway.Dao.StudentDaoImpl;
import com.model.Student;


public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Update() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String prn=request.getParameter("prn");
		
		try {
			Connection con= DbConnection.getConnection();
			String querry=("Select * from InfowayStudent where PRN=?");
			
			PreparedStatement pst=con.prepareStatement(querry);
			pst.setString(1, prn);
			ResultSet res=pst.executeQuery();
			
//			while(res.next()) {
//			  System.out.println(res.getString(1)); System.out.println(res.getString(2));
//			  System.out.println(res.getString(3));
//			  
//			}
			
			
			RequestDispatcher rd=request.getRequestDispatcher("Update.jsp");
			request.setAttribute("result", res);
			rd.forward(request, response);
			
			 
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	
	}

}
