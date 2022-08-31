<%@page import="com.queuer.model.QueuerVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.queuer.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  QueuerVO queuerVO = (QueuerVO) request.getAttribute("queuerVO"); //QueuerServlet.java(Controller), 存入req的QueuerVO物件
%>

<html>
<head>
<title>查詢候位 - listOneQueuer.jsp</title>

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
	width: 600px;
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
		 <h3>候位查詢 - ListOneQueuer.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>顧客排隊編號</th>
		<th>候位編號</th>
		<th>候位狀態</th>
		<th>顧客姓名</th>
		<th>顧客排隊號碼</th>
	</tr>
	<tr>
		<td><%=queuerVO.getQueuerID()%></td>
		<td><%=queuerVO.getWaitingID()%></td>
		<td><%=queuerVO.getQueuerStatus()%></td>
		<td><%=queuerVO.getQueuerName()%></td>
		<td><%=queuerVO.getQueuerNo()%></td>
	</tr>
</table>

</body>
</html>