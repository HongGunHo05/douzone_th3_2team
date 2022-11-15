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

<title>고객 QnA</title>
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
							
				<table class="qnatable" width="1000" cellpadding="3" style="margin-left: auto; margin-right:auto;">
					
						<tr class="tableTitle">
							<td>QnA 번호 : ${ dto.qnaid }</td>
							<td>회원 ID : ${ dto.memberid }</td>
							<td>제목 :${ dto.qnatitle }</td>
							
						</tr>
	
						<tr class="tableTitle">
							<td>날짜 : ${ dto.qnadate }</td>
							<td>내용 : ${ dto.qnacontent }</td>
							<td>답변 : ${ dto.qnaanswer }</td>
						</tr>					
							
						<tr>
							<td colspan="4" align="right">
							
								<form action="./admin?cmd=AdminQnaUpdate" method="post">
									<table style="margin-left: auto; margin-right:auto;"> <br>
									<tr>
										<td>답변 : </td>
										<td>
											<input type="String" name="qnaanswer" value="${ dto.qnaanswer }"required> 
											<input type = "hidden" name ="qnaid" value = "${ dto.qnaid }"required>
										</td>
										<td>
											<input type="submit" value="등록">
										</td>
									</tr>
									<!-- <input type="submit" value="등록"> -->
									</table>
								</form>
							
							</td>
						</tr>
				
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