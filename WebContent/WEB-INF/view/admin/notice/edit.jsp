<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style.css" type="text/css" rel="stylesheet" />
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

			<form method="post"> <!-- 현재 페이지와 같은 url이면 action 생략 가능 -->
			<table class="table">
					<tr>
						<th>제목</th>
						<td colspan="3" class="text-left"><input name="title" value="${ notice.title }"/></td>	<!--3칸 차지해달라 -->
					</tr>
					<tr>
						<th>작성일</th>
						<td colspan="3">${ notice.regDate }</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${ notice.writerId }</td>
						<th>조회수</th>
						<td>${ notice.hit }</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4"><textarea name="content">${notice.content}</textarea></td>
					</tr>
			</table>
			
			<div>
				<intput type="hidden" name="id" value="${notice.id}"/>
				<input type="submit" value="저장" class="btn btn-default"/>
				<a href="detail?id=${ notice.id }" class="btn btn-default">취소</a>
			</div>
			</form>
			</main>
		</div>
	</div>
	
<!-- footer 잘라냄 -->
<jsp:include page="../../inc/footer.jsp"/>
</body>
</html>