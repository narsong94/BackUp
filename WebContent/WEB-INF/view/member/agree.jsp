<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
   <!-- 헤더부분 -->
   <jsp:include page="../inc/header.jsp"/> <!-- 개쩐다 이게바로 집중화구나 -->
   
   <!-- visual 부분 -->
   <jsp:include page="inc/visual.jsp" />
   
   <div id = "body" class="clearfix">
      <div class="content-container clearfix">
   
   <!-- 어사이드 -->
   <jsp:include page="inc/aside.jsp"/>
   
         <main id="main">
            <h2>가입동의</h2>

         <div>
            <h3>경로</h3>
            <ol>
               <li>home</li>
               <li>회원정보</li>
               <li>가입동의</li>
            </ol>
         </div>
         <c:if test="${ param.error==1}">
         <div style="color:red;">
            모든 내용에 동의를 하셔야 합니다
         </div>
         </c:if>
         
         <form method="post">
         <div>
            <h3>개인정보 활용 동의</h3>
            <div style="width: 100%; height :100px; overflow: scroll;">
               가입된 정보는 어쩌구 저쩌구... <br/>
               가입된 정보는 어쩌구 저쩌구... <br/>
               가입된 정보는 어쩌구 저쩌구... <br/>
               가입된 정보는 어쩌구 저쩌구... <br/>
               가입된 정보는 어쩌구 저쩌구... <br/>
            </div>
            <div>
               <input type="checkbox"  name="agree"  value="ok"/>
            </div>
         </div>
         <div>
            <input type="submit" value="가입동의" />
         </div>
         </form>
         
         </main>
      </div>
     </div>
      
      <!-- 푸터부분 -->
      <jsp:include page="../inc/footer.jsp"/>

</body>
</html>