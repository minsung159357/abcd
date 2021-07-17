<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	<h1>파일 업로드</h1>
	<form action="${contextPath }/upload" enctype="multipart/form-data"
		method="post">
		<label>아이디 :</label><input type="text" name="id"><br> <label>이름
			:</label><input type="text" name="name"><br> <input type="file"
			name="file" value="파일추가"><br> <input type="submit"
			value="업로드">
	</form>
	<hr>
	<a href="${contextPath }/views">파일보기</a>
</body>
</html>
