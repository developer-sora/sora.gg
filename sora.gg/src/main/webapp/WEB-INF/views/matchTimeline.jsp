<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	$(function() {
		
		$("#sumlist").change(function() {
		/* 	alert($("#price1").val());
			
			alert($(this).children("option:selected").val()); */
			location.href = "killtimelinesearch?sname=${param.sname}&mid=${param.mid}&participant="+$(this).children("option:selected").val();
		});
	});
</script>
</head>
<body>
 <hr>
			<select id="sumlist">
				<option>소환사 명, 챔피언 선택</option>
				<c:forEach var="pti" items="${partis}">
				<option id="asd" value="${pti.participantId}">${pti.partisname }, ${pti.championKr }</option>
				</c:forEach>
			</select>
 
<br>
<a href="killtimeline?mid=${param.mid }&sname=${param.sname}"><button>전체 킬 보기</button></a>
<a href="matchdetail?mid=${param.mid }&sname=${param.sname}"><button>게임 스텟으로 돌아가기</button></a>
<hr>
	<c:forEach var="kv" items="${kv }">
<p>${kv.timestamp }
<br>
		<img
			src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${kv.killChampionEn}.png"
			onerror="this.style.display='none';" height="30px" width="30px"> 
kill
<img
			src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${kv.victimChampionEn }.png"
			onerror="this.style.display='none';" height="30px" width="30px"> death
		<br>
<c:forEach var="as" items="${kv.assistList}">
<c:if test="${as.assistChampionEn ne 'null'}">
Assist
	 <img src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${as.assistChampionEn}.png" onerror="this.style.display='none';" height="30px" width="30px">

 

</c:if>
</c:forEach>

	</c:forEach>


	<h1>---------------------------------------------------------------</h1>









</body>
</html>