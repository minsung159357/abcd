<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function getUsers(){
		$.ajax({
			url : "users", type : "GET", dataType: "json",
			success: function(list){
				console.log(list)
				//$("users").text(list)
				//str = "<b>아이디 : </b>" + list[0].name+"님<br>"
				//str += "<b>나이 : </b>" +list[0].age+"살<br>"
				str = ""
				$.each(list, function(index,item){
					str += "<b>아이디 : </b>" + item.name+"님<br>"
					str += "<b>나이 : </b>" + item.age+"살<br>"
				})
				$("#users").html(str)
			},
			error : function(){alert('문제 발생')}
		})
	}

	function userInfo(){
		$.ajax({
			url : "user/"+$("#userId").val(),	//"user?id=" +$("#userId").val(),
			type : "GET", dataType : "json",
			success: function(data){
				console.log(data)
				str = "<b>아이디 : </b>" + data.name+"님<br>"
				str += "<b>나이 : </b>" + data.age+"살<br>"
				$("#users").html(str)
			}, error: function(){
				alert('문제 발생')
			}
		})
	}
	function modify(){
		let name = $("#name").val()
		let age = $("#age").val()
		let form = {name:name, age:age}
		$.ajax({
			url:"modify", type:"PUT", dataType:"json",
			data : JSON.stringify(form),
			contentType:"application/json;charset=utf-8",
			success: function(data){
			str = "<b>아이디 : </b>" + data.name+"님<br>"
			str += "<b>나이 : </b>" + data.age+"살<br>"
			$("#users").html(str)
		}, error: function(){
			alert('문제 발생')
		}
		})
	}
	function membership(){
		/*
		let uId = $("#uId").val()
		let uAddr = $("#uAddr").val()
		let uName = $("#uName").val()
		let uAge = $("#uAge").val()
		let uPhone = $("#uPhone").val()
		let form = {uId:uId,uAddr:uAddr,uName:uName,uAge:uAge,uPhone:uPhone}
		*/
		let form = {}
		// 배열형태로 만들어 준다[{name:uId, value:값1}, {name:uName, value=값2}...]
		let arr = $("#frm").serializeArray()
		for(i=0; i<arr.length; i++){
			form[arr[i].name] = arr[i].value
			//form={uId:값1}
		}
		$.ajax({
			url: "membership", type:"POST", dataType:"json",
			data : JSON.stringify(form),
			contentType:"application/json;charset=utf-8",
			success: function(data){
				if(data.result == true) alert('성공적으로 저장')
				else alert('동일한 아이디 존재')
			}, error: function(){ alert('문제 발생')}
		})
	}
</script>
<style type = "text/css">
	#reply{display: none;}
</style>
<script type="text/javascript">
	function reply(){
		$("#reply").show()
	}
</script>

</head>
<body>
	<span id="users"></span><hr>
	<button type="button" onclick="getUsers()">사용자 목록</button>
	<hr>
	<input type="text" id="userId" placeholder="search id"><br>
	<button type="button" onclick="userInfo()">개인정보</button>
	<hr>
	<div id="reply">
		<input type="text">
		<input type="text">
		<input type="text">
	</div>
	<button type="button" onclick="reply()">답글작성</button>
	<hr>
	수정하고자 하는 비교 아이디<br>
	<input type="text" id="name"><br>
	수정 할 나이 : <input type="text" id="age"><br>
	<button type = "button" onclick="modify()">수정</button>
	<hr>
	<form id="frm">
		<input type="text" id="uId" name="uId" placeholder="id"><br>
		<input type="text" id="uName" name="uName" placeholder="uName"><br>
		<input type="text" id="uAddr" name="uAddr" placeholder="uAddr"><br>
		<input type="text" id="uPhone" name="uPhone" placeholder="uPhone"><br>
		<input type="text" id="uAge" name="uAge" placeholder="age"><br>
		<input type="button" onclick="membership()" value="가입"><br>
	</form>
	</body>
</html>