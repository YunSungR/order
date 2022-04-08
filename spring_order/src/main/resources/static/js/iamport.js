/**
 * 
 */
 $(function(){
	
	$('#order').on('click',function(){
		//가맹점 식별코드
		
		IMP.init('imp74263585');
		IMP.request_pay({
		    pg : 'html5_inicis',// pg사
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : $('#allPrdName').val() , //결제창에서 보여질 이름
		    amount : $('#amount').val(), //실제 결제되는 가격
		    buyer_email : $('#or_email').val(),
		    buyer_name : $('#or_name').val(),
		    buyer_tel : $('#or_hp').val(),
		    buyer_addr : $('#memAddress').val(),
		    buyer_postcode : '123-456'
		}, function(rsp) {
			console.log(rsp);
		    if ( rsp.success ) {
		    	var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		     	msg += "biz_email  :"+ $('#or_email').val();
				msg += "pay_date : "+	new Date().getTime();
				msg +=	"amount :"+  rsp.paid_amount;
				msg +=	"card_no :"+  rsp.apply_num,
				msg +=	"refund :"+  'payed';
					var result = {
					"imp_uid" : rsp.imp_uid,
					"merchant_uid" : rsp.merchant_uid,
					"biz_email" :  $('#or_email').val(),
					"pay_date" : new Date().getTime(),
					"amount" : rsp.paid_amount,
					"card_no" : rsp.apply_num,
					"refund" : 'payed',
					"pay_method":rsp.pay_method,
					"or_name":$('#or_name').val(),
					"or_hp":$('#or_hp').val(),
					"or_email":$('#or_email').val(),
					"memAddress":$('#memAddress').val(),
					"re_hp":$('#hp1').val()+"-"+$('#hp2').val()+"-"+$('#hp3').val(),
					"re_zip":$('#re_zip').val(),
					"re_addr1":$('#re_addr1').val(),
					"re_addr2":$('#re_addr2').val()
					}
					$.ajax({
			type:'post',
			url:'/orderCard',
			 data : {"imp_uid" : rsp.imp_uid,
					"merchant_uid" : rsp.merchant_uid,
					"biz_email" :  $('#or_email').val(),
					"pay_date" : new Date().getTime(),
					"amount" : rsp.paid_amount,
					"card_no" : rsp.apply_num,
					"refund" : 'payed',
					"pay_method":rsp.pay_method,
					"or_name":$('#or_name').val(),
					"or_hp":$('#or_hp').val(),
					"or_email":$('#or_email').val(),
					"memAddress":$('#memAddress').val(),
					"re_hp":$('#hp1').val()+"-"+$('#hp2').val()+"-"+$('#hp3').val(),
					"re_zip":$('#re_zip').val(),
					"re_addr1":$('#re_addr1').val(),
					"re_addr2":$('#re_addr2').val(),
					"re_name":$('#re_name').val()
			 		},
				 
				        dataType: 'text', //서버에서 보내줄 데이터 타입
			success:function(res){
				  if(res == 1){
							 console.log("결제성공");
							 location.href="/orderComplete";		           
				          }else{
				             console.log("Insert Fail!!!");
				          }
				
			},
			error:function(){
				  console.log(" ajax 통신 실패!!!");
			}
		});
		    } else {
		    	 var msg = '결제에 실패하였습니다.';
		         msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});
		
	});
	
});