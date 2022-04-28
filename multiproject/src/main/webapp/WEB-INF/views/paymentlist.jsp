<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- CSS -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="/css/styles.css" rel="stylesheet" />
<link href="/css/hotel.css" rel="stylesheet" />
<!-- JAVASCRIPT -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/sweetalert.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="/js/userlist.js"></script>
<script src="/js/chatbot.js"></script>

<title>boardList</title>
<style type="text/css">
table {
  border-spacing:  20px;
}
table  {
  width: 100px;
}
</style>
</head>
<body>
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/mypageheader.jsp"%>
	<!-- end of header import -->
	<hr>
	<section>
		<!-- Sidebar-->
		<div class="d-flex" id="wrapper">
		<div class="d-flex" id="wrapper">
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="list-group list-group-flush">
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="/mypage">회원 수정</a> 
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="/deletemember">회원 탈퇴</a> 
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	>내역 확인</a>
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/reservation">호텔 예약내역</a>	
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/paymentlist.do?userId=${userId}">마켓 구매내역</a>
					<a class="list-group-item list-group-item-action list-group-item-light p-3"	href="/hotel/manage">호텔관리</a>
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage/reservation">호텔예약관리</a>
					<a class=" list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage">호텔등록/수정</a>
					<a class=" list-group-item  list-group-item-action list-group-item-light p-1 mypagelists"	href="/hotel/manage/delete">호텔삭제</a>
					<a class="list-group-item list-group-item-action list-group-item-light p-3" href="/marketadmin">마켓 상품 관리</a>
				</div>
			</div>
			<div class="page-wrapper">
				<div class="container-fluid">
					<div class="col-lg-8">
						<!--게시판 넓이 -->
						<div class="col-lg-20">
							<h1 class="page-header">결제 내역</h1>
						</div>

					</div>
					<div class="panel panel-default">

						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th style="width:50px;">No</th>
										<th style="width:80px; max-width:100px;">아이디</th>
										<th style="width:100px; max-width:200px;">제품이름</th>
										<th style="width:100px; max-width:200px;">가격</th>
										<th style="width:100px; max-width:200px;">이메일</th>
										<th style="width:100px; max-width:200px;">이름</th>
										<th style="width:100px; max-width:300px;">전화번호</th>
										<th style="max-width:600px;">주소</th>
										<th>번지수</th>								
									</tr>
									
								</thead>
								<tbody>
									<c:forEach items="${list}" var="payment">
										<tr>
										<br>
											<td>${payment.payno} </td>											
											<td>${payment.userId} </td>
											<td>${payment.proname}</td>
											<td>${payment.amount}원</td>
											<td>${payment.buyer_email}</td>
											<td>${payment.buyer_name}</td>
											<td>${payment.buyer_tel}</td>
											<td>${payment.buyer_addr}</td>
											<td>${payment.buyer_postcode}</td>
										</tr>

									</c:forEach>									
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
	</section>
</body>
</html>
