<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL 사용하기 위해 태그라이브러리 임포트 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/AdminCss.css">
<script type="text/javascript" defer src="${path}/views/js/AdminOrderSelectJS.js"></script>
<title>주문 조회</title>
</head>

<body>

	<!-- header -->
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='AdminMain.jsp'"><img src="${path}/views/img/logo.png" style="width: 150px; height: 110px"/></a>
			</div>
			<div>BE NATURAL</div>
		</div>
	</header>
	
	
	
	<!-- content -->
	<div class="content">
	
		<div class="contentTop">
			<br><br>
			<a href="javascript:location.href='AdminMain.jsp'"><img class="contentTopImg" src="${path}/views/img/avataaars.svg" style="width: 100px; height: 100px" /></a>
			<br><br>
			<h1 class="contentTopText">관리자 [주문 조회] 페이지</h1>
			<br><br>
		</div>
		
		<div class="contentBottom">	
			<br><br><br><br><br><br>
			
			<table border="1" width="900" style="margin-left: auto; margin-right:auto;">
				<tr class="tableTitle">
					<th>주문번호</th>
					<th>회원 ID</th>
					<th>구매가격</th>
					
					<th>헬스용품 ID</th>
					<th>헬스식품 ID</th>	
					<th>영양제 ID</th>	
					<th>복용기간</th>
													
					<th>수령방식</th>
					<th>수령시작일</th>
					<th>결제날짜</th>
				</tr>
		
				<c:forEach var="AdminOrderSelect" items="${ AdminOrderSelect }">
					<tr class="row">
						<td>${ AdminOrderSelect.purchaseId  }</td>
						<td>${ AdminOrderSelect.memberID }</td>
						<td>${ AdminOrderSelect.purchasePrice }원</td>
												
						<td>${ AdminOrderSelect.healthgoodsID }</td>
						<td>${ AdminOrderSelect.hfid }</td>		
						<td class="nutrientsID">${ AdminOrderSelect.nutrientsID }</td>	
						<td class="receiptPeriod">${ AdminOrderSelect.receiptPeriod }</td>		
																				
						<td class="purchaseReceipt">${ AdminOrderSelect.purchaseReceipt }</td>
						<td class="receiptStartDate">${ AdminOrderSelect.receiptStartDate }</td>
						<td>${ AdminOrderSelect.purchaseDate }</td>				
					</tr>
				</c:forEach>
			</table>
	
			<br><br><br><br><br><br>
		</div> <!-- end contentBottom -->
		
	</div> <!-- end content -->



	<!-- footer -->
	<footer>
		<div id="footerFirstDiv">
			<div>COPYRIGHTⓒ by WEBDESIGN. ALL RIGHTS RESERVED</div>
		</div>
	</footer>

</body>
</html>