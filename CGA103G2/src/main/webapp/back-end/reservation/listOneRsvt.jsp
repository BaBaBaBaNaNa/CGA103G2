<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.rsvt.model.*"%>
<%@ page import="java.text.SimpleDateFormat" %>>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
RsvtVO rsvtVO = (RsvtVO) request.getAttribute("rsvtVO"); //RsvtServlet.java(Concroller), 存入req的rsvtVO物件
SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 日期格式轉換
%>

<html>
<head>
<title>訂位資料 - listOneRsvt.jsp</title>

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
	<tr><td>
		 <h3>訂位資料 - ListOneRsvt.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
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
	<tr>
		<td><%=rsvtVO.getRsvtId()%></td>
		<td><%=rsvtVO.getMemId() == null ? "" : rsvtVO.getMemId()%></td>
		<td><%=rsvtVO.getTableTypeId() == null ? "" : rsvtVO.getTableTypeId()%></td>
		<td><%=rsvtVO.getCustomerName()%></td>
		<td><%=rsvtVO.getCustomerPhone()%></td>
		<td><%=rsvtVO.getRsvtNum()%></td>
		<td><%=rsvtVO.getRsvtPeriod() == 0 ? "中午" : "晚上"%></td>
		<td><%=rsvtVO.getRsvtToSeat() == 1 ? "未入座" : "已入座"%></td>
		<td><%=rsvtVO.getRsvtDate()%></td>
		<td><%=rsvtVO.getRsvtMealDate() == null ? "尚未用餐" : sdFormat.format(rsvtVO.getRsvtMealDate()) %></td>
	</tr>
</table>

</body>
</html>