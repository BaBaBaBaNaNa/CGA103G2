<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>
<%@page import="com.botqa.model.*"%>
<%  
	BotqaService botqaSve = new BotqaService();
 	List<BotqaVO> list=botqaSve.getAll();
 	pageContext.setAttribute("botqaListData",list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>所有員工資料 - listAllEmp.jsp</title>

<%@ include file="included-fragment.file" %>
<style type="text/css">
    
    table {
      /* width: 1000px; */
	  background-color: white;
	  margin-top: 12px;
	  margin-bottom: 5px;
    }
    table, th, td {
      border: 1px solid #CCCCFF;
    }
    th, td {
      padding: 5px;
      text-align: center;
      width: 100px;
    }
	.center {
        margin-left: auto;
        margin-right: auto;
    }
    span {
		display: inline-block;
		width: 280px;
		text-align: left;
		font-weight: bold;
	}
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>所有員工資料 - listAllBotqa.jsp</h2>
		 <h3><a class="navbar-brand" href="<%=request.getContextPath()%>/back-end/botqa/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/resources/images/back1.gif">回查詢頁${success}</a></h3></div>
</nav>

<table class="center">
	<tr>
        <!-- <th>計數</th> -->
		<th>機器人編號</th>
		<th>回應名稱</th>
		<th>回應內容</th>

	</tr>
    <%@ include file="page1.file" %>
	<c:forEach var="botqaVO" items="${botqaListData}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" varStatus="s">
		
		<tr>
            <%-- <td>${s.count}</td> --%>
			<td>${botqaVO.keywordID}</td>
			<td>${botqaVO.keywordName}</td>
			<td>${botqaVO.keywordContext}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/botqa/Botqa.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="keywordID" value="${botqaVO.keywordID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/botqa/Botqa.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="keywordID" value="${botqaVO.keywordID}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
