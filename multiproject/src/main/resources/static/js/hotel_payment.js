$(document).ready(function(){ 
	$("#iamportPayment").click(function(){ 
		
		//  var name = document.getElementById('proname').value;
		//  var amount = document.getElementById('amount').value;
		//  var buyer_email = document.getElementById('buyer_email').value;
		//  var buyer_name = document.getElementById('buyer_name').value;
		//  var buyer_tel = document.getElementById('buyer_tel').value;
		//  var buyer_addr = document.getElementById('buyer_addr').value;
		//  var buyer_postcode = document.getElementById('buyer_postcode').value;
    	payment(); //버튼 클릭하면 호출 
    }); 
})

function payment(data) {
	
	
IMP.init('imp27550428');

IMP.request_pay({
    pg : 'inicis', // version 1.1.0부터 지원.
    pay_method : 'card',
    merchant_uid : 'h' + new Date().getTime(),
    name : document.getElementById('hotel_namess').value,
    amount : document.getElementById("total_payment2").value,
    buyer_email : data.userEmail,
    buyer_name : data.userName,
    // buyer_tel : document.getElementById('buyer_tel').value,
    // buyer_addr : document.getElementById('buyer_addr').value,
    // buyer_postcode : document.getElementById('buyer_postcode').value,
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '결제가 완료되었습니다.';
        msg += '고유ID : ' + rsp.imp_uid;
        msg += '상점 거래ID : ' + rsp.merchant_uid;
        msg += '결제 금액 : ' + rsp.paid_amount;
        msg += '카드 승인번호 : ' + rsp.apply_num;
        alert(msg);
        const url = location.href;
		const urlsplit=url.split('/');
		const hotelid =urlsplit[urlsplit.length-1];
		const business_id= document.getElementById("business_id").innerHTML;
		const hotel_name= document.getElementById("hotel_namess").innerHTML;
		startdate=document.getElementById("start_date").value;
		enddate=document.getElementById("end_date").value;
		let price=document.querySelector('input[name="ghost"]:checked').value; 
		const DateA= moment(startdate).format("YYYY-MM-DD HH:mm:ss");
		const DateB= moment(enddate).format("YYYY-MM-DD HH:mm:ss");
		const DateA2= moment(startdate);
		const DateB2= moment(enddate);
		const hotel_price=((DateB2.diff(DateA2,'days'))*price);

        $.ajax({
            url : '/hotel/getpay' ,
            data : {'hotel_id': hotelid,
                    'hotel_name': hotel_name,
                    'business_id': business_id,
                    'start_date':DateA,
                    'end_date': DateB,
                    'payment': hotel_price,
                    'proname':document.getElementById('hotel_namess').value,
                    'amount': document.getElementById("total_payment2").value,
                    'buyer_email' : data.userEmail,
                    'buyer_name' : data.userName
                    },
            type : 'post',
            dataType : 'json',
            success : function(respond){
                    alert('예약 신청이 완료되었습니다.');
                    window.location.href="/reservation";
            }
        });
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
        alert(msg);
    }
    
  });
}