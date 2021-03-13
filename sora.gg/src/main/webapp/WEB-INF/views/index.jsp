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
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="main">SORA.GG</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor02">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="main">Home
          <span class="sr-only">(current)</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="champion">챔피언</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="rotation">로테이션</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="community">커뮤니티</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="chal">통계보기</a>
      </li>
     
     
    </ul>
    
    <form class="form-inline my-2 my-lg-0" action="search">
      <input class="form-control mr-sm-2" type="text" type="search" placeholder="소환사명" name="sname">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit" style="margin-right:10px">.GG</button>
      </form>
    <c:choose>
<c:when test="${sessionScope.loginUser eq null }">
<a href="login" >
<button class="btn btn btn-info" type="submit">로그인</button>
</a>
</c:when>
<c:otherwise>
<a href="logout" >
<button class="btn btn btn-info" type="submit">로그아웃</button>
</a>
</c:otherwise>
</c:choose>
    
<!--         <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" align="right">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Separated link</a>
        </div> -->
  </div>
</nav>



 <%-- 	<jsp:include page="${loginPage}"></jsp:include> --%>
    <jsp:include page="${contentPage}"></jsp:include>

</div>

 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/board/js/bootstrap.js"></script>
</body>
</html>