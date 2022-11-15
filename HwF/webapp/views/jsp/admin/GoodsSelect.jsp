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
<title>전체상품 조회</title>
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
			<h1 class="contentTopText">관리자 [전체상품 조회] 페이지</h1>
			<br><br>
		</div>
	
		<div class="contentBottom">
		
			<br><br>
		
			<details>
			<summary><h3>헬스용품</h3></summary>
			
			<table border="1" width="1700" style="margin-left: auto; margin-right:auto;">
				<tr class="tableTitle">
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>카테고리</th>
					<th>이미지</th>
					<th>상세설명</th>
					<th>추천 링크</th>
				</tr>
		
				<c:forEach var="HealthGoodsSelect" items="${ HealthGoodsSelect }">
					<tr class="row">
						<td>${ HealthGoodsSelect.healthGoodsId }</td>
						<td>${ HealthGoodsSelect.healthGoodsName }</td>
						<td>${ HealthGoodsSelect.healthGoodsPrice }원</td>
						<td>${ HealthGoodsSelect.healthGoodsCategory }</td>
						<td><img src="${ HealthGoodsSelect.healthGoodsImg }" style="width: 100px; height: 100px"/></td>
						<td>${ HealthGoodsSelect.healthGoodsDetail }</td>
						<td>${ HealthGoodsSelect.link }</td>
					</tr>
				</c:forEach>
			</table>
			
			<br>
			</details>
			
			
			
			<details>
			<summary><h3>헬스식품</h3></summary>
			
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
		
				<c:forEach var="HealthFoodSelect" items="${ HealthFoodSelect }">
					<tr class="row">
						<td>${ HealthFoodSelect.hfid }</td>
						<td>${ HealthFoodSelect.hfName }</td>
						<td>${ HealthFoodSelect.hfPrice }원</td>
						<td>${ HealthFoodSelect.hfCategory }</td>
						<td><img src="${ HealthFoodSelect.hfIMG }" style="width: 100px; height: 100px"/></td>
						<td>${ HealthFoodSelect.hfDetail }</td>
						<td>${ HealthFoodSelect.hfDoM }</td>
						<td>${ HealthFoodSelect.link }</td>
					</tr>
				</c:forEach>
			</table>
			
			<br>
			</details>
			
			
			
			<details>
			<summary><h3>영양제</h3></summary>
			
			<table border="1" width="1850" style="margin-left: auto; margin-right:auto;">
				<tr class="tableTitle">
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>카테고리</th>
					<th>이미지</th>
					<th>상세설명</th>
					<th>제조날짜</th>
					<th>1일 섭취 갯수</th>
					<th>1통 당 갯수</th>
					<th>현재 잔여 갯수</th>
					<th>추천 링크</th>
				</tr>
		
				<c:forEach var="NutrientsSelect" items="${ NutrientsSelect }">
					<tr class="row">
						<td>${ NutrientsSelect.nutrientsID }</td>
						<td>${ NutrientsSelect.nutrientsName }</td>
						<td>${ NutrientsSelect.nutrientsPrice }원</td>
						<td>${ NutrientsSelect.nutrientsCategory }</td>
						<td><img src="${ NutrientsSelect.nutrientsIMG }" style="width: 100px; height: 100px"/></td>
						<td>${ NutrientsSelect.nutrientsDetail }</td>
						<td>${ NutrientsSelect.nutrientsDOM }</td>
						<td>${ NutrientsSelect.dailyInTake }</td>
						<td>${ NutrientsSelect.numperbottle }</td>
						<td>${ NutrientsSelect.remainingNum }</td>
						<td>${ NutrientsSelect.link }</td>
					</tr>
				</c:forEach>
			</table>
			
			<br>
			</details>
			
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