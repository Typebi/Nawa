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
					<a href="" class="dp1">COMMUNITY<span class="icon"></span></a>
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
<script>
	function check(){
		/*for(var i=0 ; i<document.input.elements.length ; i++){
			if(document.input.elements[i].value==""){
				alert("모든 입력칸을 채워주셔야 합니다.");
				return false;
			}
		}*/
		
		document.input.submit();
	}
</script>
	<form name="input" method="post" action="../Commu/Commu.do?m=updateOk&c_seq=${board.c_seq}" enctype="multipart/form-data"> 
	
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st write"  onload="input.subject.focus()">
		  <col class="w_form_tit"/>
		  <col class="w_auto" />
		  <!-- <tr>
		    <th>작성자</th>
		    <td><input type="text" class="input_st iw1" name="email" readonly value='${board.email}'/></td>
		  </tr> -->
		  <tr style="display:none;">
		    <th>추가기능</th>
		    <td></td>
		  </tr>
		  <tr> 
		    <th>제목</th>
		    <td><input type="text" class="input_st iw100" name="subject" value="${board.subject}"/></td>
		  </tr>
		  <tr>
		  	<td colspan="2" style="padding:0; border:none"><textarea class="input_st tw1" name="content">${board.content}</textarea></td>
		  </tr>
		  <tr>
		    <th>파일첨부</th>
		    <td><input type="file" class="input_st iw100" name="fname" value="${board.fname}"/></td>
		  </tr>
		  
		</table>
	
		<div class="board_btn_wrap ac">
		    <input type="button" value="수정하기" class="input_st s1 c1" onclick='check();'/>
		    <input type="button" value="취소하기" class="input_st s1 c2" onclick='history.back(-1); return false;' />
		</div>
		</form>
	</div>
</div>

<%@ include file="../inc/footer.jsp" %>
