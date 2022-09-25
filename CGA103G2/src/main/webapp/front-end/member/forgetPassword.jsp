<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<%@ page import="com.mem.model.*"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>會員登入</title>
<%-- CSS --%>

</head>

<body>

  <!-- =======================
<%-- header --%>

 
  <!-- =======================
	header End-->
<div class="main">
  <div>請至您註冊的信箱收取驗證碼 並輸入驗證碼完成會員驗證</div>
   <div><a href="<%=request.getContextPath()%>/frontIndex.jsp">回首頁</a></div>
    <div><a href="">回會員中心</a></div>
    <h2>請輸入註冊信箱</h2>
    <form method="post" action="/front-end/member/MemServlet.do" role="form">
      <div class="col-md-9 col-sm-12">
        <div class="form-group form-group-lg">
          <input type="text" class="form-control col-md-6 col-sm-6 col-sm-offset-2" name="mem_email" required>
          <input class="btn btn-primary btn-lg col-md-2 col-sm-2" type="submit" value="驗證">
          <input type="hidden" name="action" value="forgetPassword">
        </div>
      </div>
    </form>
</div>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<c:if test="${authSuccess == 'authSuccess'}">

<script>
swal("驗證成功","回首頁或會員中心","success");
</script>	
</c:if>
    


  <!-- 主內容 end -->


</body>

</html>