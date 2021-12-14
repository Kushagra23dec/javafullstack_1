<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.ku.dto.UserDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>

<% 
  	List<UserDto> o = (List<UserDto>) session.getAttribute("ob"); ;

try{ 
	   if( session.getAttribute("ob") == null ){
		   
		   response.sendRedirect("index.jsp");
		    
	   }
	  
}
catch(Exception e){
	response.sendRedirect("index.jsp?FromException");
	 
}
 
 %>





<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<center><H1>Welcome to the Profile</H1></center>
		
		<table border="1">
		<tr>
		<td>Id</td>
		<td>Name </td>
		<td>RollNo</td>
		<td>Marks</td>
		</tr><% 
		 
		for(UserDto ude:o) { %>
		<tr>
		<td><%= ude.getId() %> </td>
		<td><%= ude.getName() %></td>
		<td><%= ude.getRollno() %> </td>
		<td><%= ude.getMarks() %> </td>
		
		</tr>
		<% 
		 
		} 
		 
		 %>
		</table>
</body>
</html>