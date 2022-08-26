<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*"%>
<%@ page import="com.rsvt.model.*"%>
<%@ page import="java.text.SimpleDateFormat" %>>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
RsvtService rsvtSvc = new RsvtService();
List<RsvtVO> list = rsvtSvc.getAll();
pageContext.setAttribute("list", list);
SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 日期格式轉換
String mdString = "未用餐";
%>


<html>
<head>
<title>所有訂位資料 - listAllRsvt.jsp</title>

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
	width: 100%;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>所有訂位資料 - listAllRsvt.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>訂位編號</th>
			<th>會員編號</th>
			<th>桌位編號</th>
			<th>顧客姓名</th>
			<th>顧客電話</th>
			<th>訂位人數</th>
			<th>時段</th>
			<th>入座狀態</th>
			<th>訂位日期</th>
			<th>用餐日期</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="rsvtVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${rsvtVO.rsvtId}</td>
				<td>${rsvtVO.memId}</td>
				<td>${rsvtVO.tableTypeId}</td>
				<td>${rsvtVO.customerName}</td>
				<td>${rsvtVO.customerPhone}</td>
				<td>${rsvtVO.rsvtNum}</td>
				<td>${rsvtVO.rsvtPeriod == 0 ? "中午" : "晚上"}</td>
				<td>${rsvtVO.rsvtToSeat == 1 ? "未入座" : "已入座"}</td>
				<td>${rsvtVO.rsvtDate}</td>
				<td><fmt:formatDate value="${rsvtVO.rsvtMealDate == null ? '' : rsvtVO.rsvtMealDate}" type="both"/></td>
				
				<td>
					<FORM METHOD="post"
						ACTION="RsvtServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="rsvtId" value="${rsvtVO.rsvtId}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="RsvtServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="rsvtId" value="${rsvtVO.rsvtId}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>