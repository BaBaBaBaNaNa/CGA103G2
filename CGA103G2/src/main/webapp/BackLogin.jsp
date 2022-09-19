<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人 餐廳管理系統</title>
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="./back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link href="./back-assets/vendors/iconic-fonts/font-awesome/css/all.min.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="./back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="./back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Costic styles -->
<link href="./back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="./favicon.ico">

<%if ( (request.getAttribute("errorMessage") != null)) {%>
<script type="text/javascript">
 	alert("<%= request.getAttribute("errorMessage") %>");
</script>
<%} else {%>
<%}%>

</head>

<body class="ms-body ms-primary-theme ms-logged-out">
	<!-- 讀取網頁圈圈 -->
	<div id="preloader-wrap">
		<div class="spinner spinner-8">
			<div class="ms-circle1 ms-child"></div>
			<div class="ms-circle2 ms-child"></div>
			<div class="ms-circle3 ms-child"></div>
			<div class="ms-circle4 ms-child"></div>
			<div class="ms-circle5 ms-child"></div>
			<div class="ms-circle6 ms-child"></div>
			<div class="ms-circle7 ms-child"></div>
			<div class="ms-circle8 ms-child"></div>
			<div class="ms-circle9 ms-child"></div>
			<div class="ms-circle10 ms-child"></div>
			<div class="ms-circle11 ms-child"></div>
			<div class="ms-circle12 ms-child"></div>
		</div>
	</div>
	<!-- Main Content -->
	<main class="body-content">
		<!-- Body Content Wrapper -->
		<div class="ms-content-wrapper ms-auth">
			<div class="ms-auth-container">
				<div class="ms-auth-col">
					<div class="ms-auth-bg"></div>
				</div>
				<div class="ms-auth-col">
					<div class="ms-auth-form">
						<form class="needs-validation" form name="myform" action="EmpLoginServlet.do" method="POST">
							<h3>義鄉人 餐廳管理系統</h3>
							<p>請輸入你的員工帳號、員工密碼</p>
							<div class="mb-3">
								<label for="validationCustom08">員工帳號</label>
								<div class="input-group">
									<input type="text" class="form-control" name="empAccount" id="url" value="test01@gmail.com">
								</div>
							</div>
							<div class="mb-2">
								<label for="validationCustom09">員工密碼</label>
								<div class="input-group">
									<input type="password" class="form-control" name="empPassword" id="url" value="123456">
								</div>
							</div>
							<button class="btn btn-primary mt-4 d-block w-100" type="submit">登入</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- SCRIPTS -->
	<!-- Global Required Scripts Start -->
	<script src="./back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="./back-assets/js/popper.min.js"></script>
	<script src="./back-assets/js/bootstrap.min.js"></script>
<!-- 	<script src="./ack-assets/js/perfect-scrollbar.js"></script> -->
	<script src="./back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Costic core JavaScript -->
	<script src="./back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="./back-assets/js/settings.js"></script>
</body>

</html>