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
	<div>
		<div>
			<a href="champion">모든 챔피언</a>
		</div>
		<div>
			<a href="rotation">로테이션 챔피언</a>
		</div>
	</div>
	<div style="width: 1500px;">
		<h2>챔피언 목록</h2>
		<div>
			<form action="championSearch">
				<input name="championName" placeholder="챔피언 검색">
				<button>검색</button>
			</form>
		</div>
	</div>
		<hr>
	<div style="width: 1600px;">
		<c:forEach var="v" items="${val }">
			<div id="result"
				style="width:140px; margin-bottom: 20px; margin-right: 20px; float: left;">
				<div align="center">
					<a href="champDetail?championName=${v.name}"> <img id="icon2"
						src="https://ddragon.leagueoflegends.com/cdn/11.4.1/img/champion/${v.name}.png">
					</a>
				</div>
				<div align="center"> ${v.nameKr}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>