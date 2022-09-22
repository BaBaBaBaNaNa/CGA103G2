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
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/favicon.ico">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->

<style type="text/css">
	input[type=checkbox]{
	height: 0;
	width: 0;
	visibility: hidden;
}

label {
	cursor: pointer;
	width: 40px;
	height: 20px;
	background: grey;
	display: block;
	border-radius: 20px;
	position: relative;
}

label:after {
	content: '';
	position: absolute;
	top: 1px;
	left: 1px;
	width: 18px;
	height: 18px;
	background: #fff;
	border-radius: 18px;
	transition: 0.3s;
}

.switch-txt::before,
.switch-txt::after {
  display: block;
  color: #fff;
  font-weight: bold;
  box-sizing: border-box;
}
.switch-txt::before {
  content: attr(turnOn);
  color: #fff;
}
.switch-txt::after {
  content: attr(turnOff);
  color: #ccc;
}

input:checked + label {
	background: #6f42c1;;
}

label:active:after {
	width: 26px;
}

input:checked + label:after {
	left: calc(100% - 1px);
	transform: translateX(-100%);
}

</style>
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

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main class="body-content"padding-right: 0 px;>
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->
		
		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		

		<div class="ms-content-wrapper">
		<button id="openOrCloseBtn" onclick="openOrCloseBtn">開/關</button>
			<div class="row">
				<div class="col-md-12">
					<div class="alert alert-success" role="hidden" style="display:none">
					</div>
				</div>
				<div class="col-xl-6 col-md-12">
					<div class="ms-panel ms-panel-fh">
						<div class="ms-panel-header">
							<h6>日期與時間</h6>
						</div>
						<div class="ms-panel-body">
							<form class="needs-validation clearfix" novalidate>
								<div class="form-row">
									候位日期：
									<span id="today"></span>
								</div>
								<div class="form-row">
									候位時段：
									<span id="timePeriod"></span>
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
									<h6>Second Area</h6>
								</div>
								<div class="ms-panel-body">
									<div id="imagesSlider" class="ms-image-slider carousel slide" data-ride="carousel">
										<div class="carousel-inner">
										當前編號：
										<span id="currentNO">0</span>
										</div>
										<div>
										<button type="button" id="getNextNOBtn" onclick="getNextNOBtn">下一號</button>
										<button type="button" id="doSeatedListBtn" onclick="doSeatedListBtn">入座</button>
										<button type="button" id="doOverListBtn" onclick="doOverListBtn">過號</button>
										</div>

										<div class="carousel-inner">
										下一號：
										<span id="nextNO">0</span>
										</div>

										<div class="carousel-inner">
										剩餘組數：
										<span id="remainNO">0</span>
										</div>
										<div class="carousel-inner">
										總組數：
										<span id="totalNO">0</span>
										</div>

									</div>
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
	<script src="${pageContext.request.contextPath}/back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/perfect-scrollbar.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="${pageContext.request.contextPath}/back-assets/js/d3.v3.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/topojson.v1.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/datatables.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/data-tables.js"></script>
	<!-- Page Specific Scripts Finish -->
	<!-- Costic core JavaScript -->
	<script src="${pageContext.request.contextPath}/back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="${pageContext.request.contextPath}/back-assets/js/settings.js"></script>
	
	
		<script type="text/javascript">
		$(document).ready(function(){
			
	        $("#getNextNOBtn").click(function(){
	        	
	        	

	            $.ajax({


	                 url: "<%=request.getContextPath()%>/queuer/QueuerServlet.do",     

	                 data: {
	                	 action:  "doNextNO", 
	                 },

	                 success : function(res){
	                	 
	                	 showCurrentNO(res)
	                	 showNextNO(res)
	                	 
	                	 
	                 },

	                 error:function(xhr, ajaxOptions, thrownError){

	                     alert(xhr.status+"\n"+thrownError);
	                 }

	             });

	        });
	    	 
	        $("#doSeatedListBtn").click(function(){
	        	
	        	

	            $.ajax({


	                 url: "<%=request.getContextPath()%>/queuer/QueuerServlet.do",     

	                 data: {
	                	 action:  "doSeatedList", 
	                 },

	                 success : function(res){
	                	 doSeatedList(res)
	                 },

	                 error:function(xhr, ajaxOptions, thrownError){

	                     alert(xhr.status+"\n"+thrownError);
	                 }

	             });

	        });
	        
	        $("#doOverListBtn").click(function(){

	            $.ajax({


	                 url: "<%=request.getContextPath()%>/queuer/QueuerServlet.do",     

	                 data: {
	                	 action:  "doOverList", 
	                 },

	                 success : function(res){
	                	 doOverList(res)
	                 },

	                 error:function(xhr, ajaxOptions, thrownError){

	                     alert(xhr.status+"\n"+thrownError);
	                 }

	             });

	        });
	        
	        $("#openOrCloseBtn").click(function(){

	            $.ajax({


	                 url: "<%=request.getContextPath()%>/queuer/QueuerServlet.do",     

	                 data: {
	                	 action:  "openOrClose", 
	                 },

	                 success : function(res){
	                	 console.log(JSON.parse(res));
	                 },

	                 error:function(xhr, ajaxOptions, thrownError){

	                     alert(xhr.status+"\n"+thrownError);
	                 }

	             });

	        });

	     });  
	</script>
		<script type="text/javascript">
	Today = new Date();
	yy=Today.getFullYear();
	mm=Today.getMonth()+1;
	dd=Today.getDate();
	
	document.getElementById("today").innerHTML = yy+"/"+mm+"/"+dd;
	
	</script>
	
	<script type="text/javascript">
	Today = new Date();
	time = Today.getHours();
	
	if(time < 17){
		document.getElementById("timePeriod").innerHTML = "中午";
	}else{
		document.getElementById("timePeriod").innerHTML = "晚上";
	}
	</script>
	
	<script type="text/javascript">
	function showCurrentNO(res){
		document.getElementById("currentNO").innerHTML = JSON.parse(res).currentNO
	}
	
	function showNextNO(res){
		document.getElementById("nextNO").innerHTML = JSON.parse(res).nextNO
	}
	
	function doSeatedList(res){
		console.log(JSON.parse(res))
	}
	function doOverList(res){
		console.log(JSON.parse(res))
	}
	</script>
		
	<script type="text/javascript">
	
	function showTotalNO(){
		 $.ajax({


	          url: "<%=request.getContextPath()%>/queuer/QueuerServlet.do",     

	          data: {
	         	 action: "showTotalNO", 
	          },

	          success : function(res){
	         	 
			  document.getElementById("totalNO").innerHTML = JSON.parse(res).totalNO
	         	 
	          },
	         	 
	              
	          

	          error:function(xhr, ajaxOptions, thrownError){

	              alert(xhr.status+"\n"+thrownError);
	          }

	      });
	}
	  function showRemainNO(){

	      $.ajax({


	          url: "<%=request.getContextPath()%>/queuer/QueuerServlet.do",     

	          data: {
	         	 action: "showRemainNO", 
	          },

	          success : function(res){
	         	 
			  document.getElementById("remainNO").innerHTML = JSON.parse(res).remainNO
	          },
	         	 
	              
	          

	          error:function(xhr, ajaxOptions, thrownError){

	              alert(xhr.status+"\n"+thrownError);
	          }

	      });
		  
	  }
	
	window.onload = function (){
		setInterval(showTotalNO, 1000);
		setInterval(showRemainNO, 1000);
	}
	
	</script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>