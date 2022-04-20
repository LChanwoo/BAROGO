var myCarousel = document.querySelector('#carouselExampleIndicators');
var carousel = new bootstrap.Carousel(myCarousel);

let markers = new Array(); 
let infoWindows = new Array();

const x = parseFloat(document.getElementById("data_x").innerHTML);
const y = parseFloat(document.getElementById("data_y").innerText);
const title = document.getElementById("data_title").innerText;

var mapOptions = {
	center: new naver.maps.LatLng( y,x),
    zoom: 17
};
var map = new naver.maps.Map('map', mapOptions);

var marker = new naver.maps.Marker({
    position: new naver.maps.LatLng( y, x),
    map: map
});


var infoWindow = new naver.maps.InfoWindow({
	content: '<div style="width:200px;text-align:center;padding:10px;"><b>'+title +'</b></div>'
}); 
infoWindow.open(map, marker); 
markers.push(marker); 
infoWindows.push(infoWindow);


function getClickHandler(seq) {

	return function(e) {
		var marker = markers[seq], 
			infoWindow = infoWindows[seq]; 

		if (infoWindow.getMap()) {
			infoWindow.close();
		} else {
			infoWindow.open(map, marker); 
		}
	}
}

for (var i=0, ii=markers.length; i<ii; i++) {
console.log(markers[i] , getClickHandler(i));
naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i));
}



$(document).ready(function () {

	// $.ajax({
	// 	url : '/hotel/getAddress' ,
	// 	data : {'address': phonetmp},
	// 	type : 'post',
	// 	dataType : 'json',
	// 	success : function(respond){
	// 		cert_num=respond.randomNumber;
	// 		alert(cert_num);
    //     }
	// }); 
});