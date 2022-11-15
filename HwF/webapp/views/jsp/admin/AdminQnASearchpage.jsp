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


<title>고객 QnA 상세보기</title>
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
			<h1 class="contentTopText">관리자 [QnA] 페이지</h1>
			<br><br>
		</div>
	
		<div class="contentBottom">		
			<div class="main">		
		
				<br><br><br>
						
				<table class="qnatable" border="1" width="1400" cellpadding="3" style="margin-left: auto; margin-right:auto;">
				
				<!-- <th align="right">
					<tr> -->
						<form action="admin?cmd=AdminQnaSearch" method="post">		
						
							<select class="selectcolumn" name="column" style="width:100px;height:30px;">
								<option value="qnadate">날짜</option>
								<option value="qnatitle">제목</option>
								<option value="qnacontent">내용</option>
								<option value="qnaanswer">답변</option>
								<option value="memberid">아이디</option>
							</select>
							
							<input type="text" name="keyvalue" value="" placeholder="Search" style="width:200px;height:25px;">
						
						</form>
					<!-- </tr>
				</th>  -->
				
				<br><br><br>
				
				<tr class="tableTitle">
					<th width="50">번호</th>
					<th width="270">날짜</th>
					<th width="270">제목</th>
					<th width="400">내용</th>
					<th width="400">답변</th>
					<th width="80">이름</th>
				</tr>
		
				<c:forEach var="AdminQnA" items="${AdminQnA}">
					<tr class="row">
						<td>${ AdminQnA.qnaid }</td>
						<td>${ AdminQnA.qnadate }</td>
						<td>${ AdminQnA.qnatitle }</td>
						<td>${ AdminQnA.qnacontent }</td>
						<td>${ AdminQnA.qnaanswer }</td>
						<td><a href="javascript:location.href='admin?cmd=AdminDetail&qnaid=${ AdminQnA.qnaid }' ">${ AdminQnA.memberid }</a></td>
					</tr>
				</c:forEach>
				
				</table>
				
				<br><br><br>
				
			</div> <!-- end main -->
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