<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.queuer.model.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我要候位</title>
</head>
<body>
    <body bgcolor="white">

        <table id="table-1">
            <tr><td>
                 <h3>候位資料新增 - addQueuer</h3></td><td>
            </td></tr>
        </table>
        
        <h3>候位資料新增:</h3>
        
        
        <form method="post" action="queuer.do">
        <table>
   
            <tr>
                <td>候位姓名：</td>
                <td><input type="text" name="queuer_name" size="20" placeholder="請輸入姓名"  maxlength="10" required="required" pattern="\u4e00-\u9fa5)(a-zA-Z0-9_" /></td>
            </tr>
            
            <tr>
                <td>候位電話：</td>
                <td><input type="text" name="queuer_phone" size="20" placeholder="09XXXXXXX" maxlength="10" required="required"  pattern="09\d{8}"/></td>
            </tr>

        </table>
		</form>
		<input type="hidden" name="action" value="insert">
        <input type="submit" value="點我候位"/>
</body>
</html>