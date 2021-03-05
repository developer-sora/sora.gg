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
<p>
${ingame}<p>

${queue }<p>

<c:if test="${ingame eq '게임중!' }">
${time }<p>

파랑팀<br>
</c:if>
<c:forEach var = "i" items="${ingames}">
<c:if test="${i.team eq '100'}">
<img src="http://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${i.champEn }.png" title="${i.champKr }" width="80px">

<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/spell/${i.spell1 }" title="${i.spell1Kr }" width="40px">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/spell/${i.spell2 }" title="${i.spell2Kr }" width="40px">
<img src="http://ddragon.leagueoflegends.com/cdn/img/${i.perks1 }" title="${i.perks1Kr }" width="30px">
<img src="http://ddragon.leagueoflegends.com/cdn/img/${i.perks2 }" title="${i.perks2Kr }" width="20px">
${i.name}
<c:if test="${i.tier ne null }">
<img src="resources/rank/${i.tier }.png" width = "40px" onerror="this.style.display='none'" alt=''/>${i.tier }
${i.rank }
</c:if>
<c:if test="${i.tier eq null }">Un Ranked</c:if>
<img src="http://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${i.ban }.png" width="80px" onerror="this.style.display='none'" alt='' title="${i.banKr } 밴"/><br>
</c:if>
</c:forEach>
<p>

<c:if test="${ingame eq '게임중!' }">

빨강팀<br>
</c:if>
<c:forEach var = "i" items="${ingames}">
<c:if test="${i.team eq '200'}">
<img src="http://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${i.champEn }.png" title="${i.champKr }" width="80px">

<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/spell/${i.spell1 }" title="${i.spell1Kr }" width="40px">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/spell/${i.spell2 }" title="${i.spell2Kr }" width="40px">
<img src="http://ddragon.leagueoflegends.com/cdn/img/${i.perks1 }" title="${i.perks1Kr }" width="30px">
<img src="http://ddragon.leagueoflegends.com/cdn/img/${i.perks2 }" title="${i.perks2Kr }" width="20px">
${i.name}
<c:if test="${i.tier ne null }">
<img src="resources/rank/${i.tier }.png" width = "40px" onerror="this.style.display='none'" alt=''/>${i.tier }
${i.rank }
</c:if>
<c:if test="${i.tier eq null }">Un Ranked</c:if>
<img src="http://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${i.ban }.png" width="80px" onerror="this.style.display='none'" alt='' title="${i.banKr } 밴"/><br>
</c:if>


</c:forEach>

</body>
</html>