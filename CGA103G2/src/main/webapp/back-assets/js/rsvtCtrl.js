    
    function getAllRsvtCtrl()
    {
      var xmlhttp;
      if (window.XMLHttpRequest)
      {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
      }
      else
      {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xmlhttp.onreadystatechange=function()
      {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
          document.getElementById("getAll").innerHTML=xmlhttp.responseText;
        }
      }
      xmlhttp.open("POST","/CGA103G2/back-end/reservation_ctrl/listAllRsvtCtrl.jsp",true);
      xmlhttp.send();
    }

    function AddRsvtCtrl()
    {
      var xmlhttp;
      if (window.XMLHttpRequest)
      {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
      }
      else
      {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xmlhttp.onreadystatechange=function()
      {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
          document.getElementById("getAll").innerHTML=xmlhttp.responseText;
        }
      }
      xmlhttp.open("POST","/CGA103G2/back-end/reservation_ctrl/addRsvtCtrl.jsp",true);
      xmlhttp.send();
    }

    function UpdateRsvtCtrl()
    {
      var xmlhttp;
      if (window.XMLHttpRequest)
      {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
      }
      else
      {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xmlhttp.onreadystatechange=function()
      {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
          document.getElementById("getAll").innerHTML=xmlhttp.responseText;
        }
      }
      xmlhttp.open("POST","/CGA103G2/back-end/reservation_ctrl/update_rsvtCtrl_input.jsp",true);
      xmlhttp.send();
    }
    
//    $('.datepicker').datepicker({
//        autoclose: true, // 選擇後自動關閉日期選擇器
//        language: 'zh-TW', // 語言切換 中文
//        format: 'yyyy-mm-dd', // 日期格式
//        todayHighlight: true, // 高亮"當天日期"
//        toggleActive: true, // 	點擊選擇，再次點擊取消
//        startDate: new Date(), //開放初始日期 ex=> 
//        // endDate:new Date(),
//        // clearBtn: true, //顯示清除按鈕
//        daysOfWeekDisabled: [3],  //每周隱藏的第幾天  0為周日6為星期六
//        datesDisabled: [ // 特殊日期禁用
//            <%=DateString%>
//        ],
//    });