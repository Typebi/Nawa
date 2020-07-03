<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="./inc/top.jsp" />

<div id="contents">
	<div id="fullpage">
        <div id="section0" class="section">
            <div class="box1">
                <p class="site_logo"></p>
                <dl class="site_name">
                    <dt class="ani_left"><h1><span class="t1">NA</span><span class="t2">WA</span></h1></dt>
                    <dd class="ani_right"><span class="t3">Come out and leave now?</span></dd>
                </dl>
                <ul class="intro_menu">
                    <li><a href="./attr/attr.do"><span class="va"></span><span class="va_tt">REVIEW</span></a></li>
                    <li><a href="./Commu/Commu.do?m=list"><span class="va"></span><span class="va_tt">COMMUNITY</span></a></li>
                     <c:if test="${!empty user}">
                    <li><a href="mypage/mypage.do?m=mypage"><span class="va"></span><span class="va_tt">My Page</span></a></li>
             	 </c:if>
                </ul>
                <a href="#2" class="scroll_down ani_scroll">SCROLL DOWN</a>
            </div>
        </div>
        <div id="section1" class="section">
            <div class="box1">
                <dl class="section_tt c1 ani_left mt_100">
                    <dt class="tt_st1">지금 당장 나와서 떠나세요. <span class="cl_skyblue">나와</span></dt>
                    <dd class="tt_st2">여러분의 지친일상에<br> 소소한<span class="cl_skyblue"> 행복</span>을 가져다주는 </dd>
                    <dd class="tt_st3">국내 <span class="cl_skyblue">여행 소통</span> 사이트. 내 여행의 매력 지친일상에 힐링은 가까이에!</dd>
                    <dd class="tt_st3"></dd>
                </dl>
                <div class="ani_bottom">
                <ul class="post_list sec3 about_slider">
                    <li>
                        <dl class="list st1">
                            <dd class="img"><img src="./images/mso_img1.jpg" alt="" /></dd>
                            <dd class="con">
                                <p class="t1">1</p>
                                <span class="line_st1"></span>
                                <p class="t2">나만의 여행 패키지를 짤 수 있는 <br>정확하고 방대한 정보</p>
                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl class="list st1">
                            <dd class="img"><img src="./images/mso_img2.jpg" alt="" /></dd>
                            <dd class="con">
                                <p class="t1">2</p>
                                <span class="line_st1"></span>
                                <p class="t2">가고싶은 곳, 다양한 사람들의 <br>정보를 얻을 수 있는 곳</p>

                            </dd>
                        </dl>
                    </li>
                    <li>
                        <dl class="list st1">
                            <dd class="img"><img src="./images/mso_img3.jpg" alt="" /></dd>
                            <dd class="con">
                                <p class="t1">3</p>
                                <span class="line_st1"></span>
                                <p class="t2">나의 의견을 자유롭게 <br>공유할 수 있는 여행사이트!</p>
                            </dd>
                        </dl>
                    </li>
                </ul>
                </div>
            </div>
        </div>
        
        <div id="section2" class="section">
            <div class="box1">
                <dl class="section_tt ani_left mt_100">
                    <dt class="tt_st1 tshadow">Come out and leave now? NAWA</dt>
                </dl>
                <div class="ani_bottom">
	                <div class="loc_list sec3 ani_bottom">
	                	<div class="loc_l_top">
	                		<select id="area_select" class="search_select bd_none" onchange="f(this)">
	                			<option value="">전체</option>
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
					        		if(el.value==14) location.href='attr/attr.do?m=list&area_no=14';
					        		else if(el.value==23) location.href='attr/attr.do?m=list&area_no=23';
					        		else alert('서비스 준비중입니다');
					        	}
					        </script>
	                	</div>
	                	<ul class="loc_l_bottom">
	                		<li class="w70"><a href="./attr/attr.do?m=list&area_no=23" class="loc1">
	                			<div class="l_cover"></div>
	                			<dl class="txt_box">
	                				<dt>#종로구</dt>
	                				<dd>#광화문</dd>
	                			</dl>
	                		</a></li>
	                		<li class="w30"><a href="./attr/attr.do?m=list&area_no=14" class="loc2">
	                			<div class="l_cover"></div>
	                			<dl class="txt_box">
	                				<dt>#서대문구</dt>
	                				<dd>#서대문형무소</dd>
	                			</dl>
	                		</a></li>
	                		<li class="w30"><a href="#" onclick="alert('서비스 준비중입니다')" class="loc3">
	                			<div class="l_cover"></div>
	                			<dl class="txt_box">
	                				<dt>#강남구</dt>
	                				<dd>#가로수길</dd>
	                			</dl>
	                		</a></li>
	                		<li class="w50"><a href="#" onclick="alert('서비스 준비중입니다')" class="loc4">
	                			<div class="l_cover"></div>
	                			<dl class="txt_box">
	                				<dt>#서초</dt>
	                				<dd>#예술의 전당</dd>
	                			</dl>
	                		</a></li>
	                		<li class="w20"><a href="#" onclick="alert('서비스 준비중입니다')" class="loc5">
	                			<div class="l_cover"></div>
	                			<dl class="txt_box">
	                				<dt>#송파</dt>
	                				<dd>#롯데타워2</dd>
	                			</dl>
	                		</a></li>
	                		<li class="w50"><a href="#" onclick="alert('서비스 준비중입니다')" class="loc6">
	                			<div class="l_cover"></div>
	                			<dl class="txt_box">
	                				<dt>#동작구</dt>
	                				<dd>#노량진수산시장</dd>
	                			</dl>
	                		</a></li>
	                		<li class="w50"><a href="#" onclick="alert('서비스 준비중입니다')" class="loc7">
	                			<div class="l_cover"></div>
	                			<dl class="txt_box">
	                				<dt>#중구</dt>
	                				<dd>#동대문디지털프라자</dd>
	                			</dl>
	                		</a></li>
	                	</ul>
	               
	                </div>    
                </div>
            </div>
            <div id="footer">
				<div class="box1">
			    	<dl class="copy_site_name">
			            <dt>NAWA Trip</dt>
			            <dd>Come out and leave now? NAWA</dd>
			        </dl>
			        <ul class="copy_info">
			        	<li class="add">서울시 영등포구 여의도동 센터빌딩 44-36번지 7층</li>
			            <li>TEL. 02) 6268-5345</li>
			            <li>FAX. 02) 761-6811</li>
			            <li>eMail.  master@udmso.co.kr</li>
			        </ul>
			        <p class="cl"></p>
			    </div>
			</div>    
        </div>
        
	</div>
</div>
<a href="javascript:void();" class="nav_btn pc_hide"></a>
<p class="nav_bg pc_hide"><a href="javascript:void();" class="nav_btn_close pc_hide"></a></p>
<ul id="nav">
	<li><a href="#1"><span class="tt">MAIN</span><span class="circle"></span></a></li>
    <li><a href="#2"><span class="tt">ABOUT</span><span class="circle"></span></a></li>
    <li><a href="#3"><span class="tt">LOCATION</span><span class="circle"></span></a></li>
</ul>
<a href="javascript:void();" class="nav_close pc_hide"></a>

<script type="text/javascript">
$(".nav_btn").click(function(){
	$(".nav_bg, .nav_close").fadeIn(400);
	$("#nav").animate({right:0},200);
	$(".nav_bg, #nav > li, .nav_close").click(function(){
		$(".nav_bg, .nav_close").fadeOut(400);
		$("#nav").animate({right:'-50%'},200);
	})
})
$(document).ready(function() {
	$('#fullpage').fullpage({
		anchors:['MAIN','ABOUT','LOCAL'],
		menu: '#menu',
		scrollOverflow: true,
		afterLoad: function(anchorLink, index){
			var eq = Number(index)-1;
			ani_left_on(eq)
			ani_bottom_on(eq)
			if(index == 1){
				$("#nav").hide()
				$(".nav_btn").hide()
				ani_right_on(eq)
				ani_scroll()
			}else{
				$("#nav").show()
				$(".nav_btn").show()
			}
			if(index == 2){
				$("#nav > li > a").removeClass("on")
				$("#nav > li > a:eq("+eq+")").addClass("on")
			}
			if(index == 3){
				$("#nav > li > a").removeClass("on")
				$("#nav > li > a:eq("+eq+")").addClass("on")
			}
		},
		'onLeave': function(index, nextIndex, direction){
			var eq = Number(index)-1;
			ani_left_off(eq)
			ani_bottom_off(eq)
			window.location.hash = nextIndex;
			if(nextIndex == 1){
				$("#header").removeClass('on');
			}else{
				$("#header").addClass('on');
			}
			if (index == 1){
				ani_right_off(eq)
			}
			if (index == 2){
			
			}
			if (index == 3){
			}
		}
	});
	about_slider()
	service_slider()
	story_slider1()
	story_slider2()
	story_slider3()
});
function about_slider(){
	var owl = $(".about_slider");
	owl.owlCarousel({
	items : 3,
	itemsDesktop : [1170, 3],
	itemsTablet : [1151, 2],
	itemsMobile : [767, 1]
	});
}
function service_slider(){
	var owl = $(".service_slider");
	owl.owlCarousel({
	items : 4,
	itemsDesktop : [1170, 4],
	itemsTablet : [1151, 2],
	itemsMobile : [767, 1]
	});
}
function story_slider1(){
	var owl = $(".story_slider1");
	owl.owlCarousel({
	items : 2,
	itemsDesktop : [1170, 2],
	itemsTablet : [1151, 1],
	itemsMobile : [767, 1]
	});
}
function story_slider2(){
	var owl = $(".story_slider2");
	owl.owlCarousel({
	items : 4,
	itemsDesktop : [1170, 4],
	itemsTablet : [1151, 2],
	itemsMobile : [767, 1]
	});
}
function story_slider3(){
	var owl = $(".story_slider3");
	owl.owlCarousel({
	items : 2,
	itemsDesktop : [1170, 2],
	itemsTablet : [1151, 1],
	itemsMobile : [767, 1]
	});
}
var aniEasing = "easeOutCubic"
var speedOn = 1000
var speedOut = 500
function ani_left_on(eq){
	$("#section"+eq).find(".ani_left").animate({opacity:1, left:0},speedOn,aniEasing)
}
function ani_left_off(eq){
	$("#section"+eq).find(".ani_left").stop().animate({opacity:0, left:"-100%"},speedOut,aniEasing)
}
function ani_right_on(eq){
	$("#section"+eq).find(".ani_right").animate({opacity:1, right:0},speedOn,aniEasing)
}
function ani_right_off(eq){
	$("#section"+eq).find(".ani_right").stop().animate({opacity:0, right:"-100%"},speedOut,aniEasing)
}
function ani_bottom_on(eq){
	$("#section"+eq).find(".ani_bottom").animate({opacity:1, bottom:0},speedOn,aniEasing)
}
function ani_bottom_off(eq){
	$("#section"+eq).find(".ani_bottom").stop().animate({opacity:0, bottom:"-100px"},speedOut,aniEasing)
}
function ani_scroll(){
	$(".ani_scroll").animate({bottom:"-10px"},800,"easeInCubic",function(){
		ani_scroll_re()
	})
}
function ani_scroll_re(){
	$(".ani_scroll").animate({bottom:"0"},800,"easeOutCubic",function(){
		ani_scroll()
	})
}
</script>

</body>
</html>