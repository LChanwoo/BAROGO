<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	
	
function preventClick(e){
	e.preventDefault()
}
function showPopup(){
    window.open("test.jsp","팝업 테스트","width=900, height=900, top=10, left=10");
}

if($('#headerlogin li:nth-child(3)').text() == "Logout"){
$(".btn-open-popup").click(function(){
	$(".modal").css("display","block"),
	$("body").css("overflow","hidden")
})//click end,
	}else{
		alert("로그인하세요")
		location.href = "/login"
	}

$("#clo1").click(function(){
	
})



	})//ready end

</script>
<!-- header -->

<!-- end of header -->
    <footer>
    <div style="display: scroll; position: fixed; bottom: 100px; right: 42px;">
	<a href="#" title="맨위로">
	<img style="width: 25px;" src="<c:url value='/images/angleup.png' />" alt="맨위로">
	</a>
	</div>
	
	


	

	
</footer>

</html>