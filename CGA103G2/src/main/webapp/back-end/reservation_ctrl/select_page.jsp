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

	<h3>��Ƭd��:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
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
				<b>��J�q��s�� (�p7001):</b> <input type="text" name="rsvtCtrlId">
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<jsp:useBean id="rsvtCtrlSvc" scope="page"
			class="com.rsvtCtrl.model.RsvtCtrlService" />

		<li>
			<FORM METHOD="post" ACTION="RsvtCtrlServlet">
				<b>��ܭq��s��:</b> <select size="1" name="rsvtCtrlId">
					<c:forEach var="rsvtCtrlVO" items="${rsvtCtrlSvc.all}">
						<option value="${rsvtCtrlVO.rsvtCtrlId}">${rsvtCtrlVO.rsvtCtrlId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="RsvtCtrlServlet">
				<b>��ܤ��:</b> <select size="1" name="rsvtCtrlId">
					<c:forEach var="rsvtCtrlVO" items="${rsvtCtrlSvc.all}">
						<option value="${rsvtCtrlVO.rsvtCtrlId}">${rsvtCtrlVO.rsvtCtrlDate}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>
	</ul>


	<h3>�q��޲z</h3>

	<ul>
		<li><a href='addRsvtCtrl.jsp'>Add</a> a new RsvtCtrl.</li>
	</ul>

</body>
</html>