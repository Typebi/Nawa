<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/top2.jsp" %>

<%! 
String dp1 = "1";
String dp2 = "1";
%>

<div class="sub_con">
    <div class="lnb_area">
        <div class="box1">
			<ul class="gnb">
				<li class="m_1">
					<a href="../attr/attr.do?m=list&area_no=23" class="dp1">REVIEW<span class="icon"></span></a>
					<ul class="dp2">
           				<li class="sm_1 on"><a href="../attr/attr.do?m=list&area_no=23">REVIEW</a></li>
           			</ul>
				</li>
			</ul>
        </div>
    </div>
</div>   
<div class="doc">
<div class="box1">
	<div class="board_search fr">
        <input type="text" class="search_inp" placeholder="명소검색" />
        <input type="button" class="search_btn" value="검색">
    </div>
	<div class="board_search fl">
        <select id="area_select" class="search_select re_select" onchange="f(this)">
            	<option value="">지역전체</option>
	            <option value=1>강남구</option>
       			<option value=2>강동구</option>
       			<option value=3>강북구</option>
       			<option value=4>강서구</option>
       			<option value=5>관악구</option>
       			<option value=6>광진구</option>
       			<option value=7>구로구</option>
       			<option value=8>금천구</option>
       			<option value=9>노원구</option>
       			<option value=10>도봉구</option>
       			<option value=11>동대문구</option>
       			<option value=12>동작구</option>
       			<option value=13>마포구</option>
       			<option value=14>서대문구</option>
       			<option value=15>서초구</option>
       			<option value=16>성동구</option>
       			<option value=17>성북구</option>
       			<option value=18>송파구</option>
       			<option value=19>양천구</option>
       			<option value=20>영등포구</option>
       			<option value=21>용산구</option>
       			<option value=22>은평구</option>
       			<option value=23>종로구</option>
       			<option value=24>중구</option>
       			<option value=25>중랑구</option>
        </select>
        <script language="javascript">
        	function f(select){
        		var el = document.getElementById("area_select");
        		if(el.value==14) location.href='attr.do?m=list&area_no=14';
        		else if(el.value==23) location.href='attr.do?m=list&area_no=23';
        		else alert('서비스 준비중입니다');
        	}
        </script>
    </div>
    <p class="cl"></p>   
    <dl class="rv_list_top">
   		<dt class="rv_list_l"><i class="xi xi-map"></i>종로구</dt>
   		<dd class="rv_list_r">
   			<ul class="rv_list_rbtm">
   				<li><a href="">이름순</a></li>
   				<li><a href="">평점순</a></li>
   			</ul>
   		</dd>
   	</dl>
	
	<ul class="loc_gall">
		<c:forEach items="${list}" var="review">
		<li>
			<div class="inner">
		        <div class="inner1" onclick="location.href=''">
		        	<p class="eh prod_bm on" ><i class="xi xi-star"></i></p>
		            <div class="eh prod_pic img_resize_prod"><img src="../images/p1.jpg" /></div>
		            <div class="eh prod_tt_wrap">
		                <dl>
		                    <dt>${review.attr_name}</dt>
		                    <dd>${review.attr_info}</dd>
		                    <dd class="add">${review.attr_addr}</dd>
		                </dl>
	       			</div>	
		        </div>
		        <div class="review_mdl_btm2">
	           		<div class="review_mdl_br">
	           		<button type="button" class="search_btn b_btn" onclick="location.href=''">수정</button>
					<button type="button" class="search_btn b_btn" onclick="location.href='../attr/attr.do?m=del&attr_seq=${review.attr_seq}&area_no=23'">삭제</button>
	       			</div>
       			</div>
		    </div>
		</li>
		</c:forEach>     
	</ul>
	<div class="board_paging">
		<button class="icon" onclick="javascript:location.href='#'">&#x000AB;</button>
		<button class="icon" onclick="javascript:location.href='#'">&#x02039;</button>
		<button class="on">1</button>
		<button onclick="javascript:location.href='#'">2</button>
		<button onclick="javascript:location.href='#'">3</button>
		<button onclick="javascript:location.href='#'">4</button>
		<button onclick="javascript:location.href='#'">5</button>
		<button onclick="javascript:location.href='#'">6</button>
		<button onclick="javascript:location.href='#'">7</button>
		<button onclick="javascript:location.href='#'">8</button>
		<button onclick="javascript:location.href='#'">9</button>
		<button onclick="javascript:location.href='#'">10</button>
		<button class="icon" onclick="javascript:location.href='#'">&#x0203A;</button>
		<button class="icon" onclick="javascript:location.href='#'">&#x000BB;</button>
	</div>
	<button type="button" class="search_btn write" onclick="location.href='../sub/attr_write.jsp'"><i class="xi xi-border-color"></i> 글쓰기</button>
	
</div>
<script>
$(window).load(function(){
	$(".loc_gall").equalizeHeights();
	$(".loc_gall .eh").equalizeHeights();
	$(".loc_gall .prod_option").equalizeHeights();
})

imgResize_prod();
function imgResize_prod(){
	$(".img_resize_prod").css("overflow","hidden");
	$(".img_resize_prod img").css("width","100%")
	function resize(){
		$(".img_resize_prod").each(function (i) {
			var imgW = $(this).width();
			$(this).height(imgW*0.70)
			$(this).children("img").css("min-height",imgW*0.70)
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
