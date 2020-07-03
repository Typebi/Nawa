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
                    <li><input type="text" class="inp" placeholder="아이디" name="log_id" msg="아이디를" /></li>
                    <li><input type="password" class="inp" placeholder="비밀번호" name="log_pwd" msg="패스워드를" /></li>
                    <li class="tt"><label class="label_st"><input type="checkbox" name="checker" value="" onchange="changCB();" /> <span>아이디저장</span></label></li>
                    <li><input type="submit" class="btn" value="로그인" /></li>
                    <li><a class="btn st1" href="join.jsp">회원가입</a></li>
                </ul>
            </div>
        </div>
        
    </div>


</div>
<%@ include file="../inc/footer.jsp" %>
