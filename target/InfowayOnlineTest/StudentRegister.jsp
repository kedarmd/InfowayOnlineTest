<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="StudentServlet" method="post">
<pre>
<h1>Student registration </h1>
    <label><b>PRN</b></label>
    <input type="text" placeholder="Enter PRN" name="prn" required>

    <label><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="fname" required>

    <label for="psw-repeat"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="lname" required>
    <hr>
 <button type="submit" name="registerbtn">Register</button>

</pre>
</form>
<%String msg=(String)request.getAttribute("msg"); 
if(msg!=null)
{
%>
<%=msg %>
<%} %>
</body>
</html>