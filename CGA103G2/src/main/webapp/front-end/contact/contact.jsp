<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="zh-tw">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>異鄉人 - 義式餐酒館 - 客服 - 緯育 中壢Java班 CGA_103 第二組</title>

    <!-- ----- ----- ----- 此處放CSS start ----- ----- ----- -->

    <link rel="preconnect" href="https://fonts.googleapis.com">

    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap" rel="stylesheet">

    <link href="../../front-assets/bootstrap_css/bootstrap.min.css" rel="stylesheet">

    <link href="../../front-assets/bootstrap_css/bootstrap-icons.css" rel="stylesheet">

    <link href="../../front-assets/css/tooplate-crispy-kitchen.css" rel="stylesheet">

    <link href="../../front-assets/css/navbar.css" rel="stylesheet">

    <!-- ----- ----- ----- 此處放CSS end ----- ----- ----- -->
</head>

<body>
    <!-- ----- ----- ----- 頁面 上面標頭選擇列 start ----- ----- ----- -->

    <nav class="navbar navbar-expand-lg bg-white shadow-lg">
        <div class="container">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <a class="navbar-brand" href="../../FrontIndex.jsp">
                異鄉人
            </a>

            <div class="d-lg-none">
                <button type="button" class="custom-btn btn btn-danger" data-bs-toggle="modal"
                    data-bs-target="#BookingModal">訂位</button>
            </div>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="../../FrontIndex.jsp">首頁</a>
                        <ul>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">1</a></li>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">2</a></li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="../../front-end/news/news.jsp">最新資訊</a>
                        <ul>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">所有消息</a></li>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">2</a></li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="../../front-end/menu/menu.jsp">美味餐點</a>
                        <ul>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">1</a></li>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">2</a></li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="../../front-end/order/order.jsp">訂單查詢</a>
                        <ul>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">1</a></li>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">2</a></li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="../../front-end/about/about.jsp">關於我們</a>
                        <ul>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">1</a></li>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">2</a></li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="../../front-end/contact/contact.jsp">客服</a>
                        <ul>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">1</a></li>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">2</a></li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="../../front-end/member/members.jsp">會員中心</a>
                        <ul>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">1</a></li>
                            <li><a class="nav-link1" href="../../FrontIndex.jsp">2</a></li>
                        </ul>
                    </li>

                </ul>
            </div>

            <div class="d-none d-lg-block">
                <button type="button" class="custom-btn btn btn-danger" data-bs-toggle="modal"
                    data-bs-target="#BookingModal">訂位</button>
            </div>

        </div>
    </nav>
    <!-- ----- ----- ----- 頁面 上面標頭選擇列 end ----- ----- ----- -->

    <!-- ----- ----- ----- 頁面 中間內容 start ----- ----- ----- -->

    <main>
        <!-- ----- ----- ----- 頁面 中間上面 start ----- ----- ----- -->
        <header>
        </header>
        <!-- ----- ----- ----- 頁面 中間上面 end ----- ----- ----- -->
        
        <!-- ----- ----- ----- 頁面 中間 start ----- ----- ----- -->
        <section class="contact section-padding">
            <div class="container">
                <div class="row">

                    <div class="col-12">
                        <h2 class="mb-4">留下你所想建議我們的話</h2>
                    </div>

                    <div class="col-lg-6 col-12">
                        <form class="custom-form contact-form row" action="#" method="post" role="form">
                            <div class="col-lg-6 col-6">
                                <label for="contact-name" class="form-label">您的名字</label>

                                <input type="text" name="contact-name" id="contact-name" class="form-control"
                                    placeholder="Your Name" required>
                            </div>

                            <div class="col-lg-6 col-6">
                                <label for="contact-phone" class="form-label">手機號碼</label>

                                <input type="telephone" name="contact-phone" id="contact-phone"
                                    pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" class="form-control"
                                    placeholder="123-456-7890">
                            </div>

                            <div class="col-12">
                                <label for="contact-email" class="form-label">Email</label>

                                <input type="email" name="contact-email" id="contact-email" pattern="[^ @]*@[^ @]*"
                                    class="form-control" placeholder="Your Email" required="">

                                <label for="contact-message" class="form-label">你想要建議我們:</label>

                                <textarea class="form-control" rows="5" id="contact-message" name="contact-message"
                                    placeholder="Your Message"></textarea>
                            </div>

                            <div class="col-lg-5 col-12 ms-auto">
                                <button type="submit" class="form-control">傳送</button>
                            </div>
                        </form>
                    </div>

                    <div class="col-lg-4 col-12 mx-auto mt-lg-5 mt-4">

                        <h5>Weekdays</h5>

                        <div class="d-flex mb-lg-3">
                            <p>Monday to Friday</p>

                            <p class="ms-5">09:00 AM - 22:00 PM</p>
                        </div>

                        <h5>Weekends</h5>

                        <div class="d-flex">
                            <p>Saturday and Sunday</p>

                            <p class="ms-5">12:00 AM - 18:00 PM</p>
                        </div>
                    </div>

                    <div class="col-12">
                        <h4 class="mt-5 mb-4">緯育 中壢Java班 CGA_103 第二組</h4>

                        <div class="google-map pt-3">
                            <iframe src="https://goo.gl/maps/wcmDpTGaAHn3eWPd7" width="100%" height="300"
                                style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    <!-- ----- ----- ----- 中間內容 end ----- ----- ----- -->
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

                    <a href="" class="custom-btn btn btn-dark mt-2">Directions</a>
                </div>

                <div class="col-lg-4 col-md-5 col-xs-12 tooplate-mt30">
                    <h6 class="text-white mb-lg-4 mb-3">Opening Hours</h6>

                    <p class="mb-2">Monday - Friday</p>

                    <p>17:00 PM - 03:00 AM</p>

                    <p>Tel: <a href="tel: 03-425-1108" class="tel-link">03-425-1108</a></p>
                </div>

                <div class="col-lg-4 col-md-6 col-xs-12 tooplate-mt30">
                    <h6 class="text-white mb-lg-4 mb-3">Social</h6>

                    <ul class="social-icon">
                        <li><a href="#" class="social-icon-link bi-facebook"></a></li>

                        <li><a href="#" class="social-icon-link bi-instagram"></a></li>

                        <li><a href="https://twitter.com/search?q=tooplate.com&src=typed_query&f=live" target="_blank"
                                class="social-icon-link bi-twitter"></a></li>

                        <li><a href="#" class="social-icon-link bi-youtube"></a></li>
                    </ul>

                    <p class="copyright-text tooplate-mt60">Copyright © 2022 中壢Java班 CGA_103 緯育 第二組 Co., Ltd.
                        <br>Design: <a rel="nofollow" href="" target="_blank">2022 中壢Java班 CGA_103 緯育 第二組</a>
                    </p>

                </div>

            </div><!-- row ending -->

        </div><!-- container ending -->

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

                                <input type="text" name="people" id="people" class="form-control"
                                    placeholder="12 persons">
                            </div>

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

            </div>

        </div>
    </div>
    <!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

    <!-- ----- ----- ----- js start ----- ----- ----- -->

    <script src="../../front-assets/js/jquery.min.js"></script>
    <script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
    <script src="../../front-assets/js/custom.js"></script>

    <!-- ----- ----- ----- js end ----- ----- ----- -->
</body>

</html>