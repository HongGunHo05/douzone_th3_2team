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
<title>헬스식품 관리</title>
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
			<h1 class="contentTopText">관리자 [헬스식품 관리] 페이지</h1>
			<br><br>
		</div>
	
		<div class="contentBottom">
		
			<br><br>
			
			<h3>[헬스식품 관리]</h3> <br>
			
			<table border="1" width="1500" style="margin-left: auto; margin-right:auto;">
				<tr class="tableTitle">
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>카테고리</th>
					<th>이미지</th>
					<th>상세설명</th>
					<th>제조날짜</th>
					<th>추천 링크</th>
				</tr>
		
				<c:forEach var="AdminHealthFoodSelect" items="${ AdminHealthFoodSelect }">
					<tr class="row" id="${AdminHealthFoodSelect.hfid}" title="${AdminHealthFoodSelect.hfName} 수정"
						onclick="location.href='admin?cmd=AdminHealthFoodDetail&hfid=${AdminHealthFoodSelect.hfid}'" >
						<td>${ AdminHealthFoodSelect.hfid }</td>
						<td>${ AdminHealthFoodSelect.hfName }</td>
						<td>${ AdminHealthFoodSelect.hfPrice }원</td>
						<td>${ AdminHealthFoodSelect.hfCategory }</td>
						<td><img src="${ AdminHealthFoodSelect.hfIMG }" style="width: 100px; height: 100px"/></td>
						<td>${ AdminHealthFoodSelect.hfDetail }</td>
						<td>${ AdminHealthFoodSelect.hfDoM }</td>
						<td>${ AdminHealthFoodSelect.link }</td>
					</tr>
				</c:forEach>
			</table>
			
			<br><br>
		
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