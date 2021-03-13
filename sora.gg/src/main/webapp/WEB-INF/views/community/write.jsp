<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p><br>
<form action = "write.do">
<div class="container" style="margin-left:auto; margin-right:auto;">
 <div class="form-group">
  <label class="col-form-label" for="inputDefault">제목</label>
  <input type="text" class="form-control" placeholder="제목을 입력하세요." style= "width:40%;"  id="inputDefault" name = "s_title">
     </div>
      <div class="form-group">
      <label for="exampleTextarea">내용</label>
      <textarea class="form-control" id="exampleTextarea" rows="10" name = "s_comment" style= "width:40%; height:100%;" ></textarea>
    </div>
    <div>
 <button class="btn btn btn-info" type="submit">등록</button>
 <button class="btn btn-secondary my-2 my-sm-0" type="button" onclick="history.back()" >취소</button>
</div>
</div>
</form>

</body>
</html>