<%@page import="com.model.Employee"%>
<%@page import="com.helper.EmployeeCache"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>


<title>Metacube</title>


<link rel="stylesheet" href="css/style.css" />

</head>

<body>

	<nav>
		<h3 style="color: white">METACUBE</h3>
		<ul>
			<li><a href="HomeServlet">HOME</a></li>
			<li><a href="RegistrationFormServlet">REGISTRATION</a></li>
			<li><a href="ListController">EMPLOYEE LIST</a></li>
		</ul>
	</nav>

	<section>


		<%
			List<Employee> employeeList = (List<Employee>) request
					.getAttribute("list");
			Iterator<Employee> listIterator = employeeList.iterator();
			out.println("<div class= 'containerTable'>");
			out.println("<table border = '3'>");
			out.println("<tr><td>Employee ID</td> <td>Employee Name</td><td>Employee Email ID</td><td>View Details</td><td>Edit Details</td></tr>");
			while (listIterator.hasNext()) {
				Employee employee = listIterator.next();
				;

				out.println("<tr><td>" + employee.getId() + "</td>");
				out.println("<td>" + employee.getName() + "</td>");
				out.println("<td>" + employee.getEmail() + "</td>");
				out.println("<td><a href='EmployeeDetail?id="
						+ employee.getId() + "'>VIEW</a></td>");
				out.println("<td><a href='RegistrationFormServlet?id="
						+ employee.getId() + "'>EDIT</a></td></tr>");

			}
			out.println("</table></div>");
		%>
	</section>
</body>
</html>
