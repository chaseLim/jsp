<%@page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script> </script>
<script type="text/javascript" src="/JS/jquery-3.2.1.js"></script>
</head>
<body>
<%
if(session.getAttribute("user")!=null){
	Map<String,String> user = (Map)session.getAttribute("user");
	
	String id = user.get("id");
	String name =user.get("name");
	String user_no =user.get("user_no");
	String hobby = user.get("hobby");
	String admin = user.get("admin");
%>
<%=user_no %>번째로 가입하신<br>
<%=id %>님 반갑습니다.<br>
<%=name %>이란 이름이 멋지시군요.<br>
<%=name %>님의 취미는<%=hobby%>들이시군요.<br>
<form action = "logout.user" method="post">
<input type="button" value="로그아웃"  data-url="/logout.user">
<input type="button" value="회원수정"  data-url="/modify.jsp">
<input type="button" value="회원탈퇴"  data-url="/delete.user">
<input type="button" value="게시판가기" data-url="/board/board_list.jsp">
<%
if(admin!=null && admin.equals("1")){
%>
<input type="button" value="회원리스트" data-url="/list.jsp">
<input type="button" value="회원리스트(옛방식)" data-url="/list.user">
<% 
}
%>
<input type="hidden" name="command" id="command"value="logout"> 
</form> 
<script>
$("input[type='button']").click(function(){
	var url = this.getAttribute("data-url");
	if(url.split(".")[1]=="user"){
		$("#command").val(url.split(".")[0].replace("/",""));
		this.form.submit();
	}else{
		location.href = url + "?userNo=<%=user_no%>";
	}
})

/*
function move(obj){
	if(obj.value=="회원수정"){
		location.href="/modify.jsp"
		return;
	}else if(obj.value=="회원탈퇴"){
		document.getElementById("command").value="delete";
	}
	obj.form.submit();
	
}*/


</script>

<%
}else{
	response.sendRedirect("/login.jsp");
}
%>
</body>
</html>