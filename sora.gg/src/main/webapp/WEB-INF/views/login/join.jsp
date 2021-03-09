<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "join.go" name="j" method="post" onsubmit="return joincheck();">
Email Address : <input name = "u_email"><p>
Nickname : <input name = "u_nickname" maxlength="10"><p>
Password : <input name="u_password"><p>
Password Check : <input name="passwordCheck"><p>

<button type="button" onclick="history.go(-1)">CANCEL</button>
<button>SIGN UP</button> <p>
</form>

</body>
</html>