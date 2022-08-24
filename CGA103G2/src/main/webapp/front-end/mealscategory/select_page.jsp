<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM MealsCategory: Home</title>

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
   <tr><td><h3>IBM MealsCategory: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM MealsCategory: Home</p>

<h3>��Ƭd��:</h3>
	
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
  <li><a href='listAllEmp.jsp'>List</a> all MealsCategory  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="MealsCategory.do" >
        <b>��J���u�s�� (�p7001):</b>
        <input type="text" name="MealsCategoryId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="MealsCategorySvc" scope="page" class="com.MealsCategory.model.MealsCategoryService"/>
   
  <li>
     <FORM METHOD="post" ACTION="MealsCategory.do" >
       <b>��ܭ��u�s��:</b> 
       <select size="1" name="MealsCategoryId">
         <c:forEach var="MealsCategoryVO" items="${MealsCategorySvc.all}" > 
          <option value="${MealsCategoryVO.mealsCategoryId}">${MealsCategoryVO.mealsCategoryId}
         </c:forEach>
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM> 
  </li>  
  
  <li>
<!--      <FORM METHOD="post" ACTION="MealsCategory.do" > -->
<!--        <b>��ܭ��u�m�W:</b> -->
<!--        <select size="1" name="MealsCategoryId"> -->
<%--          <c:forEach var="MealsCategoryVO" items="${MealsCategorySvc.all}" >  --%>
<%--           <option value="${MealsCategoryVO.Meals_Category_Id}">${MealsCategoryVO.Mals_Category} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="�e�X"> -->
<!--      </FORM> -->
  </li>
</ul>


<h3>���u�޲z</h3>

<ul>
  <li><a href='addEmp.jsp'>Add</a> a new MealsCategory.</li>
</ul>

</body>
</html>