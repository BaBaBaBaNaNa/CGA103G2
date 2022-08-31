(function(a) {
    toastr.options = {
        closeButton: false,
        debug: false,
        newestOnTop: false,
        progressBar: true,
        positionClass: "toast-top-left",
        preventDuplicates: false,
        onclick: null,
        showDuration: "300",
        hideDuration: "1000",
        timeOut: "5000",
        extendedTimeOut: "1000",
        showEasing: "swing",
        hideEasing: "linear",
        showMethod: "fadeIn",
        hideMethod: "fadeOut"
    };
    a("#toast-success").on("click", function() {
        toastr.remove();
        toastr.options.positionClass = "toast-top-left";
        toastr.success("This is a Success Toast", "lorem ipsum asit")
    });
    a("#toast-danger").on("click", function() {
        toastr.remove();
        toastr.options.positionClass = "toast-top-right";
        toastr.error("This is a Danger Toast", "lorem ipsum asit")
    });
    a("#toast-warning").on("click", function() {
        toastr.remove();
        toastr.options.positionClass = "toast-bottom-left";
        toastr.warning("This is a Warning Toast", "lorem ipsum asit")
    });
    a("#toast-info").on("click", function() {
        toastr.remove();
        toastr.options.positionClass = "toast-bottom-right";
        toastr.info("This is an Info Toast", "lorem ipsum asit")
    });

    function b(c) {
        var d = {};
        jQuery.map(c, function(f, e) {
            d[f.name] = f.value
        });
        return d
    }
    a("#toast-form").on("submit", function(c) {
        c.preventDefault();
        var d = b(a(this).serializeArray());
        toastr.options = {
            closeButton: d.closeButton,
            debug: d.debug,
            preventDuplicates: d.preventDuplicates,
            progressBar: d.progressBar,
            positionClass: d.toastPosition
        };
        switch (d.toastType) {
            case "success":
                toastr.success(d.message, d.title);
                break;
            case "info":
                toastr.info(d.message, d.title);
                break;
            case "warning":
                toastr.warning(d.message, d.title);
                break;
            case "danger":
                toastr.error(d.message, d.title);
                break;
            default:
                toastr.success(d.message, d.title);
                break
        }
        a("#toast-options").text("toastr.options = " + JSON.stringify(toastr.options))
    });
    a("#clearToast").on("click", function() {
        toastr.remove()
    })
})(jQuery);