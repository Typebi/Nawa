<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>
<link href="../css/slick.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/slick.js"></script>
<%! 
String dp1 = "1";
String dp2 = "1";
%>
<script language="javascript">
	   function check()
	   {
	       document.input.rate.value = radio_chk();
	       
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.elements[i].value == "")
			  {
			     alert("모든 값을 입력 하셔야 합니다. ");
				 return false;
			  }
		   }
		   document.input.submit();
       }
	   function radio_chk(){
		   var radio_btn = document.getElementsByName("rating");
		   var rate_value;
		   for(var i=0; i<radio_btn.length; i++) {
			   if(radio_btn[i].checked==true){
			   	rate_value = radio_btn[i].value;
			   }
		   }return rate_value;  
	   }
	</script>
<div class="sub_con">
    <div class="lnb_area">
        <div class="box1">
			<ul class="gnb">
				<li class="m_1">
					<a href="../sub/review.jsp" class="dp1">REVIEW<span class="icon"></span></a>
					<ul class="dp2">
           				<li class="sm_1 on"><a href="../sub/review.jsp">REVIEW</a></li>
           			</ul>
				</li>
			</ul>
        </div>
    </div>
</div>   
<div class="doc">
<div class="box1">
 
<style>


.review_top {}
</style>    
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st write">
    <col class="w_form_tit"/>
    <col class="w_auto" />    
    <col class="w_form_tit"/>
    <col class="w_auto" />  
    
     <form name="input" method="post" action="../re_attr/re_attr.do?m=update&re_seq=${content[0].re_seq}">
    <tr>
        <th colspan="1">제목</th>
        <td colspan="3"><input type="text" name="review_subject" class="input_st inp_w100" value ="${content[0].re_subject}" /></td>
    </tr>
    <tr>
        <th colspan="1">평점</th>
        <td colspan="3">  
        	<Input Type="hidden" name="rate" value="">          
            <div class="rating_wrap">
            	<div>
                    <label class="label_st de"><input type="radio" id="rate1" value='5' name="rating" checked="checked" /><i class="xi"></i>
                        <ul class="star">
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                        </ul>
                    </label>
                </div>
                <div>
                    <label class="label_st de"><input type="radio" id="rate2" value='4'name="rating" /><i class="xi"></i>
                        <ul class="star">
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                        </ul>
                    </label> 
                </div>
                <div>
                    <label class="label_st de"><input type="radio" id="rate3" value='3' name="rating" /><i class="xi"></i>
                        <ul class="star">
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                        </ul>
                    </label> 
                </div>
                <div>
                    <label class="label_st de"><input type="radio" id="rate4" value='2' name="rating" /><i class="xi"></i>
                        <ul class="star">
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                        </ul>
                    </label> 
                </div>
                <div>
                    <label class="label_st de"><input type="radio" id="rate5" value='1' name="rating" /><i class="xi"></i>
                        <ul class="star">
                            <li><i class="xi xi-star"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                            <li><i class="xi xi-star-o"></i></li>
                        </ul>
                    </label>
                </div>              
            </div>
        </td>
    </tr>
    <tr>
	  	<td colspan="4" style="padding:0; border:none"><textarea name="review_content" value="${content[0].re_content}" class="input_st tw1" ></textarea></td>
	  </tr>
	  
	</form>
</table>
	<div class="board_btn_wrap ac">
		    <input type="button" value="등록하기" class="input_st s1 c1" onclick='check()' />
		    <input type="button" value="취소하기" class="input_st s1 c2" onclick='history.back(-1); return false;' />
		</div>
	</div>
	
</div>

<%@ include file="../inc/footer.jsp" %>
