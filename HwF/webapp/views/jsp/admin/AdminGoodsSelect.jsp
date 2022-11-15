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

<title>상품 관리</title>
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

	<!-- content-->
	<div class="content">
	
		<div class="contentTop">
			<br><br>
			<a href="javascript:location.href='../../../AdminMain.jsp'"><img class="contentTopImg" src="${path}/views/img/avataaars.svg" style="width: 100px; height: 100px" /></a>
			<br><br>
			<h1 class="contentTopText">관리자 [상품 관리] 페이지</h1>
			<br><br>
		</div>
		
		<div class="contentBottom">
			<br><br><br><br><br><br>
			<a href="javascript:location.href='../../../admin?cmd=AdminHealthGoodsSelect'"><img src="${path}/views/img/IconHealthGoods.png" alt="헬스용품 관리" style="width: 150px; height: 150px"><span>헬스용품 관리</span></a>
			<a href="javascript:location.href='../../../admin?cmd=AdminHealthFoodSelect'"><img src="${path}/views/img/IconHealthFood.png" alt="헬스식품 관리" style="width: 150px; height: 150px"><span>헬스식품 관리</span></a>
			<a href="javascript:location.href='../../../admin?cmd=AdminNutrientsSelect'"><img src="${path}/views/img/IconNutrients.png" alt="영양제 관리" style="width: 150px; height: 150px"><span>영양제 관리</span></a>
			<a href="javascript:location.href='../../../admin?cmd=GoodsSelect'"><img src="${path}/views/img/AllGoods.png" alt="전체상품 조회" style="width: 150px; height: 150px"><span>전체상품 조회</span></a>
			<br><br><br><br><br><br><br>
		</div>
		
	</div> <!-- end content -->

	<!-- footer -->
	<footer>
		<div id="footerFirstDiv">
			<div>COPYRIGHTⓒ by WEBDESIGN. ALL RIGHTS RESERVED</div>
		</div>
	</footer>

</body>
</html>