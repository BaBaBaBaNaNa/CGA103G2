<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.orders.model.*"%>

<%
OrdersVO ordersVO = (OrdersVO) request.getAttribute("ordersVO"); //OrdersServlet.java (Concroller) �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>
--<%=ordersVO == null%>--${ordersVO.memID}--

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�q���ƭק� - update_orders_input.jsp</title>

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
	width: 570px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�q���ƭק� - update_orders_input.jsp</h3>
				<h4>
					<a href="order_details.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

	<%-- ���~���C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="orders.do" name="form1">
		<table>
			<tr>
				<td>�q��s��:<font color=red><b>*</b></font></td>
				<td><%=ordersVO.getOrdersID()%></td>
			</tr>
			
			<tr>
				<td>�|��_�s��:</td>
				<td><input type="TEXT" name="memID" size="45"
					value="<%=ordersVO.getMemID()%>" /></td>
			</tr>
			<tr>
				<td>�d�x���u_�s��:</td>
				<td><input type="TEXT" name="empCounterID" size="45"
					value="<%=ordersVO.getEmpCounterID()%>" /></td>
			</tr>
			<tr>
				<td>�~�e���u_�s��:</td>
				<td><input type="TEXT" name="empDeliveryID" size="45"
					value="<%=ordersVO.getEmpDeliveryID()%>" /></td>
			</tr>
			<tr>
				<td>��l_�s��:</td>
				<td><input type="TEXT" name="seatID" size="45"
					value="<%=ordersVO.getSeatID()%>" /></td>
			</tr>
			<tr>
				<td>�q��_����(�~�a �~�e ����):</td>
				<td><select name="ordersType" id="ordersType">
						<option value= "0">�~�a</option>
						<option value= "1">�~�e</option>
						<option value= "2">����</option>
				</select></td>
			</tr>
			<tr>
				<td>�q��_�`���B:</td>
				<td><input type="TEXT" name="ordersAmount" size="45"
					value="<%=ordersVO.getOrdersAmount()%>" /></td>
			</tr>
			<tr>
				<td>�q�檬�A(����, ������, �h�^):</td>
				<td><select name= "ordersStatus" id="ordersStatus">
						<option value="0">����</option>
						<option value="1">������</option>
						<option value="2">�h�^</option>
				</select></td>
			</tr>
			<tr>
				<td>���\�a�I:</td>
				<td><input type="TEXT" name="ordersDestination" size="45"	
					value="<%=ordersVO.getOrdersDestination()%>" /></td>
			</tr>
			<tr>
				<td>���߭q���:</td>
				<td><input name="ordersBuildDate" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>�w�p�s�@��:</td>
				<td><input name="ordersMakeDate" id="f_date2" type="text"></td>
			</tr>


		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="ordersID" value="<%=ordersVO.getOrdersID()%>">
		<input type="submit" value="�e�X�ק�">
	</FORM>
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->


<% 
Timestamp ordersBuildDate = null;
  try {
	  ordersBuildDate = ordersVO.getOrdersBuildDate();
   } catch (Exception e) {
	   ordersBuildDate = new Timestamp(System.currentTimeMillis());
   }
%>
<% 
  Timestamp ordersMakeDate = null;
  try {
	  ordersMakeDate = ordersVO.getOrdersMakeDate();
   } catch (Exception e) {
	   ordersMakeDate = new Timestamp(System.currentTimeMillis());
   }
 %> 

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>

document.getElementById('ordersType').onchange = () => {
	console.log(this);
}
document.getElementById('ordersStatus').onchange = () => {
	console.log(this);
}


$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:true,       //timepicker:true,
   step: 30,                //step: 60 (�o�Otimepicker���w�]���j60����)
   format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
   value: '<%=ordersVO.getOrdersBuildDate()%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
   //startDate:	            '2017/07/10',  // �_�l��
   //minDate:               '-1970-01-01', // �h������(���t)���e
   //maxDate:               '+1970-01-01'  // �h������(���t)����
});


$.datetimepicker.setLocale('zh');
$('#f_date2').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:true,       //timepicker:true,
   step: 30,                //step: 60 (�o�Otimepicker���w�]���j60����)
   format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
   value: '<%=ordersVO.getOrdersMakeDate()%>', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
	//startDate:	            '2017/07/10',  // �_�l��
	//minDate:               '-1970-01-01', // �h������(���t)���e
	});

	// ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����-----------------------------------------------------------

	//      1.�H�U���Y�@�Ѥ��e������L�k���
	//      var somedate1 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      2.�H�U���Y�@�Ѥ��᪺����L�k���
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���)
	//      var somedate1 = new Date('2017-06-15');
	//      var somedate2 = new Date('2017-06-25');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//		             ||
	//		            date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});
</script>
</html>