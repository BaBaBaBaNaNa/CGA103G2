<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
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

.Info {
	float: right;
	color: #fff;
	background-color: #0d6efd;
	padding: 0.375rem 0.75rem;
	border-radius: 0.25rem;
	border: 1px solid transparent;
}
.nav-tabs {
    border-bottom: 0;
}
.pt-4 {
    padding-top: 1.5rem !important;
    padding-bottom: 1.5rem;
    display: flex;
    align-content: center;
    justify-content: flex-start;
/*      align-items: center;  */
}
	h2 { 
    font-size: 1rem; 
    font-weight: 400; 
    color:	white	;
 }
.size{
	width: 30%;
    hight: 100%;
    margin-left: auto;
    z-index:100;
    position: absolute;
}
#listBtn{
background-color: #dc3545;
    font-size: 18px;;
    padding: 10px 35px;
        border-radius: 0.25rem;
}
</style>
</head>

<body>

	<main>
		<!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
		<header> </header>

		<!-- 		<button id="demo8">Demo 8</button> -->
		<!-- Food Widget -->
		<!-- 		col-xl-6 col-md-12 -->
		<c:forEach var="BotqaVO" items="${list4}">
		<script>
			adda1("${BotqaVO.keywordName}","${BotqaVO.keywordContext}");
			adda2("${BotqaVO.keywordContext}");
		
		</script>
		</c:forEach>
<html>

	<head>
		<title>jQuery ChatBot</title>
	</head>

	<body>
	<button id="listBtn" onclick="listBtn()"> 開啟客服</button>
	<div class= "size fas" id="size" style="display:none;">
		<div id="phone-wrapper">
			<div id="app">
				<div id="landing" class="bg-dark text-light" style="">
					<span class="fas fa-robot fa-4x"></span>
					<div>
						<h1 class="mt-3">ChatBot</h1>
					</div>
					<form id="form-start">
						<input type="text" name="username" id="username" value="" placeholder="Your name" required>
						<button type="submit" id="start-chat">Start chat</button>
					</form>
				</div>
				<div id="header" class="bg-dark">
					<!-- <div>
						<button id="back-button" class="text-light btn-transparent btn-icon fas fa-arrow-left"></button>
					</div> -->
					<div class="text-light align-center">
						<h2>ChatBot</h2>
					</div>
					<div>
					</div>
				</div>
				<div id="message-board">


				</div>
				<div id="form" class="bg-light">
					<div id="emoijis" style="display: none;">
						<button class="smiley btn-transparent btn-icon"><span class="far fa-grin-beam"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-grin"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-grin-wink"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-grin-tongue"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-grin-tongue-wink"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-kiss-wink-heart"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-grin-hearts"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-surprise"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-angry"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-tired"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-sad-tear"></span></button>
						<button class="smiley btn-transparent btn-icon"><span
								class="far fa-grin-squint-tears"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-sad-cry"></span></button>
						<button class="smiley btn-transparent btn-icon"><span class="far fa-dizzy"></span></button>
					</div>
					<div><button id="emoi" class="btn-transparent btn-icon far fa-grin"></button></div>
					<div id="message" placeholder="Type your message here" rows="1" contenteditable></div>
					<div><button id="send" type="" class="btn-transparent btn-icon fas fa-paper-plane"></button></div>
				</div>
			</div>
		</div>
	</div>

	</body>

	</html>


	</footer>
	
</body>

</html>