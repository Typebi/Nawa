<%@ page contentType="text/html;charset=utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
if('${errorName}' == 1) {alert("잘못된 이메일 형식입니다"); location.href="signup";
}else if('${errorName}' == 2) {alert("잘못된 비밀번호 형식입니다"); location.href="signup";
}else if('${errorName}' == 3) {alert("잘못된 닉네임 형식입니다"); location.href="signup";
}else {alert("회원가입이 완료되었습니다"); location.href="../";
}
</script>