<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" type="text/css" href="${path}/views/css/header.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/MainCss.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/allList.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/detailnutrients.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/footer.css" />

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${path}/views/js/healthGoodsJS.js"></script>
<script type="text/javascript" src="${path}/views/js/all.js"></script>

<title>헬스용품 상세 페이지</title>
</head>

<body>

	<!-- header -->
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='Main.jsp'"><img src="${path}/views/img/logo.png" /></a>
			</div>
			<div>BE NATURAL</div>
			<div id="loginimg">
				<a onclick="location.href='cart?cmd=gobasket'"><img src="${path}/views/img/basketIcon.png" title="장바구니" /></a>
				 <a onclick="location.href='Member?cmd=login'"><img src="${path}/views/img/LoginIMG.png" title="로그인 / 마이페이지" /></a>
			</div>
		</div>

		<nav>
			<form action="search?cmd=searching" method="post">
				<p>
					<input type="hidden" name="column"> 
					<input type="text" name="keyvalue" value="" placeholder="Search">
				</p>
			</form>

			<table>
				<tr>
					<td id="1" onclick="change(this.id)">Home</td>
					<td id="2" onclick="change(this.id)">HealthGoods</td>
					<td id="3" onclick="change(this.id)">HealthFood</td>
					<td id="4" onclick="change(this.id)">HealthNutrients</td>
					<td id="5" onclick="location.href='Member?cmd=surveylist'">Survey</td>
					<td id="6" onclick="location.href='Member?cmd=inbodylist'">InbodyTest</td>
					<td id="7" onclick="change(this.id)">Community</td>
				</tr>
			</table>
		</nav>
	</header>

	<div id="selectList">

		<!--이달의 메뉴 추천 & 헬스장 운동법 소개-->
		<article class="MonthMenu" id="s1">
			<img src="${path}/views/img/getMuscle.jpg" />
			<div>
				<table>
					<th colspan="2">이달의 HOT & SALE 메뉴</th>
					<tr>
						<td onclick="location.href='nutrients?cmd=nutrientsDetail30001'">
							<img
							src="https://img.danawa.com/prod_img/500000/426/012/img/2012426_1.jpg?shrink=330:330&_v=20210817132717"
							width="200" , height="200" />
							<h4>고려은단 비타민C 1000 600정</h4>
						</td>
						<td onclick="location.href='nutrients?cmd=nutrientsDetail30002'">
							<img
							src="https://img.danawa.com/prod_img/500000/444/243/img/6243444_1.jpg?shrink=330:330&_v=20200626121658"
							width="200" , height="200" />
							<h4>코스트코 커클랜드 슈퍼 B-컴플렉스 500정</h4>
						</td>
					</tr>
					<tr>
						<td onclick="location.href='nutrients?cmd=nutrientsDetail30003'">
							<img
							src="https://img.danawa.com/prod_img/500000/178/261/img/5261178_1.jpg?shrink=330:330&_v=20200618170729"
							width="200" , height="200" />
							<h4>BSN 신타6 초콜렛 밀크쉐이크 2.27kg</h4>
						</td>
						<td onclick="location.href='nutrients?cmd=nutrientsDetail30007'">
							<img
							src="https://img.danawa.com/prod_img/500000/566/871/img/17871566_2.jpg?shrink=500:500&_v=20220920155658"
							width="200" , height="200" />
							<h4>비상썬라이즈 경성건강원 수국잎 열수 추출물 분말 110g</h4>
						</td>
					</tr>
				</table>

				<table id="healthintro">
					<th colspan="2">헬스장 소개</th>
					<tr>
						<td onclick="location.href='./views/jsp/etc/introduce.jsp'">
							<img
							src="https://contents.hiltonhotels.jp/ko/h/selhi/hotel_service_20191209111241_main_sp.jpg"
							width="640" , height="200">
						</td>
					</tr>

					<th>운동법 소개</th>
					<tr>
						<td><iframe width="640" height="300"
								src="https://www.youtube.com/embed/TY0HF4SMzhU?autoplay=1&mute=1"
								title="YouTube video player" frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen>
						</iframe></td>
					</tr>
				</table>
			</div>
		</article>


		<!--헬스용품 카테고리-->
		<article class="category" id="s2">
			<table>
				<th colspan="4">헬스용품 카테고리</th>
				<tr>
					<td onclick="location.href='healthgoods?cmd=healthGoodsList'">
						<h1>전체</h1> 
						<img src="${path}/views/img/IconHealthGoods.png" 
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectDumbbell'">
						<h1>운동용품</h1> 
						<img src="${path}/views/img/IconHealthGoodsDumbbell.png"
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectBelt'">
						<h1>벨트</h1> 
						<img src="${path}/views/img/IconHealthGoodsBelt.png"
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectGloves'">
						<h1>장갑</h1> 
						<img src="${path}/views/img/IconHealthGoodsGloves.png"
						style="width: 150px; height: 150px" />
					</td>
				</tr>
			</table>
		</article>


		<!--헬스식품 카테고리-->
		<article class="category" id="s3">
			<table>
				<th colspan="4">헬스식품 카테고리</th>
				<tr>
					<td onclick="location.href='healthfood?cmd=healthFoodList'">
						<h1>전체</h1> 
						<img src="${path}/views/img/IconHealthFoodAll.png"
						style="width: 200px; height: 200px" />
					</td>
					<td onclick="location.href='healthfood?cmd=selectFood'">
						<h1>음식</h1> 
						<img src="${path}/views/img/IconHealthFoodSalad.png"
						style="width: 200px; height: 200px" />
					</td>
					<td onclick="location.href='healthfood?cmd=selectCafe'">
						<h1>음료</h1> 
						<img src="${path}/views/img/IconHealthFoodCafe.png"
						style="width: 200px; height: 200px" />
					</td>
				</tr>
			</table>
		</article>


		<!--영양제 카테고리-->
		<article class="category" id="s4">
			<table>
				<th colspan="4">영양제 카테고리</th>
				<tr>
					<td onclick="location.href='nutrients?cmd=list'">
						<h1>모든 영양제</h1> 
						<img id="allnutrientsImg"
						src="${path}/views/img/allList.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=vitaminList'">
						<h1>비타민</h1> 
						<img src="${path}/views/img/vitamin.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=proteinList'">
						<h1>헬스 보충제</h1> 
						<img src="${path}/views/img/protein.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=dietList'">
						<h1>다이어트 보충제</h1> 
						<img src="${path}/views/img/diet.png" />
					</td>
				</tr>
			</table>
		</article>


		<!--커뮤니티 카테고리-->
		<article class="category" id="s7">
			<table>
				<th colspan="2">문의</th>
				<tr>
					<td><a href="${path}/views/jsp/qna/FQA.jsp">
							<h1>FQA</h1> 
							<img src="${path}/views/img/IconFQA.png" />
					</a></td>
					<td><a href="Member?cmd=membersearch">
							<h1>1:1 문의</h1> 
							<img src="${path}/views/img/IconOneToOne.png" />
					</a></td>
				</tr>
			</table>
		</article>

	</div>
	<!-- end selectList -->



	<!-- 선택한 상품 보여주기 -->

	<form name="buybottle" action="${path}/cart?cmd=healthGoodsInsertCart"
		method="post">

		<div id="nutrientsListDiv">

			<c:forEach var="healthGoodsList" items="${ healthGoodsList }">

				<div>
					<img name="healthGoodsImg" alt="사진"
						src="${ healthGoodsList.healthGoodsImg }">
				</div>

				<div id="nutrdiscription">

					<div>
						<input type="text" id="hiddenid" name="healthGoodsId" value="${ healthGoodsList.healthGoodsId }"/>
						<%-- <input type="text" id="healthGoodsId" name="healthGoodsId" value="${ healthGoodsList.healthGoodsId }" /> --%>
						<h3>${ healthGoodsList.healthGoodsName }</h3>
					</div>
					<br />

					<div>${ healthGoodsList.healthGoodsDetail }</div>

					<div>
						<br />
						<div>
							가격 : <a id="result">${ healthGoodsList.healthGoodsPrice }</a>원
						</div>
					</div>

				</div> <!-- end nutrdiscription -->

			</c:forEach>



			<div id="selectbuymethod">

				<div id="buy1">

					<!-- <input type="text" id="hiddenid" name="hiddenid" value="0" /> <!-- 제품 번호 -->
					<h1>총 가격</h1>

					<input id="onetotal" name="onetotal" value="0" readonly />
					<p />
					<a>수량 결정</a>
					<p />
					<input id="countone" name="countone" value="0" readonly />

					<div id="calculationdiv">
						<input type='button' onclick="countnum('plus')"
							class="calculation" value='+' /> <input type='button'
							onclick="countnum('minus')" class="calculation" value='-' />
					</div>

					<div>
						<input type="submit" id="bottlebasket" class="calculation"
							value="장바구니">
					</div>

				</div> <!-- end buy1 -->

			</div> <!-- end selectbuymethod -->

		</div> <!-- end nutrientsListDiv -->

	</form>
	
	<br><br><br><br><br>



	<!-- footer -->
	<footer>
		<div id="footer">
			<div class="xans-element- xans-layout xans-layout-footer footer_start ">

				<div class="cs">
					<div class="cs-down">
					
						<div class="cs_left">
							<ul>
								<li class="title">C/S<span></span>
								</li>
							</ul>
							<ul class="cs_info">
								<li class="tel">02-548-3339</li>
								<li class="tel_time">AM 9:00 - PM 6:00 
								<span>(주말 및 공휴일 휴무)</span>
								</li>
							</ul>
						</div> <!-- end cs_left -->

						<div class="company_pg">
							<ul>
								<li class="title">COMPANY</li>
							</ul>
							<div class="inner2">
								<li class="info">
									<span>상호 <span>(주)레스트롱</span></span> <br>
									<span>대표<span class="han">000</span></span> <br>
									<span>사업자등록번호<span>123-98-05123</span></span> <br> 
									<span>통신판매업 신고<span>2022-서울종로-0500</span></span> <br>
									<span>전화 <span>02-517-1470</span></span> <br>
									<span>주소 <span> 서울 종로구 창경궁로 254 7층</span></span> <br>
								</li>
							</div>
						</div> <!-- end company_pg -->

						<div class="cs_right">
							<ul>
								<li class="title">BANK</li>
							</ul>
							<li class="info">
								<span class="han">국민은행</span> 
								<span class="num">98760212341562</span><br> 
								<span class="name">예금주 <strong> (주)000</strong></span>
							</li>
						</div> <!-- end cs_right -->
						
					</div> <!-- end cs-down -->

					<div class="company_i">
						<li class="utilMenu">
							<a href='./views/jsp/etc/policy.jsp'">이용약관</onclick>
						</li>
						<p></p>
					</div> <!-- end company_i -->
		
				</div> <!-- end cs -->
			</div>
		</div> <!-- end footer -->
	</footer>
	
</body>
</html>