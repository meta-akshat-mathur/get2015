<%@page import="com.vehiclemanagement.model.Car"%>
<%@page import="java.util.ArrayList"%>
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
		<div class="searchDetails" id="searchDetails">
			<div id="car1">
				<%
					ArrayList<Car> carList = (ArrayList<Car>) request
							.getAttribute("carList");
					if (carList.size() > 0) {
						for (Car objCar : carList) {
				%>
				<h1><%=objCar.getMake()%></h1>
				<img src=<%=objCar.getImagePath()%> width="400px" height="200px" />
				<br>
				<h2>
					Price : Rs
					<%=objCar.getPrice()%>/-
				</h2>
				<br /> <a
					href="DetailsCarController?make=<%=objCar.getMake()%>&model=<%=objCar.getModel()%>">View
					Details</a>
				<%
					}
					} else {
						out.write("<h3>No Cars to Display</h3>");
					}
				%>
				<br>

			</div>
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
										</tr>
										<tr>
											<td>Phone:</td>
											<td>540-754-4081</td>
										</tr>
										<tr>
											<td>Hours Open:</td>
											<td>Tues- Sundays: 10 am- 9pm</td>
										</tr>
									</tbody>
								</table>
								<h3>Follow us</h3>
								<div id="connect">
									<a href="http://facebook.com/" target="_blank" class="facebook"></a>
									<a href="http://twitter.com/" target="_blank" class="twitter"></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer">
				<p>
					© 2015 Auto Portal. All Rights Reserved. <a href="home.html">Privacy
						Policy</a> <a href="home.html">Terms and Conditions</a>
				</p>
			</div>
		</div>
</body>
</html>