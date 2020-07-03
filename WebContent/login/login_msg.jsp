<%@page contentType="text/html;charset=utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
if('${LoginError}' == 1) { alert("LoginError "+'${LoginError}'+" : 존재하지 않는 이메일(아이디)입니다"); location.href="login";
}else if('${LoginError}' == 2) { alert("LoginError "+'${LoginError}'+" : 잘못된 비밀번호입니다"); location.href="login";
}else{alert('${user.name}'+" 님 환영합니다"); location.href="../";
}
</script>