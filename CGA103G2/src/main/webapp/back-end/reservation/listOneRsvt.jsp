<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.rsvt.model.*"%>
<%@ page import="java.text.SimpleDateFormat" %>>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
RsvtVO rsvtVO = (RsvtVO) request.getAttribute("rsvtVO"); //RsvtServlet.java(Concroller), �s�Jreq��rsvtVO����
SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // ����榡�ഫ
%>

<html>
<head>
<title>�q���� - listOneRsvt.jsp</title>

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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�q���� - ListOneRsvt.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�q��s��</th>
		<th>�|���s��</th>
		<th>���s��</th>
		<th>�U�ȩm�W</th>
		<th>�U�ȹq��</th>
		<th>�q��H��</th>
		<th>�ɬq</th>
		<th>�J�y���A</th>
		<th>�q����</th>
		<th>���\���</th>
	</tr>
	<tr>
		<td><%=rsvtVO.getRsvtId()%></td>
		<td><%=rsvtVO.getMemId() == null ? "" : rsvtVO.getMemId()%></td>
		<td><%=rsvtVO.getTableTypeId() == null ? "" : rsvtVO.getTableTypeId()%></td>
		<td><%=rsvtVO.getCustomerName()%></td>
		<td><%=rsvtVO.getCustomerPhone()%></td>
		<td><%=rsvtVO.getRsvtNum()%></td>
		<td><%=rsvtVO.getRsvtPeriod() == 0 ? "����" : "�ߤW"%></td>
		<td><%=rsvtVO.getRsvtToSeat() == 1 ? "���J�y" : "�w�J�y"%></td>
		<td><%=rsvtVO.getRsvtDate()%></td>
		<td><%=rsvtVO.getRsvtMealDate() == null ? "�|�����\" : sdFormat.format(rsvtVO.getRsvtMealDate()) %></td>
	</tr>
</table>

</body>
</html>