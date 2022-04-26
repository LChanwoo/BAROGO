let scrollTop 
let innerHeight
let scrollHeight
let page=1;
const makediv=function(){
	return new Promise((resolve, reject) => {
	var i =document.createElement('li');
	i.innerHTML='<div class="hotel_list_infor" ><a class="goedit" href="">'
			+'<div class="hotel_list_infor_pic"><img class="hotel_list_infor_pic_img" src=""></div>'
			+'<div class="hotel_list_infor_contents">'
			+'	<div class="hotel_list_infor_name">'
			+'		<span class="hotel_name"></span>'
			+'			<div class="hotel_reservation_button"></div>'
			+'		</div>'
			+'	<div class="hotel_list_infor_detail">'
			+'	</div>'
			+'</div>'
			+'</a></div>';
	var addressContainer = document.getElementsByClassName("hotel_list")[document.getElementsByClassName("hotel_list").length-1];
	addressContainer.appendChild(i);
	resolve(addressContainer.appendChild(i));
	})
};
const makesection=function(){
	var i =document.createElement('div');
	i.setAttribute("class","hotel_list");
	var addressContainer = document.getElementById("hotel_lists_section");
	addressContainer.appendChild(i);
}
const makeinvisible=function(page){
	var i =document.createElement('div');
	i.setAttribute("class","invisible_line");
	i.setAttribute("hidden","hidden");
	i.innerHTML=page;
	var addressContainer = document.getElementById("hotel_lists_section");
	addressContainer.appendChild(i);
}
// function detectBottom() {
//     scrollTop = $(window).scrollTop();
//     innerHeight = $(window).innerHeight();
	
//      scrollHeight = $('body').prop('scrollHeight');
//     if (scrollTop + innerHeight >= scrollHeight) {
//         return true;
//     } else {
//         return false;
//     }
// }
// setTimeout(detectBottom(), 1000);
const getAjax = function() {
	return new Promise((resolve, reject) => { // 1.
	  $.ajax({
		url: "/hotel",
		type: "post",
		dataType: "json",
		data: {'page':page},
		success: (respond) => {
			resolve(respond);
		},
		error: (e) => {
		  reject(e);  // 3.
		}
	  });
	});
  }
//   const makedivasync = function(respond) {
// 	return new Promise((resolve, reject) => { // 1.
// 		if(respond.length==0){return;}
// 				else{				
// 					console.log(respond.length);
// 					makesection();
// 					page++;
// 					for(let i=0;i<respond.length;i++){
// 						makediv();
// 						inserttodiv(i,respond);
// 					} 
					
// 				}

// 	});
//   }
  const inserttodiv = function(i,respond) {
	return new Promise((resolve, reject) => {
		console.log("i : "+i);
		console.log("respond : "+respond[i].hotel_id);
	const hotelname= document.getElementsByClassName("hotel_list_infor_name")[i+15*(page-2)];
	const pic_url= document.getElementsByClassName("hotel_list_infor_pic_img")[i+15*(page-2)];
	const contents= document.getElementsByClassName("hotel_list_infor_detail")[i+15*(page-2)];
	const edithref = document.getElementsByClassName("goedit")[i+15*(page-2)];
	edithref.setAttribute("href","/hotel/"+respond[i].hotel_id);
	hotelname.innerHTML = respond[i].hotel_name;
	pic_url.setAttribute("src",respond[i].hotel_picture);
	contents.innerHTML = respond[i].hotel_phone+"<br>"+respond[i].hotel_address1+" "+respond[i].hotel_address2+"<br>";
	resolve();
	})
	};
	// function getDocHeight() {
	// 	var D = document;
	// 	return Math.max(
	// 		D.body.scrollHeight, D.documentElement.scrollHeight,
	// 		D.body.offsetHeight, D.documentElement.offsetHeight,
	// 		D.body.clientHeight, D.documentElement.clientHeight
	// 	);
	// }
	// $(window).scroll(function() {
	// 	console.log($(window).scrollTop() + " , "+  $(window).height()  + " , "+ getDocHeight());
	// 	if($(window).scrollTop() + $(window).height() == getDocHeight()) {
	// 		alert("bottom!");
	// 	}
	// });
	function disableScrolling(){
		var x=window.scrollX;
		var y=window.scrollY;
		window.onscroll=function(){window.scrollTo(x, y);};
	}
	
	function enableScrolling(){
		window.onscroll=function(){};
	}
	// const timer = setInterval(() => {
	// 	console.log('하이');
	// }, 00);
	const divif = function(respond) {
		return new Promise((resolve, reject) => {
		
			if(respond.length==0){return;}
			else{				
				console.log(respond.length);
				makesection();
				for(let i=0;i<respond.length;i++){
					makediv();
				} 
				for(let i=0;i<respond.length;i++){
					inserttodiv(i,respond);
				} 
				page++;
				
			}
			resolve();
		})
		};
	setTimeout(()=>{
	window.addEventListener('scroll',async () => { 
		 scrollTop = parseInt( $(window).scrollTop());
		 innerHeight = $(window).innerHeight();
		 scrollHeight = $('html').prop('scrollHeight')
		//  console.log(scrollTop+innerHeight);
		//  console.log(scrollHeight);
		// const scrollable =document.documentElement.scrollHeight -window.innerHeight;
		// const scrolled=window.scrollY;
		// console.log("scrollable = "+scrollable);
		// console.log("scrolled = "+Math.ceil(scrolled));
		// if(Math.ceil(scrolled)==scrollable){

		// 	console.log("bottom");
		// }

		if( scrollTop+innerHeight>=scrollHeight){
			console.log(page);
			 const respond=await getAjax()
			 if(respond.length==0){
				 console.log("respond.length==0")
				 return;}
			 else{				
				 console.log("respond.length :"+respond.length);
				 makesection();
				 page++;
				 for(let i=0;i<respond.length;i++){
					 makediv();
				 } 
				 for(let i=0;i<respond.length;i++){
					 inserttodiv(i,respond);
				 } 
			 }
		}				
		// else{
		// 	return ;
		// }

	});
	},300);




document.getElementsByClassName("search_btns1")[0].onclick=function(){
	const page=1;
	const val= document.getElementsByClassName("searchtextbox")[0];
	window.location.href="/hotel/search?text="+val.value+"?page="+page;
}

$(document).ready(function () {
	scrollTop = $(window).scrollTop();
	innerHeight = $(window).innerHeight();
	scrollHeight = $('body').prop('scrollHeight');
	console.log( $(window).scrollTop());
	console.log(  $(window).innerHeight());
	console.log($('body').prop('scrollHeight'));
	window.scrollTo(0, 0)
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
				edithref.setAttribute("href","/hotel/"+respond[i].hotel_id);
				hotelname.innerHTML = respond[i].hotel_name;
				// pic_url.style.backgroundImage='url("'+ '/upload/hotel/example/example+(554e08ba-4ce8-4041-b186-62bfb7af7485).jpg'+'")';
				pic_url.setAttribute("src",respond[i].hotel_picture);
				contents.innerHTML = respond[i].hotel_phone+"<br>"+respond[i].hotel_address1+" "+respond[i].hotel_address2+"<br>";
		   } 
		   location.href="#";
		   page++;
		   
		//    const scrolll = window.addEventListener('scroll', () => { 
		// 	if(detectBottom()){
		// 		console.log($(window).scrollTop()+$(window).innerHeight());
		// 		$.ajax({
		// 			url : '/hotel' ,
		// 			data : {'page':page},
		// 			type : 'post',
		// 			dataType : 'json',
		// 			success : function(respond){
		// 				if(respond.length==0){return;};
		// 				console.log("page : "+page);
		// 				makesection();
		// 				for(let i=0;i<respond.length;i++){
		// 					makediv();
		// 					const hotelname= document.getElementsByClassName("hotel_list_infor_name")[i+15*(page-1)];
		// 					const pic_url= document.getElementsByClassName("hotel_list_infor_pic_img")[i+15*(page-1)];
		// 					const contents= document.getElementsByClassName("hotel_list_infor_detail")[i+15*(page-1)];
		// 					const edithref = document.getElementsByClassName("goedit")[i+15*(page-1)];
		// 					edithref.setAttribute("href","/hotel/"+respond[i].hotel_id);
		// 					hotelname.innerHTML = respond[i].hotel_name;
		// 					// pic_url.style.backgroundImage='url("'+ '/upload/hotel/example/example+(554e08ba-4ce8-4041-b186-62bfb7af7485).jpg'+'")';
		// 					pic_url.setAttribute("src",respond[i].hotel_picture);
		// 					contents.innerHTML = respond[i].hotel_phone+"<br>"+respond[i].hotel_address1+" "+respond[i].hotel_address2+"<br>";
		// 				} 
		// 				page++;
					   		   
					   					   
		// 			}
		// 		});
		// 	}
		//   	});
		//	  setTimeout(scrolll, 1000);
		   
		}
		
}); 

});