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
<link rel="stylesheet" type="text/css" href="${path}/views/css/detailnutrients.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/footer.css" />

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="${path}/views/js/nutr.js"></script>


<title>영양제 상세 페이지</title>

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
	
		<article class="MonthMenu" id="s1">
			<img src="${path}/views/img/getMuscle.jpg" />
			<div>
				<table>
					<th colspan="2">이달의 HOT & SALE 메뉴</th>
					<tr>
						<td><img src="${path}/views/img/logo.png" /></td>
						<td><img src="${path}/views/img/logo.png" /></td>
					</tr>
					<tr>
						<td><img src="${path}/views/img/logo.png " /></td>
						<td><img src="${path}/views/img/logo.png" /></td>
					</tr>
				</table>

				<table id="healthintro">
					<th>헬스장 및 운동법 소개</th>
					<tr>
						<td><img src="${path}/views/img/logo.png" /></td>
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
						<h1>전체</h1> <img src="${path}/views/img/IconHealthGoods.png" style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectDumbbell'">
						<h1>운동용품</h1> <img src="${path}/views/img/IconHealthGoodsDumbbell.png" style="width: 150px; height: 150px"/>
					</td>
					<td onclick="location.href='healthgoods?cmd=selectBelt'">
						<h1>벨트</h1> <img src="${path}/views/img/IconHealthGoodsBelt.png" style="width: 150px; height: 150px"/>
					</td>
					<td onclick="location.href='healthgoods?cmd=selectGloves'">
						<h1>장갑</h1> <img src="${path}/views/img/IconHealthGoodsGloves.png" style="width: 150px; height: 150px"/>
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
						<h1>전체</h1> <img src="${path}/views/img/IconHealthFoodAll.png" style="width: 200px; height: 200px"/>
					</td>
					<td onclick="location.href='healthfood?cmd=selectFood'">
						<h1>음식</h1> <img src="${path}/views/img/IconHealthFoodSalad.png" style="width: 200px; height: 200px"/>
					</td>
					<td onclick="location.href='healthfood?cmd=selectCafe'">
						<h1>음료</h1> <img src="${path}/views/img/IconHealthFoodCafe.png" style="width: 200px; height: 200px"/>
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
						<h1>모든 영양제</h1> <img id="allnutrientsImg" src="${path}/views/img/allList.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=vitaminList'">
						<h1>비타민</h1> <img src="${path}/views/img/vitamin.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=proteinList'">
						<h1>헬스 보충제</h1> <img src="${path}/views/img/protein.png" />
					</td>
					<td onclick="location.href='nutrients?cmd=dietList'">
						<h1>다이어트 보충제</h1> <img src="${path}/views/img/diet.png" />
					</td>
				</tr>
			</table>
		</article>
		
		
		<!--커뮤니티 카테고리-->
		<article class="category" id="s7">
			<table>
				<th colspan="2">문의</th>
				<tr>
					<td>
						<a href="${path}/views/jsp/qna/FQA.jsp">
						<h1>FQA</h1> <img src="${path}/views/img/IconFQA.png" />
						</a>
					</td>
					<td>
						<a href="Member?cmd=membersearch">
						<h1>1:1 문의</h1> <img src="${path}/views/img/IconOneToOne.png" />
						</a>
					</td>
				</tr>
			</table>
		</article>
		
	</div> <!-- end selectList -->
	
	

	<div id="nutrientsListDiv">

		<!-- 선택한 상품 보여주기 -->
		<c:forEach var="list" items="${ list }">

			<div>
				<img id="nutrientsIMG" alt="사진" src="${list.nutrientsIMG }">
			</div>

			<div id="nutrdiscription">

				<div>
					<a id="nutrientsID">${list.nutrientsID }</a>
					<h3>${list.nutrientsName }</h3>
				</div>
				<br />

				<div>${list.nutrientsDetail }</div>


				<div>
					<br />

					<div>
						1병 당 가격 : <a id="result">${list.nutrientsPrice }</a>원
					</div>
					<br />

					<div>
						1병 기준 섭취가능 수량 : <a id="numperbottle">${list.numperbottle }</a>회
					</div>
					<br />

					<div onload="takeoneprice()">
						1회 분량 가격 : <a id="takeone">0</a>원
					</div>
				</div>


			</div>
		</c:forEach>



		<div id="selectbuymethod">
			<table>
				<tr>
					<td id="1" onclick="selectbuymethod(this.id)" title="일 수 수량 선택">낱개 구매</td>
					<td id="2" onclick="selectbuymethod(this.id)" title="낱개 수량 선택">세트 구매</td>
				</tr>
			</table>

			<!-- 일 수 구매 -->

			<div id="buy1">
				<form name="buyday" action="${path}/cart?cmd=insertCart"
					method="post">
					<input type="text" id="hiddenid" name="hiddenid" value="0" />
					<h1>낱개 총 가격</h1>

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

					<div id="calender1">
						<input type='radio' name='getnu' value='onetime' checked="checked" />한번에
						받기 <input type='radio' name='getnu' value='splittime' />나눠서 받기
						<p />
						<input type='date' id="selectdate" name="selectgetday"
							value="2022-11-06" />

						<div>
							끝나는 날 : <input id="finishnutr" name="finishnutr" value="0"
								readonly />
						</div>
						<p />
						<p />
						<input type="submit" id="bottlebasket" class="calculation"
							value="장바구니"> <input type='button'
							onclick="selectnudate()" class="calculation" value='날짜 선택' />

					</div>

				</form>
			</div>


			<!-- 낱개 구매 -->

			<div id="buy2">
				<form name="buybottle" action="${path}/cart?cmd=insertbottleCart"
					method="post">
					<input type="text" id="hiddenid" name="hiddenid" value="0" />
					<h1>세트 총 가격</h1>

					<input id="total" name="total" value="0" readonly />
					<p />
					<a>수량 결정</a>
					<p />
					<input id="countnum" name="countnum" value="0" readonly />

					<div id="calculationdiv">

						<input type='button' onclick="count('plus')" class="calculation"
							value='+' /> <input type='button' onclick="count('minus')"
							class="calculation" value='-' />
					</div>

					<div id="calender2">
						<input type='radio' name='getnuall' value='onetime'
							checked="checked" />한번에 받기 <input type='radio' name='getnuall'
							value='splittime' />나눠서 받기
						<p />
						<input type='date' id="selectdate2" name="selectgetday2"
							value="2022-11-06" />

						<div>
							끝나는 날 : <input id="finishnutr2" name="finishnutr2" value="0"
								readonly />
						</div>
						<p />
						<p />

						<input type="submit" id="bottlebasket" class="calculation" value="장바구니"> 
						<input type='button' onclick="selectnudate2()" class="calculation" value='날짜 선택' />



					</div>

				</form>

			</div>

		</div>

	</div>

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