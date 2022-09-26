<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.meals.model.*"%>
<%@ page import="com.meals.controller.MealsServlet"%>
<%@ page import="com.mealscateory.model.*"%>
<%@ page import="com.botqa.model.*"%>
<%@ page import="com.botqa.controller.BotqaServlet"%>

<%
	
	BotqaService botqaSvc = new BotqaService();
	List<BotqaVO> list4 = botqaSvc.getAll();
	pageContext.setAttribute("list4",list4);
%>


<!doctype html>
<html lang="zh-tw">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.0/css/all.min.css'>
	<link rel="stylesheet" href="./style.css">
	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
	<script src="botqa.js"></script>
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
    justify-content: flex-start;
/*      align-items: center;  */
}
	h2 { 
    font-size: 1rem; 
    font-weight: 400; 
    color:	white	;
 }
.size{
	width: 30%;
    hight: 100%;
    margin-left: auto;
/*     display:none; */
    margin-left: 150px;
    margin-top: -50px;
}
#listBtn{
	background-color: #dc3545;
    font-size: 18px;;
    padding: 10px 35px;
    border-radius: 0.25rem;
}
</style>
</head>

<body>

	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/UpSideBarNoRSVT.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main>
		<!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
		<header> </header>

		<!-- 		<button id="demo8">Demo 8</button> -->
		<!-- Food Widget -->
		<!-- 		col-xl-6 col-md-12 -->
		<c:forEach var="BotqaVO" items="${list4}">
		<script>
			adda1("${BotqaVO.keywordName}","${BotqaVO.keywordContext}");
			adda2("${BotqaVO.keywordContext}");
		
		</script>
		</c:forEach>
<html>

	<head>
		<title>jQuery ChatBot</title>
	</head>

	<body>
	<button id="listBtn" onclick="listBtn()"> 開啟客服</button>
	<div class= "size fas" id="size" style="display:none;">
		<div id="phone-wrapper">
			<div id="app">
				<div id="landing" class="bg-dark text-light" style="">
					<span class="fas fa-robot fa-4x"></span>
					<div>
						<h1 class="mt-3">ChatBot</h1>
					</div>
					<form id="form-start">
						<input type="text" name="username" id="username" value="" placeholder="Your name" required>
						<button type="submit" id="start-chat">Start chat</button>
					</form>
				</div>
				<div id="header" class="bg-dark">
					<!-- <div>
						<button id="back-button" class="text-light btn-transparent btn-icon fas fa-arrow-left"></button>
					</div> -->
					<div class="text-light align-center">
						<h2>ChatBot</h2>
					</div>
					<div>
						<!-- <button id="nav-icon" class="text-light btn-transparent btn-icon fas fa-bars"></button>
						<nav id="nav-container" style="display: none;">
							<ul class="nav">
								<li id="search" class="nav-link"><span class="fas fa-search"></span>Search</li>
								<li id="clear-history" class="nav-link"><span class="fas fa-trash-alt"></span>Clear
									history</li>
								<li id="theme" class="nav-link"><span class="fas fa-cogs"></span>Settings</li>
								<hr>
								<li id="sign-out" class="nav-link"><span class="fas fa-sign-out-alt"></span>Sign out
								</li>
							</ul>
						</nav> -->
					</div>
				</div>
				<div id="message-board">


				</div>
				<div id="form" class="bg-light">
					<div id="emoijis" style="display: none;">
						<button class="smiley btn-transparent btn-icon"><span class="far fa-grin-beam"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-grin"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-grin-wink"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-grin-tongue"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-grin-tongue-wink"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-kiss-wink-heart"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-grin-hearts"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-surprise"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-angry"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-tired"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-sad-tear"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-grin-squint-tears"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-sad-cry"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-dizzy"></span></button>
					</div>
					<div><button id="emoi" class="btn-transparent btn-icon far fa-grin"></button></div>
					<div id="message" placeholder="Type your message here" rows="1" contenteditable></div>
					<div><button id="send" type="" class="btn-transparent btn-icon fas fa-paper-plane"></button></div>
				</div>
			</div>
		</div>
	</div>

	</body>

	</html>


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
	
</body>

</html>