<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>게시판 작성</title>
</head>
<script>
$(document).ready(function(){
	$("#btnwrite").click(function(){
		var param = {};
		param["title"] = $("#title").val();
		param["content"] = $("#content").val();
		param ="?command=write&param="+JSON.stringify(param);
		param = encodeURI(param);
		var au =new AjaxUtil(param,"write.board");
		au.send();
	})
})

</script>
<body>
<form action="write.board" method="post">
<table >
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
		<td><input type="text" name="writer" id="writer" value="<%=user.get("name")%>"/></td>
	</tr>

</table>
<input type="button" id="btnwrite" value="게시글 올리기">
</form>

</body>
</html>