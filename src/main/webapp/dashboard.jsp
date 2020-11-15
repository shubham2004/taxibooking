
<%@ include file="common/header.jspf"  %>
<style>
	body{
		background-image:linear-gradient(rgba(0,0,0,0.7), rgba(255,255,255,0.7)),url("background\(dashboard\).png");
		background-position: center center;
  		background-repeat: no-repeat;
  		background-attachment: fixed;
  		background-size: cover;
  		background-color: #464646;
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
			color: black;
		
	}
	.button:hover{
		background-color:#82f090;
		color: black;
	}
	.center {
	height: 100vh;
    width: 100vw;
    display: flex;
	}

</style>
<%@ include file="common/navigation.jspf"  %>
</head>
	<body>
		<div class="container">
			<h1>Welcome ${passanger}</h1>
			<br>
			<div class ="center">
				<div class="btn-group btn-group-justified">
  					<a href="/bookingHistory"><button type="button" class="button">Check Booking History</button></a>
  					<a href="/newBooking"><button type="button" class="button">Book new Cab</button></a>
  					<a href="/bookingHistory"><button type="button" class="button">Update Current Booking</button></a>
				</div>
			</div>
		</div>	
	
<%@ include file="common/footer.jspf"  %>