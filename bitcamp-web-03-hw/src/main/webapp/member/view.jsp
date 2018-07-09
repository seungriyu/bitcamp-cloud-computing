<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>멤버 보기</title>
</head>
<body>
<h1>멤버 보기</h1>
<form action='update' method='post'>
<table border='1'>
<tr><th>아이디</th><td>
    <input type='text' name='id' value='user01' readonly></td></tr>
<tr><th>이메일</th>
    <td><input type='email' name='email' value='user02@test.com11'></td></tr>
<tr><th>암호</th>
    <td><input type='password' name='password'></td></tr>

</table>
<p>
<a href='list'>목록</a>
<button>변경</button>
<a href='delete?id=user01'>삭제</a>
</p>
</form>
</body>
</html>
    