const makediv=function(){
	var i =document.createElement('li');
	i.innerHTML='<div class="hotel_list_infor" ><a class="goedit" href="/hotel/15">'
			+'<div class="hotel_list_infor_pic"><img class="hotel_list_infor_pic_img" src="/images/hotel111.jpg"></div>'
			+'<div class="hotel_list_infor_contents">'
			+'	<div class="hotel_list_infor_name">'
			+'		<span class="hotel_name"></span>'
			+'			<div class="hotel_reservation_button"></div>'
			+'		</div>'
			+'	<div class="hotel_list_infor_detail">'
			// +'		최대 인원 2명 침실 1개 침대 1개 '
			+'	</div>'
			+'</div>'
			+'</a></div>';
	var addressContainer = document.getElementsByClassName("hotel_list")[document.getElementsByClassName("hotel_list").length-1];
	addressContainer.appendChild(i);
};
	// const makepage=function(e){
	// 	//<li class='manage_hotel_list_page'><a href=/hotel/manage?page=1>1</a></li>
	// 	var i =document.createElement('li');
	// 	i.setAttribute("class",'manage_hotel_list_page');
	// 	i.innerHTML='<a href=/hotel/manage?page='+e+'>'+e+'</a>';
	// 	var addressContainer = document.getElementById("manage_hotel_list_pages");
	// 	addressContainer.appendChild(i);
	// }
	// // const add_clcik=function(){
	// document.getElementById("add_hotel").onclick=function(){
	// 	window.location.href="/hotel/manage/post";
	// };
	function detectBottom() {
		var scrollTop = $(window).scrollTop();
		var innerHeight = $(window).innerHeight();
		var scrollHeight = $('body').prop('scrollHeight');
		if (scrollTop + innerHeight >= scrollHeight) {
			alert("wgo");
		return true;
		} else {
		return false;
		}
		}
	window.addEventListener('scroll', () => { 
		//스크롤을 할 때마다 로그로 현재 스크롤의 위치가 찍혀나온다.
		detectBottom;
		console.log(window.scrollX, window.scrollY);
	  });
$(document).ready(function () {



	// $.ajax({
	// 		url : '/hotel/manage/getcount' ,
	// 		data : {'page':1},
	// 		type : 'post',
	// 		dataType : 'json',
	// 		success : function(respond){
    //            for(let i=1;i<= parseInt(respond.count/3+1);i++){
	// 				makepage(i);

	// 		   } 
               
    //         }
    // }); 
	$.ajax({
		url : '/hotel' ,
		data : {'page':1},
		type : 'post',
		dataType : 'json',
		success : function(respond){
		   for(let i=0;i<respond.length;i++){
				makediv();
				const hotelname= document.getElementsByClassName("hotel_list_infor_name")[i];
				const pic_url= document.getElementsByClassName("hotel_list_infor_pic_img")[i];
				const contents= document.getElementsByClassName("hotel_list_infor_detail")[i];
				const edithref = document.getElementsByClassName("goedit")[i];
				console.log(respond[i].hotel_id);
				edithref.setAttribute("href","/hotel/"+respond[i].hotel_id);
				hotelname.innerHTML = respond[i].hotel_name;
				console.log(respond[i].hotel_picture);
				// pic_url.style.backgroundImage='url("'+ '/upload/hotel/example/example+(554e08ba-4ce8-4041-b186-62bfb7af7485).jpg'+'")';
				pic_url.setAttribute("src",respond[i].hotel_picture);
				contents.innerHTML = respond[i].hotel_phone+"<br>"+respond[i].hotel_address1+" "+respond[i].hotel_address2+"<br>";
		   } 
		   
		}
}); 
});