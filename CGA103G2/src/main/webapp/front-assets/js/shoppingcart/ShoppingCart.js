var shoppingCart = (function() {
	// =============================
	// Private 相關方法設置
	// =============================
	cart = [];
	var Type ;

	// 建構子 品項名 價格 數量
	function Item(name, price, count , id) {
		this.name = name;
		this.price = price;
		this.count = count;
		this.id = id;
	}

	// 儲存購物車在session
	function saveCart() {
		sessionStorage.setItem('shoppingCart', JSON.stringify(cart));
	}

	// 從session中讀取購物車
	function loadCart() {
		cart = JSON.parse(sessionStorage.getItem('shoppingCart'));
		console.log(cart);
	}
	//如果購物車不是空的時候取得購物車東西
	if (sessionStorage.getItem("shoppingCart") != null) {
		loadCart();
	}

	// =============================
	// Public 相關方法設置
	// =============================
	var obj = {};

	// 增加物品數量
	obj.addItemToCart = function(name, price, count , id) {
		for (var item in cart) {
			if (cart[item].name === name) {
				cart[item].count++;
				saveCart();
				return;
			}
		}
		var item = new Item(name, price, count , id);
		cart.push(item);
		saveCart();
	}
	// 設置物品的數量
	obj.setCountForItem = function(name, count) {
		for (var i in cart) {
			if (cart[i].name === name) {
				cart[i].count = count;
				break;
			}
		}
	};
	// 點擊減少物品數量,小於1時物品消失
	obj.removeItemFromCart = function(name) {
		for (var item in cart) {
			if (cart[item].name === name) {
				cart[item].count--;
				if (cart[item].count === 0) {
					cart.splice(item, 1);
					var name = $(this).data('name')
					shoppingCart.removeItemFromCartAll(name);
					displayCart();
				}
				break;
			}
		}
		saveCart();
	}

	// 購物車中移除食物品項
	obj.removeItemFromCartAll = function(name) {
		for (var item in cart) {
			if (cart[item].name === name) {
				cart.splice(item, 1);
				break;
			}
		}
		saveCart();
	}

	// 購物車無東西時
	obj.clearCart = function() {
		cart = [];
		saveCart();
	}

	// 購物車有東西時,計算數量
	obj.totalCount = function() {
		var totalCount = 0;
		for (var item in cart) {
			totalCount += cart[item].count;
		}
		return totalCount;
	}

	// 購物車有東西時,計算總價
	obj.totalCart = function() {
		var totalCart = 0;
		for (var item in cart) {
			totalCart += cart[item].price * cart[item].count;
		}
		return Number(totalCart.toFixed(2));
	}

	// 購物車的清單
	obj.listCart = function() {
		var cartCopy = [];
		for (i in cart) {
			item = cart[i];
			itemCopy = {};
			for (p in item) {
				itemCopy[p] = item[p];

			}
			itemCopy.total = Number(item.price * item.count).toFixed(2);
			cartCopy.push(itemCopy)
		}
		return cartCopy;
	}

	// cart : Array
	// Item : Object/Class
	// addItemToCart : Function
	// removeItemFromCart : Function
	// removeItemFromCartAll : Function
	// clearCart : Function
	// countCart : Function
	// totalCart : Function
	// listCart : Function
	// saveCart : Function
	// loadCart : Function
	return obj;
})();

// *****************************************
// 監聽事件
// ***************************************** 
// 增加物品
$('.add-to-cart').click(function(event) {
	event.preventDefault();
	var name = $(this).data('name');
	var price = Number($(this).data('price'));
	var id = $(this).data('id');
	shoppingCart.addItemToCart(name, price, 1,id);
	displayCart();
});


// 清除物品
$('.clear-cart').click(function() {
	shoppingCart.clearCart();
	displayCart();
});

// 顯示購物車外觀
function displayCart() {
	var cartArray = shoppingCart.listCart();
	var output = "";
	for (var i in cartArray) {
		output += "<tr>"
			+ "<td>" + cartArray[i].name + "</td>"
			+ "<td>(" + cartArray[i].price + ")</td>"
			+ "<td><div class='input-group'><button class='minus-item input-group-addon btn btn-primary' data-name=" + cartArray[i].name + ">-</button>"
			+ "<input type='number' class='item-count form-control' data-name='" + cartArray[i].name + "' value='" + cartArray[i].count + "'>"
			+ "<button class='plus-item btn btn-primary input-group-addon' data-name=" + cartArray[i].name + ">+</button></div></td>"
			+ "<td><button class='delete-item btn btn-danger' data-name=" + cartArray[i].name + ">X</button></td>"
			+ " = "
			+ "<td>" + cartArray[i].total + "</td>"
			+ "</tr>"
	}
	$('.show-cart').html(output);
	$('.total-cart').html(shoppingCart.totalCart());
	$('.total-count').html(shoppingCart.totalCount());
}

// 刪除物件按鈕
$('.show-cart').on("click", ".delete-item", function(event) {
	var name = $(this).data('name')
	shoppingCart.removeItemFromCartAll(name);
	displayCart();
})


// 數量-1按鈕
$('.show-cart').on("click", ".minus-item", function(event) {
	var name = $(this).data('name')
	shoppingCart.removeItemFromCart(name);
	displayCart();
})
// 數量+1按鈕
$('.show-cart').on("click", ".plus-item", function(event) {
	var name = $(this).data('name')
	shoppingCart.addItemToCart(name);
	displayCart();
})

// 當有品項加入購物車時
$('.show-cart').on("change", ".item-count", function(event) {
	var name = $(this).data('name');
	var count = Number($(this).val());
	shoppingCart.setCountForItem(name, count);
	displayCart();
});

//監控checkbox 使0:外帶, 1:外送, 2: 內用 單選 
$('#checkboxGroup li input').click(function(){
	if($(this).prop('checked')){
		
		$('#checkboxGroup li input:checkbox').prop('checked',false);
		$(this).prop('checked',true);
		//console.log($(this).val());
		if(!(JSON.parse(sessionStorage.getItem('Type')) === "0") || (JSON.parse(sessionStorage.getItem('Type')) === "1") || (JSON.parse(sessionStorage.getItem('Type')) === "2")){
			sessionStorage.setItem('Type', JSON.stringify($(this).val()));
		}
		if($(this).val() === "1"){
			$("#ordtext1").prop('disabled',false);
//			document.getElementById("ordtext1").disabled=false; 
		}
		else{
			$("#ordtext1").prop('disabled',true);
		}
	}
	else{
		sessionStorage.setItem('Type', JSON.stringify("999")); 
		$("#ordtext1").prop('disabled',true);
	}
});

//監聽ordtext1打字
$('#ordtext1').on('input', function () {
	sessionStorage.setItem('ordaddress', JSON.stringify($('#ordtext1').val()));
});

var MyPoint = "/front-end/shopcart/ShopCartAddSuccess.jsp";
var host = window.location.host;
var path = window.location.pathname;
var webCtx = path.substring(0, path.indexOf('/', 1));
var endPointURL = "http://" + host + webCtx + MyPoint;

// 當要把購物車送出產生訂單時
$('#submit2').on("click",  function(event) {
	var orderType = JSON.parse(sessionStorage.getItem('Type'));
	var ordaddress = JSON.parse(sessionStorage.getItem('ordaddress'));
//	console.log(JSON.parse(sessionStorage.getItem('Type')));
//	console.log(cart);
	if(JSON.stringify(cart) === '{}' || JSON.stringify(cart) === '' || JSON.stringify(cart) === '[]'){
//		console.log("請至少點一份餐點");
		alert("請至少點一份餐點");
	}
	else if(!(JSON.parse(sessionStorage.getItem('Type')) === "0") && !(JSON.parse(sessionStorage.getItem('Type')) === "1") && !(JSON.parse(sessionStorage.getItem('Type')) === "2")){
		alert("請選擇需要 外帶 外送 內用");
	}
	else{
	  fetch('ShopCartServlet.do', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
		cart,
		orderType,
		ordaddress
      }),
    })
    .then(resp => window.location.href='ShopCartAddSuccess.jsp');
	}
});


// ===== ===== ===== ===== ===== 執行方法 ===== ===== ===== ===== =====
// 執行顯示購物車
displayCart();