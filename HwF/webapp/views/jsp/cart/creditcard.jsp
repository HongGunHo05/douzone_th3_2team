<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<script>
window.onload = function requestPay() {
		var IMP = window.IMP; // 생략 가능
		IMP.init("imp02185252"); // 예: imp00000000
		// IMP.request_pay(param, callback) 결제창 호출
		IMP.request_pay({ // param
			pg : "html5_inicis",
			pay_method : "card",
			merchant_uid : "123456789"+ new Date().getTime(),
			name : "영양제, 식품, 운동기구",
			amount : ${ totalPrice }
		}, function(rsp) { // callback
			if (rsp.success) {
				alert("결제가 완료되었습니다.");
				location.href = "${path}/HwF/cart?cmd=success"
			} else {
				alert("결제에 실패하였습니다.");
				location.href = "${path}/HwF/cart?cmd=fail"
			}
		});
	}
</script>

<title>Document</title>
</head>

<body>

</body>

</html>