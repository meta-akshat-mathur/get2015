<%@page import="com.vehiclemanagement.service.MetaCRMService"%>
<%@page import="java.util.ArrayList,java.util.HashMap,java.util.Map;"%>
<html>
<head>
<title>www.cardekho.com</title>
<link rel="stylesheet" href="style.css" type="text/css">
<link rel="stylesheet" href="HeaderFooterStyle.css" type="text/css">
<script src="javascript.js"></script>
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
	<div id="wrapper">
		<aside>
			<iframe scrolling="no" src="slider/demo1.html"></iframe>
		</aside>
	</div>
	<div id="backgroundcontainer">
		<div id="contents">
			<div id="adbox">
				<div id="contents1">
					<div id="search">
						<center>
							<form action="SearchCarController" method="post">
						<input type="radio" name="search" id="brand" value="brand"
							onclick="callService();" />Search By Brand <input type="radio"
							name="search" id="budget" value="budget" onclick="addPriceMin();" />Search
						By Budget <br> <br>
						<script>
							var myObject;
							var str = "";
							function callService() {
								document.getElementById("submit").disabled = false;
								myObject =<%=MetaCRMService.getMap()%>
								var make = document.getElementById("make");
								make.length = 0;
								var option = document.createElement("option");
								option.text = "---Select Make---";
								make.add(option);
								for ( var i in myObject) {
									var newOption = document
											.createElement("option");
									newOption.text = i;
									make.add(newOption);
								}
							}
							function addModel() {
								var make = document.getElementById("make").value;
								var model = document.getElementById("model");
								model.length = 0;
								if (isNaN(make) == false) {
									var option = document
											.createElement("option");
									option.text = "---Select Maximum---";
									model.add(option);
									var higherprice = [ 150000, 160000, 1700000 ];
									for (var i = 0; i < higherprice.length; i++) {
										if ((higherprice[i]) > (make)) {
											var option = document
													.createElement("option");
											option.text = higherprice[i];
											option.value = higherprice[i];
											model.add(option);
										}
									}
								} else {
									var option = document
											.createElement("option");
									option.text = "---Select Model---";
									model.add(option);
									for ( var i in myObject[make]) {
										var newOption = document
												.createElement("option");
										newOption.text = myObject[make][i];
										model.add(newOption);
									}
								}
							}
						</script>
						<select id="make" name="make" class="make" onchange="addModel();">
							<option>---Select---</option>

						</select> <select id="model" class="model" name="model">
							<option>---Select---</option>


						</select> <br> <br> <input type="submit" id="submit" disabled
							value="Search">
					</form>
						</center>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="featured">
		<center>
			<h1>LATEST ARRIVALS</h1>
			<a href="homeController" class="all-colors"><img src="images/car3.jpg" /><br>BUGGATI
				VERON</a> <a href="homeController" class="all-colors"><img
				src="images/car4.jpg" /><br>MACLAREN F1</a> <a href="homeController"
				class="all-colors"><img src="images/car5.jpg" /><br>ALFA
				ROMEO</a>
			<center>
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
				© 2015 Auto Portal. All Rights Reserved. <a href="home.jsp">Privacy
					Policy</a> <a href="home.jsp">Terms and Conditions</a>
			</p>
		</div>
	</div>
</body>
</html>