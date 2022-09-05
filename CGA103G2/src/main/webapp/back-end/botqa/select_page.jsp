<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>機器人回答資料管理 - select_page.jsp</title>

<%@ include file="included-fragment.file" %>
<style type="text/css">
	
	button {
		padding: 5px;
	}
	form {
		display: table;
	}
	form div {
		display: table-row;
	}
	label, input, span, select {
		display: table-cell;
		margin: 2px;
		text-align: left;		
	}
	input[type=text], input[type=password], select, textarea {
		width: 200px;
		margin: 2px;
	}
	form div div {
		display: table-cell;
	}
	.center {
        margin-left: auto;
        margin-right: auto;
    }
    span {
		display: inline-block;
		width: 150px;
		text-align: left;
		font-weight: bold;
	}
	div.a {
        display: inline-block;
        width: 50%;
        height: auto;
        padding: 5px;
        border: 0px solid blue;    
        background-color: white; 
    }
    div.b {
        display: inline-block;
        width: 45%;
        height: auto;
        padding: 5px;
        border: 1px solid blue;    
        background-color: white;
    }
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>機器人資料管理 - select_page.jsp</h2>
		 <h3><a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp"><img src="<%=request.getContextPath()%>/resources/images/back1.gif">回index.jsp</a></h3></div>
</nav>

	<h4><span>資料查詢:</span></h4>

	<div></div><br>
	<div class="a">
	  <ul>
		<li><h5><a href='<%=request.getContextPath()%>/botqa/listAllBotqa.jsp'>List</a> all Botqa. <br><br></h5></li>

        <jsp:useBean id="botqaSvc" scope="page" class="com.botqa.model.BotqaService" />

		<li><form method="post" action="<%=request.getContextPath()%>/botqa/Botqa.do">
				選擇機器人編號:
				<select size="1" name="keywordID">
                  <c:forEach var="botqaVO" items="${botqaSvc.all}" > 
                    <option value="${botqaVO.keywordID}">${botqaVO.keywordID}
                  </c:forEach>   
                </select>
                <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</form><br>
		</li> 

		<li><form method="post" action="<%=request.getContextPath()%>/botqa/Botqqa.do">
				選擇回應名稱:
				<select size="1" name="keywordName">
                  <c:forEach var="botqaVO" items="${botqaSvc.all}" > 
                    <option value="${botqaVO.keywordID}">${botqaVO.keywordName}
                  </c:forEach>   
                </select>
                <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</form><br>
		</li>
      </ul>

      <h4><span>機器人管理</span></h4>
	  <ul>
		  <li><h5><a href='addBotqa.jsp'>Add</a> a new Botqa.</h5></li>
	  </ul>
	</div>

    <c:if test="${getOne_For_Display}"><!-- 旗標getOne_For_Display見EmpServlet.java的第74行 -->
         <div class="b">
	      <%@ include file="listOneBotqa-div-fragment.file" %> <%-- 或(不好) <jsp:include page="listOneEmp.jsp" /> --%>
	     </div>  
    </c:if>

</body>
</html>