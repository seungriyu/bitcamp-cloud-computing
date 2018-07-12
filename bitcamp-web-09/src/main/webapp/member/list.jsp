<%@page import="bitcamp.pms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    


<h1>멤버 목록5</h1>
<p><a href='add'>새회원</a></p>
<table border='1'>
<tr>
    <th>아이디</th><th>이메일</th>
</tr>

<!--  
<jsp:useBean id="list"
     type="java.util.List<bitcamp.pms.domain.Member>"
     scope="request"></jsp:useBean>

//List<Member> list = (List)request.getAttribute("list");

for (Member member : list){
}
-->

<!-- JSTL : 반복문 사용가능한 라이브러리 -->
<c:forEach items="${list}" var ="member"> <!-- el -->
<tr>
    <td><a href='view?id=${member.id}'>${member.id}</a></td>
    <td>${member.email}</td> <!-- 반드시 결과값이 있는 expression(식) -->
</tr>

</c:forEach>


</table>

</body>
</html>