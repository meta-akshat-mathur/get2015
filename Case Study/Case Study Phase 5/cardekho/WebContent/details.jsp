<%@page import="com.vehiclemanagement.model.Car"%>
<html>

	<head>
	<title>www.cardekho.com</title>
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="stylesheet" href="HeaderFooterStyle.css" type="text/css">
	</head>
	<body>
		<div id="header">
		<div>
			<div id="logo">
				<a href="home.jsp"><h1>cardekho</h1></a>
			</div>
			<ul id="navigation">
				<li><a href="HomeController">Home</a></li>
				<%
						if (session.getAttribute("userName") != null)
							out.print("<li><a href='CreateCarController'>Create</a></li>");
					%>
				<%
						if (session.getAttribute("userName") == null)
							out.print("<li><a href='LoginController'>Login</a></li>");
						else
							out.print("<li><a href='LogoutController'>Logout</a></li>");
					%>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
	</div>
	<div id="contents">
	<div id="abc"></div>
		<div id="contents1">
		<center>
			<%
					String actionUrl = "";
					if (session.getAttribute("userName") == null)
						actionUrl = "details.jsp";
					else {
						//session.setAttribute("", "");
						actionUrl = "EditCarController";
						
					}
					Car objCar = (Car)request.getAttribute("objOfCar");
					session.setAttribute("objOfCar", objCar);
					if(objCar!=null)
					{
						request.setAttribute("objOfCar",objCar);
					}%>
				<form action="EditCarController">
				<div>
					<img src=<%=objCar.getImagePath()%> height="30%"
						width="20%" />
				</div>
				</br>
				<h3>Specifications</h3>
				<div>
					<table>
						<tr>
							<td>Make</td>
							<td><%=objCar.getMake()%></td>
						</tr>
						<tr>
							<td>Model</td>
							<td><%=objCar.getModel()%></td>
						</tr>
						<tr>
							<td>AC</td>
							<td><%=objCar.isAC()%></td>
						</tr>
						<tr>
							<td>Power Steering</td>
							<td><%=objCar.isPowerSteering()%></td>
						</tr>
						<tr>
							<td>Accessory Kit</td>
							<td><%=objCar.isAccessoryKit()%></td>
						</tr>
						<tr>
							<td>Engine In CC</td>
							<td><%=objCar.getEngineInCC()%></td>
						</tr>
						<tr>
							<td>Fuel Capacity</td>
							<td><%=objCar.getFuelCapacity()%></td>
						</tr>
						<tr>
							<td>Milage</td>
							<td><%=objCar.getMilage()%></td>
						</tr>
						<tr>
							<td>Price</td>
							<td><%=objCar.getPrice()%></td>
						</tr>
						<tr>
							<td>Road Tax</td>
							<td><%=objCar.getRoadTax()%></td>
						</tr>
					</table>
					<%
						if (session.getAttribute("userName") != null)
								out.write("<input type='submit' value='Edit'>");
					%>
					<br>
				</div>
				</form>
			</center>
		</div>	
	<div id="footer">
		<div id="articles">
			<div class="header">
				<div class="body">
					<div>
						<div class="section">
							<h3>About us</h3>	
						</div>
						<div class="section">
							<h3>Latest Blog Posts</h3>
						</div>
						<div class="section">
							<h3>Contact Information</h3>
							<table class="info">
								<tbody>
									<tr>
										<td>Address:</td>
										<td>Sitapura
									</tr> <tr>
										<td>Phone:</td>
										<td>540-754-4081</td>
									</tr> <tr>
										<td>Hours Open:</td>
										<td>Tues- Sundays: 10 am- 9pm</td>
									</tr>
								</tbody>
							</table>
							<h3>Follow us</h3>
							<div id="connect">
								<a href="http://facebook.com/" target="_blank" class="facebook"></a> <a href="http://twitter.com/" target="_blank" class="twitter"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<p>
				© 2015 Auto Portal. All Rights Reserved. <a href="home.html">Privacy Policy</a> <a href="home.html">Terms and Conditions</a>
			</p>
		</div>
	</div>
	</body>
	</html>