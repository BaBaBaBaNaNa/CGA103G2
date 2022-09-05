<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>員工資料 - listOneEmp.jsp</title>

<%@ include file="included-fragment.file" %>
<style type="text/css">
	
    span {
		display: inline-block;
		width: 150px;
		text-align: left;
		font-weight: bold;
	}
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>機器人個人資料 - listOneBotqa.jsp</h2>
		 <h3><a class="navbar-brand" href="<%=request.getContextPath()%>/botqa/select_page.jsp"><img src="<%=request.getContextPath()%>/resources/images/back1.gif">回查詢頁${success}</a></h3></div>
</nav>

	<div align="center">
		<h3><span>查詢結果 :</span></h3>
		<span>機器人編號:</span><span>${botqaVO.keywordID}</span><br/>
		<span>回應名稱:</span><span>${botqaVO.keywordName}</span><br/>
		<span>回應內容:</span><span>${botqaVO.keywordContext}</span><br/>
	</div>


</body>
</html>