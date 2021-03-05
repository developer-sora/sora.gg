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
<link rel="stylesheet" href="board/css/bootstrap.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<!-- <link rel="stylesheet" href="css/css.css"> -->
  <link href="resources/css/css.css" rel="stylesheet" >
<meta charset="utf-8">
<title>sora.gg</title>
</head>
<body>
<div class="container">
    <br/>

    <jsp:include page="${contentPage}"></jsp:include>

</div>

 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="board/js/bootstrap.js"></script>
</body>
</html>