<%@ include file="common/header.jspf"  %>
    <style>
        h1{
            color: #82f090;
            margin-top: 200px;
            text-align: center;
        }
        body{
          background-image:linear-gradient(rgba(0,0,0,0.7), rgba(255,255,255,0.7)),url("background\(dashboard\).png");
		background-position: center center;
  		background-repeat: no-repeat;
  		background-attachment: fixed;
  		background-size: cover;
        }
        table {
            background-color: white;
            box-shadow: 1px 1px 10px 0.1px black;
            border-radius: 10px;
            text-align: center;
        }
		.table-head {
			background-color: #808080;
			color: white;
			text-align: center;
		}
       
    </style>
</head>

<body>

<%@ include file="common/navigation.jspf"  %>
<div class="container">
    <h1>Booking History</h1>
    <table class="table table-striped table-bordered">
        <tr >
            <th class="table-head">Pickup Date</th>
            <th class="table-head">Pickup Place</th>
            <th class="table-head">Drop Off</th>
            <th class="table-head">Taxi Type</th>
        </tr>
       
        
        <c:forEach items="${lists}" var="booking">
            <tr>

                <td>
                    <c:out value="${booking.pickupDate}" />
                </td>
                <td>
                    <c:out value="${booking.pickupPlace}" />
                </td>
                <td>
                    <c:out value="${booking.dropOff}" />
                </td>
                <td>
                    <c:out value="${booking.taxi}" />
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="text-center">
            <a href="backToDashBoard"><button type="submit" class="btn btn-success">Go Back To Dash Board</button></a>
          </div>
    </div>

<%@ include file="common/footer.jspf"  %>