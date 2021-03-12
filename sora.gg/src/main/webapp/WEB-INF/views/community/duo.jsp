<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><p>
<c:choose>
<c:when test="${sessionScope.loginUser eq null }">
<a href="login" >
<button>글쓰기</button>
</a>
</c:when>
<c:otherwise>
<a href="write" >
<button>글쓰기</button>
</a>
</c:otherwise>
</c:choose>




</body>
</html>