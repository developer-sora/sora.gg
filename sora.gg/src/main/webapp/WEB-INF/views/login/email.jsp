<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="resources/css/logincss.css" rel="stylesheet" >
</head>
 
 <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

		
		

 <c:if test = "${u_email == null}">

	<div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h3 class="card-title text-center" style="color:#113366;">이메일 중복 확인</h3>
		</div>
		<div class="card-body">
                        <form action="email_check.do" method="post" name = "j" onsubmit="return joincheck();">
        <label for="inputEmail" class="sr-only">Email</label>
        <input type="email" id="uid" class="form-control" name = "u_email" placeholder="Email" required autofocus><BR>
                             <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">중복 확인</button>
                        </form>                                      
                        </div>
                        </div>
        </c:if>
       
 
  <!-- 넘겨받은 이메일이 있을시에 출력되는 구문, 이메일 중복확인을 한 후에 다른 이메일로 변경하지 못하도록 이메일 값을 그대로 받아옴  -->

        <c:if test = "${u_email != null}">
 <div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
	<h3 class="card-title text-center" style="color:#113366;">이메일 인증</h3>
                    <form action="auth.do${u_email}" method="post">
                    <input name ="email" value="${u_email }" type="hidden">
                        <div align="center">${u_email}</div>
                        <br> <br>
                        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">이메일 인증받기</button>
 
        </form>
                        </div>
                        </c:if>
                   

	<div class="modal">
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 


</body>
</html>