<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM RsvtCtrl: Home</title>

<style>
/* .form_ul li	{ */
/* 	display: inline-block; */
/* 	list-style: none; */
/* 	border: 1px solid black; */
/* } */

table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td><h3>IBM RsvtCtrl: Home</h3>
				<h4>( MVC )</h4></td>
		</tr>
	</table>

	<p>This is the Home page for IBM RsvtCtrl: Home</p>

	<h3>資料查詢:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul class="form_ul">
		<li><a href='listAllRsvtCtrl.jsp'>List</a> all RsvtCtrls. <br><br></li>
		
		<li>
			<FORM METHOD="post" ACTION="RsvtCtrlServlet">
				<b>輸入訂位編號 (如7001):</b> <input type="text" name="rsvtCtrlId">
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<jsp:useBean id="rsvtCtrlSvc" scope="page"
			class="com.rsvtCtrl.model.RsvtCtrlService" />

		<li>
			<FORM METHOD="post" ACTION="RsvtCtrlServlet">
				<b>選擇訂位編號:</b> <select size="1" name="rsvtCtrlId">
					<c:forEach var="rsvtCtrlVO" items="${rsvtCtrlSvc.all}">
						<option value="${rsvtCtrlVO.rsvtCtrlId}">${rsvtCtrlVO.rsvtCtrlId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="RsvtCtrlServlet">
				<b>選擇日期:</b> <select size="1" name="rsvtCtrlId">
					<c:forEach var="rsvtCtrlVO" items="${rsvtCtrlSvc.all}">
						<option value="${rsvtCtrlVO.rsvtCtrlId}">${rsvtCtrlVO.rsvtCtrlDate}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>


	<h3>訂位管理</h3>

	<ul>
		<li><a href='addRsvtCtrl.jsp'>Add</a> a new RsvtCtrl.</li>
	</ul>

</body>
</html>