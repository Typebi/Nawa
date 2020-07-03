<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>
<jsp:include page="../login/login_check_module.jsp"/>
<%! 
String dp1 = "2";
String dp2 = "1";
%>
<script language="javascript">
	   function check()
	   {
	       /*for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.elements[i].value == "")
			  {
			     alert("모든 값을 입력 하셔야 합니다. ");
				 return false;
			  }
		   }*/
		   document.input.submit();
       }
	</script>
<div class="sub_con">
    <div class="lnb_area">
        <div class="box1">
			<ul class="gnb">
				<li class="m_2">
					<a href="../sub/community.jsp" class="dp1">COMMUNITY<span class="icon"></span></a>
					<ul class="dp2">
           				<li class="sm_1 on"><a href="../sub/community.jsp">COMMUNITY</a></li>
           			</ul>
				</li>
			</ul>
        </div>
    </div>
</div>
<div class="doc">
	<div class="box1">
		<form name="input" method="post" action="../attr/attr.do?m=insert">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st write write1_1">
		  <col class="w_form_tit"/>
		  <col class="w_auto" />
		  <col class="w_form_tit"/>
		  <col class="w_auto" />
		  <tr>
		    <th colspan="1">지역선택</th>
		    <td colspan="3">
		    	<select name="area_no" class="search_select iw1" >
	            <option value="">지역전체</option>
	            <option value="1">강남구</option>
       			<option value="2">강동구</option>
       			<option value="3">강북구</option>
       			<option value="4">강서구</option>
       			<option value="5">관악구</option>
       			<option value="6">광진구</option>
       			<option value="7">구로구</option>
       			<option value="8">금천구</option>
       			<option value="9">노원구</option>
       			<option value="10">도봉구</option>
       			<option value="11">동대문구</option>
       			<option value="12">동작구</option>
       			<option value="13">마포구</option>
       			<option value="14">서대문구</option>
       			<option value="15">서초구</option>
       			<option value="16">성동구</option>
       			<option value="17">성북구</option>
       			<option value="18">송파구</option>
       			<option value="19">양천구</option>
       			<option value="20">영등포구</option>
       			<option value="21">용산구</option>
       			<option value="22">은평구</option>
       			<option value="23">종로구</option>
       			<option value="24">중구</option>
       			<option value="25">중랑구</option>
	      	  </select>
	        </td>
		  </tr>
		  <tr> 
		    <th colspan="1">명소 이름</th>
		    <td colspan="3"><input type="text" name="attr_name" class="input_st iw100" /></td>
		  </tr>
		  <tr>
		    <th colspan="1">주소</th>
		    <td colspan="3"><input type="text" name="attr_addr" class="input_st iw100" /></td>
		  </tr>
		  <tr>
		    <th colspan="1">간단한 설명</th>
		    <td colspan="3"><input type="text" name="attr_info" class="input_st iw100" /></td>
		  </tr>
		  
		</table>
		<div class="board_btn_wrap ac">
		    <input type="button" value="등록하기" class="input_st s1 c1" onclick='check()'/>
		    <input type="button" value="취소하기" class="input_st s1 c2" onclick='history.back(-1); return false;' />
		</div>
		</form>
	</div>
</div>

<%@ include file="../inc/footer.jsp" %>
