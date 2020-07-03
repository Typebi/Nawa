<%@page contentType="text/html;charset=utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sign Up</title>
</head>
<body>


<div align="center">
<h1>회원가입</h1><br/>
<form action="signup?code=register" method="post">
	<input name="email" placeholder="아이디(이메일)"><br/><br/>
	<input name="pwd" placeholder="비밀번호(4~20글자,영문.숫자.특수문자 포함)"><br/><br/>
	<input name="nick" placeholder="닉네임(2~8글자)"><br/><br/>
	<input type="submit" value="가입하기"/>
</form>
<a href="../">돌아가기</a>
</div>
</body>
</html>