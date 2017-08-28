<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>

<!-- 헤더부분 잘라냄  -->
<jsp:include page="../../inc/header.jsp"/>

<!-- visual 잘라냄  -->
<jsp:include page="../inc/visual.jsp"/>

	<div id="body" class="clearfix">
		<div class="content-container">

			<!-- aside 잘라냄 -->
			<jsp:include page="../inc/aside.jsp"/>

			<main id="main">
			<h2>공지사항</h2>

			<div>
				<h3 class="hidden">경로</h3>
				<ol>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ol>
			</div>

			<div>
				<h3>공지사항 검색 폼</h3>
				<form action="notice-list" method="get">
					<label>검색어</label> <input type="text" name="title" /> <input
						type="submit" />
				</form>
			</div>
			<table border="1">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
					<tr>
						<td>${ detail.id }</td>
						<td>${ detail.title }</a></td>
						<td>newlec</td>
						<td>${ detail.regDate }</td>
						<td>${ detail.hit }</td>
					</tr>
			</table>
			<span class="btn btn-default" href="">글쓰기</span> 
			<a class="btn btn-img btn-cancel" href="">취소</a> 
			</main>
		</div>
	</div>
	
<!-- footer 잘라냄 -->
<jsp:include page="../../inc/footer.jsp"/>
</body>
</html>