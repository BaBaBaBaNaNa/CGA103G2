<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.orders.model.*"%>
<%@ page import="java.sql.*"%>

<%
    OrdersService ordersSvc = new OrdersService();
    List<OrdersVO> list = ordersSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!doctype html>
<html lang="zh-tw">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

<title>義鄉人 - 義式餐酒館 - 訂單 - 緯育 中壢Java班 CGA_103 第二組</title>

<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap"
	rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap.min.css"
	rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap-icons.css"
	rel="stylesheet">

<link href="../../front-assets/css/tooplate-crispy-kitchen.css"
	rel="stylesheet">

<link href="../../front-assets/css/navbar.css" rel="stylesheet">

<style>
  table {
	width: 100%;
	background-color: #f0f0fa;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body>
	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/UpSideBarNoRSVT.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main>
		<!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
		<header> </header>
		<!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->

		<!-- ----- ----- ----- 中間內容 start ----- ----- ----- -->
		<section class="about section-padding bg-white">
			<div class="container">
				<div class="row">

					<div class="col-lg-6 col-12 mb-2">
							<h4 class="mb-3" ><a href="../../front-end/order/order.jsp">訂單查詢 </a>
                        <a class="mb-3 " href="../../front-end/order/order-wai-song.jsp">外送</a>
                        <a class="mb-3 ">外送明細</a>
                        </h4>
					</div>
	
<table>
	<tr>
		<th>訂單編號</th>
		<th>會員編號</th>
		<th>訂單總金額</th>
		<th>訂單狀態</th>
		<th>取餐地點</th>
		<th>成立訂單日</th>
	</tr>
	
	<c:forEach var="ordersVO" items="${list}">
	<c:if test="${ordersVO.ordersType == 1}">
		<tr>
			<td>${ordersVO.ordersID}</td>
			<td>${ordersVO.memID}</td>
			<td>${ordersVO.ordersAmount}</td>
			<td>
			   <c:if test="${ordersVO.ordersStatus == 0}">完成</c:if>
    	       <c:if test="${ordersVO.ordersStatus == 1}">未完成</c:if>
    	       <c:if test="${ordersVO.ordersStatus == 2}">退回</c:if>
    	    </td>
    	    <td>${ordersVO.ordersDestination}</td>
			<td>${ordersVO.ordersBuildDate}</td> 
		</tr>
		</c:if>
	</c:forEach>
</table>



				</div>
			</div>
		</section>
		<!-- ----- ----- ----- 中間內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

    <!-- ----- ----- ----- 頁面 底部 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/PageFooter.file"%>
    <!-- ----- ----- ----- 頁面 底部 end ----- ----- ----- -->

	<!-- ----- ----- ----- 跳出預先訂位頁面 start ----- ----- ----- -->
	
	<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="../../front-assets/js/jquery.min.js"></script>
	<script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
	<script src="../../front-assets/js/custom.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->

</body>

</html>