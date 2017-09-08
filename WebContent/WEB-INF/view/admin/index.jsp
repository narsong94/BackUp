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
<jsp:include page="../inc/header.jsp"/>

<!-- visual 잘라냄  -->
<jsp:include page="inc/visual.jsp"/>

	<div id="body" class="clearfix">
		<div class="content-container">

			<!-- aside 잘라냄 -->
			<jsp:include page="inc/aside.jsp"/>

			<main id="main">
			<h2>관리자 Index Page</h2>

			</main>
		</div>
	</div>
	
<!-- footer 잘라냄 -->
<jsp:include page="../inc/footer.jsp"/>
</body>
</html>