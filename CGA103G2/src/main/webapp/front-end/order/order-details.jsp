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
	<%@ include file="../../front-end/tool/UpSideBar.file"%>
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
							<h4><a href="../../front-end/order/order.jsp">訂單查詢</a>
							<a  href="../../front-end/order/order-nel-yong.jsp" class="mb-3 ">-內用</a>
							<a class="mb-3 ">-內用明細</a>
							</h4>
					</div>
	
<table>
	<tr>
		<th>訂單編號</th>
		<th>會員編號</th>
		<th>桌子編號</th>
		<th>訂單總金額</th>
		<th>訂單狀態</th>
		<th>成立訂單日</th>
	</tr>
	
	<c:forEach var="ordersVO" items="${list}">
	<c:if test="${ordersVO.ordersType == 2}">
		<tr>
			<td>${ordersVO.ordersID}</td>
			<td>${ordersVO.memID}</td>
			<td>${ordersVO.seatID}</td>
			<td>${ordersVO.ordersAmount}</td>
			<td>
			   <c:if test="${ordersVO.ordersStatus == 0}">完成</c:if>
    	       <c:if test="${ordersVO.ordersStatus == 1}">未完成</c:if>
    	       <c:if test="${ordersVO.ordersStatus == 2}">退回</c:if>
    	    </td>
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

	<!-- ----- ----- ----- 底部 start ----- ----- ----- -->
	<footer class="site-footer section-padding">

		<div class="container">

			<div class="row">

				<div class="col-12">
					<h4 class="text-white mb-4 me-5">義式餐酒館</h4>
				</div>

				<div class="col-lg-4 col-md-7 col-xs-12 tooplate-mt30">
					<h6 class="text-white mb-lg-4 mb-3">Location</h6>

					<p>緯育 中壢Java班 CGA_103 第二組</p>

					<a href="https://goo.gl/maps/wcmDpTGaAHn3eWPd7"
						class="custom-btn btn btn-dark mt-2">Directions</a>
				</div>

				<div class="col-lg-4 col-md-5 col-xs-12 tooplate-mt30">
					<h6 class="text-white mb-lg-4 mb-3">Opening Hours</h6>

					<p class="mb-2">Monday - Friday</p>

					<p>17:00 PM - 03:00 AM</p>

					<p>
						Tel: <a href="tel: 03-425-1108" class="tel-link">03-425-1108</a>
					</p>
				</div>

				<div class="col-lg-4 col-md-6 col-xs-12 tooplate-mt30">
					<h6 class="text-white mb-lg-4 mb-3">社群</h6>

					<ul class="social-icon">
						<li><a href="#" class="social-icon-link bi-facebook"></a></li>

						<li><a href="#" class="social-icon-link bi-instagram"></a></li>

						<li><a
							href="https://twitter.com/search?q=tooplate.com&src=typed_query&f=live"
							target="_blank" class="social-icon-link bi-twitter"></a></li>

						<li><a href="#" class="social-icon-link bi-youtube"></a></li>
					</ul>

					<p class="copyright-text tooplate-mt60">
						Copyright © 2022 中壢Java班 CGA_103 緯育 第二組 Co., Ltd. <br>Design:
						<a rel="nofollow" href="" target="_blank">2022 中壢Java班 CGA_103
							緯育 第二組</a>
					</p>

				</div>

			</div>
			<!-- row ending -->

		</div>
		<!-- container ending -->

	</footer>
	<!-- ----- ----- ----- 底部 end ----- ----- ----- -->

	<!-- ----- ----- ----- 跳出預先訂位頁面 start ----- ----- ----- -->
	<div class="modal fade" id="BookingModal" tabindex="-1"
		aria-labelledby="BookingModal" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="mb-0">預先訂位</h3>

					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body d-flex flex-column justify-content-center">
					<div class="booking">

						<form class="booking-form row" role="form" action="#"
							method="post">
							<div class="col-lg-6 col-12">
								<label for="name" class="form-label">您的名字</label> <input
									type="text" name="name" id="name" class="form-control"
									placeholder="Your Name" required>
							</div>

							<div class="col-lg-6 col-12">
								<label for="email" class="form-label">Email</label> <input
									type="email" name="email" id="email" pattern="[^ @]*@[^ @]*"
									class="form-control" placeholder="your@email.com" required>
							</div>

							<div class="col-lg-6 col-12">
								<label for="phone" class="form-label">電話號碼</label> <input
									type="telephone" name="phone" id="phone"
									pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" class="form-control"
									placeholder="123-456-7890">
							</div>

							<div class="col-lg-6 col-12">
								<label for="people" class="form-label">訂位人數</label> <input
									type="text" name="people" id="people" class="form-control"
									placeholder="12 persons">
							</div>

							<div class="col-lg-6 col-12">
								<label for="date" class="form-label">日期</label> <input
									type="date" name="date" id="date" value="" class="form-control">
							</div>

							<div class="col-lg-6 col-12">
								<label for="time" class="form-label">時間</label> <select
									class="form-select form-control" name="time" id="time">
									<option value="5" selected>5:00 PM</option>
									<option value="6">18:00 PM</option>
									<option value="7">19:00 PM</option>
									<option value="8">20:00 PM</option>
									<option value="10">21:00 PM</option>
									<option value="11">22:00 PM</option>
									<option value="12">23:00 PM</option>
									<option value="13">00:00 AM</option>
								</select>
							</div>

							<div class="col-12">
								<label for="message" class="form-label">其他需求:</label>

								<textarea class="form-control" rows="4" id="message"
									name="message" placeholder=""></textarea>
							</div>

							<div class="col-lg-4 col-12 ms-auto">
								<button type="submit" class="form-control">送出</button>
							</div>
						</form>
					</div>
				</div>

				<div class="modal-footer"></div>

			</div>

		</div>
	</div>
	<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="../../front-assets/js/jquery.min.js"></script>
	<script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
	<script src="../../front-assets/js/custom.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->

</body>

</html>