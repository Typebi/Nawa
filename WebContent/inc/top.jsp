<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=1200" />
<title>NAWA Trip</title>
<meta name="description" content="">

<link href="./css/font.css" rel="stylesheet" type="text/css" />
<link href="./css/inc.css" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<link href="./css/board.css" rel="stylesheet" type="text/css" />
<link href="./css/owl.carousel.css" rel="stylesheet" type="text/css" />
<link href="./css/xeicon.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="./js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./js/jquery-ui.min.js"></script>
<script type="text/javascript" src="./js/jquery.slimscroll.js"></script>
<script type="text/javascript" src="./js/jquery.fullPage.js"></script>
<script type="text/javascript" src="./js/jquery.flexslider.js"></script>
<script type="text/javascript" src="./js/jquery.word-break-keep-all.js"></script>
<script type="text/javascript" src="./js/owl.carousel.js"></script>
<link rel="shortcut icon" href="../images/inc/favicon.ico" />
<script>
$(document).ready(function(){
	$('.keep_all').wordBreakKeepAll();
	$('.keep_all').wordBreakKeepAll({OffForIE:true}); 
})
//

//
$(function(){
	$(".tab_idx.click > li").each(function (i) {
		$(this).attr("idx", i);
		}).click(function () {
		var n = $(this).attr("idx");
		$(this).parents(".wrap_idx").find(".con_idx .idx").removeClass("on");
		$(this).parents(".wrap_idx").find(".con_idx .idx:eq("+n+")").addClass("on");
		$(this).parents(".wrap_idx").find(".tab_idx > li").removeClass("on");
		$(this).addClass("on");
	});

	/*$("#header .gnb_area .gnb > li").mouseenter(function(){
		$("#header .gnb_area .gnb .dp2").hide();
		if ($(this).children(".dp2").css("display") == "none") {
			$("#header .gnb_area .gnb .dp2").hide();
			$(this).children(".dp2").show();
			$("#header .gnb_area .gnb .dp1").removeClass("on");
			$("#header .gnb_area .gnb .m_<?=$dp1?> .dp1").addClass("on");
		}
	});*/
	$("#header .gnb_area .gnb > li").mouseleave(function(){
		//$("#header .gnb_area .gnb .dp2").slideUp();
		$("#header .gnb_area .gnb .m_<?=$dp1?> .dp1").addClass("on");
	});
	//$("#header .gnb_area .gnb .m_<?=$dp1?> .dp1").addClass("on");
	//
	//$("#contents .lnb_area .gnb .m_<?=$dp1?>").css("display","block");
	//$("#contents .lnb_area .gnb .sm_<?=$dp2?>").addClass("on");
})

</script>
</head>
<body>
<!--header-->
	<!--<div id="header" class="<?if($dp1=='main'){?>main<?}else{?>on<?}?>"> -->
	<div id="header"> 
		<div class="box1">
			<div class="gnb_area">
				<div class="logo">
					<a href="<?=$link_home?>">&nbsp;</a>
				</div>        
				<ul class="gnb">
					<li class="m_1">
						<a href="./attr/attr.do?m=list" class="dp1">REVIEW<span class="icon"></span></a>
					</li>
					<li class="m_2">
						<a href="./Commu/Commu.do?m=list" class="dp1">COMMUNITY<span class="icon"></span></a>
					</li>
					<c:if test="${!empty user}">
					<li class="m_3">
						<a href="./mypage/mypage.do?m=mypage" class="dp1">My Page<span class="icon"></span></a>
					</li>
					</c:if>
				</ul>
			</div>
			<div class="r_menu">
				<ul>
					<c:if test="${empty user && empty kakaoUser}">
	               <li><a href="/Trip_Full/login/login" title="로그인"><i class="xi xi-log-in"></i></a></li>
	               </c:if>
	               <c:if test="${!empty user || !empty kakaoUser}">
	               <li><a href="/Trip_Full/login/login?code=logout" title="로그아웃"><i class="xi xi-log-in"></i></a></li>
	               </c:if>
	               <li><a class="signup/signup" href="/Trip_Full/signup/signup" title="회원가입"><i class="xi xi-user-plus"></i></a></li>
				</ul>
			</div>
		</div>
		<p class="cl"></p>
		<script type="text/javascript">
		//<![CDATA[
		$(document).ready(function(){
			pcNav()
		})
		//전체메뉴
		function pcNav() {
			var headerH = $("#header").outerHeight();
			var headWrap = $('#header')
			var siteMapBtn = $('#header .siteMapbtn')
			var siteMapWrap = $('.allSItemap_wrap')
			siteMapWrap.find('.inner').css('padding-top',headerH)
			siteMapBtn.on('click',function(e){
				if($(this).parents('#header').hasClass('siteOpen') === true){
					siteMapWrap.animate({right:'-100%',opacity:"0"},200)
					headWrap.removeClass("siteOpen")
					$("html").css("overflow-y","scroll");
				}else{
					siteMapWrap.animate({right:0,opacity:"1"},200)
					headWrap.addClass("siteOpen")
					$("html").css("overflow-y","hidden");
				}
			});
		}
		//]]>
		</script>
	</div>
	<!--header end-->