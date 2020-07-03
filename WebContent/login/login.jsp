<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>

<%! 
String dp1 = "3";
String dp2 = "1";
%>
<div class="doc">
	<div class="sub_login_wrap page_sec2">
    	<div class="sub_login_box_tit">
            <p class="tt">
                <span class="c1">NAWA 홈페이지 방문을 환영합니다.</span><br />
                <span class="c2">회원이시라면 로그인 후 자유로운 서비스 이용이 가능합니다.</span>
            </p>
        </div>
    	<div class="sub_login_box">
        	<div class="sub_login">
            	<p class="login_tit"><span class="c1">회원</span> <span class="c2">로그인</span></p>
				
                <ul class="login_inp">
                	<form id="f" name="f" action="login?code=login" method="post">
	                    <li><input type="text" class="inp" placeholder="아이디 (이메일)" name="email" msg="아이디를" /></li>
	                    <li><input type="password" class="inp" placeholder="비밀번호" name="pwd" msg="패스워드를" /></li>
	                    <!--  <li class="tt"><label class="label_st"><input type="checkbox" name="checker" value="" onchange="changCB();" /> <span>아이디저장</span></label></li>  -->
	                    <li><input type="submit" class="btn" value="로그인" /></li>
	                    <li><a class="btn st1" href="../signup/signup.jsp">회원가입</a></li>
                    </form>
                    <a id="kakao-login-btn"></a>
                </ul>
            </div>
        </div>
    </div>
</div>
<%@ include file="../inc/footer.jsp" %>

<form id="f2" name="f2" action="login?code=kakaoLogin" method="post">
	<input name='kakao' type='hidden' id='kakao' value='empty'>
</form>
   
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<a id="kakao-login-btn"></a>
<a href="http://developers.kakao.com/logout"></a>
<script type='text/javascript'>
    Kakao.init('bd2549716ffe1028040aa30ea7e63f40');
    Kakao.Auth.createLoginButton({
		container: '#kakao-login-btn',
		success: function(authObj) {
	        Kakao.API.request({
	       	url: '/v1/user/me',
			success: function(res) {
				console.log(authObj.access_token);
				alert(res.properties['nickname'] + ' 님 환영합니다.');
				document.getElementById("kakao").setAttribute("value", JSON.stringify(res));
				$('#f2').submit();
				}
			})
		},
		fail: function(err) {
        alert(JSON.stringify(err));
      }
    });
  //]]>
</script>