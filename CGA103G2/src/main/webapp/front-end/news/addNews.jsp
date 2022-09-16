<%@page import="com.news.model.NewsVO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
NewsVO newsVO = (NewsVO) request.getAttribute("newsVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�q���Ʒs�W - addNews.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 570px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�����s�W - addNews.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img src="images/giphy.gif"
						width="250" height="250" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��Ʒs�W:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="news.do" name="form1"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>���u�s��:</td>
				<td><input type="TEXT" name="empID" size="45"
					value="<%=(newsVO == null) ? "" : newsVO.getEmpID()%>" /></td>
			</tr>
			<tr>
				<td>�������D:</td>
				<td><input type="TEXT" name="newsTitle" size="45"
					value="<%=(newsVO == null) ? "TEST" : newsVO.getNewsTitle()%>" /></td>
			</tr>
			<tr>
				<td>�������e:</td>
				<td><input type="TEXT" name="newsInformation" size="45"
					value="<%=(newsVO == null) ? "TEST" : newsVO.getNewsInformation()%>" /></td>
			</tr>
			<tr>
				<td>��������:</td>
				<td><select name="NewsControl" id="NewsControl">
						<option value="0">�W�[</option>
						<option value="1">�U�[</option>
				</select></td>
			</tr>
			<tr>
				<td>�������:</td>
				<td><input name="newsDate" id="f_date1" type="text"></td>
			</tr>

			<div>
				<label for="newsPictures">�Ӥ�:</label> <input id="newsPictures"
					name="newsPictures" type="file" onclick="previewImage()"
					multiple="multiple" accept="image/*" /> <span
					id="newsPictures.errors" class="error">${errorMsgs.newsPictures}</span>
				<div id="blob_holder"></div>
			</div>
		</table>

		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W">
	</FORM>
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->

<%
Timestamp newsDate = null;
try {
	newsDate = newsVO.getNewsDate();
} catch (Exception e) {
	newsDate = new Timestamp(System.currentTimeMillis());
}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>


<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>
<script type="text/javascript">
	
	document.getElementById('NewsControl').onchange = () => {
		console.log(this);
	}

        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:true,       //timepicker:true,
	       step: 30,                //step: 60 (�o�Otimepicker���w�]���j60����)
	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
		   value: '<%=newsDate%>', // value:   new Date(),
        });
        
      //�M�����ܫH��
        function hideContent(d) {
            document.getElementById(d).style.display = "none";
       }
        
//         �U�C���W�ǹ���
        
        var filereader_support = typeof FileReader != 'undefined';
        if (!filereader_support) {
        	alert("No FileReader support");
        }
        acceptedTypes = {
        		'image/png' : true,
        		'image/jpeg' : true,
        		'image/gif' : true
        };
        function previewImage() {
        	var newsPictures1 = document.getElementById("newsPictures");
        	newsPictures1.addEventListener("change", function(event) {
        		var files = event.target.files || event.dataTransfer.files;
        		for (var i = 0; i < files.length; i++) {
        			previewfile(files[i])
        		}
        	}, false);
        }
        function previewfile(file) {
        	if (filereader_support === true && acceptedTypes[file.type] === true) {
        		var reader = new FileReader();
        		reader.onload = function(event) {
        			var image = new Image();
        			image.src = event.target.result;
        			image.width = 200;
        			image.height = 200;
        			image.border = 2;
        			if (blob_holder.hasChildNodes()) {
        				blob_holder.removeChild(blob_holder.childNodes[0]);
        			}
        			blob_holder.appendChild(image);
        		};
        		reader.readAsDataURL(file);
        		document.getElementById('submit');
        	} else {
        		blob_holder.innerHTML = "<div  style='text-align: left;'>" + "�� filename: " + file.name
        				+ "<br>" + "�� ContentTyp: " + file.type
        				+ "<br>" + "�� size: " + file.size + "bytes"
        				+ "<br>" + "�� �W��ContentType����: <b> <font color=red>image/png�Bimage/jpeg�Bimage/gif </font></b></div>";
        		document.getElementById('submit');
        	}
        }
        
   		
        
        
        
</script>

</html>