<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	if(${empty user}){
		alert("로그인이 필요합니다");
		history.back();
	}
</script>