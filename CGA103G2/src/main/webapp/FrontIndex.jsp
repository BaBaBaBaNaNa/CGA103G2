<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!doctype html>
	<html lang="zh-tw">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<meta name="description" content="">
		<meta name="author" content="">

		<title>義鄉人 - 義式餐酒館 - 首頁 - 緯育 中壢Java班 CGA_103 第二組</title>

		<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->
		<link rel="preconnect" href="https://fonts.googleapis.com">

		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

		<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap"
			rel="stylesheet">

		<link href="front-assets/bootstrap_css/bootstrap.min.css" rel="stylesheet">

		<link href="front-assets/bootstrap_css/bootstrap-icons.css" rel="stylesheet">

		<link href="front-assets/css/tooplate-crispy-kitchen.css" rel="stylesheet">

		<link href="front-assets/css/navbar.css" rel="stylesheet">
		<link href="front-assets/css/datepicker.css" rel="stylesheet">
		<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
	</head>
	<style>
	
	</style>
	<body>

		<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
		<%@ include file="front-end/tool/UpSideBar.file" %>
			<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

			<!-- ----- ----- ----- 頁面 中間內容 start ----- ----- ----- -->
			<main>

				<section class="hero">
					<div class="container">
						<div class="row">

							<div class="col-lg-5 col-12 m-auto">
								<div class="heroText">

									<h1 class="text-white mb-lg-5 mb-3">Delicious Steaks</h1>

									<div class="c-reviews my-3 d-flex flex-wrap align-items-center">
										<div class="d-flex flex-wrap align-items-center">
											<h4 class="text-white mb-0 me-3">4.4/5</h4>

											<div class="reviews-stars">
												<i class="bi-star-fill reviews-icon"></i> <i
													class="bi-star-fill reviews-icon"></i> <i
													class="bi-star-fill reviews-icon"></i> <i
													class="bi-star-fill reviews-icon"></i> <i
													class="bi-star reviews-icon"></i>
											</div>
										</div>

										<p class="text-white w-100">
											From <strong>1,206+</strong> Customer Reviews
										</p>
									</div>
								</div>
							</div>

							<div class="col-lg-7 col-12">
								<div id="carouselExampleCaptions" class="carousel carousel-fade hero-carousel slide"
									data-bs-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item active">
											<div class="carousel-image-wrap">
												<img src="front-assets/images/slide/jay-wennington-N_Y88TWmGwA-unsplash.jpg"
													class="img-fluid carousel-image" alt="">
											</div>

											<div class="carousel-caption">
												<span class="text-white"> <i class="bi-geo-alt me-2"></i>
													Manhattan, New York
												</span>

												<h4 class="hero-text">Fine Dining Restaurant</h4>
											</div>
										</div>

										<div class="carousel-item">
											<div class="carousel-image-wrap">
												<img src="front-assets/images/slide/jason-leung-O67LZfeyYBk-unsplash.jpg"
													class="img-fluid carousel-image" alt="">
											</div>

											<div class="carousel-caption">
												<div class="d-flex align-items-center">
													<h4 class="hero-text">Steak</h4>

													<span class="price-tag ms-4"><small>$</small>26.50</span>
												</div>

												<div class="d-flex flex-wrap align-items-center">
													<h5 class="reviews-text mb-0 me-3">3.8/5</h5>

													<div class="reviews-stars">
														<i class="bi-star-fill reviews-icon"></i> <i
															class="bi-star-fill reviews-icon"></i> <i
															class="bi-star-fill reviews-icon"></i> <i
															class="bi-star reviews-icon"></i> <i
															class="bi-star reviews-icon"></i>
													</div>
												</div>
											</div>
										</div>

										<div class="carousel-item">
											<div class="carousel-image-wrap">
												<img src="front-assets/images/slide/ivan-torres-MQUqbmszGGM-unsplash.jpg"
													class="img-fluid carousel-image" alt="">
											</div>

											<div class="carousel-caption">
												<div class="d-flex align-items-center">
													<h4 class="hero-text">Sausage Pasta</h4>

													<span class="price-tag ms-4"><small>$</small>18.25</span>
												</div>

												<div class="d-flex flex-wrap align-items-center">
													<h5 class="reviews-text mb-0 me-3">4.2/5</h5>

													<div class="reviews-stars">
														<i class="bi-star-fill reviews-icon"></i> <i
															class="bi-star-fill reviews-icon"></i> <i
															class="bi-star-fill reviews-icon"></i> <i
															class="bi-star-fill reviews-icon"></i> <i
															class="bi-star reviews-icon"></i>
													</div>
												</div>
											</div>
										</div>
									</div>

									<button class="carousel-control-prev" type="button"
										data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
										<span class="carousel-control-prev-icon" aria-hidden="true"></span>
										<span class="visually-hidden">Previous</span>
									</button>

									<button class="carousel-control-next" type="button"
										data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
										<span class="carousel-control-next-icon" aria-hidden="true"></span>
										<span class="visually-hidden">Next</span>
									</button>
								</div>
							</div>

						</div>
					</div>

					<div class="video-wrap">
						<video autoplay="" loop="" muted="" class="custom-video" poster="">
							<source src="front-assets/video/production_ID_3769033.mp4" type="video/mp4">
							Your browser does not support the video tag.
						</video>
					</div>

					<div class="overlay"></div>
				</section>



			</main>
			<!-- ----- ----- ----- 頁面 中間內容 end ----- ----- ----- -->

			<!-- ----- ----- ----- 頁面 底部 start ----- ----- ----- -->
			<footer class="site-footer section-padding">

				<div class="container">

					<div class="row">

						<div class="col-12">
							<h4 class="text-white mb-4 me-5">義式餐酒館</h4>
						</div>

						<div class="col-lg-4 col-md-7 col-xs-12 tooplate-mt30">
							<h6 class="text-white mb-lg-4 mb-3">Location</h6>

							<p>緯育 中壢Java班 CGA_103 第二組</p>

							<a href="https://goo.gl/maps/wcmDpTGaAHn3eWPd7"
								class="custom-btn btn btn-dark mt-2">Directions</a>
						</div>

						<div class="col-lg-4 col-md-5 col-xs-12 tooplate-mt30">
							<h6 class="text-white mb-lg-4 mb-3">Opening Hours</h6>

							<p class="mb-2">Monday - Friday</p>

							<p>17:00 PM - 03:00 AM</p>

							<p>
								Tel: <a href="tel: 03-425-1108" class="tel-link">03-425-1108</a>
							</p>
						</div>

						<div class="col-lg-4 col-md-6 col-xs-12 tooplate-mt30">
							<h6 class="text-white mb-lg-4 mb-3">Social</h6>

							<ul class="social-icon">
								<li><a href="#" class="social-icon-link bi-facebook"></a></li>

								<li><a href="#" class="social-icon-link bi-instagram"></a></li>

								<li><a href="https://twitter.com/search?q=tooplate.com&src=typed_query&f=live"
										target="_blank" class="social-icon-link bi-twitter"></a></li>

								<li><a href="#" class="social-icon-link bi-youtube"></a></li>
							</ul>

							<p class="copyright-text tooplate-mt60">
								Copyright © 2022 中壢Java班 CGA_103 緯育 第二組 Co., Ltd. <br>Design:
								<a rel="nofollow" href="" target="_blank">2022 中壢Java班 CGA_103
									緯育 第二組</a>
							</p>

						</div>

					</div>
					<!-- row ending -->

				</div>
				<!-- container ending -->

			</footer>
			<!-- ----- ----- ----- 頁面 底部 end ----- ----- ----- -->

			<!-- ----- ----- ----- 跳出預先訂位頁面 start ----- ----- ----- -->
			<div class="modal fade" id="BookingModal" tabindex="-1" aria-labelledby="BookingModal" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h3 class="mb-0">預先訂位</h3>

							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>

						<div class="modal-body d-flex flex-column justify-content-center">
							<div class="booking">
								<!-- 	訂位Form在此 -->
								<form class="booking-form row" role="form" action="RsvtFEServlet" method="post"
									id="rsvt_form">
									<div class="col-lg-6 col-12">
										<label for="name" class="form-label">您的名字</label>
										<input type="text" name="customerName" id="name" class="form-control"
											placeholder="請輸入姓名" pattern="[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}" required>
									</div>

									<!-- <div class="col-lg-6 col-12">
                                <label for="email" class="form-label">Email</label>

                                <input type="email" name="email" id="email" pattern="[^ @]*@[^ @]*" class="form-control"
                                    placeholder="your@email.com" required>
                            </div> -->

									<div class="col-lg-6 col-12">
										<label for="phone" class="form-label">電話號碼</label> <input type="telephone"
											name="customerPhone" id="phone" pattern="[0]{1}[9]{1}[0-9]{8}"
											class="form-control" placeholder="請輸入手機" required>
									</div>

									<div class="col-lg-6 col-12">
										<label for="people" class="form-label">訂位人數</label> <input type="text"
											name="rsvtNum" id="people" class="form-control" placeholder="請輸入人數"
											autocomplete="off" pattern="\d{1,2}" maxlength="2" required>
									</div>

									<div class="col-lg-6 col-12">
										<label for="date" class="form-label">日期</label> <input type="text" id="dp1"
											class="datepicker mr-2 form-control" placeholder="選擇日期" name="rsvtDate"
											autocomplete="off" onchange="checkPeriod()"><span style="display: none">*</span>
									</div>

									<div class="col-lg-6 col-12">
										<label for="period" class="form-label">時段</label> <select
											class="form-select form-control" name="rsvtPeriod" id="period" required>
											<option selected disabled>請選擇時段</option>
										</select>
									</div>
									<div class="col-lg-6 col-12"></div>

									<!-- <div class="col-12">
                                <label for="message" class="form-label">其他需求:</label>

                                <textarea class="form-control" rows="4" id="message" name="message"
                                    placeholder=""></textarea>
                            </div> -->

									<div class="col-lg-4 col-12 ms-auto">
										<input type="hidden" name="action" value="insert">

										<button type="submit" class="form-control" id="sub_btn">送出</button>
									</div>
								</form>
							</div>
						</div>

						<div class="modal-footer"></div>

					</div>

				</div>
			</div>
			<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

			<!-- ----- ----- ----- js start ----- ----- ----- -->

			<script src="front-assets/js/jquery.min.js"></script>
			<script src="front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
			<script src="front-assets/js/custom.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
			<script src="front-assets/js/bootstrap-datepicker.zh-TW.min.js"></script>

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
			<!-- ----- ----- ----- js end ----- ----- ----- -->
	</body>

	</html>