function validate()
 {
	 var flag = true;
	if(document.getElementById("name").value.trim() == "")
	{
		document.getElementById("fName").innerHTML="Enter first name";
		flag=false;
	} 
	
	if(document.getElementById("userName").value.trim() == "") 
	{
		document.getElementById("uName").innerHTML="Enter last name";
	    flag=false;
	}
	
	if(document.getElementById("password").value.length < 8 )
	{
		document.getElementById("passwordValue").innerHTML="Password Length should be greater than 8";
	     flag=false;
	}
	
	if(document.getElementById("password").value != document.getElementById("confirmPassword").value) 
	{  
      document.getElementById("cPasswordValue").innerHTML="Password doesn't match";
	   flag=false;
	}
	
	if(document.getElementById("eMail").value=="")
	{
		document.getElementById("eMailValue").innerHTML="Please Enter E-Mail ID";
	    flag=false;
	}
	if(flag==true){
		alert("Form submitted");
	}
	return flag;
}