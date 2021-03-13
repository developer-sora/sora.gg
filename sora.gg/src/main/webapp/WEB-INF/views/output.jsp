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



<c:if test="${nodata ne 2 }">
<img src="http://ddragon.leagueoflegends.com/cdn/${curVer }/img/profileicon/${sicon }.png" width="200px"><p>
소환사 이름 : ${sname }<p>
소환사 레벨 : ${slv }<p>


<a href="search?sname=${sname }"> 최근 20게임 </a>

<c:if test="${nowgame eq 1}">
<a href="ingame?sname=${sname }" title="게임중!"> 인게임 정보</a>
</c:if>

<c:if test="${nowgame eq 2}">
현재 게임 중이 아닙니다.
</c:if>

</c:if>

<c:if test="${nodata eq 2 }">
입력하신 소환사를 찾을수 없거나 라이엇 API 서버에 문제가 있습니다. 
</c:if>


<jsp:include page="${summonerPage}"></jsp:include>

</body>
</html>