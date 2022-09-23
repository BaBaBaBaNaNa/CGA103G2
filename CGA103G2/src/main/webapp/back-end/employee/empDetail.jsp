<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>

<%
EmpVO empVO = (EmpVO) request.getAttribute("empVO");
%>

<jsp:useBean id="list" scope="session" type="java.util.List<EmpVO>" />

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>異鄉人-義式餐酒館-管理中心</title>

<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="../../back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="../../back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Page Specific CSS (Slick Slider.css) -->
<link href="../../back-assets/css/slick.css" rel="stylesheet">
<link href="../../back-assets/css/datatables.min.css" rel="stylesheet">
<!-- Costic styles -->
<link href="../../back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="../../favicon.ico">

<link href="../../back-assets/css/empDetailStyle.css" rel="stylesheet">
<!-- GoTop -->
<link href="${pageContext.request.contextPath}/back-assets/css//gotop/GoTop.css" rel="stylesheet">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">

	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->

	<div class="ms-aside-overlay ms-overlay-left ms-toggler" data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler" data-target="#ms-recent-activity" data-toggle="slideRight"></div>

	<!-- ----- ----- ----- 最左邊的 選擇列 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/LeftSideBar.file"%>
	<!-- ----- ----- ----- 最左邊的 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main class="body-content"padding-right: 0 px;>
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->

		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pl-0">
				<li class="breadcrumb-item"><a href="../../back-end/index/BackIndex.jsp"><i
						class="material-icons">home</i>首頁</a></li>
				<li class="breadcrumb-item">員工管理</li>
				<li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/back-end/employee/EmpServlet.do?action=getAll">查看員工資料</a></li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<h2>查看員工訊息</h2>
		<jsp:useBean id="jobSvc" scope="page" class="com.job.model.JobService" />
		<hr>
		<div style="text-align: center;">
    		<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/back-end/employee/EmpServlet.do" >
        		<b>輸入員工編號 (如1):</b>
        		<input type="text" name="empID" value="${param.empID}"><font color=red>${errorMsgs.empID}</font>
        		<input type="hidden" name="action" value="getOne_For_Display">
        		<input type="submit" value="送出">
    		</FORM>
    	</div>
  		<hr>
  		<div style="text-align: center;">
  			<div style= "margin:0 auto;">
  			<div>
  		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/employee/EmpServlet.do" name="form1">
        	<b><font color=blue>複合查詢:</font></b> <br>
        	<b>輸入員工編號:</b>
        	<input type="text" name="empID"><br>
           
       		<b>輸入員工姓名:</b>
      		<input type="text" name="empName"><br>
       
       		<b>輸入員工職位:</b>
       		<select size="1" name="jobID" >
          		<option value="">
         		<c:forEach var="jobVO" items="${jobSvc.all}" > 
          			<option value="${jobVO.jobID}">${jobVO.jobName}
         		</c:forEach>   
       		</select><br>
           
       		<b>雇用日期:</b>
	   		<input name="empHiredate" id="f_date1" type="text">
		        
        	<input type="submit" value="送出">
        	<input type="hidden" name="action" value="getEmpListCompositeQuery">
        	</div>
     	</FORM>
     	</div> 
     	</div>
  		<hr>
		<table class = "dataTable table-striped thead-primary" style="width: 95%">
			<tr>
				<th style="width: 5% ; ">員工<br>編號</th>
				<th style="width: 7% ;">員工<br>姓名</th>
				<th style="width: 10% ;">帳號</th>
				<th style="width: 10% ;">密碼</th>
				<th style="width: 5% ;">權限</th>
				<th style="width: 10% ;">員工<br>電話</th>
				<th>員工<br>地址</th>
				<th style="width: 10% ;">員工<br>職位</th>
				<th style="width: 10% ;">員工<br>入職日期</th>
				<th style="width: 5% ;">修改</th>
				<th style="width: 5% ; display: none">刪除</th>
			</tr>
			<div style="text-align: center">
			<%@ include file="../../back-end/tool/page1.file"%>
			</div>
			<c:forEach var="empVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
				<tr>
					<td style="width: 5% ;">${empVO.empID}</td>
					<td style="width: 7%">${empVO.empName}</td>
					<td style="width: 10%">${empVO.empAccount}</td>
					<td style="width: 10%">${empVO.empPassword}</td>
					<td style="width: 5%">${(empVO.empPermission == "0") ? "正常" : "停權"}</td>
					<td style="width: 10%">${empVO.empPhone}</td>
					<td>${empVO.empAddress}</td>
					<td style="width: 10% ; ">${empVO.jobVO.jobName}</td>
<%-- 					<td>${empVO.emp_job}-[${empVO.jobVO.job_name}]</td> --%>
					<td style="width: 10% ; ">${empVO.empHiredate}</td>
					<td style="width: 5% ; ">
						<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/back-end/employee/EmpServlet.do" style="margin-bottom: 0px;">
							<input type="submit" value="修改"> <input type="hidden" name="empID" value="${empVO.empID}"> <input type="hidden" name="action" value="getOne_For_Update">
						</FORM>
					</td>
					<td style="width: 5% ; height:100px ; display: none">
						<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/back-end/employee/EmpServlet.do" style="margin-bottom: 0px;">
<!-- 							        "submit" -->
							<input type="hidden" value="刪除" disabled="disabled">
							<input type="hidden" name="empID" value="${empVO.empID}" >
							<input type="hidden" name="action" value="delete">
						</FORM>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div style="text-align: center;">
		<%@ include file="../../back-end/tool/page2.file"%>
		</div>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
		<!-- ----- ----- -----   按鈕-回到網頁最上面 start ----- ----- ----- -->
		<button type="button" id="GoTop" class="GoTop-arrow"></button>
		<!-- ----- ----- -----   按鈕-回到網頁最上面 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<!-- Global Required Scripts Start -->
	<script src="../../back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="../../back-assets/js/popper.min.js"></script>
	<script src="../../back-assets/js/bootstrap.min.js"></script>
	<script src="../../back-assets/js/perfect-scrollbar.js"></script>
	<script src="../../back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="../../back-assets/js/d3.v3.min.js"></script>
	<script src="../../back-assets/js/topojson.v1.min.js"></script>
	<script src="../../back-assets/js/datatables.min.js"></script>
	<script src="../../back-assets/js/data-tables.js"></script>
	<!-- Page Specific Scripts Finish -->
	<!-- Costic core JavaScript -->
	<script src="../../back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="../../back-assets/js/settings.js"></script>
	<!-- GoTop -->
	<script src="${pageContext.request.contextPath}/back-assets/js/gotop/GoTop.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
	
	<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
	<%
	java.sql.Date empHiredate = null;
	try {
		empHiredate = empVO.getEmpHiredate();
	} catch (Exception e) {
		empHiredate = new java.sql.Date(System.currentTimeMillis());
	}
	%>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.datetimepicker.css" />
	<script src="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.datetimepicker.full.js"></script>

	<style>
		.xdsoft_datetimepicker .xdsoft_datepicker {
			width: 300px; /* width:  300px; */
		}

		.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
			height: 151px; /* height:  151px; */
		}
	</style>

	<script type="text/javascript">
    $.datetimepicker.setLocale('zh');
    $('#f_date1').datetimepicker({
       theme: '',              //theme: 'dark',
       timepicker:false,       //timepicker:true,
       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
       format:'Y-m-d',         //format:'Y-m-d H:i:s',
	   value: '<%=empHiredate%>', // value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
	</script>
</body>

</html>