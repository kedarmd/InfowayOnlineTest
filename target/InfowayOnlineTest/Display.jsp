<%@page import="com.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.infoway.Dao.StudentDao"%>
<%@page import="com.infoway.Dao.StudentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
StudentDao sdao=new StudentDaoImpl();
ArrayList<Student> alist=sdao.getAllStudent();


%>
<table border="1px">
<tr>
<th>PRN</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
<% for(Student aa:alist)
	
{
	%>
	

<tr>

<td>
<%=aa.getPrn() %>
</td>
<td><%=aa.getName() %></td>
<td><%=aa.getLname() %>
</td></tr>
<%} %>
</table>

</body>
</html>