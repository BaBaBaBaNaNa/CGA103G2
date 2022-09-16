<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title> news: Home</title>

<style>
  table#table-1 {
	width: 570px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 100px;
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
   <tr><td><h3>IBM news: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM news: Home</p>

<h3>������Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllNews.jsp'>List</a> all News.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="news.do" >
        <b>��ܮ����s�� (�p:1):</b>
        <input type="text" name="newsID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="newsSvc" scope="page" class="com.news.model.NewsService"/>
   
  <li>
     <FORM METHOD="post" ACTION="news.do" >
       <b>��ܽs��:</b>
       <select size="1" name="newsID">
         <c:forEach var="newsVO" items="${newsSvc.all}" > 
          <option value="${newsVO.newsID}">${newsVO.empID}
         </c:forEach>
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
</ul>



<ul>
  <li><a href='addNews.jsp'>Add</a> a new News.</li>
</ul>

</body>
</html>