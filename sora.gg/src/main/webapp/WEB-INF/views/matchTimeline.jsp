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
		
		$("#qt").change(function() {
		/* 	alert($("#price1").val());
			
			alert($(this).children("option:selected").val()); */
			location.href = "killtimelinesearch?sname=${param.sname}&mid=${param.mid}&participant="+$(this).children("option:selected").val();
		});
	});
</script>
</head>
<body>
<%-- 
		<form>
			<select id="qt">
				<option>게임 타입</option>
				<c:forEach var="" items="">
				<option id="asd" value="440">자유 랭크게임</option>
				<option id="asd" value="430">일반 게임</option>
				<option id="asd" value="450">무작위 총력전</option>
				</c:forEach>
			</select>
		</form>
 --%>

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