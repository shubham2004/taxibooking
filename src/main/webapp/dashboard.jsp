<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="https://st.depositphotos.com/1005920/1832/i/950/depositphotos_18322691-stock-photo-taxi-green-glossy-icon-on.jpg">
    <meta charset="ISO-8859-1">
<title>Dashboard</title>



<style>
	.navigator{
		background:black;
		background-color: rgb(0,0,0,0.95);
		color: #FFFFFF ;
		position: fixed;
		top: 0px;
		width: 100%;
    
    }
	.navigator a{
		color:#ffffff;
		text-decoration: none;
		font-size: 25px;
		margin-left:2%;
		padding: 14px 16px;
		display: block;
		float: left;
	}
	.navigator a:hover{
		color:black;
		background: #0ae227;
		border-radius: 10px;
	}
	body{
		background-image:linear-gradient(rgba(0,0,0,0.7), rgba(255,255,255,0.7)),url("background\(dashboard\).png");
		background-size:1550px 800px;
	}
	h1{
		font-size: 50px;
		font-family: sans-serif;
		margin-top: 150px;
		color: #82f090;
		text-align: center;	
	}
	.button {
		    margin: 50px;
			height: 100px;
			width:250px;
			background-color:#0ae227;
			border-radius: 20px;
			font-weight: bold;
			font-family: sans-serif;
			font-size: 20px;
			
		
	}
	.button:hover{
		background-color:#82f090;
	}
	.center {
	display: table;
   margin: 0 auto
	}

</style>



</head>
<body>
	<div class="navigator">
        <a href="">HOME</a>
        <a href="#menu">MENU</a>
        <a href="#about">ABOUT</a>
        <a href="#gallery">GALLERY</a>
        <a href="#testimonials">TESTIMONIALS</a>
        <a href="#contact">CONTACT</a>
    </div>
    
	<h1>Welcome ${passanger}</h1>
	<br>
	<div class ="center">
		<div class="btn-group btn-group-justified">
  			<a href="/bookingHistory"><button type="button" class="button">Check Booking History</button></a>
  			<a href="/newBooking"><button type="button" class="button">Book new Cab</button></a>
  			<a href="/bookingHistory"><button type="button" class="button">Update Current Booking</button></a>
		</div>
	</div>
		
</body>
</html>