(function(a) {
    a("#animate-it").on("click", function() {
        a("#img-animate").addClass(a("#animation-selection").val());
        a("#img-animate").on("animationend", function() {
            a("#img-animate").attr("class", "animated")
        })
    })
})(jQuery);