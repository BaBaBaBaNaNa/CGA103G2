<%@page import="com.news.model.NewsVO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
NewsVO newsVO = (NewsVO) request.getAttribute("newsVO"); //OrdersServlet.java (Concroller) 存入req的newsVO物件 (包括幫忙取出的newsVO, 也包括輸入資料錯誤時的newsVO物件)
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>news修改 - update_news_input.jsp</title>

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

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 570px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>訂單資料修改 - update_news_input.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

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
				<td>消息編號:<font color=red><b>*</b></font></td>
				<td><%=newsVO.getNewsID()%></td>
			</tr>

			<tr>
				<td>員工編號 :</td>
				<td><input type="TEXT" name="empID" size="45"
					value="<%=newsVO.getEmpID()%>" /></td>
			</tr>
			<tr>
				<td>消息日期:</td>
				<td><input name="newsDate" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>消息標題 :</td>
				<td><input type="TEXT" name="newsTitle" size="45"
					value="<%=newsVO.getNewsTitle()%>" /></td>
			</tr>
			<tr>
				<td>消息內容:</td>
				<td><input type="TEXT" name="newsInformation" size="45"
					value="<%=newsVO.getNewsInformation()%>" /></td>
			</tr>

			<tr>
				<td>消息控制(上架 下架):</td>
				<td><select name="newsControl" id="newsControl">
						<option value="0">上架</option>
						<option value="1">下架</option>
				</select></td>
			</tr>

			<div>
				<label for="newsPictures">圖片:</label> <input id="newsPictures"
					name="newsPictures" type="file" onclick="previewImage()"
					multiple="multiple " accept="image/*" />
				<%-- 				可以不修改圖片 <span  id ="newsPictures.errors" class="error">${errorMsgs.newsPictures}</span> --%>
				<div id="blob_holder">
					<img
						src="<%=request.getContextPath()%>/news/DBGifReader?newsID=${param.newsID}"
						width="100px">
				</div>
			</div>

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="newsID" value="<%=newsVO.getNewsID()%>">
		<input type="submit" value="送出修改">
	</FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->


<%
Timestamp newsDate = null;
try {
	newsDate = newsVO.getNewsDate();
} catch (Exception e) {
	newsDate = new Timestamp(System.currentTimeMillis());
}
%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>

document.getElementById('newsControl').onchange = ()=> {
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


//照片上傳-預覽用
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
			blob_holder.innerHTML = '';
// 			if (blob_holder.hasChildNodes()) {
// 				blob_holder.removeChild(blob_holder.childNodes[0]);
// 			}
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