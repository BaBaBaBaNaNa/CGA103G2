<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.news.model.NewsVO"%>
<%@page import="java.sql.Timestamp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
NewsVO newsVO = (NewsVO) request.getAttribute("newsVO");
%>


<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Costic Dashboard</title>
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="../../back-assets/vendors/iconic-fonts/font-awesome/css/all.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="../../back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Page Specific Css (Datatables.css) -->
<link href="../../back-assets/css/datatables.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="../../back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Costic Core styles -->
<link href="../../back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="../../favicon.ico">

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

table {
	width: 750px;
	background-color: #f0f0fa;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
table, tr, td{
	margin-left: 30px;
}
from, table, div{
	margin-left: 30px;
}
</style>

</head>

<body
	class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->
	<div class="ms-aside-overlay ms-overlay-left ms-toggler"
		data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler"
		data-target="#ms-recent-activity" data-toggle="slideRight"></div>
	<!-- Sidebar Navigation Left -->

	<!-- ----- ----- ----- 最左邊的 選擇列 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/LeftSideBar.file"%>
	<!-- ----- ----- ----- 最左邊的 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main class="body-content">
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->
		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pl-0">
				<li class="breadcrumb-item"><a href="#"><i
						class="material-icons">home</i>首頁</a></li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->

		<table id="table-1" >
			<tr>
				<td>
					<h4>消息新增</h4>
				</td>
				<td>
					<h4>
						<a href="listAllNews.jsp"><img src="images/giphy.gif"
							width="250" height="250" border="0">回首頁</a>
					</h4>
				</td>
			</tr>
		</table>

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<FORM METHOD="post" ACTION="news.do" name="form1"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>員工編號:</td>
					<td><input type="TEXT" name="empID" size="45"
						value="<%=(newsVO == null) ? "" : newsVO.getEmpID()%>" /></td>
				</tr>
				<tr>
					<td>消息標題:</td>
					<td><input type="TEXT" name="newsTitle" size="45"
						value="<%=(newsVO == null) ? "TEST" : newsVO.getNewsTitle()%>" /></td>
				</tr>
				<tr>
					<td>消息內容:</td>
					<td class="form-group"><textarea class="form-control"
							id="newsInformation" rows="4" name="newsInformation"><%=(newsVO == null) ? "" : newsVO.getNewsInformation()%></textarea>
					</td>
				</tr>
				<tr>
					<td>消息控制:</td>
					<td><select name="NewsControl" id="NewsControl">
							<option value="0">上架</option>
							<option value="1">下架</option>
					</select></td>
				</tr>
				<tr>
					<td>消息日期:</td>
					<td><input name="newsDate" id="f_date1" type="text"></td>
				</tr>

				<div>
					<label for="newsPictures" class="mt-4">照片:</label> <input id="newsPictures"
						name="newsPictures" type="file" onclick="previewImage()"
						multiple="multiple" accept="image/*" /> <span
						id="newsPictures.errors" class="error">${errorMsgs.newsPictures}</span>
					<div id="blob_holder"></div>
				</div>
			</table>

			<br> <input type="hidden" name="action" value="insert">
			<input  type="submit" value="送出新增">
		</FORM>

		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

	<!-- SCRIPTS -->
	<!-- Global Required Scripts Start -->
	<script src="../../back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="../../back-assets/js/popper.min.js"></script>
	<script src="../../back-assets/js/bootstrap.min.js"></script>
	<script src="../../back-assets/js/perfect-scrollbar.js"></script>
	<script src="../../back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="../../back-assets/js/Chart.bundle.min.js"></script>
	<!-- Page Specific Scripts End -->
	<!-- Page Specific Scripts Finish -->
	<script src="../../back-assets/js/datatables.min.js"></script>
	<script src="../../back-assets/js/data-tables.js"></script>
	<!-- Costic core JavaScript -->
	<script src="../../back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="../../back-assets/js/settings.js"></script>
</body>
<%
Timestamp newsDate = null;
try {
	newsDate = newsVO.getNewsDate();
} catch (Exception e) {
	newsDate = new Timestamp(System.currentTimeMillis());
}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.datetimepicker.css" />
<script
	src="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.datetimepicker.full.js"></script>


<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>
<script type="text/javascript">
	
	document.getElementById('NewsControl').onchange = () => {
		console.log(this);
	}

        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:true,       //timepicker:true,
	       step: 30,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
		   value: '<%=newsDate%>', // value:   new Date(),
        });
        
      //清除提示信息
        function hideContent(d) {
            document.getElementById(d).style.display = "none";
       }
        
//         下列為上傳圖檔
        
        var filereader_support = typeof FileReader != 'undefined';
        if (!filereader_support) {
        	alert("No FileReader support");
        }
        acceptedTypes = {
        		'image/png' : true,
        		'image/jpeg' : true,
        		'image/gif' : true
        };
        function previewImage() {
        	var newsPictures1 = document.getElementById("newsPictures");
        	newsPictures1.addEventListener("change", function(event) {
        		var files = event.target.files || event.dataTransfer.files;
        		for (var i = 0; i < files.length; i++) {
        			previewfile(files[i])
        		}
        	}, false);
        }
        function previewfile(file) {
        	if (filereader_support === true && acceptedTypes[file.type] === true) {
        		var reader = new FileReader();
        		reader.onload = function(event) {
        			var image = new Image();
        			image.src = event.target.result;
        			image.width = 200;
        			image.height = 200;
        			image.border = 2;
        			if (blob_holder.hasChildNodes()) {
        				blob_holder.removeChild(blob_holder.childNodes[0]);
        			}
        			blob_holder.appendChild(image);
        		};
        		reader.readAsDataURL(file);
        		document.getElementById('submit');
        	} else {
        		blob_holder.innerHTML = "<div  style='text-align: left;'>" + "● filename: " + file.name
        				+ "<br>" + "● ContentTyp: " + file.type
        				+ "<br>" + "● size: " + file.size + "bytes"
        				+ "<br>" + "● 上傳ContentType限制: <b> <font color=red>image/png、image/jpeg、image/gif </font></b></div>";
        		document.getElementById('submit');
        	}
        }
        
   		
        
        
        
</script>
</html>