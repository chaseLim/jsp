<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="abc.board" method="post">
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" id="title"/></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="content" id="content"/></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer" id="writer"/></td>
	</tr>

</table>
<input type="hidden" name="command" value="write">
</form>

</body>
</html>