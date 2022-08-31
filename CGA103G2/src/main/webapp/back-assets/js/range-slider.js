(function(a) {
    a("#demo_0").ionRangeSlider();
    a("#demo_1").ionRangeSlider({
        type: "double",
        grid: true,
        min: 0,
        max: 1000,
        from: 200,
        to: 800,
        prefix: "$"
    });
    a("#demo_2").ionRangeSlider({
        grid: true,
        from: new Date().getMonth(),
        values: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    });
    a("#demo_3").ionRangeSlider({
        type: "double",
        grid: true,
        min: 0,
        max: 100,
        from: 47,
        to: 53,
        prefix: "Weight: ",
        postfix: " million pounds",
        decorate_both: true
    });
    a("#demo_4").ionRangeSlider({
        type: "double",
        grid: true,
        min: -1000,
        max: 1000,
        from: -500,
        to: 500,
        step: 250
    });
    a("#demo_5").ionRangeSlider({
        type: "double",
        grid: true,
        min: -12.8,
        max: 12.8,
        from: -3.2,
        to: 3.2,
        step: 0.1
    });
    a("#demo_6").ionRangeSlider();
    a("#demo_7").ionRangeSlider({
        skin: "big"
    });
    a("#demo_8").ionRangeSlider({
        skin: "modern"
    });
    a("#demo_9").ionRangeSlider({
        skin: "sharp"
    });
    a("#demo_10").ionRangeSlider({
        skin: "round"
    });
    a("#demo_11").ionRangeSlider({
        skin: "square"
    })
})(jQuery);