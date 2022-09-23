var shoppingCart = (function() {
	// =============================
	// Private 相關方法設置
	// =============================
	cart = [];

	// 建構子 品項名 價格 數量
	function Item(name, price, count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	// 儲存購物車在session
	function saveCart() {
		sessionStorage.setItem('shoppingCart', JSON.stringify(cart));
	}

	// 從session中讀取購物車
	function loadCart() {
		cart = JSON.parse(sessionStorage.getItem('shoppingCart'));
	}
	if (sessionStorage.getItem("shoppingCart") != null) {
		loadCart();
	}


	// =============================
	// Public 相關方法設置
	// =============================
	var obj = {};

	// 增加物品數量
	obj.addItemToCart = function(name, price, count) {
		for (var item in cart) {
			if (cart[item].name === name) {
				cart[item].count++;
				saveCart();
				return;
			}
		}
		var item = new Item(name, price, count);
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
	shoppingCart.addItemToCart(name, price, 1);
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

// 執行顯示購物車
displayCart();




