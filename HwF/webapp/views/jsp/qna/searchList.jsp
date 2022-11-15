<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchList.jsp</title>
</head>
<body>
	<h3>단일검색하기</h3>
	<form action="../../../board?cmd=search" method="post">
		<select name="column">
			<option value="memberid">아이디</option>
		</select> <input type="text" name="keyvalue"> <input type="submit"	value="검색">
	</form>

	<h3>다중검색하기</h3>
	<!-- 검색: where writer='yuna' or title='title' or content='test' -->
	<form action="board?cmd=search2" method="post">
		<input type="checkbox" name="writer" value="writer" checked>
		   작성자 <input	type="checkbox" name="title" value="title">
			제목 <input type="checkbox" name="content" value="content">내용 <br> 
			검색어:<input	type="text" name="keyvalue"> <input type="submit" value="검색">
	</form>

	<hr>
	<table class="qnatable" width="600" cellpadding="3">
		<tr>
			<th width="50">번호</th>
			<th width="100">날짜</th>
			<th width="270">제목</th>
			<th width="200">답변</th>
			<th width="100">이름</th>

		</tr>
		<c:forEach var="list" items="${list}">

			<tr>
				<td>${ list.qnaid }</td>
				<td>${ list.qnadate }</td>
				<td>${ list.qnacontent }</td>
				<td>${ list.qnaanswer }</td>
				<td>${ list.memberid }</td>


			</tr>
		</c:forEach>
	</table>
	<a href="writeForm.jsp">글쓰기</a>

</body>
</html>