<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <link rel="icon"
        href="https://st.depositphotos.com/1005920/1832/i/950/depositphotos_18322691-stock-photo-taxi-green-glossy-icon-on.jpg">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
    <style>
        h1{
            color: #82f090;
            margin-top: 200px;
            text-align: center;
        }
        body{
            background-image:linear-gradient(rgba(0,0,0,0.7), rgba(255,255,255,0.7)),url("back.jpeg");
		    background-size:1710px 800px;
            
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
    <form action="backToDashBoard" method="get">
    <div class="text-center">
            <button type="submit" class="btn btn-success">Go Back To Dash Board</button>
          </div>
    </form>
    </div>
</body>

</html>