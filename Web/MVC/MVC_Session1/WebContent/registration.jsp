<%@page import="com.model.Employee"%>
<%@page import="com.helper.EmployeeCache"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Metacube</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%!String name;
	String email;
	String idValue;
	String age;
	String value;
	String readonly;
	String type;%>
	<%
		if ((Integer.parseInt(request.getParameter("id"))) != 0) {
			idValue = request.getParameter("id");
			EmployeeCache employeeCache = EmployeeCache.getInstance();
			Employee employee = employeeCache.getEmployeeForId(Integer
					.parseInt(idValue));
			name = employee.getName();
			email = employee.getEmail();
			age = Integer.toString(employee.getAge());
			value = "Update";
			readonly = "readonly";
			type = "Edit";
		} else {
			name = "";
			email = "";
			idValue = "";
			age = "";
			value = "Register";
			readonly = "";
			type = "register";
		}
	%>

	<nav>
		<h3 style="color: white">METACUBE</h3>
		<ul>
			<li><a href="HomeServlet">HOME</a></li>
			<li><a href="RegistrationFormServlet">REGISTRATION</a></li>
			<li><a href="ListController">EMPLOYEE LIST</a></li>
		</ul>
	</nav>


	<section>

		<div class="containerForm">
			<form action="RegistrationForm">

				<table>
					<tr>
						<td>NAME</td>
						<td><input type="text" name="name" id="name" value=<%=name%>></td>
						<td><label>${nameReq}</label></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email" id="email"
							value=<%=email%>></td>
						<td><label>${emailReq}</label></td>
					</tr>
					<tr>
						<td>Employee Id:</td>
						<td><input type="number" name="Eid" min='1' id="Eid"
							value=<%=idValue%> <%=readonly%>></td>
						<td><label>${idReq}</label></td>
					</tr>
					<tr>
						<td>Age</td>
						<td><input type="number" name="age" id="age" min="20"
							value=<%=age%>></td>
						<td><label>${ageReq}</label></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value=<%=type%>></td>
					</tr>
				</table>
				<input hidden='hidden' type="text" name="type" id="type"
					value=<%=type%>>
			</form>
			<label>${msg}</label>
		</div>
	</section>
</html>
