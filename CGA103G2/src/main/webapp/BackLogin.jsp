<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>登入</title>

<!-- 登入 style -->
<link type="text/css" rel="stylesheet" href="./back-assets/css/back.login.css"
	media="screen" />
<!-- Load Javascript -->
<script type="text/javascript" src="./back-assets/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./back-assets/js/rainbows.js"></script>
<!-- // Load Javascipt end-->

<!-- Load stylesheets -->
<link type="text/css" rel="stylesheet" href="./back-assets/css/back.login.css"
	media="screen" />
<!-- // Load stylesheets -->
<!-- 登入 style end-->
<%if ("wrong".equals(request.getAttribute("errorMessage"))) {%>
<script type="text/javascript">
	alert("用戶名或者密碼錯誤！");
</script>
<%} else {%>
<%}%>
</head>

<body style="text-align: center">
	<form name="myform" action="EmpLoginServlet.do" method="POST">
		<div id="wrapper">
			<div id="wrappertop"></div>

			<div id="wrappermiddle">
				<h2>義鄉人 後台登入系統</h2>

				<div id="username_input">

					<div id="username_inputleft"></div>

					<div id="username_inputmiddle">
						<input type="text" name="empAccount" id="url" value="員工帳號">
					</div>

					<div id="username_inputright"></div>

				</div>

				<div id="password_input">

					<div id="password_inputleft"></div>
 
					<div id="password_inputmiddle">
						<input type="password" name="empPassword" id="url"
							value="Password">
					</div>

					<div id="password_inputright"></div>

				</div>
				<div id="submit">
					<input type="image" src="./back-assets/img/login_images/submit_hover.png"
						id="submit1" value="Sign In" onclick="return checkForm()">
					<input type="image" src="./back-assets/img/login_images/submit.png"
						id="submit2" value="Sign In">
				</div>
			</div> 

			<div id="wrapperbottom"></div>
		</div>
	</form>
	<script type="text/javascript" src="./back-assets/js/back.login.js"></script>
</body>
</html>