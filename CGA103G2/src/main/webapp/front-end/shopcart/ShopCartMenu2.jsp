<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.meals.model.*"%>
<%@ page import="com.meals.controller.MealsServlet"%>
<%@ page import="com.mealscateory.model.*"%>

<%-- <jsp:useBean id="MealsSvc" scope="page" --%>
<%-- 	class="com.meals.model.MealsService" /> --%>
<%-- <jsp:useBean id="list" scope="session" type="java.util.List<MealsVO>" /> --%>





<%
	MealsCategoryService mealsCategorySvc = new MealsCategoryService();
	List<MealsCategoryVO> list1 = mealsCategorySvc.getAll();
	pageContext.setAttribute("list1",list1);
	
	MealsService mealsSvc = new MealsService();
	List<MealsVO> list = mealsSvc.getAll();
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

<link href="../../front-assets/css/navbar.css" rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap.min.css"
	rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap-icons.css"
	rel="stylesheet">

<link href="../../front-assets/css/tooplate-crispy-kitchen.css"
	rel="stylesheet">

<link href="../../front-assets/css/menuButton.css" rel="stylesheet">
<!-- <link href="../../front-assets/css/navbar.css" rel="stylesheet"> -->

<!-- <link href="../../front-assets/css/shoppingcart/ShoppingCart.css" rel="stylesheet"> -->
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
<style>
.show-cart li {
	display: flex;
}

.card {
	margin-bottom: 20px;
}

.card-img-top {
	width: 200px;
	height: 200px;
	align-self: center;
}

.Info {
	float: right;
	color: #fff;
	background-color: #0d6efd;
	padding: 0.375rem 0.75rem;
	border-radius: 0.25rem;
	border: 1px solid transparent;
}
.nav-tabs {
    border-bottom: 0;
}
.pt-4 {
    padding-top: 1.5rem !important;
    padding-bottom: 1.5rem;
    display: flex;
    align-content: center;
    justify-content: center;
    align-items: center;
}

</style>
</head>

<body>

	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/UpSideBar.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main>
		<%@ include file="../../back-end/tool/page3.file"%>
		<!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
		<header> </header>

		<!-- 		<button id="demo8">Demo 8</button> -->
		<!-- Food Widget -->
		<!-- 		col-xl-6 col-md-12 -->
		
		<div class="">
			<div class="ms-panel ms-widget ms-crypto-widget">
				<div class="ms-panel-header">
					<h6>美味餐點</h6>
					<p>選擇你想吃的食物</p>
				</div>
				<c:forEach var="MealsCategoryVO" items="${list1}"
											begin="<%=pageIndex +1%>" end="<%=pageIndex+rowsPerPage-1%>">
										<h4 class="card-title">${MealsCategoryVO.mealsCategoryId}</h4>	
										<h4 class="card-title">${MealsCategoryVO.mealsCategory}</h4>	
				</c:forEach>
				<div class="ms-panel-body p-0">
					<ul class="nav nav-tabs nav-justified has-gap px-4 pt-4"
						role="tablist">
						<li role="presentation" class="fs-12"><a href="#btc"
							aria-controls="btc" class="active show" role="tab"
							data-toggle="tab">沙拉 </a></li>
						<li role="presentation" class="fs-12"><a href="#xrp"
							aria-controls="xrp" role="tab" data-toggle="tab">前菜</a></li>
						<li role="presentation" class="fs-12"><a href="#ltc"
							aria-controls="ltc" role="tab" data-toggle="tab">主餐</a></li>
						<li role="presentation" class="fs-12"><a href="#eth"
							aria-controls="eth" role="tab" data-toggle="tab">甜點</a></li>
						<li role="presentation" class="fs-12"><a href="#zec"
							aria-controls="zec" role="tab" data-toggle="tab">飲料</a></li>
					</ul>
					<div class="tab-content">
						<!--                             --------------沙拉------------------- -->
						<div role="tabpanel" class="tab-pane active show fade in" id="btc">

							<div class="table-responsive">
								<div class="container">
									<div class="row">
										<c:forEach var="MealsVO" items="${list}"
											begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
											<c:if test="${MealsVO.mealsCategoryID ==1}">
												<div class="col">
													<div class="card" style="width: 20rem;">
														<img class="card-img-top" alt="Card image cap"
															src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${MealsVO.mealsID}"
															width="100px">
														<div class="card-block">
															<h4 class="card-title">${MealsVO.mealsName}</h4>
															<p class="card-text">價錢:${MealsVO.mealsPrice}</p>
															<a 
																data-id="${MealsVO.mealsID}" 
																data-name="${MealsVO.mealsName}"
																data-price="${MealsVO.mealsPrice}"
																data-info="${MealsVO.mealsInfo}" class="Info">查看詳情</a>
															<a href="#"
																data-id="${MealsVO.mealsID}" 
																data-name="${MealsVO.mealsName}"
																data-price="${MealsVO.mealsPrice}"
																class="add-to-cart btn btn-primary">加入購物車</a>
														</div>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<!--                             --------------前菜------------------- -->
						<div role="tabpanel" class="tab-pane fade" id="xrp">

							<div class="table-responsive">
								<div class="container">
									<div class="row">
										<c:forEach var="MealsVO" items="${list}"
											begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
											<c:if test="${MealsVO.mealsCategoryID ==2}">
												<c:if test="${MealsVO.mealsControl==1}">
													<div class="col">
														<div class="card" style="width: 20rem;">
															<img class="card-img-top" alt="Card image cap"
																src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${MealsVO.mealsID}"
																width="100px">
															<h4 class="card-title">${MealsVO.mealsName}</h4>
															<p class="card-text">${MealsVO.mealsPrice}</p>
															<a data-name="${MealsVO.mealsName}"
																data-price="${MealsVO.mealsPrice}"
																data-info="${MealsVO.mealsInfo}" class="Info">查看詳情</a>
															<a href="#" 
															
															data-name="${MealsVO.mealsName}"
																data-price="${MealsVO.mealsPrice}"
																class="add-to-cart btn btn-primary">加入購物車</a>
														</div>
													</div>
												</c:if>
											</c:if>
										</c:forEach>
									</div>
								</div>

							</div>
						</div>
					
											
						<!--         --------------主餐------------------- -->
						<div role="tabpanel" class="tab-pane fade" id="ltc">
							<div class="table-responsive">
								<div class="container">
									<div class="row">
										<c:forEach var="MealsVO" items="${list}"
											begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
											<c:if test="${MealsVO.mealsCategoryID ==3}">
												<c:if test="${MealsVO.mealsControl==1}">
													<div class="col">
														<div class="card" style="width: 20rem;">
															<img class="card-img-top" alt="Card image cap"
																src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${MealsVO.mealsID}"
																width="100px">
															<h4 class="card-title">${MealsVO.mealsName}</h4>
															<p class="card-text">價錢:${MealsVO.mealsPrice}</p>
															<a href="#"
																data-id= "${MealsVO.mealsID}"
																data-name="${MealsVO.mealsName}"
																data-price="${MealsVO.mealsPrice}"
																class="add-to-cart btn btn-primary">加入購物車</a>
														</div>
													</div>
												</c:if>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<!--                             --------------甜點------------------- -->
						<div role="tabpanel" class="tab-pane fade" id="eth">
							<div class="table-responsive">
								<div class="container">
									<div class="row">
										<c:forEach var="MealsVO" items="${list}"
											begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
											<c:if test="${MealsVO.mealsCategoryID ==4}">
												<c:if test="${MealsVO.mealsControl==1}">
													<div class="col">
														<div class="card" style="width: 20rem;">
															<img class="card-img-top" alt="Card image cap"
																src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${MealsVO.mealsID}"
																width="100px">
															<h4 class="card-title">${MealsVO.mealsName}</h4>
															<p class="card-text">${MealsVO.mealsPrice}</p>
															<a href="#" data-name="${MealsVO.mealsName}"
																data-price="${MealsVO.mealsPrice}"
																class="add-to-cart btn btn-primary">加入購物車</a>
														</div>
													</div>
												</c:if>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<!--                             --------------飲料------------------- -->

						
						<div role="tabpanel" class="tab-pane fade" id="zec">
							<div class="table-responsive">
								<div class="container">
									<div class="row">
										<c:forEach var="MealsVO" items="${list}"
											begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
											<c:if test="${MealsVO.mealsCategoryID ==5}">
												<c:if test="${MealsVO.mealsControl==1}">
													<div class="col">
														<div class="card" style="width: 20rem;">
															<img class="card-img-top" alt="Card image cap"
																src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${MealsVO.mealsID}"
																width="100px">
															<h4 class="card-title">${MealsVO.mealsName}</h4>
															<p class="card-text">${MealsVO.mealsPrice}</p>
															<a href="#" data-name="${MealsVO.mealsName}"
																data-price="${MealsVO.mealsPrice}"
																class="add-to-cart btn btn-primary">加入購物車</a>
														</div>
													</div>
												</c:if>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->

		<!-- ----- ----- ----- 中間內容 start ----- ----- ----- -->

		<section class="about section-padding bg-white">
			<!-- Nav -->
			<!-- 			<nav class="navbar bg-inverse bg-faded "> -->
			<!-- 				<div class="row"> -->
			<!-- 					<div class="col"> -->
			<!-- 						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#cart"> -->
			<!-- 							Cart (<span class="total-count"></span>) -->
			<!-- 						</button> -->
			<!-- 						<button class="clear-cart btn btn-danger">Clear Cart</button> -->
			<!-- 					</div> -->
			<!-- 				</div> -->
			<!-- 			</nav> -->


			<!-- Main -->

			<!-- Modal -->
			<div class="modal-fade" id="cart" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<!-- 						<div class="modal-dialog modal-dialog-centered modal-xl"> -->
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">購物車</h5>
							<!-- 							<button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
							<!-- 								<span aria-hidden="true">&times;</span> -->
							<!-- 							</button> -->
						</div>
						<div class="modal-body">
							<table class="show-cart table">

							</table>
							<div>
								總金額: $<span class="total-cart"></span>
							</div>
						</div>
						<div class="modal-footer">
							<!-- 							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
							<button type="button" class="btn btn-primary"
								onclick="window.location.href='../../front-end/shopcart/ShopCart.jsp'">確認購物車</button>
						</div>
					</div>
				</div>
			</div>
			<hr>
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

	<script src="../../front-assets/js/shoppingcart/bootstrap.min.js"></script>
	<script src="../../front-assets/js/shoppingcart/ShoppingCart.js"></script>
	<script src="../../front-assets/js/shoppingcart/test.js"></script>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
	<script>
				$('.Info').click(function(event) {
					event.preventDefault();
					var name = $(this).data('name');
					var price = Number($(this).data('price'));
			        var info = ($(this).data('info'));
			        var id = ($(this).data('id'));
					console.log(name);
					console.log(info);
					swal.fire({
					 title: name,
		                html: "價錢:" + price + "<p></p>" + info,
		                text: 'Modal with a custom image.',
		                imageUrl: 'https://unsplash.it/400/200',
		                imageWidth: 400,
		                imageHeight: 200,
		                imageAlt: 'Custom image',
		                showCancelButton: true,
		                confirmButtonColor: '#3085d6',
		                cancelButtonColor: '#d33',
		                cancelButtonText: '取消',
		                confirmButtonText: '加入購物車!'
		            }).then((result) => {
		                if (result.isConfirmed) {
		                    Swal.fire(
		                    	'success',
		                        '成功加入購物車',
		                        'success'
		                    )
		                    shoppingCart.addItemToCart(name, price, 1,id);
		                	displayCart();
		                }
		            })
					
				});
		

      
            </script>
</body>

</html>