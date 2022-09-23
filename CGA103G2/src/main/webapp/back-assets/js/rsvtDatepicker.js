$('.datepicker').datepicker({
    autoclose: true, // 選擇後自動關閉日期選擇器
    language: 'zh-TW', // 語言切換 中文
    format: 'yyyy-mm-dd', // 日期格式
    todayHighlight: true, // 高亮"當天日期"
    toggleActive: true, // 	點擊選擇，再次點擊取消
    startDate: new Date(), //開放初始日期 ex=> 
    // endDate:new Date(),
    // clearBtn: true, //顯示清除按鈕
    daysOfWeekDisabled: [3], //每周隱藏的第幾天  0為周日6為星期六
    datesDisabled: [ // 特殊日期禁用
        '2022/10/10', '2022.09.09', '2022.09.10', '2022.09.11'],
});