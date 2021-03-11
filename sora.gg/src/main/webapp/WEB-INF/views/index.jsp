<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
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
<link rel="stylesheet" href="resources/board/css/bootstrap.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<!-- <link rel="stylesheet" href="css/css.css"> -->
  <link href="resources/css/css.css" rel="stylesheet" >
<meta charset="utf-8">

<title>sora.gg</title>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
</head>
<body>

<div class="container">
    <br/>
    <a href="main">홈으로</a>
<a href="community">커뮤니티
</a>    
<a href="chal">통계보기</a>

<c:choose>
<c:when test="${sessionScope.loginUser eq null }">
<a href="login" >
<button>로그인</button>
</a>
</c:when>
<c:otherwise>
<a href="logout" >
<button>로그아웃</button>
</a>
</c:otherwise>
</c:choose>

 <%-- 	<jsp:include page="${loginPage}"></jsp:include> --%>
    <jsp:include page="${contentPage}"></jsp:include>

</div>

 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/board/js/bootstrap.js"></script>
</body>
</html>