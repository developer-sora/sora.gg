<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
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
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="MM월dd일" var="today" />
<fmt:formatDate value="${now}" pattern="MM월" var="thismonth" />
<c:out value="${today}"/> 오늘의 트랜드<br><br>


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
<hr>
<c:out value="${thismonth}"/> 이번달 트랜드<br><br>
많이 픽된 챔피언
<br>
<c:forEach items="${mcpl }" var="mp" varStatus="mcp">
${mcp.count } : 
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${mp.championEn }.png " title="${mp.championKr }" onerror="this.style.display='none';" height="25px" width="25px">

</c:forEach>
<br>
많이 밴된 챔피언<br>
<c:forEach items="${mcbl }" var="mb" varStatus="mcb">
<c:if test="${mb.championKr ne '없음' }">
${mcb.count } : <img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${mb.championEn }.png " title="${mb.championKr}" onerror="this.style.display='none';" height="25px" width="25px">
</c:if>
<c:if test="${mb.championKr eq '없음' }">
${mcb.count } : 없음
</c:if>

</c:forEach>
 <%-- title="${b.championKr }"
 --%>
 
 </body>
</html>