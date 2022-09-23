<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="com.rsvtCtrl.model.*"%>

<%
RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
List<RsvtCtrlVO> list = rsvtCtrlSvc.getAll();
pageContext.setAttribute("list", list);
%>
<style>
.table th,.table th{
	text-align: center;
	background-color: white;
}
</style>
<table class="table">
	<tr>
		<th>訂位控制編號</th>
		<th>桌型編號</th>
		<th>訂位控制開放</th>
		<th>訂位控制日期</th>
		<th>訂位控制時段</th>
		<th>桌子上限</th>
		<th>已預訂桌數</th>
		<th></th>
		<th></th>
	</tr>
	<%@ include file="page1.file"%>
	<c:forEach var="rsvtCtrlVO" items="${list}" begin="<%=pageIndex%>"
		end="<%=pageIndex+rowsPerPage-1%>">

		<tr>
			<td>${rsvtCtrlVO.rsvtCtrlId}</td>
			<td>${rsvtCtrlVO.tableTypeId}</td>
			<td>${rsvtCtrlVO.rsvtCtrlOpen == 0 ? "開放" : "不開放"}</td>
			<td>${rsvtCtrlVO.rsvtCtrlDate}</td>
			<td>${rsvtCtrlVO.rsvtCtrlOpen == 0 ? "中午" : "晚上"}</td>
			<td>${rsvtCtrlVO.rsvtCtrlMax}</td>
			<td>${rsvtCtrlVO.rsvtCtrlNumber}</td>

			<td>
				<FORM METHOD="post" ACTION="RsvtCtrlServlet"
					style="margin-bottom: 0px;">
					<input type="submit" value="修改" class="input_btn"> <input type="hidden"
						name="rsvtCtrlId" value="${rsvtCtrlVO.rsvtCtrlId}"> <input
						type="hidden" name="action" value="getOne_For_Update">
				</FORM>
			</td>
			<td>
				<FORM METHOD="post" ACTION="RsvtCtrlServlet"
					style="margin-bottom: 0px;">
					<input type="submit" value="刪除" class="input_btn"> <input type="hidden"
						name="rsvtCtrlId" value="${rsvtCtrlVO.rsvtCtrlId}"> <input
						type="hidden" name="action" value="delete">
				</FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file"%>