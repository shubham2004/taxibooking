<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${passanger}
<br>
	<form class="login-form" action="logincust" method="post">
	  	<input type="submit" class="button" value="Check Booking History">
	</form>
 	<form class="login-form" action="newBooking" method="post">
		<input type="submit" class="button" value="Book new Cab">
	</form>
	<form class="login-form" action="logincust" method="post">
		<input type="submit" class="button" value="Update Current Booking">					
	</form>
</body>
</html>