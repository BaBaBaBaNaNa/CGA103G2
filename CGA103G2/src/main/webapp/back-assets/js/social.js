(function(a) {
    var b = [7, 6, 3, 5, 4, 2, 3, 6, 8, 5, 7];
    var c = [0, -4, -2, 0, -5, -3, 0, 0, -2, -5, -3];
    var d = ["12 AM", "2 PM", "4 PM", "6 PM", "8 PM", "10 PM", "12 PM", "2 PM", "6 PM", "8 AM", "10 PM"];
    var e = new Chart(document.getElementById("youtube-subscribers"), {
        type: "bar",
        data: {
            labels: d,
            datasets: [{
                label: "Subscribers Gained",
                backgroundColor: "#ff0018",
                data: b
            }, {
                label: "Subscribers List",
                backgroundColor: "#ec4e3f",
                data: c
            }],
        },
        options: {
            legend: {
                display: false
            },
            title: {
                display: false,
            },
            scales: {
                xAxes: [{
                    stacked: true,
                }],
                yAxes: [{
                    stacked: true
                }]
            },
        }
    })
})(jQuery);