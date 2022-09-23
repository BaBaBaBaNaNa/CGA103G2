var getAmount = (function() {
	fetch('ShopCartServlet.do', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
		cart
      }),
    })
    .then(resp => window.location.href='ShopCartAddSuccess.jsp');
})();