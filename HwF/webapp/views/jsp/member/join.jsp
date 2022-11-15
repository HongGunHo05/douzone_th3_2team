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

<%-- <script type="text/javascript" src="${path}/views/js/all.js"></script> --%>
<script type="text/javascript" src="${path}/views/js/Join.js"></script>

<link rel="stylesheet" type="text/css" href="${path}/views/css/header.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/allList.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/memberTemplate.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/memberTemplate2.css" />
<link rel="stylesheet" type="text/css" href="${path}/views/css/footer.css" />

<title>회원가입 페이지</title>
</head>

<body>
	<header>
		<div id="headerFirstDiv">
			<div>
				<a href="javascript:location.href='Main.jsp'"><img
					src="${path}/views/img/logo.png" /></a>
			</div>
			<div>BE NATURAL</div>
		</div>

		<nav style="display: flex">
			<form action="search?cmd=searching" method="post">
				<p>
					<input type="hidden" name="column"> <input type="text"
						name="keyvalue" value="" placeholder="Search">
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
						<h1>전체</h1> <img src="${path}/views/img/IconHealthGoods.png"
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectDumbbell'">
						<h1>운동용품</h1> <img
						src="${path}/views/img/IconHealthGoodsDumbbell.png"
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectBelt'">
						<h1>벨트</h1> <img src="${path}/views/img/IconHealthGoodsBelt.png"
						style="width: 150px; height: 150px" />
					</td>
					<td onclick="location.href='healthgoods?cmd=selectGloves'">
						<h1>장갑</h1> <img src="${path}/views/img/IconHealthGoodsGloves.png"
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
						<h1>전체</h1> <img src="${path}/views/img/IconHealthFoodAll.png"
						style="width: 200px; height: 200px" />
					</td>
					<td onclick="location.href='healthfood?cmd=selectFood'">
						<h1>음식</h1> <img src="${path}/views/img/IconHealthFoodSalad.png"
						style="width: 200px; height: 200px" />
					</td>
					<td onclick="location.href='healthfood?cmd=selectCafe'">
						<h1>음료</h1> <img src="${path}/views/img/IconHealthFoodCafe.png"
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
						<h1>모든 영양제</h1> <img id="allnutrientsImg"
						src="${path}/views/img/allList.png" />
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
					<td><a href="${path}/views/jsp/qna/FQA.jsp">
							<h1>FQA</h1> <img src="${path}/views/img/IconFQA.png" />
					</a></td>
					<td><a href="Member?cmd=membersearch">
							<h1>1:1 문의</h1> <img src="${path}/views/img/IconOneToOne.png" />
					</a></td>
				</tr>
			</table>
		</article>

	</div>
	<!-- end selectList -->
			
		<div id="con">		
			<form action="./Member?cmd=insertmember" method="post">
			
				<div class="container">
			        <div class="card card-container">
			        
			        	<h2 align="center">회원가입</h2><br>
			        	
			            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			            <p id="profile-name" class="profile-name-card"></p>
			            
			                <span id="reauth-email" class="reauth-email"></span>
			                <input type="text" id="userid" name="userid" class="form-control" placeholder="아이디" required autofocus> <br>
			                <input type="password" id="passwd" name="passwd" class="form-control"placeholder="비밀번호" required> <br>
			                <input type="text" id="name" name="name" class="form-control" placeholder="이름" required autofocus> <br>
			                <select name="sex" required class="form-control">
			                	<option>성별</option>
								<option value="2">여자</option>
								<option value="1">남자</option>
							</select> <br>
			                <input type="submit" value="회원가입" class="btn btn-lg btn-primary btn-block btn-signin" onclick="send();">
			            
			        </div><!-- end card-container -->
			        
			    </div> <!-- end container -->
		    
			</form>
			
		</div>
		<c:if test="${joincheck == false}">
        	 <p style="color: red;" align="center">회원가입 실패! 이미 있는 아이디입니다.</p>
        </c:if>

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