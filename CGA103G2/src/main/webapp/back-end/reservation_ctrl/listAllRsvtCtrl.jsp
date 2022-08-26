<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="com.rsvtCtrl.model.*"%>

<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
List<RsvtCtrlVO> list = rsvtCtrlSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>�Ҧ���� - listAllRsvtCtrl.jsp</title>

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
				<h3>�Ҧ��q���� - listAllRsvtCtrl.jsp</h3>
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
			<th>��l�W��</th>
			<th>�w�w�q���</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="rsvtCtrlVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${rsvtCtrlVO.rsvtCtrlId}</td>
				<td>${rsvtCtrlVO.tableTypeId}</td>
				<td>${rsvtCtrlVO.rsvtCtrlOpen == 0 ? "�}��" : "���}��"}</td>
				<td>${rsvtCtrlVO.rsvtCtrlDate}</td>
				<td>${rsvtCtrlVO.rsvtCtrlOpen == 0 ? "����" : "�ߤW"}</td>
				<td>${rsvtCtrlVO.rsvtCtrlMax}</td>
				<td>${rsvtCtrlVO.rsvtCtrlNumber}</td>
				
				<td>
					<FORM METHOD="post"
						ACTION="RsvtCtrlServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="�ק�"> <input type="hidden"
							name="rsvtCtrlId" value="${rsvtCtrlVO.rsvtCtrlId}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="RsvtCtrlServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="�R��"> <input type="hidden"
							name="rsvtCtrlId" value="${rsvtCtrlVO.rsvtCtrlId}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>