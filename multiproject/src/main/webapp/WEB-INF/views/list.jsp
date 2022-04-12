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
<link rel="stylesheet" href="css/hotel.css" />
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
		
			<h1>세션태그부터 입력하시면 됩니다</h1>
			
		</div>
		<div class="hotel_list">
		
			<div class="hotel_list_infor" src="/Market">
				<div class="hotel_list_infor_pic"></div>
				<div class="hotel_list_infor_contents">
					<div class="hotel_list_infor_name">
						<span class="hotel_name">하얏트호텔</span>
						<div class="hotel_reservation_button"></div>
						</div>
					<div class="hotel_list_infor_detail">
						최대 인원 2명 침실 1개 침대 1개 
					</div>
				</div>
			</div>			
			<div class="hotel_list_infor">
				<div class="hotel_list_infor_pic"></div>
				<div class="hotel_list_infor_contents">
					<div class="hotel_list_infor_name">
						<span class="hotel_name">하얏트호텔</span>
						<div class="hotel_reservation_button"></div>
						</div>
					<div class="hotel_list_infor_detail">
						최대 인원 2명 침실 1개 침대 1개 
						최대 인원 2명 침실 1개 침대 1개 
						최대 인원 2명 침실 1개 침대 1개 
						최대 인원 2명 침실 1개 침대 1개 
						최대 인원 2명 침실 1개 침대 1개 
						최대 인원 2명 침실 1개 침대 1개 
					</div>
				</div>
			</div>
						<div class="hotel_list_infor">
				<div class="hotel_list_infor_pic"></div>
				<div class="hotel_list_infor_contents">
					<div class="hotel_list_infor_name">
						<span class="hotel_name">하얏트호텔</span>
						<div class="hotel_reservation_button"></div>
						</div>
					<div class="hotel_list_infor_detail">
						최대 인원 2명 침실 1개 침대 1개 
					</div>
				</div>
			</div>
						<div class="hotel_list_infor">
				<div class="hotel_list_infor_pic"></div>
				<div class="hotel_list_infor_contents">
					<div class="hotel_list_infor_name">
						<span class="hotel_name">하얏트호텔</span>
						<div class="hotel_reservation_button"></div>
						</div>
					<div class="hotel_list_infor_detail">
						최대 인원 2명 침실 1개 침대 1개 
					</div>
				</div>
			</div>
						<div class="hotel_list_infor">
				<div class="hotel_list_infor_pic"></div>
				<div class="hotel_list_infor_contents">
					<div class="hotel_list_infor_name">
						<span class="hotel_name">하얏트호텔</span>
						<div class="hotel_reservation_button"></div>
						</div>
					<div class="hotel_list_infor_detail">
						최대 인원 2명 침실 1개 침대 1개 
					</div>
				</div>
			</div>
						<div class="hotel_list_infor">
				<div class="hotel_list_infor_pic"></div>
				<div class="hotel_list_infor_contents">
					<div class="hotel_list_infor_name">
						<span class="hotel_name">하얏트호텔</span>
						<div class="hotel_reservation_button"></div>
						</div>
					<div class="hotel_list_infor_detail">
						최대 인원 2명 침실 1개 침대 1개 
					</div>
				</div>
			</div>
									<div class="hotel_list_infor">
				<div class="hotel_list_infor_pic"></div>
				<div class="hotel_list_infor_contents">
					<div class="hotel_list_infor_name">
						<span class="hotel_name">하얏트호텔</span>
						<div class="hotel_reservation_button"></div>
						</div>
					<div class="hotel_list_infor_detail">
						최대 인원 2명 침실 1개 침대 1개 
					</div>
				</div>
			</div>
		</div>
		
	</section>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>