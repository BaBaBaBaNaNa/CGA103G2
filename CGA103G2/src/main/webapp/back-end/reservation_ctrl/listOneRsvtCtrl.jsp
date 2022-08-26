<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.rsvtCtrl.model.*"%>
<%@ page import="java.text.SimpleDateFormat"%>>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
RsvtCtrlVO rsvtCtrlVO = (RsvtCtrlVO) request.getAttribute("rsvtCtrlVO"); //RsvtServlet.java(Concroller), 存入req的rsvtVO物件
%>

<html>
<head>
<title>訂位資料 - listOneRsvtCtrl.jsp</title>

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

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>訂位資料 - ListOneRsvt.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>訂位控制編號</th>
			<th>桌型編號</th>
			<th>訂位控制開放</th>
			<th>訂位控制日期</th>
			<th>訂位控制時段</th>
			<th>每時段桌子上限</th>
			<th>已預訂桌數</th>
		</tr>
		<tr>
			<td><%=rsvtCtrlVO.getRsvtCtrlId()%></td>
			<td><%=rsvtCtrlVO.getTableTypeId()%></td>
			<td><%=rsvtCtrlVO.getRsvtCtrlOpen()%></td>
			<td><%=rsvtCtrlVO.getRsvtCtrlDate()%></td>
			<td><%=rsvtCtrlVO.getRsvtCtrlPeriod()%></td>
			<td><%=rsvtCtrlVO.getRsvtCtrlMax()%></td>
			<td><%=rsvtCtrlVO.getRsvtCtrlNumber()%></td>
		</tr>
	</table>

</body>
</html>