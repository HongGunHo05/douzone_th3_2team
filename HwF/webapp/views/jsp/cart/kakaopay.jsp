<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script>
	
window.onload = function requestPay() {
	IMP.init('imp02185252'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
	IMP.request_pay({
		pg: "kakaopay.TC0ONETIME",
		pay_method: "card",
		merchant_uid: '123123' + new Date().getTime(),
		name: '영양제, 식품, 운동기구',
		amount: ${ totalPrice }
		}, function(rsp) {
		console.log(rsp);
		if (rsp.success) {
			var msg = '결제가 완료되었습니다.';
			alert(msg);
			location.href = "${path}/cart?cmd=success"
		} else {
			var msg = '결제에 실패하였습니다.';
			alert(msg);
			location.href = "${path}/cart?cmd=fail"
		}
	});
	}
</script>

</head>
<body>
</body>
</html>
