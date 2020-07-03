<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>

<%! 
String dp1 = "join";
%>
<div class="doc">
	<div class="box1">

	<div class="sub_box_st join">
		<form name="mem_jForm" action="signup?code=register" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st write">
        	<col class="w_form_tit"/>
        	<col class="w_auto" />
	             <tr>
	               <th class="th_st1">이메일(아이디)</th>
	               <td>
	               <input type="text" class="input_st inp_w15" name="email" id="email" onkeyup="emailCheck()"/>@<input type="text" class="input_st inp_w15" name="host" id="host" onkeyup="emailCheck()"/>
	               <!--
	               <select class="input_st inp_w15">
	                   <option value="">직접입력</option>
	               </select>
	               <input type="button" class="input_st join_btn1" value="중복확인" onclick="" />
	               -->
					<span class="board_sub_tt" id="emailCheckText" style="color:red; display:inline-block">이미 가입된 이메일</span>
	               <p class="board_sub_tt mt5">[ 아이디는 변경이 불가능한 정보이므로 신중하게 입력하시기 바랍니다 ]</p>
					</td>
	             </tr>
	             <tr>
	               <th class="th_st1">닉네임</th>
	               <td><input type="text" class="input_st inp_w2" name="nick" id="user_name" value="" />
	               <span class="board_sub_tt">[ 특수문자를 제외한 2 ~ 8자 ]</span></td>
	             </tr>
	             <tr>
	               <th class="th_st1">비밀번호</th>
	               <td><input type="password" class="input_st inp_w2"  name="pwd" id="passwd" msg="비밀번호를" onkeyup="check()"/> 
	               <span class="board_sub_tt">[ 영문/숫자/특수문자를 포함하는 6 ~ 15자 ]</span></td>
	             </tr>
	             <tr>
	               <th class="th_st1">비밀번호 확인</th>
	               <td><input type="password" class="input_st inp_w2"  name="pwd2" id="passwd2" msg="비밀번호 확인을" onkeyup="check()"/>
	               <span class="alert alert-success" id="alert-success" style="color:green">비밀번호 일치</span>
	               <span class="alert alert-danger" id="alert-danger" style="color:red">비밀번호 불일치</span></td>
					<script>
						$("#alert-success").hide();
						$("#alert-danger").hide();
					    function check() {
					    	var pwd1=$('#passwd').val();
					    	var pwd2=$('#passwd2').val();
					    	if(pwd1 != "" && pwd2 != ""){
					    		if(pwd1 == pwd2){
					    			$("#alert-success").show();
					    			$("#alert-danger").hide();
					    			$("#submit").removeAttr("disabled");
					    		}else{
					    			$("#alert-success").hide();
					    			$("#alert-danger").show();
					    			$("#submit").attr("disabled", "disabled"); }
					    	}else{
					    		$("#alert-success").hide();
								$("#alert-danger").hide();
					    	}
					    };
					</script>
	             </tr>
		</table>
       <div class="board_btn_wrap ac">
           <input type="submit" class="btn_st j_btn_st c1 next" id="submit" value="회원가입" />
           <input type="button" class="btn_st j_btn_st c3" value="취소" onclick="document.mem_jForm.reset();" />
       </div>
       </form>
	</div>
</div>
<%@ include file="../inc/footer.jsp" %>
<!-- 
<script>
$("#emailCheckText").hide();
function emailCheck(){
	if($('#email').val() != "" && $('#host').val() != ""){
		$.ajax({
		    url:'signup?code=ajax',
		    async:true,
		    type:'POST',
		    data: { email:$('#email').val()+"@"+$('#host').val()},
		    dataType:'json',
		    beforeSend:function(jqXHR) {},
		    success:function(data) {
		    	if(data.isExist == 1) {$("#emailCheckText").show();}
		    	else {$("#emailCheckText").hide();}
		    },
		    error:function(jqXHR) {
		    	//console.log(jqXHR)
		    },
		    complete:function(jqXHR) {}
		});
	}
}
</script>
 -->