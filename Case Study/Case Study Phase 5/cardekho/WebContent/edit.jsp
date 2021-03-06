<!DOCTYPE html>
<%@page import="com.vehiclemanagement.model.Car"%>
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
	
	<div id="contents">
	<div id="abc"></div>
		<div id="contents1">
		<center>
			<%Car objCar=(Car)request.getAttribute("objOfCar");
			   	System.out.println("object of car is "+objCar);%>
				<center>
					<form action=<%=(objCar != null)?"EditCarController":"CreateCarController"%> method="post">

						<h3>Specifications</h3>
						<div>
							<table>
								<%
									if(objCar == null){
										out.write("<tr><td>Portrait Photo:</td><td><input type='file' name='photo' size='50' /></td></tr>");
									}else{
										out.write("<div><img src="+objCar.getImagePath()+" name='photo' id='photo' height='30%' width=20%' /></div>");
										out.write("<tr><td></td><td><input type='file' name='uploadPhoto' value="+objCar.getImagePath()+" size='50' id='uploadPhoto' onchange='changePic();'/></td></tr>");
									}
								%>
								<input type="hidden" name="oldMake" value="<%=(objCar != null)?objCar.getMake():""%>"/>
								<input type="hidden" name="oldModel" value="<%=(objCar != null)?objCar.getModel():""%>"/>
								<tr>
									<td>Make</td>
									<td><input type="text" name="make"
										value="<%=(objCar != null)?objCar.getMake():""%>" class="editInput" required /></td>
								</tr>
								<tr>
									<td>Model</td>
									<td><input type="text" name="model"
										value="<%=(objCar != null)?objCar.getModel():""%>"
										class="editInput" required /></td>
								</tr>
								<tr>
									<td>AC</td>
									<td><select name="ac" class="editInput" ><option selected><%=(objCar != null)?objCar.isAC():"True"%></option>
									<option><%=(objCar != null)?!objCar.isAC():"False"%></option></select>
									</td>
								</tr>
								<tr>
									<td>Power Steering</td>
									<td><select name="powerSteering" class="editInput" >
									<option selected><%=(objCar != null)?objCar.isPowerSteering():"True"%></option>
									<option><%=(objCar != null)?!objCar.isPowerSteering():"False"%></option></select>
									</td>
								</tr>
								<tr>
									<td>Accessory Kit</td>
									<td><select name="accessoryKit" class="editInput" >
									<option selected><%=(objCar != null)?objCar.isAccessoryKit():"True"%></option>
									<option><%=(objCar != null)?!objCar.isAccessoryKit():"False"%></option></select>
									</td>
								</tr>
								<tr>
									<td>Engine In CC</td>
									<td><input type="text" name="engineIncc"
										value="<%=(objCar != null)?objCar.getEngineInCC():""%>"
										class="editInput" required /></td>
								</tr>
								<tr>
									<td>Fuel Capacity</td>
									<td><input type="text" name="fuelCapacity"
										value="<%=(objCar != null)?objCar.getFuelCapacity():""%>"
										class="editInput" required /></td>
								</tr>
								<tr>
									<td>Milage</td>
									<td><input type="text" name="milage"
										value="<%=(objCar != null)?objCar.getMilage():""%>"
										class="editInput" required /></td>
								</tr>
								<tr>
									<td>Price</td>
									<td><input type="text" name="price"
										value="<%=(objCar != null)?objCar.getPrice():""%>"
										class="editInput" required /></td>
								</tr>
								<tr>
									<td>Road Tax</td>
									<td><input type="text" name="roadTax"
										value="<%=(objCar != null)?objCar.getRoadTax():""%>"
										class="editInput" required /></td>
								</tr>
							</table>
							<br> <input type="submit" value="Submit">
							<br>
							<%=request.getAttribute("message") != null ? request.getAttribute("message") :""  %>
					</form>
		</div>
			</center>
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
				© 2015 Auto Portal. All Rights Reserved. <a href="adminhomepage.html">Privacy
					Policy</a> <a href="adminhomepage.html">Terms and Conditions</a>
			</p>
		</div>
	</div>
</body>
</html>