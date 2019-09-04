package com.infoway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoway.Dao.StudentDao;
import com.infoway.Dao.StudentDaoImpl;
import com.model.Student;
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public StudentServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
	
		
		
		String prn1=request.getParameter("prn");
		String name1=request.getParameter("fname");
		String lname1=request.getParameter("lname");
		
	//	out.println("welcome"+prn+" "+name+""+lname);
		
		Student student=new Student(prn1,name1,lname1);
		
	StudentDao sdao=new StudentDaoImpl();
	boolean res=sdao.insertStudent(student);
	
String msg="prn already exists";

if(res)
{
	msg="Record Inserted";
}

RequestDispatcher rd=request.getRequestDispatcher("StudentRegister.jsp");
request.setAttribute("msg", msg);
rd.forward(request, response);
	
	
		
		
	}

}
