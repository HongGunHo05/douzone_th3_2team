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
<script type="text/javascript" defer src="${path}/views/js/AdminHealthGoodsJS.js"></script>
<title>헬스용품 수정</title>
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
			<a href="javascript:location.href='AdminMain.jsp'"><img class="contentTopImg" src="${path}/views/img/avataaars.svg" style="width: 100px; height: 100px" /></a>
			<br><br>
			<h1 class="contentTopText">관리자 [헬스용품 수정] 페이지</h1>
			<br><br>
		</div>
	
		<div class="contentBottom">
			<br>
			<h3>헬스용품 수정</h3>
			
			<form action="./admin?cmd=AdminHealthGoodsUpdate" method="post" id="frmHealthGoodsUpdate">
				<table style="margin-left: auto; margin-right:auto;">
					<tr><td>번호</td><td><input type="number" name="healthGoodsId" value="${ healthGoodsId }"> </td></tr>
					<tr><td>이름</td><td><input type="text" name="healthGoodsName" value="${ healthGoodsName }"> </td></tr>
					<tr><td>가격</td><td><input type="number" name="healthGoodsPrice" value="${ healthGoodsPrice }"> </td></tr>
					<tr><td>카테고리</td><td><input type="number" name="healthGoodsCategory" value="${ healthGoodsCategory }"> </td></tr>
					<tr><td>이미지</td><td><input type="text" name="healthGoodsImg" value="${ healthGoodsImg }"> </td></tr>
					<tr><td>상세설명</td><td><textArea rows="5" cols="50" name="healthGoodsDetail">${ healthGoodsDetail }</textArea></td></tr>
					<tr><td>추천 링크</td><td><input type="text" name="link" value="${ link }"> </td></tr>
				</table>
				<input type="submit" value="수정">
				<input type="button" value="삭제"  onclick='return alertDelete(this.form);'>
			</form>
			
			<br>
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