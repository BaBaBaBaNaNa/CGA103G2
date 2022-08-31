(function(a) {
    var f = document.getElementById("default");
    var b = new Cropper(f, {
        aspectRatio: 16 / 9,
        responsive: true,
    });
    var g = document.getElementById("zoom-disabled");
    var c = new Cropper(g, {
        aspectRatio: 16 / 9,
        responsive: true,
        zoomable: false
    });
    var e = document.getElementById("cropper-expanded");
    var d = new Cropper(e, {
        aspectRatio: 16 / 9,
        guides: false,
        responsive: true,
        preview: ".ms-crop-preview",
    });
    a("#zoom-in").on("click", function() {
        d.zoom(0.1)
    });
    a("#zoom-out").on("click", function() {
        d.zoom(-0.1)
    });
    a("#rotate-right").on("click", function() {
        d.rotate(45)
    });
    a("#rotate-left").on("click", function() {
        d.rotate(-45)
    });
    a("#move-left").on("click", function() {
        d.move(-10, 0)
    });
    a("#move-down").on("click", function() {
        d.move(0, 10)
    });
    a("#move-right").on("click", function() {
        d.move(10, 0)
    });
    a("#move-up").on("click", function() {
        d.move(0, -10)
    });
    a("#lock").on("click", function() {
        d.disable()
    });
    a("#unlock").on("click", function() {
        d.enable()
    });
    a("#reset").on("click", function() {
        d.reset()
    })
})(jQuery);