<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <link rel="icon"
        href="https://st.depositphotos.com/1005920/1832/i/950/depositphotos_18322691-stock-photo-taxi-green-glossy-icon-on.jpg">
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
            width: 500px;
            text-align: center;
            background-color: white;
            margin-top: 10px;
            margin-left: 497px;
            box-shadow: 1px 1px 10px 0.1px black;
            border-radius: 5px;
        }

        form {
            margin-top: 20px;
            margin-left: 675px;

        }

        form .button {
            padding: 1em;
            border-radius: 0.5em;
            background: #eee;
            border: none;
            font-weight: bold;
            margin-top: 1em;
            background-color: #82f090;
            
        }

        form .button:hover {
            background-color: #0ae227;
        }
    </style>
</head>

<body>
    <h1>Booking History</h1>

    <table border="1">
        <tr>
            <th>Pickup Date</th>
            <th>Pickup Place</th>
            <th>Drop Off</th>
            <th>Taxi Type</th>
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
    <form action="backToDashBoard" method="post">
        <input type="submit" class="button" value="Go Back To Dash Board">
    </form>
</body>

</html>