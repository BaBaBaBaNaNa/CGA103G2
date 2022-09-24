<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="com.news.model.NewsService"%>
<%@page import="com.news.model.NewsVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%
	NewsService newsSvc = new NewsService();
    List<NewsVO> list = newsSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<!doctype html>
<html lang="zh-tw">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>義鄉人 - 義式餐酒館 - 消息 - 緯育 中壢Java班 CGA_103 第二組</title>

<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->

    <link rel="preconnect" href="https://fonts.googleapis.com">

    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap" rel="stylesheet">

    <link href="../../front-assets/bootstrap_css/bootstrap.min.css" rel="stylesheet">

    <link href="../../front-assets/bootstrap_css/bootstrap-icons.css" rel="stylesheet">

    <link href="../../front-assets/css/tooplate-crispy-kitchen.css" rel="stylesheet">

    <link href="../../front-assets/css/navbar.css" rel="stylesheet">
    
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body>
	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/UpSideBarNoRSVT.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
        <!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
        <header>

        </header>
        <!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->
        
        <!-- ----- ----- ----- 中間內容 start ----- ----- ----- -->
    <main>
    <!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
    <!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->
    <!-- ----- ----- ----- 中間內容 start ----- ----- ----- -->
        <section class="news section-padding bg-white">
            <div class="container">
                <div class="row">

<!--                     <h2 class="mb-lg-5 mb-4">最近更新資訊</h2> -->

<!--                     <div class="col-lg-6 col-md-6 col-12"> -->
<!--                         <div class="news-thumb mb-4"> -->
<!--                             <a href="../../front-end/news/news-detail.jsp"> -->
<!--                                 <img src="../../front-assets/images/news/pablo-merchan-montes-Orz90t6o0e4-unsplash.jpg" -->
<!--                                     class="img-fluid news-image" alt=""> -->
<!--                             </a> -->

<!--                             <div class="news-text-info news-text-info-large"> -->
<!--                                 <span class="category-tag bg-danger">Featured</span> -->

<!--                                 <h5 class="news-title mt-2"> -->
<!--                                     <a href="../../front-end/news/news-detail.jsp" class="news-title-link">甚麼是義大利麵</a> -->
<!--                                 </h5> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->

            </div>
      
        </section>

        
        <!-- ----- ----- ----- 中間內容 end ----- ----- ----- -->
        <%@ include file="page1.file" %> 
        <div class="container">
        <c:forEach var="NewsVO" items="${list}"  begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
        <c:if test="${NewsVO.newsControl == 0}" >
	        <div class="row">
	            <div class="col-md-6 img-cols">
	                <div	 class="img-col">
	                    <img class="img-fluid news-image" src="<%=request.getContextPath() %>/back-end/news/DBGifReader4?newsID=${NewsVO.newsID}">
	                </div>
	            </div>
	            <div class="col-md-6 content-cols">
	                <div class="content-col">
	                    <h3>${NewsVO.newsTitle}</h3>
	                    <p>${NewsVO.newsInformation}</p>
	                </div>
	            </div>
	        </div>
	        <hr>
        </c:if>
        </c:forEach>
    </div>
        
        <%@ include file="page2.file" %>
    </main>
    <!-- ----- ----- ----- 中間 end ----- ----- ----- -->

    <!-- ----- ----- ----- 底部 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/PageFooter.file"%>
    <!-- ----- ----- ----- 底部 end ----- ----- ----- -->

	<!-- ----- ----- ----- 跳出預先訂位頁面 start ----- ----- ----- -->

	<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="../../front-assets/js/jquery.min.js"></script>
	<script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
	<script src="../../front-assets/js/custom.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>