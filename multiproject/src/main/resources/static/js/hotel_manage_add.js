
	function goPopup(){
		// 호출된 페이지(jusoPopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("/hotel/manage/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		
		// 모바일 웹인 경우, 호출된 페이지(jusoPopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}
	/** API 서비스 제공항목 확대 (2017.02) **/
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
							, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.getElementById('roadAddrPart').value = roadAddrPart1;
		document.getElementById('roadAddrPart').append = " "+roadAddrPart2;
		document.getElementById('addrDetail').value = addrDetail;
		document.getElementById('zipNo').value = zipNo;
	}
	const abs_add =function(){
			var i =document.createElement('div');
			i.setAttribute('class','abs_infor_room_infors')
			i.innerHTML='<div class="abs_infor_room_infors_inner spacingtb10">'
			+'	<div>룸 이름 : <input text=text class="room_name spacingtb10 roomtxt" value="ex)일반실, 특실"></div>'
			+'	<div>침대 크기/수량 : <input text=text class="room_bed_size spacingtb10 roomtxt" value="ex)1인" >/<input text=text class="room_bed_qty roomtxt" value="ex)2개"></div>'
			+'	<div>기타 사항 : <input text=text class="room_etc spacingtb10 roomtxt" ></div>'
			+'</div>';
			var addressContainer = document.getElementsByClassName("abs_infor")[0];
			addressContainer.appendChild(i);
		};
$(document).ready(function () {
	document.getElementById("roadAddrPart").onclick=function(){	goPopup();};  
	document.getElementById("add_abs_infor").onclick=function(){ abs_add(); };  
	// $.ajax({
	// 		url : '/hotel/manage/jusoPopup' ,
	// 		data : {'str':'str2'},
	// 		type : 'post',
	// 		dataType : 'json',
	// 		success : function(respond){
	// 		   alert("s");
	// 		}
	// }); 
});