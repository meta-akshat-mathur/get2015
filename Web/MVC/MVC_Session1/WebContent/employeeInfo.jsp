<%@page import="com.model.Employee"%>
<%@page import="com.helper.EmployeeCache"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
  

    <title>Metacube</title>

    
    <link href="css/style.css" rel="stylesheet">


  </head>

  <body >

    <nav>
		<h3 style="color: white">METACUBE</h3>
		<ul>
			<li><a href = "HomeServlet">HOME</a></li>
			<li><a href ="RegistrationFormServlet">REGISTRATION</a></li>
			<li><a href = "ListController">EMPLOYEE LIST</a></li>
		</ul>
	</nav>

	<section>		
			<%			
				Employee employee =(Employee)request.getAttribute("employee");
				out.println(request.getRequestURL());
				out.println("<div class=\"containerView\">");
			 	out.println("<table border = \"2\"><tr>");
				out.println("<td>Employee ID</td><td>Employee Name</td><td>Employee EmailID</td><td>Employee Age</td><td>Registration Date</td></tr>");
			 	out.println("<tr><td>" + employee.getId() + "</td>");
			 	out.println("<td>" + employee.getName() + "</td>");
			 	out.println("<td>" + employee.getEmail() + "</td>");
			 	out.println("<td>" + employee.getAge() + "</td>");
			 	out.println("<td>" + employee.getDateOfRegistration() + "</td></tr></table>");
			 	out.println("</form>");
			 %>
	</section>
	</body>
   
</html>
