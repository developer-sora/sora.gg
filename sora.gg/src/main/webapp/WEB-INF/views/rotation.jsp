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
	<div style="margin-bottom: 600px;">
		<h2>금주 로테이션 목록</h2>
		<div style="width: 700px;">
			<c:forEach var="r" items="${rotation }">
				<div style="float: left; margin-right: 15px;">
					<div>
						<a href="champDetail?championName=${r.name }"> <img
							src="https://ddragon.leagueoflegends.com/cdn/11.4.1/img/champion/${r.name }.png">
						</a>
					</div>
					<div align="center" style="margin-bottom: 20px;">${r.nameKr }</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>