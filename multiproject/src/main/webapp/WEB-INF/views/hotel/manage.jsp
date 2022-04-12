<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/hotel_managelist.js"></script>
<script src="/js/chatbot.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	});
</script>
<link rel="stylesheet" href="/css/hotel.css" />
</head>
<body style="background-image: URL(/images/hotel.png); 
background-repeat: no-repeat;
background-size: 100% 250px; 
 background-blend-mode: multiply;">
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/hotelheader.jsp"%>
	<!-- end of header import -->
	<hr />
	<section>
		<div class="search_bar">
			<h1>이곳에 검색창을 만들예정?</h1>
		</div>
		
			<div class="page_name">My호텔관리</div>
		<div class="manage_hotel_list">
			<ul class="manage_hotel_ul"></ul>
			<button id="add_hotel" href="/hotel/manage/add">호텔추가 </button>
			<ul id="manage_hotel_list_pages">
				<li class="manage_hotel_list_page"><a href="#">1</a></li>
				<li class="manage_hotel_list_page"><a href="#">2</a></li>
				<li class="manage_hotel_list_page"><a href="#">3</a></li>
				<li class="manage_hotel_list_page"><a href="#">4</a></li>
			</ul>
		</div>
	
		
	</section>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>