<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문서 작성</title>
		<link href="<c:url value='/css/orderForm.css'/>" rel="stylesheet" type="text/css">
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
		<!-- 다음 우편번호 API 사용하기 -->
		<script src="<c:url value='http://dmaps.daum.net/map_js_init/postcode.v2.js'/>"></script>
		<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- 아래 제이쿼리는 1.0이상이면 원하는 버전을 사용하셔도 무방합니다. -->
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
		<script type="text/javascript" src="<c:url value='/js/iamport.js'/>"></script>
		<script type="text/javascript">
			function searchZipcode(){
				new daum.Postcode({
				    oncomplete: function(data) {
				        //팝업 창에서 검색 결과 항목을 클릭했을 때 실행할 코드 작성
				        var address1 = '';
				        //법정명과 건물명 : (~동, ~건물) (~동, ~아파트)
				        var dong_building = ''; 
				        
				        //도로명 주소인 경우
				        if(data.userSelectedType == 'R'){
				        	
				        	address1 = data.roadAddress + " (" + data.bname + ", " + data.buildingName + ")";
				        	
				        } else { //지번 주소인 경우
				        	address1 = data.jibunAddress;			        	
				        }				        
				        
				    	document.getElementById('re_zip').value = data.zonecode;
				    	document.getElementById('re_addr1').value = address1;
				    	//상세주소 입력하도록 출력된 값 삭제하고 포커스 주기
				    	var address2 =  document.getElementById('re_addr2');
				    	address2.value = '';
				    	address2.focus();
				    }
				}).open();
			}
		</script>
		
	</head>
	<body>
		<div id="wrap">

			<section>
				<br>
				<form method="post" action="<c:url value="/orderComplete"/>">
					<h3>주문자 정보</h3>
					<table  width="700">
						<tr><th>주문자</th>
								<td width="200">${memInfo.memName}
								<input type="hidden" name="or_name" id="or_name" value="${memInfo.memName}">
															</td>
						<th>연락처</th>
								<td>${memInfo.memHp }
								<input type="hidden" name="or_hp" id="or_hp" value="${memInfo.memHp }">
								</td>
						<th>이메일</th>
						<td>${memInfo.memEmail }
						<input type="hidden" name="or_email" id="or_email" value="${memInfo.memEmail }"> 
						<input type="hidden" id="memAddress" name="memAddress" value="${memInfo.memAddress }">
						</td>
		
						</tr>
					</table>
					<br>
					<h3>수령인 정보</h3>
					<table width="700">
						<tr><th>받는분</th><td width="200"><input type="text" name="re_name" ></td>
						<th>연락처</th>
								<td><input type="text" name="hp1" size="3"> - 
										<input type="text" name="hp2" size="4" > - 
										<input type="text" name="hp3" size="4" ></td></tr>
						<tr><th>배송지 주소</th>
								<td colspan="3">
										<input type="text" id="re_zip" name="re_zip"   size="5"  value="" readonly > 
										<input type="button" id="searchZip" name="searchZip" value="우편번호찾기"  
													onclick="searchZipcode()"><br>
										<input type="text"  id="re_addr1"  name="re_addr1" size="70"  
													  readonly><br> 
										<input type="text" id="re_addr2"  name="re_addr2" size="70" 
													  placeholder="상세 주소 입력">
								</td></tr>		
						<tr><td><input type="submit"></td></tr>
					</table><br>				
					<h3>주문 상품 목록</h3>
					<table id="cartTable"  width="700">
						<tr><th>상품번호</th><th>상품명</th><th>가격</th>
							   <th>주문수량 </th><th>구매예정금액</th></tr>				 
			 			<c:forEach items="${cart }" var="ca">
			 			
							 <tr>  
							 	  <td>${ca.product_cd}</td>     					     				      	
							      <td>
							      ${ca.product_nm }
							      <c:set var="name" value="${ca.product_nm}" />
							      <c:set var="allPrdName" value="${allPrdName } ${name }"/>
							      </td>	      
							      <td align="right"><fmt:formatNumber value="${ca.sale_price}" pattern="#,###" /> 원 </td> 						      			
							      <td>		
							      			${ca.cartQty }
											
							      			
								  </td>
								  
								  <td  align="right"> <span class="amount">
								  				<c:set var="amount" value="${ca.sale_price * ca.cartQty+ca.trans_price }" />
								  				<c:set var="sum" value="${sum + amount }" />
												<fmt:formatNumber value="${amount}" pattern="#,###" />
												<input type="hidden" name="amount" id="amount" value="${amount}">
										    </span> 원 </td>	
								  </tr>			
								  </c:forEach>
								  
						<tr><td colspan="6" >총구매예정금액 </td>
								<td align="center"><fmt:formatNumber value="${sum}" pattern="#,###" /> 원<br></td></tr>			
					</table><br>
					
					<h3>결제 정보</h3>
					<table width="700">
						<tr><th>결제방법</th>
								<td ><input type="radio" name="ordPay" value="card" checked>신용카드
                                   <input type="radio" name="ordPay" value="bank">실시간계좌이체
                                   <input type="hidden" id="allPrdName" name="allPrdName" value="${allPrdName }">
                                   </td>
                                  
                                   </tr>
					</table><br>
					<div id="btnwrap">
					<input type="submit" value="결제완료" id="submit">
					<input type="button" id="order" name="order" value="주문하기">
					</div>
					</form>
				</section>
		     
	      </div>		
	</body>
</html>





