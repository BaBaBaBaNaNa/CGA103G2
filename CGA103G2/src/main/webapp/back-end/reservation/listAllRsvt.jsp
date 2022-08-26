<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*"%>
<%@ page import="com.rsvt.model.*"%>
<%@ page import="java.text.SimpleDateFormat" %>>

<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
RsvtService rsvtSvc = new RsvtService();
List<RsvtVO> list = rsvtSvc.getAll();
pageContext.setAttribute("list", list);
SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // ����榡�ഫ
String mdString = "�����\";
%>


<html>
<head>
<title>�Ҧ��q���� - listAllRsvt.jsp</title>

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

	<h4>�����m�߱ĥ� EL ���g�k����:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>�Ҧ��q���� - listAllRsvt.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
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
				<td>${rsvtVO.rsvtPeriod == 0 ? "����" : "�ߤW"}</td>
				<td>${rsvtVO.rsvtToSeat == 1 ? "���J�y" : "�w�J�y"}</td>
				<td>${rsvtVO.rsvtDate}</td>
				<td><fmt:formatDate value="${rsvtVO.rsvtMealDate == null ? '' : rsvtVO.rsvtMealDate}" type="both"/></td>
				
				<td>
					<FORM METHOD="post"
						ACTION="RsvtServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="�ק�"> <input type="hidden"
							name="rsvtId" value="${rsvtVO.rsvtId}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="RsvtServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="�R��"> <input type="hidden"
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