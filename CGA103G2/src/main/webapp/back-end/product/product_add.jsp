<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人-義式餐酒館-管理中心</title>
<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="${pageContext.request.contextPath}/back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Page Specific CSS (Slick Slider.css) -->
<link href="${pageContext.request.contextPath}/back-assets/css/slick.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/back-assets/css/datatables.min.css" rel="stylesheet">
<!-- Costic styles -->
<link href="${pageContext.request.contextPath}/back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="favicon.ico">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->
	
	<div class="ms-aside-overlay ms-overlay-left ms-toggler" data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler" data-target="#ms-recent-activity" data-toggle="slideRight"></div>
	
	<!-- ----- ----- ----- 最左邊的 選擇列 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/LeftSideBar.file"%>
	<!-- ----- ----- ----- 最左邊的 選擇列 end ----- ----- ----- -->

	<main class="body-content">
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->
		
		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<div class="ms-content-wrapper">
			<div class="row">
				<div class="col-md-12">
					<div class="alert alert-success" role="alert">
						<strong>Well done!</strong>You successfully read this important alert message.
					</div>
				</div>
				<div class="col-xl-6 col-md-12">
					<div class="ms-panel ms-panel-fh">
						<div class="ms-panel-header">
							<h6>Add Product Form</h6>
						</div>
						<div class="ms-panel-body">
							<form class="needs-validation clearfix" novalidate>
								<div class="form-row">
									<div class="col-md-12 mb-3">
										<label for="validationCustom18">Product Name</label>
										<div class="input-group">
											<input type="text" class="form-control" id="validationCustom18" placeholder="Product Name" value="Pizza" required>
											<div class="valid-feedback">Looks good!</div>
										</div>
									</div>
									<div class="col-md-6 mb-3">
										<label for="validationCustom22">Select Catagory</label>
										<div class="input-group">
											<select class="form-control" id="validationCustom22" required>
												<option value="">Catagory 1</option>
												<option value="">Catagory 2</option>
												<option value="">Catagory 3</option>
												<option value="">Catagory 4</option>
											</select>
											<div class="invalid-feedback">Please select a Catagory.</div>
										</div>
									</div>
									<div class="col-md-6 mb-3">
										<label for="validationCustom23">Currency</label>
										<div class="input-group">
											<select class="form-control" id="validationCustom23" required>
												<option value="">USD</option>
												<option value="">Bitcoins</option>
												<option value="">EURO</option>
											</select>
											<div class="invalid-feedback">Please select a Currency</div>
										</div>
									</div>
									<div class="col-md-6 mb-3">
										<label for="validationCustom24">Quantity</label>
										<div class="input-group">
											<input type="text" class="form-control" id="validationCustom24" placeholder="01" required>
											<div class="invalid-feedback">Quantity</div>
										</div>
									</div>
									<div class="col-md-6 mb-3">
										<label for="validationCustom25">Price</label>
										<div class="input-group">
											<input type="text" class="form-control" id="validationCustom25" placeholder="$10" required>
											<div class="invalid-feedback">Price</div>
										</div>
									</div>
									<div class="col-md-12 mb-3">
										<label for="validationCustom12">Description</label>
										<div class="input-group">
											<textarea rows="5" id="validationCustom12" class="form-control" placeholder="Message" required></textarea>
											<div class="invalid-feedback">Please provide a message.</div>
										</div>
									</div>
									<div class="col-md-12 mb-3">
										<label for="validationCustom12">Product Image</label>
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="validatedCustomFile"><label class="custom-file-label" for="validatedCustomFile">Upload Images...</label>
											<div class="invalid-feedback">Example invalid custom file feedback</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-xl-6 col-md-12">
					<div class="row">
						<div class="col-md-12">
							<div class="ms-panel">
								<div class="ms-panel-header">
									<h6>Product</h6>
								</div>
								<div class="ms-panel-body">
									<div id="imagesSlider" class="ms-image-slider carousel slide" data-ride="carousel">
										<div class="carousel-inner">
											<div class="carousel-item active">
												<img class="d-block w-100" src="../../back-assets/img/costic/add-product-1.jpg" alt="First slide">
											</div>
											<div class="carousel-item">
												<img class="d-block w-100" src="../../back-assets/img/costic/add-product-2.jpg" alt="Second slide">
											</div>
											<div class="carousel-item">
												<img class="d-block w-100" src="../../back-assets/img/costic/add-product-3.jpg" alt="Third slide">
											</div>
										</div>
										<ol class="carousel-indicators">
											<li data-target="#imagesSlider" data-slide-to="0" class="active"><img class="d-block w-100" src="../../back-assets/img/costic/add-product-1.jpg" alt="First slide"></li>
											<li data-target="#imagesSlider" data-slide-to="1"><img class="d-block w-100" src="../../back-assets/img/costic/add-product-2.jpg" alt="Second slide"></li>
											<li data-target="#imagesSlider" data-slide-to="2"><img class="d-block w-100" src="../../back-assets/img/costic/add-product-3.jpg" alt="Third slide"></li>
										</ol>
									</div>
								</div>
								<div class="ms-panel-header new">
									<p class="medium">Status Available</p>
									<div>
										<label class="ms-switch"><input type="checkbox"><span class="ms-switch-slider round"></span></label>
									</div>
								</div>
								<div class="ms-panel-header new">
									<p class="medium">Discount Active</p>
									<div>
										<label class="ms-switch"><input type="checkbox" checked=""><span class="ms-switch-slider round"></span></label>
									</div>
								</div>
								<div class="ms-panel-header new">
									<button class="btn btn-secondary d-block" type="submit">Save</button>
									<button class="btn btn-primary d-block" type="submit">Save and Add</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
	
	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<!-- Global Required Scripts Start -->
	<script src="../../back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="../../back-assets/js/popper.min.js"></script>
	<script src="../../back-assets/js/bootstrap.min.js"></script>
	<script src="../../back-assets/js/perfect-scrollbar.js"></script>
	<script src="../../back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="../../back-assets/js/slick.min.js"></script>
	<script src="../../back-assets/js/moment.js"></script>
	<script src="../../back-assets/js/jquery.webticker.min.js"></script>
	<script src="../../back-assets/js/Chart.bundle.min.js"></script>
	<script src="../../back-assets/js/Chart.Financial.js"></script>
	<!-- Page Specific Scripts Finish -->
	<!-- Costic core JavaScript -->
	<script src="../../back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="../../back-assets/js/settings.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>