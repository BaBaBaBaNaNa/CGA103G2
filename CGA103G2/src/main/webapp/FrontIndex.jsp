<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

    <link rel="preconnect" href="https://fonts.gstatic.com" >

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap" rel="stylesheet">

    <link href="front-assets/bootstrap_css/bootstrap.min.css" rel="stylesheet">

    <link href="front-assets/bootstrap_css/bootstrap-icons.css" rel="stylesheet">

    <link href="front-assets/css/tooplate-crispy-kitchen.css" rel="stylesheet">

    <link href="front-assets/css/navbar.css" rel="stylesheet">
    <!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body>

	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="front-end/tool/UpSideBar.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

    <!-- ----- ----- ----- 頁面 中間內容 start ----- ----- ----- -->
    <main>

        <section class="hero">
            <div class="container">
                <div class="row">

                    <div class="col-lg-5 col-12 m-auto">
                        <div class="heroText">

                            <h1 class="text-white mb-lg-5 mb-3">義鄉人</h1>

                            <div class="c-reviews my-3 d-flex flex-wrap align-items-center">
                                <p class="text-white w-100"> <strong>義式餐酒館</strong></p>
                                <p class="text-white w-100"> <strong>since. 2022</strong></p>
                            </div>
                        </div>
                    </div>

                    

                </div>
            </div>
			<br><br><br><br><br><br><br><br><br><br>
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
	<%@ include file="front-end/tool/PageFooter.file"%>
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

                        <form class="booking-form row" role="form" action="#" method="post">
                            <div class="col-lg-6 col-12">
                                <label for="name" class="form-label">您的名字</label>

                                <input type="text" name="name" id="name" class="form-control" placeholder="Your Name"
                                    required>
                            </div>

                            <div class="col-lg-6 col-12">
                                <label for="email" class="form-label">Email</label>

                                <input type="email" name="email" id="email" pattern="[^ @]*@[^ @]*" class="form-control"
                                    placeholder="your@email.com" required>
                            </div>

                            <div class="col-lg-6 col-12">
                                <label for="phone" class="form-label">電話號碼</label>

                                <input type="telephone" name="phone" id="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
                                    class="form-control" placeholder="123-456-7890">
                            </div>

                            <div class="col-lg-6 col-12">
                                <label for="people" class="form-label">訂位人數</label>
									<div class="col-lg-6 col-12">
										<label for="date" class="form-label">日期</label> <input type="text" id="dp1"
											class="datepicker mr-2 form-control" placeholder="選擇日期" name="rsvtDate"
											autocomplete="off" onchange="checkPeriod()"><span style="display: none">*</span>
									</div>
                                <input type="text" name="people" id="people" class="form-control"
                                    placeholder="12 persons">
                            </div>
									<div class="col-lg-6 col-12">
										<label for="period" class="form-label">時段</label> <select
											class="form-select form-control" name="rsvtPeriod" id="period" required>
											<option selected disabled>請選擇時段</option>
										</select>
									</div>
									<div class="col-lg-6 col-12"></div>
                            <div class="col-lg-6 col-12">
                                <label for="date" class="form-label">日期</label>

                                <input type="date" name="date" id="date" value="" class="form-control">
                            </div>

                            <div class="col-lg-6 col-12">
                                <label for="time" class="form-label">時間</label>

                                <select class="form-select form-control" name="time" id="time">
                                    <option value="5" selected>5:00 PM</option>
                                    <option value="6">18:00 PM</option>
                                    <option value="7">19:00 PM</option>
                                    <option value="8">20:00 PM</option>
                                    <option value="10">21:00 PM</option>
                                    <option value="11">22:00 PM</option>
                                    <option value="12">23:00 PM</option>
                                    <option value="13">00:00 AM</option>
                                </select>
                            </div>

                            <div class="col-12">
                                <label for="message" class="form-label">其他需求:</label>

                                <textarea class="form-control" rows="4" id="message" name="message"
                                    placeholder=""></textarea>
                            </div>

                            <div class="col-lg-4 col-12 ms-auto">
                                <button type="submit" class="form-control">送出</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer"></div>
										<button type="submit" class="form-control" id="sub_btn">送出</button>
									</div>
								</form>
							</div>
						</div>
            </div>

        </div>
    </div>
    <!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

    <!-- ----- ----- ----- js start ----- ----- ----- -->
    
    <script src="front-assets/js/jquery.min.js"></script>
    <script src="front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
    <script src="front-assets/js/custom.js"></script>

    <!-- ----- ----- ----- js end ----- ----- ----- -->
</body>

</html>
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
