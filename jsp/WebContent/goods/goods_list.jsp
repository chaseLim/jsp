<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="tt" value="이게 태그라이브러입니다." />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${tt}
	<br> ${test}
	<table border="1">
	<tr>
		<td	colspan="11" align="center">
			<form action="test.goods" method="post">
			<input type="hidden" value="list" name="command"/>
			<select name="vendor">
						<c:forEach items="${vendorList}" var="vendor">
							<option value="${vendor.viNum}">${vendor.viName}</option>
						</c:forEach>
				</select>
			상품명 :<input type="text" id="giName" name="giName"> 
			<input type="submit" id="btnSearch" value="상품검색"/>	
			</form>
		</td>
	</tr>
		<c:forEach items="${goodsList}" var="goods">
			<tr>
				<td><c:out value="${goods.giNum}" /></td>
				<td><c:out value="${goods.giName}" /></td>
				<td><c:out value="${goods.giDesc}" /></td>
				<td><select name="vendor">
						<c:forEach items="${vendorList}" var="vendor">
							<c:set var="sel" value="" />
							<c:if test="${vendor.viNum eq goods.viNum}">
								<c:set var="sel" value="selected" />
							</c:if>
							<option value="${vendor.viNum}" ${sel }>${vendor.viName}</option>
						</c:forEach>
				</select>
				<td><c:out value="${goods.viNum}" /></td>
				<td><c:out value="${goods.giCredat}" /></td>
				<td><c:out value="${goods.giMofdat}" /></td> 
				<td><c:out value="${goods.giCreusr}" /></td>
				<td><c:out value="${goods.name}" /></td>
				<td><c:out value="${goods.giMofusr}" /></td>
				<td><c:out value="${goods.name2}" /></td>
			</tr>
		</c:forEach>
	</table>
	상품리스트 페이지에 오셨습니다.
</body>
</html>