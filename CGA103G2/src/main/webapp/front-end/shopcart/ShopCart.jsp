<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.shopcart.controller.ShopCartServlet"%>
<%@ page import="com.shopcart.model.*"%>

<!doctype html>
<html lang="zh-tw">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

<title>義鄉人 - 義式餐酒館 - 訂單 - 緯育 中壢Java班 CGA_103 第二組</title>

<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap" rel="stylesheet">

<link href="../../front-assets/css/navbar.css" rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap.min.css" rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap-icons.css" rel="stylesheet">

<link href="../../front-assets/css/tooplate-crispy-kitchen.css" rel="stylesheet">

<link href="../../front-assets/css/datepicker.css" rel="stylesheet">

<!-- <link href="../../front-assets/css/shoppingcart/ShoppingCart.css" rel="stylesheet"> -->

<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
<style>
.show-cart li {
	display: flex;
}

.card {
	margin-bottom: 20px;
}

.card-img-top {
	width: 200px;
	height: 200px;
	align-self: center;
}
</style>

</head>

<body>
	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/UpSideBar.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main>
		<!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
		<header> </header>
		<!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->

		<!-- ----- ----- ----- 中間內容 start ----- ----- ----- -->

		<section class="about section-padding bg-white">
			<hr>
<!-- 			<form METHOD="post" ACTION="ShopCartServlet.do" name="form1"> -->
				<div class="modal-fade" id="cart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<!-- 						<div class="modal-dialog modal-dialog-centered modal-xl"> -->
					<div class="modal-dialog modal-lg" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">購物車</h5>
								<br>
								<div id="checkboxGroup">
									<ul>
										<li style="text-align:right"><input type="checkbox" class="checkbox" value="0"/>外帶</li>
										<li style="text-align:right"><input type="checkbox" class="checkbox" value="1"/>外送</li>
										<li style="text-align:right"><input type="checkbox" class="checkbox" value="2"/>內用</li>
									</ul>
									輸入外送地址<input style="width:300px" type="text" name="aa" id="ordtext1" disabled="disabled">
								</div>
							</div>
							<div class="modal-body">
								<table class="show-cart table">

								</table>
								<div>
									總金額: $<span class="total-cart"></span>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="window.location.href='${pageContext.request.contextPath}/back-end/meals/MealsServlet.do?action=getAll1'">回到菜單</button>
<!-- 								<input type="hidden" name="action" value="insert"> -->
<!-- 								<input type="submit" class="btn btn-primary" id="submit2" value="送出訂單" style="background-color: #0d6efd;"> -->
<!-- 								<button type="button" class="btn btn-primary" id="submit2"onclick="window.location.href='../../front-end/shopcart/ShopCart.jsp'">送出訂單</button> -->
								<button type="button" class="btn btn-primary" id="submit2">送出訂單</button>
							</div>
						</div>
					</div>
				</div>
<!-- 			</form> -->
			<hr>
		</section>
		<!-- ----- ----- ----- 中間內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

    <!-- ----- ----- ----- 頁面 底部 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/PageFooter.file"%>
    <!-- ----- ----- ----- 頁面 底部 end ----- ----- ----- -->

	<!-- ----- ----- ----- 跳出預先訂位頁面 start ----- ----- ----- -->
		<%@ include file="../../front-end/tool/RsvtButton.file"%>
	<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="../../front-assets/js/jquery.min.js"></script>
	<script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
	<script src="../../front-assets/js/custom.js"></script>

	<script src="../../front-assets/js/shoppingcart/ShoppingCart.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
			<script src="<%=request.getContextPath()%>/front-assets/js/bootstrap-datepicker.zh-TW.min.js"></script>

			<script>
				var dp1 = document.getElementById('dp1');
				var period = document.getElementById('period');
				const dateUrl = '/CGA103G2/back-end/reservation_ctrl/Date';
				const periodUrl = '/CGA103G2/back-end/reservation_ctrl/Period';
				const arr = [];
				fetch(dateUrl,{
					headers: {
						'Content-Type': 'application/json'
					},
				})
				.then(res => res.json())
					.then(list => {
						console.log(list);
						for(let key of list){
							arr.push(key);
						}
					})
							console.log(arr);
			
				var disabledDates = arr;
				$('.datepicker').datepicker({
					autoclose: true, // 選擇後自動關閉日期選擇器
					language: 'zh-TW', // 語言切換 中文
					format: 'yyyy-mm-dd', // 日期格式
					todayHighlight: true, // 高亮"當天日期"
					toggleActive: true, // 	點擊選擇，再次點擊取消
					startDate: new Date(), //開放初始日期 ex=> 
					// endDate:new Date(),
					// clearBtn: true, //顯示清除按鈕
					daysOfWeekDisabled: [3], //每周隱藏的第幾天  0為周日6為星期六
					datesDisabled: arr
				});
				function checkPeriod(){
					fetch(periodUrl,{
						method: 'post',
						headers: {
							'Content-Type': 'application/json'
						},
						body: JSON.stringify({
							rsvtCtrlDate : dp1.value,
						})
					})
					.then(res => res.json())
					.then(periodList => {
						console.log(periodList);
						period.textContent = "";
						if(periodList.length != 0){
							period.textContent = "";
							const plsSelect = document.createElement('option');
							plsSelect.textContent = "請選擇時段";
							plsSelect.selected = true;
							plsSelect.disabled = true;
							period.append(plsSelect);
							let n = 0;
							for(let i = 0; i < periodList.length; i++){
								if(i == n){
									const option = document.createElement('option');
									option.value = periodList[i];
									switch (periodList[i]){
										case 0 :{
											option.textContent = '中午';
											break;
										}
										case 1 :{
											option.textContent = '晚上';
											break;
										}
										default :{
											option.textContent = '未有時段';
										}
									}
									period.append(option);

								}
							}
						}else{
							const option = document.createElement('option');
							option.textContent = '未有時段';
							period.append(option);
						}
					})
				}
			</script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->

</body>

</html>