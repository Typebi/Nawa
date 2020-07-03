<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*, domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>
<link href="../css/slick.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/slick.js"></script>
<%! 
String dp1 = "1";
String dp2 = "1";
%>
<script>
	function enterCheck(elm){
		if(event.keyCode == 13){
			if(${empty user}){
				alert("로그인이 필요합니다");
				location.href="login.jsp";
			}else f.submit();
		}
	}
</script>
<div class="sub_con">
    <div class="lnb_area">
        <div class="box1">
			<ul class="gnb">
				<li class="m_1">
					<a href="#" class="dp1">REVIEW<span class="icon"></span></a>
					<ul class="dp2">
           				<li class="sm_1 on"><a href="../attr/attr.do">REVIEW</a></li>
           			</ul>
				</li>
			</ul>
        </div>
    </div>
</div>   
<div class="doc">
<div class="box1">
	
	<div class="">
		<div class="prod_detail_wrap">
	        <div class="inner">
	            <div class=" eht slide_wrap">
	                <div class="in">
	                    <div class="prod_slide">
	                    	<div class="item"><p class="img img_resize_prod"><img src="../images/img1.jpg"></p></div>
	                    	<div class="item"><p class="img img_resize_prod"><img src="../images/img2.jpg"></p></div>                
	                     	<div class="item"><p class="img img_resize_prod"><img src="../images/img3.jpg"></p></div>                 
	                    	<div class="item"><p class="img img_resize_prod"><img src="../images/img4.jpg"></p></div>
	                    	<div class="item"><p class="img img_resize_prod"><img src="../images/img5.jpg"></p></div>
	                    </div>
	                    <div class="prod_thumb">
	                    	<div class="item"><p class="img img_resize_prod"><img src="../images/img1.jpg"></p></div>
	                        <div class="item"><p class="img img_resize_prod"><img src="../images/img2.jpg"></p></div>
	                        <div class="item"><p class="img img_resize_prod"><img src="../images/img3.jpg"></p></div>
	                        <div class="item"><p class="img img_resize_prod"><img src="../images/img4.jpg"></p></div>
	                        <div class="item"><p class="img img_resize_prod"><img src="../images/img5.jpg"></p></div>
	                    </div>
	                </div>
	                <div class="arrowSlider">
						<span class="prev" id="aro1_prev"><i class="xi xi-angle-left-min"></i></span>
						<span class="next" id="aro1_next"><i class="xi xi-angle-right-min"></i></span>
					</div>
	            </div>
	            <div class="eht info_wrap">
	            	<dl>
						<dt class="tit"><span>${attr.area_name}</span>${attr.attr_name}</dt>
						<dd class="txt">
							<p>${attr.attr_info}</p>
						</dd>
	            	</dl>
	     	 	</div>
	         </div>
	         
	      </div>   
	      
      </div>   
     <div class="btn_w">
		<button type="button" class="search_btn write" onclick="location.href='../sub/re_write.jsp'"><i class="xi xi-border-color"></i> 리뷰쓰기</button>
	</div>
	
	<c:forEach items="${reviewList}" var="review">
		<div class="review_wrap">
		<div class="review_wrap1">
			<div class="review_top">
				<div class="review_top_l">
					<div>
						<p class="name"><span>${review.nick}</span>님의 리뷰입니다.</p>
						<p class="date">${review.rdate}</p>
					</div>
					
				</div>
				<div class="review_top_r">
					<a href="">
						<i class="xi xi-thumbs-up"></i>
						<p class="num">${review.recommend}</p>
					</a>	
				</div>
			</div>
			<div class="review_mdl">
				<div class="review_mdl_v">
					<div class="rating_wrap">
		            	<div>
	                        <ul class="star">
	                        	<c:forEach var="i" begin="0" end="${review.rate-1}">
	                            	<li><i class="xi xi-star"></i></li>
	                            </c:forEach>
	                        </ul>
		                </div>
	                </div>
	                <div class="review_mdl_vin">
	                	<p class="tit">${review.re_subject}</p>
	                	<p class="txt">${review.re_content}</p>
	                	<p class="ps">이 리뷰는 NAWA 운영진의 의견이 아닌 NAWA 회원의 주관적인 의견입니다.</p>
	                </div>
				</div>
			</div>	
			<div class="review_btm">
	           	<div class="review_mdl_btm1">
	       			<a class="review_mdl_bl" href="../re_attr/re_attr.do?m=recommend&re_seq=${review.re_seq}&attr_seq=${review.attr_seq}">
	       				<i class="xi xi-thumbs-up"></i>
	       				<span>도움이 됨</span>
	       			</a>
	           	</div>
	           	<div class="review_mdl_btm2">
	           		<div class="review_mdl_br">
	          		<button type="button" class="search_btn b_btn" onclick="location.href='../re_attr/re_attr.do?m=content&re_seq=${review.re_seq}&attr_seq=${review.attr_seq}'">수정</button>
					<button type="button" class="search_btn b_btn" onclick="location.href='../re_attr/re_attr.do?m=del&re_seq=${review.re_seq}&attr_seq=${review.attr_seq}'">삭제</button>
	       			</div>
	       		</div>	
	         </div>  
         </div>
<style>

.review_wrap2 .review_wrap2_in2 .del {position:absolute; right:-20px; top:50%; margin-top:-10px;}
.review_wrap2 .review_wrap2_in2 .del.on {display:block;}
.review_wrap2 .review_wrap2_in2 .del a {display:block;}
.review_wrap2 .review_wrap2_in2 .del a:hover {opacity:.6;}
.review_wrap2 .review_wrap2_in2 .del .xi{ color:#ccc; font-size:20px;}
</style> 
         <div class="review_wrap2">
         <form name="f" action="../re_attr/re_attr.do?m=comment&re_seq=${review.re_seq}&attr_seq=${review.attr_seq}&email=${user.email}" method="post"> 
         	<div class="review_wrap2_in review_wrap2_in1">
         		
         		<input type="text" name="comm_content" class="input_st inp_w100" onkeydown="enterCheck(this)"/>
         	</div>
         	</form>
         	<c:forEach items="${review.replys}" var="reply">
	         	<div class="review_wrap2_in">
	         		<dl class="review_wrap2_in2">
	         			<dt><span class="nic">${reply.NICK}</span>님 <span class="date">${reply.RDATE}</span></dt>
	         			<dd>${reply.COMM_CONTENT}</dd>
	         			<dd class="del on">
	         				<a href="../re_attr/re_attr.do?m=comm_del&re_seq=${review.re_seq}&comm_seq=${reply.COMM_SEQ}&attr_seq=${review.attr_seq}"><i class="xi xi-close-circle"></i>
	         			</a></dd>
	         		</dl>
	         	</div>
         	</c:forEach>
		</div> 
	</div>
	</c:forEach>
	<div class="board_paging">
			<button class="icon" onclick="javascript:location.href='re_attr.do?m=list&cp=1&attr_seq=${listResult.list[0].attr_seq}'">&#x000AB;</button>
		<button class="icon" onclick="javascript:location.href='re_attr.do?m=back&cp=${cp}&attr_seq=${listResult.list[0].attr_seq}'">&#x02039;</button>
		<c:forEach begin="1" end="${listResult.totalPageCount}" var="i">
				<c:choose>
					<c:when test="${i==listResult.currentPage}">
						<button onclick="javascript:location.href='re_attr.do?m=list&cp=${i}&attr_seq=${listResult.list[0].attr_seq}'" class="on">${i}</button>
					</c:when>
				<c:otherwise>
					 <button onclick="javascript:location.href='re_attr.do?m=list&cp=${i}&attr_seq=${listResult.list[0].attr_seq}'">${i}</button>
				</c:otherwise>
				</c:choose>
		</c:forEach>
		<button class="icon" onclick="javascript:location.href='re_attr.do?m=go&cp=${cp}&attr_seq=${listResult.list[0].attr_seq}'">&#x0203A;</button>
		<button class="icon" onclick="javascript:location.href='re_attr.do?m=list&cp=${listResult.totalPageCount}&attr_seq=${listResult.list[0].attr_seq}'">&#x000BB;</button>
		</div>
	
</div>
<script>
$(window).load(function(){
//	$(".prod_detail_wrap .inner .eht").equalizeHeights();
})

function detailSlide(){
	var Wrap = $(".prod_detail_wrap");	
	var slideWrap = $(".prod_detail_wrap .slide_wrap .prod_slide");	
	var thumbWrap = $(".prod_detail_wrap .slide_wrap .prod_thumb");	
	slideWrap.slick({
	  slidesToShow: 1,
	  slidesToScroll: 1,
	  fade: true,
	  arrows: false,				
	  autoplay: true,
	  autoplaySpeed: 3000,	
	  asNavFor: thumbWrap,	
	  prevArrow: Wrap.find('.control_arrow .prev'),
	  nextArrow: Wrap.find('.control_arrow .next') 
	});
	thumbWrap.slick({
	  slidesToShow: 4,
	  slidesToScroll: 1,				 
	  arrows: true,	
	  //centerMode: true,
	  focusOnSelect: true,								
	  asNavFor: slideWrap,
	  prevArrow: $('#aro1_prev'),
	  nextArrow: $('#aro1_next'),
	});	
}
$(document).ready(function(){	
	detailSlide();
})

imgResize_prod();
function imgResize_prod(){
	$(".img_resize_prod").css("overflow","hidden");
	$(".img_resize_prod img").css("width","100%")
	function resize(){
		$(".img_resize_prod").each(function (i) {
			var imgW = $(this).width();
			$(this).height(imgW*0.55)
			$(this).children("img").css("min-height",imgW*0.55)
		});
	}
	function resize2(){
		$(".img_resize_prod").each(function (i) {
			var imgW = $(this).width();
			var imgH = $(this).children("img").height();
			if(imgW < imgH || imgW == imgH){
				var gap = (imgH - $(".img_resize_prod").height())/2
				$(this).children("img").css("margin-top","-"+gap+"px")
			}
		});
	}
	$(window).load(function(){
		resize()
		resize2()
	})
	$(window).resize(function(){
		resize()
		resize2()
	})
}
</script>
</div>
<%@ include file="../inc/footer.jsp" %>
