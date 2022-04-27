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

</head>
<body>
	<!-- header import -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!-- end of header import -->
	<hr>
	<section>

		<div>
			<h1>세션태그부터 입력하시면 됩니다</h1>
		</div>
	</section>

	<!-- footer import -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!-- end of footer import -->
</body>

</html>