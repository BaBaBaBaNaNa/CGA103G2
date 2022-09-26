<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zh-tw">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

<title>義鄉人 - 義式餐酒館 - 新增訂單成功 - 緯育 中壢Java班 CGA_103 第二組</title>

<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap" rel="stylesheet">

<link href="../../front-assets/css/navbar.css" rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap.min.css" rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap-icons.css" rel="stylesheet">

<link href="../../front-assets/css/tooplate-crispy-kitchen.css" rel="stylesheet">

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
		<!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->

		<!-- ----- ----- ----- 中間內容 start ----- ----- ----- -->

		<section class="about section-padding bg-white">
		<p style="font-size:30px; text-align: center;">新增訂單成功</p>
			<hr>
				<div class="modal-fade" id="cart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">訂單詳情</h5>
								<span id="orderType"></span><br>
								<span id="ordaddress"></span>
							</div>
							<div class="modal-body">
								<table class="show-cart table">

								</table>
								<div>
									總金額: $<span class="total-cart"></span>
								</div>
							</div>
							<div class="modal-footer">
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
	<%@ include file="../../front-end/tool/PageFooter.file"%>
	<!-- ----- ----- ----- 底部 end ----- ----- ----- -->

	<!-- ----- ----- ----- 跳出預先訂位頁面 start ----- ----- ----- -->
	
	<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="../../front-assets/js/jquery.min.js"></script>
	<script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
	<script src="../../front-assets/js/custom.js"></script>

	<script src="../../front-assets/js/shoppingcart/ShoppingCartSuccess.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->

</body>

</html>