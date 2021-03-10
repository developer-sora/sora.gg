<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="challlist"><button>첼린저 목록 초기화</button></a>
<a href="challgamereg"><button>gameid</button></a>
<a href="champreg"><button>챔프등록</button></a>
<a href="champresult"><button>픽/밴 상위 5개 챔피언</button></a>

<br>
<br>
<jsp:include page="${summonerPage}"></jsp:include>

</body>
</html>