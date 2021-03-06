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
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	
	$(function() {

		$("#qt").change(function() {
		/* 	alert($("#price1").val());
			
			alert($(this).children("option:selected").val()); */
			location.href = "matchsearch?sname=${sname}&queue="+$(this).children("option:selected").val();
		});
	});
</script>


</head>
<body>

	<c:if test="${nodata ne 2 }">
<%-- 		<p>20전  ${win }승   ${lose }패<p>
승률 ${winRate}% <p> --%>

		<form>
			<select id="qt">
				<option>게임 타입</option>
				<option id="asd" value="420">솔로 랭크게임</option>
				<option id="asd" value="440">자유 랭크게임</option>
				<option id="asd" value="430">일반 게임</option>
				<option id="asd" value="450">무작위 총력전</option>
			</select>
		</form>




		<c:forEach items="${mls }" var="ml">
			<div
				style="border: 1px solid; margin: 0 auto; width: 33%; padding: 10px;"
				onclick="location.href='matchdetail?mid=${ml.gameId}&sname=${sname }'">

				<table>
					<tr>
						<td>${ml.queue }</td>
						<td><img
							src="https://ddragon.leagueoflegends.com/cdn/${curVer }/img/champion/${ml.championEn }.png"><br>${ml.championKr}</td>
					</tr>
					<tr>
						<td>${ml.timestamp }</td>
						<td>${ml.position }</td>
					</tr>
				</table>

			</div>
		</c:forEach>
	</c:if>


</body>
</html>