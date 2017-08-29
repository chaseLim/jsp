<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= "이건 JSP파일입니다."%>
<%= "전 System.out.println이랑 상당히 비슷한 녀석이에요." %>
<br>jsp 태그 시작해요
<%
out.println("저도  System.out.println이랑 비슷한녀석이에요");
int a= 1;
int b= 2;

int result = a + b;

out.println(a + "+" +b +"=" +result);
int[] arrNum = new int[5];

int add=10;

for (int i = 0; i < arrNum.length; i++){  
    arrNum[i] = (i+1)*10;   
}
for (int i = 0; i < arrNum.length; i++){  
	out.println("<br>"+arrNum[i]);
}


%>
<br> jsp태그 종료
</body>
</html>