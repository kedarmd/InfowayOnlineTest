<%@page import="com.model.Student"%>
<%@page import="com.infoway.Dao.StudentDao"%>
<%@page import="com.infoway.Dao.StudentDaoImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ResultSet res=(ResultSet)request.getAttribute("result");%>
<form action="Update" method="post">
<pre>
<%while(res.next()) {

%>
PRN:      <input type="text" name="prn" readonly value="<%=res.getString(1) %>">
FirstName:<input type="text" name="fname" value="<%=res.getString(2) %>">
LastName: <input type="text" name="lname" value="<%=res.getString(3) %>">
<%} %>
          <input type="submit" value="Update Record" name="submit1" onclick="alert('Record Updated Successfully')">
          
          
 </pre>
</form>
<%
String aa=request.getParameter("submit1");
if(aa!=null){
String msg=null;
String prn=request.getParameter("prn");
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");

Student student=new Student(prn,fname,lname);
StudentDao sdao=new StudentDaoImpl();
boolean updated=sdao.updateStudent(student);
if(updated)
{
	response.sendRedirect("UpdateStudent.jsp");
}
%>

<%} %>
</body>
</html>