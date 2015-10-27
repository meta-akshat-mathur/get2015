<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temperature Converter</title>
</head>
<body>
	<form action='ConverterUse'>
		<table>
		  <tr>
		    <td>Fahrenheit to Celsius:</td>
		    <td>
		    <input class="frmInput" type="number" size="30" step="any" name="Fahrenheit"/>
		    </td>
		    <td>${result}</td>
		  </tr>
		</table>

<table>
  <tr>
    <td>Celsius to Fahrenheit:</td>
    <td>
    <input class="frmInput" type="number" size="30" step = "any" name="Celsius"/> 
    </td>
    <td>${result1}</td>
  </tr>
  <tr>
    <td></td>
    <td align="right">
    <input type="submit" value="Submit" class="button">
    </td>
  </tr>
</table>
</form>
</body>
</html>