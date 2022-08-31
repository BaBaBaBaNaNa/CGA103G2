(function(a) {
    a("#default-wizard").steps({
        headerTag: "h3",
        bodyTag: "div",
        autoFocus: true,
        titleTemplate: "#title#",
        labels: {
            current: "",
            finish: "Submit",
            previous: "Back"
        },
        onFinished: function(c, b) {
            alert("Form Submitted Successfully!")
        }
    });
    a(".style2-wizard, .style3-wizard, .style4-wizard").steps({
        headerTag: "h3",
        bodyTag: "div",
        autoFocus: true,
        titleTemplate: '<span class="number">#index#</span> #title#',
        labels: {
            current: "",
            finish: "Submit",
            previous: "Back"
        },
        onFinished: function(c, b) {
            alert("Form Submitted Successfully!")
        }
    })
})(jQuery);