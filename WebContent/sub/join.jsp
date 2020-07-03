<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>

<%! 
String dp1 = "join";
%>

<div class="doc">
	<div class="box1">

	<div class="sub_box_st join">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st write">
        	<col class="w_form_tit"/>
        	<col class="w_auto" />
             <tr>
               <th class="th_st1">이메일</th>
               <td>
               <input type="text" class="input_st inp_w15" />@<input type="text" class="input_st inp_w15"/>
               <select class="input_st inp_w15">
                   <option value="">직접입력</option>
               </select>
               <input type="button" class="input_st join_btn1" value="중복확인" onclick="" /> 
               <p class="board_sub_tt mt5">[ 아이디는 변경이 불가능한 정보이오니 신중하게 입력하시기 바랍니다 ]</p>
				</td>
             </tr>
             <tr>
               <th class="th_st1">닉네임</th>
               <td><input type="text" class="input_st inp_w2" name="user_name" id="user_name" value="" /></td>
             </tr>
             <tr>
               <th class="th_st1">비밀번호</th>
               <td><input type="password" class="input_st inp_w2"  name="passwd" id="passwd" msg="비밀번호를" /> 
               <span class="board_sub_tt">[ 비밀번호는 6자 이상 15자 이하의 영문/숫자 이어야 합니다 ]</span></td>
             </tr>
             <tr>
               <th class="th_st1">비밀번호 확인</th>
               <td><input type="password" class="input_st inp_w2"  name="passwd2" id="passwd2" msg="비밀번호 확인을" /> <span class="board_sub_tt">[ 위에 입력하신 비밀번호를 한번 더 확인해주십시오 ]</span></td>
             </tr>
             
		</table>
       <div class="board_btn_wrap ac">
           <input type="submit" class="btn_st j_btn_st c1 next" value="회원가입" />
           <input type="button" class="btn_st j_btn_st c3" value="취소" onclick="document.mem_jForm.reset();" />
       </div>
	</div>
</div>
<%@ include file="../inc/footer.jsp" %>
