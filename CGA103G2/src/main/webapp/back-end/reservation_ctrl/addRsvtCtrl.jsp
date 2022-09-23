<%@ page import="java.sql.Date"%>
<%@ page import="com.rsvtCtrl.model.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
RsvtCtrlVO rsvtCtrlVO = (RsvtCtrlVO) request.getAttribute("rsvtCtrlVO");
%>
<%=rsvtCtrlVO == null%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<link rel="stylesheet" href="../../back-assets/css/rsvt.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="../../back-assets/js/bootstrap-datepicker.zh-TW.min.js"></script>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color: red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color: red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
<body>
<FORM METHOD="post" ACTION="RsvtCtrlServlet" name="form1">
	<table class="table">
		<tr>
			<td>設定開放狀態:</td>
			<td><select name="rsvtCtrlOpen">
					<option value="0" selected>開放</option>
					<option value="1">不開放</option>
			</select></td>
		</tr>
                   
		<tr>
			<td>設定訂位日期:</td>
			<td><input name="rsvtCtrlDate" type="text" placeholder="請選擇日期"
				autoComplete="off" class="datepicker mr-2 form-control" size="45" id="f_date1"></td>
		</tr>
		<tr>
			<td>設定訂位時段:</td>
			<td><select name="rsvtCtrlPeriod">
					<option value="0">中午</option>
					<option value="1">晚上</option>
			</select></td>
		</tr>
		<tr>
			<td>設定桌位上限:</td>
			<td><input type="TEXT" name="rsvtCtrlMax" size="45" value="" /></td>
		</tr>
		<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
		<!-- 	<tr> -->
		<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
		<!-- 		<td><select size="1" name="deptno"> -->
		<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
		<%-- 				<option value="${deptVO.deptno}" ${(rsvtCtrlVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
		<%-- 			</c:forEach> --%>
		<!-- 		</select></td> -->
		<!-- 	</tr> -->

	</table>
	<br> <input type="hidden" name="action" value="insert"> <input
		type="submit" value="送出新增">
</FORM>
</body>

<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
java.sql.Date rsvtCtrlDate = null;
try {
	rsvtCtrlDate = rsvtCtrlVO.getRsvtCtrlDate();
} catch (Exception e) {
	rsvtCtrlDate = new java.sql.Date(System.currentTimeMillis());
}
RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
List<RsvtCtrlVO> list = rsvtCtrlSvc.getAll();
List<String> lists = new ArrayList<>();

String DateString = "";
for (RsvtCtrlVO all : list) {
	//取得不開放的日期
	if (all.getRsvtCtrlOpen() == 1) {
		DateString += "'" + all.getRsvtCtrlDate() + "'" + ",";
	}
}
%>
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-assets/css/jquery.datetimepicker.css" /> --%>
<%-- <script src="<%=request.getContextPath()%>/back-assets/js/jquery.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/back-assets/js/jquery.datetimepicker.full.js"></script> --%>
<script>
<%-- 	var a = [<%=DateString%>] --%>
// 	console.log(a);
// 	  $('#f_date1').on("focusin","input[type=date]", function () {
// 	        $(this).datepicker({
// 	        	 autoclose: true, // 選擇後自動關閉日期選擇器
// 	             language: 'zh-TW', // 語言切換 中文
// 	             format: 'yyyy-mm-dd', // 日期格式
// 	             todayHighlight: true, // 高亮"當天日期"
// 	             toggleActive: true, // 	點擊選擇，再次點擊取消
// 	             startDate: new Date(), //開放初始日期 ex=> 
// 	             // endDate:new Date(),
// 	             // clearBtn: true, //顯示清除按鈕
// 	             daysOfWeekDisabled: [3],  //每周隱藏的第幾天  0為周日6為星期六
// 	             datesDisabled: [ // 特殊日期禁用
<%-- 	                 <%=DateString%> --%>
// 	             ],
// 	        });
// 	    });
	 $('.datepicker').datepicker({
         autoclose: true, // 選擇後自動關閉日期選擇器
         language: 'zh-TW', // 語言切換 中文
         format: 'yyyy-mm-dd', // 日期格式
         todayHighlight: true, // 高亮"當天日期"
         toggleActive: true, // 	點擊選擇，再次點擊取消
         startDate: new Date(), //開放初始日期 ex=> 
         // endDate:new Date(),
         // clearBtn: true, //顯示清除按鈕
         daysOfWeekDisabled: [3],  //每周隱藏的第幾天  0為周日6為星期六
         datesDisabled: [ // 特殊日期禁用
             <%=DateString%>
         ],
     });
// 	$.datetimepicker.setLocale('zh');
//     $('#f_date1').datetimepicker({
//        theme: '',              //theme: 'dark',
//        timepicker:false,       //timepicker:true,
//        step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
//        format:'Y-m-d',         //format:'Y-m-d H:i:s',
<%-- 	   value: '<%=rsvtCtrlDate%>', --%>
// 		minDate : 0,
// 	value:   new Date(),
//     autoclose: true, // 選擇後自動關閉日期選擇器
//     language: 'zh-TW', // 語言切換 中文
//     todayHighlight: true, // 高亮"當天日期"
//     toggleActive: true, // 	點擊選擇，再次點擊取消
// 	startDate: new Date(), //開放初始日期 ex=> 
//     // endDate:new Date(),
//     // clearBtn: true, //顯示清除按鈕
//     daysOfWeekDisabled: [3],  //每周隱藏的第幾天  0為周日6為星期六
//     disabledDates: [ // 特殊日期禁用
<%--              <%=DateString%> --%>
//     ],
// 	// 去除特定不含
// 	//startDate:	            '2017/07/10',  // 起始日
// 	//minDate:               '-1970-01-01', // 去除今日(不含)之前
// 	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
// 	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	//      1.以下為某一天之前的日期無法選擇
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

	//      2.以下為某一天之後的日期無法選擇
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

	//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
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
