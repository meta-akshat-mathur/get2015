<!DOCTYPE>
<html>
<head>
<title>Registration Form</title>

<link rel="stylesheet" href="StyleSheet.css" />
<script type="text/javascript" src="JavaScript.js"></script>
</head>
<body>
	<form action="Registration" class="register">
		<h1>Registration</h1>
		<fieldset class="row1">
			<legend>Personal Details </legend>
			<p>
				<label>Name * </label> <input id="name" name="firstName"
					type="text" placeholder="Enter Name here" /> <span id="fName"></span>
			</p>
			<p>
				<label>User Name * </label> <input id="userName" name="userName"
					type="text" placeholder="Enter USERiD here" /> <span id="lName"></span>
			</p>
			<p>
				<label>Password* </label> <input id="password" name="password"
					type="password" placeholder="Enter password here" /> <span
					id="passwordValue"></span>
			</p>
			<p>
				<label>Repeat Password* </label> <input id="confirmPassword"
					name="confirmPassword" type="password"
					placeholder="Re-type password" /> <span id="cPasswordValue"></span>
			</p>

			
			<p>
				<label>  E-Mail Id* </label>
				<input id="eMail" name="eMailID" type="email" placeholder="Enter ID here" />
				<span id="eMailValue"></span>
			</p>
		</fieldset>
		<div>
			<input type="submit" id="button" class="button" value="register" onclick="return validate()">
		</div>
	</form>
</body>
</html>





