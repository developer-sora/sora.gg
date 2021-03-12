<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
<meta name="google-signin-client_id"
	content="696606451912-1qpdbt2mgtl7lpnqn67pmrv3v5k2ocri.apps.googleusercontent.com">
<!-- <script>
	function onSignIn(googleUser) {
		var id_token = googleUser.getAuthResponse().id_token;
		var profile = googleUser.getBasicProfile();
		console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
		console.log('Name: ' + profile.getName());
		console.log('Image URL: ' + profile.getImageUrl());
		console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

		setTimeout(sendPost("loginsuccess"), 5000);

		function sendPost(action, params) {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', 'http://localhost/sora/loginsuccess');
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.onload = function() {
				console.log('Signed in as: ' + xhr.responseText);
			};
			xhr.send('idtoken=' + id_token);
			console.log('idtoken=' + id_token);
			var form = document.createElement('form');

			form.setAttribute('method', 'post');

			form.setAttribute('action', action);

			document.charset = "utf-8";

			document.body.appendChild(form);

			form.submit();
			
			

		}

	}

	function signOut() {
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signOut().then(function() {
			console.log('User signed out.');
		});
		auth2.disconnect();

	}
</script> -->

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="resources/css/logincss.css" rel="stylesheet" >
 
    <title>로그인 폼</title>
</head>
<body>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h3 class="card-title text-center" style="color:#113366;">SORA.GG</h3>
		</div>
		<div class="card-body">
	<form action="login.go" name="f" method="post" onsubmit="return logincheck();">
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
	<br>
        <label for="inputEmail" class="sr-only">Email</label>
        <input type="text" id="uid" class="form-control" name = "u_email" placeholder="Email" required autofocus><BR>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="upw" class="form-control" name = "u_password" placeholder="Password" required><br>
        ${lr }
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 기억하기
          </label>
        </div>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">LOGIN</button>
		<a href ="email.do">회원가입</a>
		<a href ="main">홈으로</a>
      </form>
      
		</div>
	</div>

	<div class="modal">
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 

	<!-- <a href="#" onclick="signOut();">Sign out</a> -->

</body>
</html>