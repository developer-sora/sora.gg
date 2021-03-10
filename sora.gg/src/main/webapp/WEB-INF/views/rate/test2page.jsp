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
<%-- <c:forEach items="${cpl }" var="p">
${p.pickchamp }
</c:forEach>
<br>
<c:forEach items="${cbl}" var="b">
${b.banchamp }
</c:forEach> --%>
많이 픽된 챔피언
<br>
<c:forEach items="${cpl }" var="p" varStatus="cp">
${cp.count } : 
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${p.championEn }.png " title="${p.championKr }" onerror="this.style.display='none';" height="25px" width="25px">

</c:forEach>
<br>
많이 밴된 챔피언<br>
<c:forEach items="${cbl }" var="b" varStatus="cb">
<c:if test="${b.championKr ne '없음' }">
${cb.count } : <img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${b.championEn }.png " title="${b.championKr}" onerror="this.style.display='none';" height="25px" width="25px">
</c:if>
<c:if test="${b.championKr eq '없음' }">
${cb.count } : 없음
</c:if>

</c:forEach>
 <%-- title="${b.championKr }"
 --%></body>
</html>