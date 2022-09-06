<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.queuer.model.*"%>

<html>
<head>
<title>異鄉人 : Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>異鄉人: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for 異鄉人: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllQueuer.jsp'>List</a> all Queuers.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="queuer.do" >
        <b>輸入候位號碼 (如1):</b>
        <input type="text" name="queuerNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="queuerSvc" scope="page" class="com.queuer.model.QueuerService" />
   
  <li>
     <FORM METHOD="post" ACTION="queuer.do" >
       <b>選擇候位號碼:</b>
       <select size="1" name="queuerNo">
         <c:forEach var="queuerVO" items="${queuerSvc.all}" > 
          <option value="${queuerVO.queuerNo}">${queuerVO.queuerNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
</ul>


<h3>候位管理</h3>

<ul>
  <li><a href='addQueuer.jsp'>Add</a> a new queuer.</li>
</ul>

</body>
</html>