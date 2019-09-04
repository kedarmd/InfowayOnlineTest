<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.infoway.Dao.StudentDao"%>
<%@page import="com.infoway.Dao.StudentDaoImpl"%>
<%@page import="com.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
<form action="SingleDisplay.jsp" method="post">
Enter PRN for Displaying Record:<input type="text" name="prn" >
                                
                                <input type="submit" name="submit2" value="Check Record">    
   </form>                               
</pre>


<%String btnValue=request.getParameter("submit2") ;
if(btnValue!=null)
{
	String prn=request.getParameter("prn");
	// Student student=new Student();
	StudentDao sdao=new StudentDaoImpl();
	
	ArrayList<Student> alist =  sdao.getStudent(prn);
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
	
<% }


%>



</body>

</html>