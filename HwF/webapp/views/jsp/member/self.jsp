<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- 본인인증 -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<script>
	window.onload = function() {
		var IMP = window.IMP; // 생략 가능
		IMP.init("imp02185252"); // 예: imp00000000

		IMP.certification({
			merchant_uid : "123456789" + new Date().getTime(),
			m_redirect_url : "{리디렉션 될 URL}",
			popup : false
		// PC환경에서는 popup 파라메터가 무시되고 항상 true 로 적용됨
		}, function(rsp) { // callback
			if (rsp.success) {
				alert("success!");
				location.href = "${path}/HwF/Member?cmd=join"

			} else {
				alert("fail!");
				location.href = "${path}/HwF/Member?cmd=login"
			}
		});
	}
</script>

<title>Document</title>
</head>

<body>
</body>

</html>