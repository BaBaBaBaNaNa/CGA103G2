<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.rsvtCtrl.model.*"%>
<%@ page import="java.text.SimpleDateFormat"%>>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
RsvtCtrlVO rsvtCtrlVO = (RsvtCtrlVO) request.getAttribute("rsvtCtrlVO"); //RsvtServlet.java(Concroller), �s�Jreq��rsvtVO����
%>

<html>
<head>
<title>�q���� - listOneRsvtCtrl.jsp</title>

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
		<tr>
			<td>
				<h3>�q���� - ListOneRsvt.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>�q�챱��s��</th>
			<th>�૬�s��</th>
			<th>�q�챱��}��</th>
			<th>�q�챱����</th>
			<th>�q�챱��ɬq</th>
			<th>�C�ɬq��l�W��</th>
			<th>�w�w�q���</th>
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