<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>Insert title here</title>

</head>

<body>
<%
String userNo = request.getParameter("userNo");
%>
<script>
function callback(result){
	$("#id").val(result.id);
	$("#name").val(result.name);
	if(result.hobby){
		var hobbies = result.hobby.split(",");
		for(var i=0 , max=hobbies.length;i<max;i++){
			$("input[value='"+hobbies[i]+"']").prop("checked",true);
		}
	}
	$("#userNo").val(result.user_no);		
}
$(document).ready(function(){
	var param = "?command=view&userNo=<%=userNo%>";
	param = encodeURI(param);
	var au = new AjaxUtil(param);
	au.changeCallBack(callback);
	au.send();	
})
</script>
<form action="sigin.user" method="post">

<table border="1" cellspacing="0" cellpadding="0" width="400" align="center">

<tr>
	<td colspan="2"><p align="center"> = 회원 정보 수정 = </p></td>
</tr>

<tr>
	<td align="center">아이디</td>
	<td><input type="text" name="id" id="id"  /></td>

</tr>

<tr>

	<td align="center">비밀번호</td>

	<td><input type="password" name="pwd" id="pwd" maxlength="100"/></td>

</tr>

<tr>

	<td align="center">이름</td>

	<td><input type="text" name="name" id="name" maxlength="100"/></td>

<tr>

<tr>

	<td align="center">취미</td>

	<td>

	잠자기<input type="checkbox" name="hobby" value="잠자기" >

	게임<input type="checkbox" name="hobby" value="게임"  >

	독서<input type="checkbox" name="hobby" value="독서" >
	음악<input type="checkbox" name="hobby" value="음악"  >

	</td>

</tr>

<tr>

	<td colspan="2" align="center"><input type="submit" value="회원정보수정" /></td>

</tr> 

</table>

<input type="hidden" name="command" id="command" value="modify"/><br/>
<input type="hidden" name="userNo"  id="userNo"/><br/>
</form>

</body>

</html>
