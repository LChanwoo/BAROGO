$(document).ready(function () {
	const makelist=function(){
		var i =document.createElement('li');
		i.innerHTML='<a class="manage_hotel_list_infor" href="/Hotel">'
		+'	<div class="manage_hotel_list_infor_pic"></div>'
		+'	<div class="manage_hotel_list_infor_contents">'
		+'		<div class="manage_hotel_list_infor_name">'
		+'			<span class="manage_hotel_name"></span>'
		+'		</div>'
		+'		<div class="manage_hotel_list_infor_detail"></div>'
		+'	</div></a>';
		var addressContainer = document.getElementsByClassName("manage_hotel_ul")[0];
		addressContainer.appendChild(i);
	}
	// const add_clcik=function(){
	document.getElementById("add_hotel").onclick=function(){
		window.location.href="/hotel/manage/add";
	};
	// };
	$.ajax({
			url : '/hotel/manage' ,
			data : {'str':'str2'},
			type : 'post',
			dataType : 'json',
			success : function(respond){
               for(let i=0;i<respond.length;i++){
					makelist();
					const hotelname= document.getElementsByClassName("manage_hotel_list_infor_name")[i];
					const pic_url= document.getElementsByClassName("manage_hotel_list_infor_pic")[i];
					const contents= document.getElementsByClassName("manage_hotel_list_infor_detail")[i];
					hotelname.innerHTML = respond[i].hotelname;
					pic_url.style.backgroundImage='url("'+respond[i].pic_url +'")';
					contents.innerHTML = respond[i].contents;
			   } 
               
            }
    }); 
});