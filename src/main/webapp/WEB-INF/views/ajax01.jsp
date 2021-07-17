<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function ajax(){
		var n = document.getElementById("name").value;
		var a = $("#age").val()
		var addr = $("#addr").val()
		var form = { name:n, age:a, addr:addr}
		$.ajax({
			url:"ajax_result01", type:"POST",
			data: JSON.stringify( form ), //data: 서버로 전송할 데이터
			// 보낼 데이터의 형식을 지정
			contentType : "application/json; charset=utf-8",
			dataType : "json", // 서버로부터 return type 지정
			success: function(data){
				console.log(data)
				console.log(data.name)
				console.log(data.age)
				console.log(data.addr)
				$("#label").text( data.name+":"+data.age+":"+data.addr )
			}, error: function(){
				alert('문제 발생')
			}
		})
	}
</script>

</head>
<body>
	<input type="text" id="name"><br>
	<input type="text" id="age"><br>
	<input type="text" id="addr"><br>
	<input type="button" value="click" onclick="ajax()"><hr>
	결과 : <label id="label"></label>
</body>
</html>