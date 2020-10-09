<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
}
</style>
</head>
<body>
	<div class ="msg">
		Thankyou for choosing us ${name} <br>
		your request for ${taxt} on ${date} <br>
		has been confirmed. 
	</div>
</body>
</html>