function checkForm() {
	var form = document.forms["myform"];
	var emp_account = form["emp_account"].value;
	var emp_password = form["emp_password"].value;
	if (emp_account == null || emp_account == "") {
		alert("請輸入帳號！");
		return false;
	} else if (emp_password == null || emp_password == "") {
		alert("請輸入密碼！");
		return false;
	}
	return true;
}