<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/MainCss.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/search.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/introduce.css" />
<script type="text/javascript" src="../js/MainJS.js"></script>
<title>searching</title>
</head>
<body>

<article class = "introduce">
		<div class = "intro">추천 페이지입니다.</div>
</article>

	<table>
        <thead>
            <tr>
                <th>이미지</th>
                <th>헬스용품 이름</th>
                 <th>가격</th>
                <th>상세설명</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach var="HealthGoodsSelect" items="${ HealthGoodsSelect }">
				<tr id="${HealthGoodsSelect.healthGoodsId}"
					title="${HealthGoodsSelect.healthGoodsName}의 상세 페이지 가기"
					onclick="location.href='healthgoods?cmd=healthGoodsDetail&healthGoodsId=${HealthGoodsSelect.healthGoodsId}'">
					<td><img alt="사진" src="${HealthGoodsSelect.healthGoodsImg } "></td>
					<td>${ HealthGoodsSelect.healthGoodsName }</td>
					<td>${ HealthGoodsSelect.healthGoodsPrice }</td>
					<td>${ HealthGoodsSelect.healthGoodsDetail}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<table>
		<thead>
			<tr>
				<th>이미지</th>
				<th>식품 이름</th>
				<th>가격</th>
				<th>상세설명</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach var="HealthFoodSelect" items="${ HealthFoodSelect }">
				<tr id="${HealthFoodSelect.hfid}"
					title="${HealthFoodSelect.hfname}의 상세 페이지 가기"
					onclick="location.href='healthfood?cmd=healthFoodDetail&hfid=${HealthFoodSelect.hfid}'">
					<td><img alt="사진" src="${HealthFoodSelect.hfimg } "></td>
					<td>${ HealthFoodSelect.hfname }</td>
					<td>${ HealthFoodSelect.hfprice }</td>
					<td>${ HealthFoodSelect.hfdetail}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

	<table>
		<thead>
			<tr>
				<th>이미지</th>
				<th>영양제 이름</th>
				<th>가격</th>
				<th>상세설명</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="NutrientsSelect" items="${ NutrientsSelect }">
				<tr id="${NutrientsSelect.nutrientsID}"
					title="${NutrientsSelect.nutrientsName}의 상세 페이지 가기"
					onclick="location.href='nutrients?cmd=nutrientsDetail${NutrientsSelect.nutrientsID}'">
					<td><img alt="사진" src="${NutrientsSelect.nutrientsIMG } "></td>
					<td>${ NutrientsSelect.nutrientsName }</td>
					<td>${ NutrientsSelect.nutrientsPrice }</td>
					<td>${ NutrientsSelect.nutrientsDetail}</td>
				</tr>
			</c:forEach>


		</tbody>
	</table>

</body>
</html>