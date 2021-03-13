<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	<p>
				<div class="container" align="right">
				
		<c:choose>
			<c:when test="${sessionScope.loginUser eq null }">
					<a href="login">
						<button class="btn btn btn-info" type="submit">글쓰기</button>
					</a>
			</c:when>
			<c:otherwise>
					<a href="write" >
						<button class="btn btn btn-info" type="submit">글쓰기</button> <input name="token" value="${token }"
						type="hidden">
					</a>
			</c:otherwise>
		</c:choose>
		<form class="form-inline my-2 my-lg-0" action="duo.search.go">
      <input class="form-control mr-sm-2" type="text" type="search" placeholder="제목,내용 검색" name="search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit" style="margin-right:10px">검색</button>
      </form>
				</div>

<br><br>

		<%-- <c:if test="${curPage != 1 }">
		<div align="center" id="snsL"
			onclick="snsPageChange(${curPage - 1 });">
			<div class="paging">◀</div>
		</div>
	</c:if>
	<c:if test="${curPage != allPageCount }">
		<div align="center" id="snsR"
			onclick="snsPageChange(${curPage + 1 });">
			<div class="paging">▶</div>
		</div>
	</c:if> --%>
	


		<c:forEach var="m" items="${msgs }">

			<div class="container">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">${m.s_title}</h4>
						<h5 class="card-subtitle mb-2">${m.u_nickname }</h5>
						<h6 class="card-subtitle mb-2 text-muted">
						<fmt:formatDate pattern ="yyyy-MM-dd a hh:mm:ss" value="${m.s_date }"/>
						</h6>
						<p class="card-text">${m.s_comment }</p>
						<div align="right">
							<c:if test="${m.u_email == sessionScope.loginUser.u_email }">
								<a onclick="goDel(${m.s_no});" style="cursor:pointer">❌</a>
								<br>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			<br>
		</c:forEach>
</body>
</html>