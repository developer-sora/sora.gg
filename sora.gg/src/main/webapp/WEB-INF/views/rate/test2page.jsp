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
<c:forEach items="${cpl }" var="p">
${p.pickchamp }
</c:forEach>
<br>
<c:forEach items="${cbl}" var="b">
${b.banchamp }
</c:forEach>
<%-- <c:forEach items="${cbl }" var="b">
${b.banchamp}
</c:forEach> --%>
</body>
</html>