<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>My Example</title>

<!-- CSS -->
<style>
    body{
        background-color: rgb(221, 252, 221);
    }
    h1{
        text-align: center;
        color:rgb(0, 0, 0) ;
    }
    
    .myForm {
        background-color: white;
        font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
        font-size: 15px;
        width: 50em;
        padding: 1em;
        border: 3px solid #ccc;
        box-shadow: 1px 1px 50px 0.1px black;
        margin: auto;
    }

    .myForm * {
        box-sizing: border-box;
    }

    .myForm fieldset {
        border: none;
        padding: 0;
    }

    .myForm legend,
    .myForm label {
        padding: 0;
        font-weight: bold;
    }

    .myForm label.choice {
        font-size: 0.9em;
        font-weight: normal;
    }

    .myForm input[type="text"],
    .myForm input[type="tel"],
    .myForm input[type="email"],
    .myForm input[type="datetime-local"],
    .myForm select,
    .myForm textarea {
        display: block;
        width: 100%;
        border: 1px solid #ccc;
        font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
        font-size: 0.9em;
        padding: 0.3em;
        box-shadow: 0.5px 0.5px 2px 2px rgb(187, 241, 194) ;
        border-radius:5px
    }
    .myForm input[type="datetime-local"]{
        background-color: rgb(200, 245, 220));
    }

    .myForm textarea {
        height: 100px;
    }

    .myForm button {
        padding: 1em;
        border-radius: 0.5em;
        background: #eee;
        border: none;
        font-weight: bold;
        margin-top: 1em;
        background-color: rgb(153, 245, 207);
    }

    .myForm button:hover {
        cursor: pointer;
        background-color: rgb(0, 255, 149);
    }
    fieldset input:hover{
        box-shadow: 0.5px 0.5px 2px 2px rgb(187, 241, 194) ;
    }
    #pickup_place ,
    .dt{
        
        background-color: rgb(200, 245, 220);
        
    }
    
</style>

</head>
<body>
    <h1>Conform Your Booking</h1>

    <form class="myForm" method="get" action="result">

            <p>
                <label>Name
                    <input type="text" name="customer_name" required value=${name} }>
                </label> 
            </p>

            <p>
                <label>Phone 
                    <input type="tel" name="phone_number" value=${mnumber}>
                </label>
            </p>

            <p>
                <label>Email 
                    <input type="email" name="email_address" value=${email}>
                </label>
            </p>

        <fieldset>
            <legend>Which taxi do you require?</legend>
            <p><label class="choice"> <input type="radio" name="taxi" required value="car"> Car </label></p>
            <p><label class="choice"> <input type="radio" name="taxi" required value="van"> Van </label></p>
            <p><label class="choice"> <input type="radio" name="taxi" required value="tuktuk"> Tuk Tuk </label></p>
        </fieldset>

        <fieldset>
            <legend>Extras</legend>
            <p><label class="choice"> <input type="checkbox" name="extras" value="baby"> Baby Seat </label></p>
            <p><label class="choice"> <input type="checkbox" name="extras" value="wheelchair"> Wheelchair Access </label></p>
            <p><label class="choice"> <input type="checkbox" name="extras" value="tip"> Stock Tip </label></p>
        </fieldset>

         <p>
            <label>Pickup Date/Time
                <input class="dt" type="datetime-local" name="pickup_time" required>
            </label>
        </p>
            
        <p>
            <label>Pickup Place
            <select id="pickup_place" name="pickup_place">
                <option value="" selected="selected">Select One</option>
                <option value="office" >Taxi Office</option>
                <option value="town_hall" >Town Hall</option>
                <option value="telepathy" >We'll Guess!</option>
            </select>
            </label> 
        </p>

        <p>
            <label>Dropoff Place
                <input  type="text" name="dropoff_place" required list="destinations">
            </label>

            <datalist id="destinations">
                <option value="Airport">
                <option value="Beach">
                <option value="Fred Flinstone's House">
            </datalist>
        </p>

        <p>
            <label>Special Instructions
                <textarea name="comments" maxlength="500"></textarea>
            </label>
        </p>

        <p><button>Submit Booking</button></p>
         <form action="backToDashBoard" method="post">
        <input type="submit" class="button" value="Go Back To Dash Board" formnovalidate>
    </form>
    </form>
   

</body>
</html>