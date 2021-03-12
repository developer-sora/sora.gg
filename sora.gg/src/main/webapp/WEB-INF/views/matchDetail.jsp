<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>

<!-- 

 #####  ####### ######     #         #####   #####  
#     # #     # #     #   # #       #     # #     # 
#       #     # #     #  #   #      #       #       
 #####  #     # ######  #     #     #  #### #  #### 
      # #     # #   #   ####### ### #     # #     # 
#     # #     # #    #  #     # ### #     # #     # 
 #####  ####### #     # #     # ###  #####   #####        
                     
 -->
 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script> function fn_spread(id){ 
	var getID = document.getElementById(id);
	getID.style.display=(getID.style.display=='block') ? 'none' : 'block'; } 
</script>
</head>

<body>

<h1>${queueType }</h1>
<h1><a href="killtimeline?mid=${param.mid }&sname=${sname}">킬 기록 보기</a></h1><br>${restartgame }
<h3>${min }분 ${sec}초</h3>



<c:if test="${queueType eq '솔로랭크' }">

<div>

파랑팀 밴<br>

<c:forEach items="${bbls }" var="bl">
<a href="champDetail?championName=${bl.bannedChampion}">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${bl.bannedChampion }.png" title="${bl.bannedChampion }" onerror="this.style.display='none';" height="25px" width="25px">
</a>
</c:forEach>


<br>빨강팀 밴<br>
<c:forEach items="${pbls }" var="bl">

<a href="champDetail?championName=${bl.bannedChampion}">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${bl.bannedChampion }.png " title="${bl.bannedChampion }" onerror="this.style.display='none';" height="25px" width="25px">
</a>

</c:forEach>
</div>

</c:if>



<c:forEach items="${md }" var="md">

<div style="border: 1px solid; float: left; width: 17%;" onclick="fn_spread('hiddenContent${md.summonerName }');">

<h3>${md.summonerName }</h3>
<c:if test="${md.win eq '승리'}">
<h3 style="color:blue">승리</h3>
</c:if>
<c:if test="${md.win eq '패배'}">
<h3 style="color:red">패배</h3>
</c:if>
<table>
<tr><td>
챔피언 레벨 : ${md.champLevel }<br>
<a href="champDetail?championName=${md.championEn}">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${md.championEn }.png" height="100px" width="100px" title="${md.championKr}">
</a>
</td>
<td>
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer}/img/spell/${md.spell1Id }" height="20px" width="20px"><img src="https://ddragon.leagueoflegends.com/cdn/${curVer}/img/spell/${md.spell2Id }" height="20px" width="20px">
<br>
<img src="https://ddragon.leagueoflegends.com/cdn/img/${md.keyperks }" height="20px" width="20px"><img src="https://ddragon.leagueoflegends.com/cdn/img/${md.perkSubStyle }" height="20px" width="20px">
</td></tr>
<tr><td>K/D/A ${md.kills }/${md.deaths }/${md.assists }<br>${md.kda } 킬관여율 ${md.killper }</td><td>${md.position }</td></tr>
<tr>
<td>

<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item0}.png" height="20px" width="20px" onerror="this.style.display='none';">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item1}.png" height="20px" width="20px" onerror="this.style.display='none';">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item2}.png" height="20px" width="20px" onerror="this.style.display='none';"><br>
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item3}.png" height="20px" width="20px" onerror="this.style.display='none';">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item4}.png" height="20px" width="20px" onerror="this.style.display='none';">
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item5}.png" height="20px" width="20px" onerror="this.style.display='none';"><br>
<img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/item/${md.item6}.png" height="20px" width="20px" onerror="this.style.display='none';">
</td>
<td>${md.pb }</td>
</tr>
<tr>
<td><div id="hiddenContent${md.summonerName }"  style="display: none;"><p>
 <c:if test="${md.visionScore ne '0'}"> 시야점수 ${md.visionScore } <br>와드 설치 / 제어와드 구매 / 와드제거<br> ${md.wardsPlaced }  / ${md.visionWardsBoughtInGame} / ${md.wardsKilled }</c:if>
<p>챔피언에게 입힌 피해 : ${md.totalDamageDealtToChampions }<p>
${md.doubleKills } ${md.tripleKills } ${md.quadraKills } ${md.pentaKills}<br>
${md.firstBloodKill } ${md.firstTowerKill }



 </div><td>
</tr>
</table>

</div>
</c:forEach>
</body>
</html>