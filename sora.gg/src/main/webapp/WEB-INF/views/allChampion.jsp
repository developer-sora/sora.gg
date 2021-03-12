<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 1600px;">
		<c:forEach var="v" items="${val }">
			<div id="result"
				style="width:140px; margin-bottom: 20px; margin-right: 20px; float: left;">
				<div align="center">
					<a href="champDetail?c_name=${v.name}"> <img id="icon2"
						src="https://ddragon.leagueoflegends.com/cdn/11.4.1/img/champion/${v.name}.png">
					</a>
				</div>
				<div align="center"> <a href="go.detail?name=${v.name}">${v.nameKr}</a></div>
			</div>
		</c:forEach>
	</div>
</body>
</html>