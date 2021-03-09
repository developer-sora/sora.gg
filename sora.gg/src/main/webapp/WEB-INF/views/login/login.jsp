<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="696606451912-1qpdbt2mgtl7lpnqn67pmrv3v5k2ocri.apps.googleusercontent.com">
<script>
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
</script>
<title>Insert title here</title>
</head>
<body>

	<div class="g-signin2" data-onsuccess="onSignIn"></div>
	<a href="#" onclick="signOut();">Sign out</a>
	<p>

		ID : <input>
	<p>
		PW : <input>
	<p>
		<button>로그인</button>
	<p>
		<button>회원가입</button>
	<p>
</body>
</html>