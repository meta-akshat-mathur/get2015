function activateSubmit() 
{
	if(document.getElementById("acceptCondition").checked == true)
	{
		document.getElementById("button").disabled = false;
	}
	else 
	{
		document.getElementById("button").disabled = true;
	}
}
function validate()
 {
	 var flag = true;
	if(document.getElementById("firstName").value.trim() == "")
	{
		document.getElementById("fName").innerHTML="Enter first name";
		flag=false;
	} 
	
	if(document.getElementById("lastName").value.trim() == "") 
	{
		document.getElementById("lName").innerHTML="Enter last name";
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
	
	if(document.getElementById("states").value=="")
	{ 
       document.getElementById("stateValue").innerHTML="Please select state";
		flag=false;
	}
	if(document.getElementById("cities").value=="") 
	{ 
     document.getElementById("cityValue").innerHTML="Please select city";
	   flag=false;
	}
	if(document.getElementById("address").value=="")
	{
		document.getElementById("addressValue").innerHTML="Please Enter Address";
	    flag=false;
	}
   if( document.getElementById("age").value=="")
	{
    	document.getElementById("ageValue").innerHTML="Please Enter age";
		flag=false;	
	}
	if(flag==true){
		alert("Form submitted");
	}
	return flag;
}
function createCity() 
{
	var cityObject = document.getElementById("city");
	var stateObject = document.getElementById("states");
	switch(stateObject.value) {
		case "Rajasthan" :
			cityObject.innerHTML = "<Option>Jaipur</option><Option>Bikaner</option><Option>Kota</option><Option>Ajmer</option>";
			break;
		case "Gujrat" :
			cityObject.innerHTML = "<Option>Ahmedabad</option><Option>Surat</option><Option>Vadodara</option><Option>Rajkot</option>";
			break;
		case "Uttar Pradesh" :
			cityObject.innerHTML = "<Option>Agra</option><Option>Kanpur</option><Option>Aligarh</option><Option>Mathura</option>";
			break;
		case "Uttarakhand":
			cityObject.innerHTML = "<Option>Dehradun</option><Option>Haridwar</option><Option>Roorkee</option><Option>Rishikesh</option>";
		case "Punjab":
			cityObject.innerHTML = "<Option>Amritsar</option><Option>Jalandhar</option><Option>Patiala</option><Option>chandigarh</option>";
			break;
	}
}


