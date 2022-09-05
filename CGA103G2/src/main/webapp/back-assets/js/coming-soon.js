(function(a) {
    a("#countdown-duration").countdown("2021/01/01", function(b) {
        a("#days").text(b.strftime("%D"));
        a("#hours").text(b.strftime("%H"));
        a("#minutes").text(b.strftime("%M"));
        a("#seconds").text(b.strftime("%S"))
    })
})(jQuery);