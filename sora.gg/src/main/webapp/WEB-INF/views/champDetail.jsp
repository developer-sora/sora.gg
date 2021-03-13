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

	<table>
		<tr>
			<td><img
				src="https://ddragon.leagueoflegends.com/cdn/11.4.1/img/champion/${passive.name }.png"></td>
			<td><h3>${passive.nameKr }</h3></td>
		</tr>
	</table>

	<table>
		<tr>
			<td>패시브</td>
			<td><img title="${passive.title }
${passive.description}"
				src="http://ddragon.leagueoflegends.com/cdn/11.4.1/img/passive/${passive.imgName }">
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<td>스킬&nbsp;&nbsp;&nbsp;</td>
			<c:forEach var="c" items="${champSkillInfo }">
				<td><img
					title="${c.getSkillName() }
${c.getTooltip() }

[???] 로 표시된 값은 Riot API에서 제공하지 않는 데이터 입니다.
정확한 값은 League of Legends 클라이언트에서 확인하실 수 있습니다."
					src="http://ddragon.leagueoflegends.com/cdn/11.4.1/img/spell/${c.getName() }"></td>
			</c:forEach>
		</tr>
		<!-- jsoup >> .elements.text >> 추가 하면 됨  -->
	</table>

	<br>
	<br>
	<br>
	<br>


	<form action="champDetail">
		<div id="searchArea">
			<div id="writeArea">
				<input name="${passive.name }" type="hidden" value="${passive.name }">
				<textarea name="c_comment" placeholder="챔피언에 대한 팁을 남겨주세요."
					style="width: 600px; height: 200px; resize: none; font-size: 15pt;"></textarea>
				<br>
				<button style="width: 100px; height: 50px;">글쓰기</button>
			</div>
		</div>
	</form>
	
	<div>
		<jsp:include page="${tipPage }"></jsp:include>
	</div>

	<!-- 
	<form action="sns.write">
		<div id="searchArea">
			<div id="writeArea">
				<textarea name="c_comment"></textarea>
				<br>
				<button>글쓰기</button>
			</div>
			
		  <input name="token" value="${token }" type="hidden">
			 
		</div>
	</form>
 -->
</body>
</html>