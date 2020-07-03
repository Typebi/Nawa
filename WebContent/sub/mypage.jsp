<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>
<script language="javascript">
      function check() {
         var f=document.f;
          for(var i=0; i<f.elements.length; i++)
         {
            if(f.elements[i].value == "")
           {
              alert("모든 값을 입력 하셔야 합니다.");
            return false;
           }
         }
          alert("수정완료");
          f.action="../mypage/mypage.do?m=update";
         f.submit();
       }
      
      function check2() {
         var f=document.f;
            if(f.elements[0].value != "${user.email}") {
              alert("email정보를 정확히 입력하세요");
            return false;
           }
            if(f.elements[1].value != "${user.pwd}") {
              alert("pwd정보를 정확히 입력하세요");
            return false;
           }
            if(f.elements[2].value != "${user.pwd}") {
                 alert("pwd정보를 정확히 입력하세요");
               return false;
              }
            if(f.elements[3].value != "${user.name}") {
              alert("nick_name정보를 정확히 입력하세요");
            return false;
           }

          alert("탈퇴완료");
          f.action="../mypage/mypage.do?m=delete";
        f.submit(); 
       }
      
      function f(){
          input.pwd.value = "";
          input.nick_name.value = "";
          //input.content.innerText = "";
          //$("#ta").text("");
          f.pwd.focus();
       }
      function f2(){
    	  console.log('hello');
    	  var f=document.f;
         if(f.pwd.value!=f.pwd2.value){
            alert("비밀번호 불일치");
            return false;
         }         
         var chk = 0;
         if(f.pwd.value.search(/[0-9]/g) != -1 ) chk ++;
         if(f.pwd.value.search(/[a-z]/ig)  != -1 ) chk ++;
         if(f.pwd.value.search(/[!@#$%^&*()?_~]/g)  != -1  ) chk ++;
         if(chk < 2) {
	          alert("비밀번호는 숫자, 영문, 특수문자를 두가지이상 혼용하여야 합니다.");
	          return false;
         }else{
            check();
         } 
      }
      function fb(){
    	  history.back();
      }
   </script>
<%! 
String dp1 = "3";
String dp2 = "1";
%>
<div class="sub_con">
    <div class="lnb_area">
        <div class="box1">
			<ul class="gnb">
				<li class="m_3">
						<a href="./sub/3_1.jsp" class="dp1">My Page<span class="icon"></span></a>
					<ul class="dp2">
           				<li class="sm_1 on"><a href="../mypage/mypage.do?m=mypage">Modify</a></li>
           				<!--<li class="sm_2"><a href="../sub/bookmark.jsp">Bookmark</a></li>-->
           			</ul>
				</li>
			</ul> 
        </div>
    </div>
</div> 

<div class="doc">
	<div class="box1">
	<div class="sub_box_st join">
	<form name="f"  method="post" action="../mypage/mypage.do?m=update">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st write">
        	<col class="w_form_tit"/>
        	<col class="w_auto" />
             <tr>
               <th class="th_st1"></th>
               <td>
               ${user.email}
<!--               <input type="text" class="input_st inp_w15" value="${user.email}" />  --> 
				</td>
             </tr>
             <tr>
               <th class="th_st1">닉네임</th>
               <td><input type="text" class="input_st inp_w2" name="user_name" id="user_name" value="${user.name}" /></td>
             </tr>
             <tr>
               <th class="th_st1">비밀번호</th>
               <td><input type="password" class="input_st inp_w2"  name="pwd" id="pwd" msg="비밀번호를" /> 
               <span class="board_sub_tt">[ 비밀번호는 6자 이상 15자 이하의 영문/숫자 이어야 합니다 ]</span></td>
             </tr>
             <tr>
               <th class="th_st1">비밀번호 확인</th>
               <td><input type="password" class="input_st inp_w2"  name="pwd2" id="pwd2" msg="비밀번호 확인을" /> <span class="board_sub_tt">[ 위에 입력하신 비밀번호를 한번 더 확인해주십시오 ]</span></td>
             </tr>
             
		</table>
		</form>
       <div class="board_btn_wrap ac">
           <input type="button" class="btn_st j_btn_st c1 next" value="수정" onclick="f2()"/>
           <input type="button" class="btn_st j_btn_st c3" value="취소" onclick="fb()" onclick="document.mem_jForm.reset()"/>
       </div>
	</div>
	</div>
</div>

<%@ include file="../inc/footer.jsp" %>
