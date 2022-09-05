<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Meals: Home</title>

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
   <tr><td><h3>IBM Meals: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Meals: Home</p>

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
  <li><a href='listAllMeals.jsp'>List</a> all MealsCategory  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="Meals.do" >
        <b>輸入菜系編號 (如1):</b>
        <input type="text" name="mealsID">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="MealsSvc" scope="page" class="com.meals.model.MealsService"/>
   
  <li>
     <FORM METHOD="post" ACTION="Meals.do" >
       <b>選擇菜系編號:</b> 
       <select size="1" name="mealsID">
         <c:forEach var="MealsVO" items="${MealsSvc.all}" > 
          <option value="${MealsVO.mealsID}">${MealsVO.mealsCategoryID}
         </c:forEach>
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM> 
  </li>  
  
  <li>
     <FORM METHOD="post" ACTION="Meals.do" >
       <b>選擇菜色名稱:</b>
       <select size="1" name="mealsID">
         <c:forEach var="MealsVO" items="${MealsSvc.all}" > 
          <option value="${MealsVO.mealsID}">${MealsVO.mealsID}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>菜系管理</h3>

<ul>
  <li><a href='addMeals.jsp'>Add</a> a new MealsCategory.</li>
</ul>

</body>
</html>