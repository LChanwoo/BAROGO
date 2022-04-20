<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=hb8r593xf9"></script>
<script src="/jquery-3.6.0.min.js"></script>
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
		
			<h1>세션태그부터 입력하시면 됩니다</h1>
			
		</div>
		<div class="hotel_list">
		<div id= "hotel_name">${title }</div>
			<div id="image_and_map">
				<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" >
				  <div class="carousel-indicators">
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
				  </div>
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="/images/noimage.png" class="d-block w-100" alt="">
				    </div>
				    <div class="carousel-item">
				      <img src="/images/hotel111.jpg" class="d-block w-100" alt="">
				    </div>
				    <div class="carousel-item">
				      <img src="/images/htelpick.jpg" class="d-block w-100" alt="">
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
				
				<div id="map" ></div>
			</div>

			
			
			
		</div>
		
	</section>
	<span id="data_x" hidden>${x }</span>
	<span id="data_y" hidden>${y }</span>
	<span id="data_title" hidden>${title }</span>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="/js/hotel_hotels.js"></script>
</body>

</html>