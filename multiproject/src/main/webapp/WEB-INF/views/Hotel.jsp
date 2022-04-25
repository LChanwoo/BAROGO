<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
<script src="js/chatbot.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	});
</script>
<link rel="stylesheet" href="/css/hotel.css" />
</head>
<body style="background-image: URL(images/hotel.png); 
background-repeat: no-repeat;
background-size: 100% 250px; 
 background-blend-mode: multiply;">
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/hotelheader.jsp"%>
	<!-- end of header import -->
	<hr />
	<section>

		<div class="search_bar">
		
			<h1>세션태그부터 입력하시면 됩니다</h1>
			
		</div>
		<div class="hotel_list">
		

		</div>
		
	</section>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script src="/js/hotel_list.js"></script>
	<!-- end of footer import -->
</body>

</html>