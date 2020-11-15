
<%@ include file="common/header.jspf"  %>
<style>
body{
          background-image:linear-gradient(rgba(0,0,0,0.7), rgba(255,255,255,0.7)),url("background\(dashboard\).png");
		background-position: center center;
  		background-repeat: no-repeat;
  		background-attachment: fixed;
  		background-size: cover;
        }
.msg {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  width: 50%;
  border: 3px solid green;
  padding: 10px;
  text-align: center;
  background-color: white;
}

</style>
</head>
<body>

<%@ include file="common/navigation.jspf"  %>
	<div class="container">
		<div class ="msg">
			Thankyou for choosing us ${name} <br>
			your request for ${taxt} on ${date} <br>
			has been confirmed.<br>
			Please go to the dash board and check your booking.<br><br>
			<a href="/backToDashBoard"><button type="button" class="btn btn-success">Go Back to Dashboard</button></a>
			
   	</div>
  </div>
<%@ include file="common/footer.jspf"  %>