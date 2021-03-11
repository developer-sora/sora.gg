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
	<div>
		<jsp:include page="${championPage }"></jsp:include>
	</div>

</body>
</html>