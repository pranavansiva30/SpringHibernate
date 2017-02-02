<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 <!-- <script src="${pageContext.request.contextPath}/resources/scripts/Departments.js"></script>-->
<script>
$(document).ready(function(){
    $("#submit").click(function(){
    	var fdo=new FormData();
    	var name=$("#name").val();
    	var departmentcode=$("#departmentcode").val();
    	fdo.append('name',name);
    	fdo.append('departmentcode',departmentcode);
    	
    	$.ajax({
            type: "POST",
            url: "department",
            data:fdo,
            processData : false,
    		contentType : false,
            success:  function (response) {
           	 if(response.status=="SUCCESS"){
           	alert(response.status);
           	alert(response.result[0].name);
            }
            }
           	 ,
            error: function () {
           	
            }
        });    });
});
</script>
</head>
<body>
<form id="depform" method="POST" action="department">
Name:<input type="text" id="name" name="name"> <br/>
Department Code:<input type="text" id="departmentcode" name="departmentcode"> <br/>


</form>
<input type="submit" value="submit" id="submit">
</body>
</html>