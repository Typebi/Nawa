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
<div class="board_search_wrap">
    <div class="board_search fl">
        <button type="button" class="search_btn write" onclick="location.href='../Commu/Commu.do?m=write'"><i class="xi xi-border-color"></i> 글쓰기</button>
    </div>
    <div class="board_search fr">
    	<form name="input" method="post" action="../Commu/Commu.do?m=search"  >
        <input type="text" name="subject" class="search_inp" placeholder="제목으로 검색하기" />
        <input type="submit" class="search_btn" value="검색">
        </form>
    </div>
</div>
<c:if test = "${empty listResult.list}">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st list">
		<tbody>
		    <tr>
		        <td class="no_con">등록된 게시물이 없습니다.</td>
		    </tr>
		</tbody>
	</table>
</c:if>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st list tit">
  <col class="w_no" />
  <col class="w_tit" />
  <col class="w_name" />
  <col class="w_date" />
  <col class="w_hit" />
  <tr>
    <th class="w_no">No.</th>
    <th class="w_tit">제목</th>
    <th class="w_name">작성자</th>
    <th class="w_date">등록일</th>
    <th class="w_hit">조회수</th>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st list notice">
  <col class="w_no" />
  <col class="w_tit" />
  <col class="w_name" />
  <col class="w_date" />
  <col class="w_hit" />
	<tbody>
	<c:forEach items = "${listResult.list}" var="board">
		<tr>
	        <td class="w_no">${board.c_seq}</td>
	        <td class="w_tit"><a href="../Commu/Commu.do?m=content&c_seq=${board.c_seq}">${board.subject}</a></td>
	        <td class="w_name">${board.nick_name}</td>
	        <td class="w_date">${board.rdate}</td>
	        <td class="w_hit">${board.hits}</td>
	    </tr>
	</c:forEach>
	</tbody>
</table>
<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0" class="board_st list reply">
  <col class="w_no" />
  <col class="w_tit" />
  <col class="w_name" />
  <col class="w_date" />
  <col class="w_hit" />
<tbody>
    <tr>
        <td class="w_no"><span class="board_icon reply">ㄴ</span></td>
        <td class="w_tit"><a href="2_1_v.jsp">답변이 입력됩니다.답변이 입력됩니다.답변이 입력됩니다.</a></td>
        <td class="w_name">관리자</td>
        <td class="w_date">2016.00.00</td>
        <td class="w_hit">1000</td>
    </tr>
</tbody>
</table> -->

<div class="board_paging">
    <button class="icon" onclick="javascript:location.href='../Commu/Commu.do?m=back&cp=1'">&#x000AB;</button>
    <button class="icon" onclick="javascript:location.href='../Commu/Commu.do?m=back&cp=${cp}'">&#x02039;</button>
    
    <c:forEach begin="1" end = "${listResult.totalPageCount}" var="i">
    <c:choose>
	    <c:when test="${i==listResult.currentPage}">
	    	<button class="on">${i}</button>
	    </c:when>
	    <c:otherwise>
	    	<button onclick="javascript:location.href='../Commu/Commu.do?m=list&cp=${i}'">${i}</button>
	    </c:otherwise>	
	</c:choose>    
    </c:forEach>
    <button class="icon" onclick="javascript:location.href='../Commu/Commu.do?m=go&cp=${cp}'">&#x0203A;</button>
    <button class="icon" onclick="javascript:location.href='../Commu/Commu.do?m=list&cp=${listResult.totalPageCount}'">&#x000BB;</button>
</div>
</div>
</div>
<%@ include file="../inc/footer.jsp" %>
