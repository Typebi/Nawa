<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.ArrayList, domain.Community"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>

<%! 
String dp1 = "2";
String dp2 = "1";
%>
<div class="sub_con">
    <div class="lnb_area">
        <div class="box1">
			<ul class="gnb">
				<li class="m_2">
					<a href="../sub/2_1.jsp" class="dp1">COMMUNITY<span class="icon"></span></a>
					<ul class="dp2">
           				<li class="sm_1 on"><a href="../Commu/Commu.do?m=list">COMMUNITY</a></li>
           			</ul>
				</li>
			</ul>
        </div>
    </div>
</div>  
<div class="doc">
<div class="box1">

	<div class="board_view_top">
		<p class="tit">${board.subject}</p>
	    <ul class="info">
	    	<li>작성자 : ${board.nick_name}</li>
	        <li>작성일 : ${board.rdate}</li>
	    </ul>
	    
	    <a href="Commu.do?m=download&fname=${board.fname}" class="file"><i class="xi xi-file-text-o"></i> ${board.fname}</a>
	    
	    <p class="cl"></p>
	</div>
	<div class="board_view_middle">
		${board.content}
	</div>
	<!-- <div class="board_view_bottom">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st view">
	      <col class="w_form_tit"/>
	      <col class="w_auto" />
	      <tr>
	        <th><i class="xi xi-angle-left-min"></i> 이전글</th>
	        <td><a href="#">게시물의 제목이 입력됩니다.</a></td>
	      </tr>
	      <tr>
	        <th><i class="xi xi-angle-right-min"></i> 다음글</th>
	        <td><a href="#">게시물의 제목이 입력됩니다.</a></td>
	      </tr>
	    </table>
	</div> -->

	<div class="board_btn_wrap">
		<button type="button" class="input_st s1 c2 re" onclick="location.href='../Commu/Commu.do?m=update&c_seq=${board.c_seq}'">수정하기</button>
	    <button type="button" class="input_st s1 c2 re" onclick="location.href='../Commu/Commu.do?m=del&c_seq=${board.c_seq}&fname=${board.fname}'">삭제</button>
	    
	    <input type="button" value="목록으로" class="input_st s1 c2 re b_c1" onclick='history.back(-1); return false;' />
	</div>
</div>
</div>
<%@ include file="../inc/footer.jsp" %>
