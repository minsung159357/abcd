<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function test(){
		$.ajax({
			url : "ajax_result", type:"GET",
			success: function(data){
				$("#count").text(data)
				console.log("통신 성공")
			},
			error : function(){ console.log("통신 실패")}
		})
	}
</script>
</head>
<body>
	<!-- <h1>일</h1><h1>2</h1><h1>3</h1>
	<h1>4</h1><h1>5</h1><h1>6</h1>
	<h1>7</h1><h1>8</h1><h1>9</h1>
	 -->
	<button type="button" onclick="test()">click</button>
	<label id="count">0</label>
</body>
</html>