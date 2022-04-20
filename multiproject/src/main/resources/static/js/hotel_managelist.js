
$(document).ready(function () {
	
	const urlParams = new URL(location.href).searchParams;
	let page = urlParams.get('page');
	if(page==null){
		page=1;
	}
	console.log(page);
	const makelist=function(){
		var i =document.createElement('li');
		i.innerHTML='<a class="manage_hotel_list_infor" href="/Hotel">'
		+'	<div class="manage_hotel_list_infor_pic_div"><img class="manage_hotel_list_infor_pic"/></div>'
		+'	<div class="manage_hotel_list_infor_contents">'
		+'		<div class="manage_hotel_list_infor_name">'
		+'			<span class="manage_hotel_name"></span>'
		+'		</div>'
		+'		<div class="manage_hotel_list_infor_detail"></div>'
		+'	</div></a>';
		var addressContainer = document.getElementsByClassName("manage_hotel_ul")[0];
		addressContainer.appendChild(i);
	}
	const makepage=function(e){
		//<li class='manage_hotel_list_page'><a href=/hotel/manage?page=1>1</a></li>
		var i =document.createElement('li');
		i.setAttribute("class",'manage_hotel_list_page');
		i.innerHTML='<a href=/hotel/manage?page='+e+'>'+e+'</a>';
		var addressContainer = document.getElementById("manage_hotel_list_pages");
		addressContainer.appendChild(i);
	}
	// const add_clcik=function(){
	document.getElementById("add_hotel").onclick=function(){
		window.location.href="/hotel/manage/post";
	};

	$.ajax({
			url : '/hotel/manage/getcount' ,
			data : {'page':1},
			type : 'post',
			dataType : 'json',
			success : function(respond){
               for(let i=1;i<= parseInt(respond.count/3+1);i++){
					makepage(i);

			   } 
               
            }
    }); 
	$.ajax({
		url : '/hotel/manage' ,
		data : {'page':page},
		type : 'post',
		dataType : 'json',
		success : function(respond){
		   for(let i=0;i<respond.length;i++){
				makelist();
				const hotelname= document.getElementsByClassName("manage_hotel_list_infor_name")[i];
				const pic_url= document.getElementsByClassName("manage_hotel_list_infor_pic")[i];
				const contents= document.getElementsByClassName("manage_hotel_list_infor_detail")[i];
				hotelname.innerHTML = respond[i].hotelname;
				console.log(respond[i].pic_url);
				// pic_url.style.backgroundImage='url("'+ '/upload/hotel/example/example+(554e08ba-4ce8-4041-b186-62bfb7af7485).jpg'+'")';
				pic_url.setAttribute("src",respond[i].pic_url);
				contents.innerHTML = respond[i].contents;
		   } 
		   
		}
}); 
});