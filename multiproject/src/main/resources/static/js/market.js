/**
 * 
 */
function lihover(i){
		$(".lif"+i).css("display","block")		
				}
function liout(i){
		$(".lif"+i).css("display","none")
				}	
				
			/*장바구니 등록*/		
function basketajax(i){	
	
	if($('#headerlogin li:nth-child(3)').text() == "Login"){
		alert("로그인해야합니다")
	}else{
	var product = '#p_product'+i
	var price = '#p_price'+i
	$.ajax({
			url:"/basket",
			data:{name:$('#p_product'+i).text() , num:'1' , price:$('#p_price'+i).text(),market:$('#select1').val() },
			type:'post',
			dataType:'json',
			success:function(dto){
				var totalprice = 0;
				alert($(product).text() + "상품이 장바구니에 담겼습니다")
					$("#basket_tb").html(
			"<tr><th style= 'width:170px'>상품명</th><th style= 'width:70px'>수량</th><th style= 'width:130px'>주문금액</th><th style= 'width:90px'></th></tr>"	
			)		
				for(var j=0 ; j<dto.length;j++){
						
					$("#basket_tb").append(
								
			"<tr><td style= 'width:170px'><input type = 'checkbox' checked='checked' class='bscl'>"+
			"<input class='payname' readonly='readonly' type=text name='name' style = 'border:0;' value='"+dto[j].name+"'>"+
			"</td><td style= 'width:70px'><input min='0' id='changenum" + j + "' onchange='numchange(" + j + ")' type = number value ="+dto[j].num +" style = 'width:30px;height:20px;'>"+
			"</td><td style= 'width:130px' id='changeprice"+j+"'>"+dto[j].price+"</td><td style='width:90px'  class='num_only"+j+"'>"+dto[j].num*dto[j].price+"</td></tr>"	
					)
				totalprice += dto[j].num*dto[j].price;
				
				
				}//for
				$('#totalinput').val(totalprice)		
           
			},//success
			err:function(err){
				console.log(err)
			}
		})
				}
				
			}
			
			
		
$(document).ready(function(){	
			
		$('.basket_btn').click(
			function(){
				
				
				
			}
			
		)
		
		
		
		
		
		
		
	
		
		/*장바구니 삭제*/
	$('#delete_bs').click(
			
	function(){
		var name1 = []
		alert($('input:checked+input').val())
		$('input:checked+input').each(function(){
			name1.push($(this).val());
		
		});
		var name = {
			'name':name1
		}
			
		$.ajax({
			url: '/deletebasket'	,
					data:name,
					type:'post',
					dataType:'json',
					traditional:true, 
					success:function(dto){
						alert('장바구니 삭제완료')
						var totalprice = 0;
						$('#basket_tb').html(
		"<tr><th style= 'width:170px'>상품명</th><th style= 'width:70px'>수량</th><th style= 'width:130px'>주문금액</th><th style= 'width:90px'></th></tr>"	
						)
						for(var i =0 ; i<dto.length;i++){
						$('#basket_tb').append(	
			"<tr><td style= 'width:170px'><input type = 'checkbox'  class='bscl' checked='checked'>"+
			"<input class='payname' readonly='readonly' type=text name='name' style = 'border:0;' value="+dto[j].name+"'>"+
			"</td><td style= 'width:70px'><input min='0' id='changenum" + j + "' onchange='numchange(" + j + ")' type = number value ="+dto[j].num +" style = 'width:30px;height:20px;'>"+
			"</td><td style= 'width:130px' id='changeprice"+j+"'>"+dto[j].price+"</td><td style='width:90px'  class='num_only"+j+"'>"+dto[j].num*dto[j].price+"</td></tr>"					
					)
				totalprice += dto[j].num*dto[j].price;
				
						
						
						}
				$('#totalinput').val(totalprice)	
					
					},
					error:function(err){
						console.log(err)
					}
					
					
				})//ajax end	
			
					})
			$('#select1').change(function(){
				
				location.href='market?market='+$('#select1').val()
				
				})
				
				$('#clo1').click(function(){
					$('.modal').css('display','none')
					
				})
				
				
		})




	
	
 
 
