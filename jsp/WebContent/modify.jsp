<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>

<body>
<%
String userNo = request.getParameter("userNo");
Map<String, String> user = (Map)session.getAttribute("user");
%>
<script>
function callback(result){
	alert(result);
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
	<td><input type="text" name="id" id="id" value=<%=user.get("id") %> /></td>

</tr>

<tr>

	<td align="center">비밀번호</td>

	<td><input type="password" name="pwd" id="pwd" maxlength="100"/></td>

</tr>

<tr>

	<td align="center">이름</td>

	<td><input type="text" name="name" id="name" maxlength="100"value="<%=user.get("name") %>"/></td>

<tr>

<tr>

	<td align="center">취미</td>

	<td>

	잠자기<input type="checkbox" name="hobby" value="잠자기" <%=user.get("hobby").indexOf("잠자기")!=-1?"checked":"" %>>

	게임<input type="checkbox" name="hobby" value="게임"  <%=user.get("hobby").indexOf("게임")!=-1?"checked":""%> >

	독서<input type="checkbox" name="hobby" value="독서"  <%=user.get("hobby").indexOf("독서")!=-1?"checked":""%>>
	음악<input type="checkbox" name="hobby" value="음악"  <%=user.get("hobby").indexOf("음악")!=-1?"checked":""%>>

	</td>

</tr>

<tr>

	<td colspan="2" align="center"><input type="submit" value="회원정보수정" /></td>

</tr> 

</table>

<input type="hidden" name="command" id="command" value="modify"/><br/>

</form>

</body>

</html>
