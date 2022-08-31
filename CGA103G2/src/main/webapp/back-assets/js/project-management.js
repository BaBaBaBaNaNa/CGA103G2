(function(a) {
    var j = document.getElementById("pm-chart").getContext("2d");
    var f = j.createLinearGradient(0, 0, 0, 450);
    f.addColorStop(0, "#ff0018");
    var d = j.createLinearGradient(0, 0, 0, 450);
    d.addColorStop(0, "rgba(53,127,250,0.4)");
    d.addColorStop(1, "rgba(255,255,255,0)");
    var g = j.createLinearGradient(0, 0, 0, 450);
    g.addColorStop(0, "#ec4e3f");
    var e = j.createLinearGradient(0, 0, 0, 450);
    e.addColorStop(0, "rgba(236, 78, 63,0.4)");
    e.addColorStop(1, "rgba(255, 255, 255,0)");
    var b = [3800, 3900, 3300, 3800, 4000, 4200, 4400, 3800, 4600, 3900, 3800];
    var c = [2100, 3000, 2200, 2400, 2800, 2600, 2800, 2600, 2300, 2900, 2800];
    var h = ["12 AM", "2 PM", "4 PM", "6 PM", "8 PM", "10 PM", "12 PM", "2 PM", "6 PM", "8 AM", "10 PM"];
    var i = new Chart(j, {
        type: "line",
        data: {
            labels: h,
            datasets: [{
                label: "Traffic",
                borderColor: f,
                pointBorderWidth: 9,
                pointRadius: 9,
                pointBorderColor: "transparent",
                pointHoverRadius: 8,
                pointHoverBorderWidth: 3,
                pointHoverBackgroundColor: "white",
                pointHoverBorderColor: "#ff0018",
                pointBackgroundColor: "transparent",
                fill: true,
                backgroundColor: d,
                borderWidth: 2,
                data: b
            }, {
                label: "Sales",
                borderColor: g,
                pointBorderWidth: 9,
                pointRadius: 9,
                pointBorderColor: "transparent",
                pointHoverRadius: 8,
                pointHoverBorderWidth: 3,
                pointHoverBackgroundColor: "white",
                pointHoverBorderColor: "#ec4e3f",
                pointBackgroundColor: "transparent",
                fill: true,
                backgroundColor: e,
                borderWidth: 2,
                data: c
            }]
        },
        options: {
            elements: {
                line: {
                    tension: 0
                }
            },
            tooltips: {
                titleFontColor: "#3a3952",
                bodyFontFamily: "Roboto",
                backgroundColor: "#FFF",
                bodyFontColor: "#878793",
                bodyFontSize: 14,
                displayColors: false,
                bodySpacing: 10,
                intersect: false,
                bodyFontStyle: "bold",
                xPadding: 15,
                yPadding: 15,
                mode: "index"
            },
            legend: {
                display: false,
                position: "top"
            },
            scales: {
                yAxes: [{
                    ticks: {
                        fontColor: "rgba(0,0,0,0.5)",
                        fontStyle: "bold",
                        beginAtZero: true,
                        maxTicksLimit: 200,
                        padding: 20
                    },
                    gridLines: {
                        drawTicks: false,
                        display: false
                    }
                }],
                xAxes: [{
                    gridLines: {
                        zeroLineColor: "transparent"
                    },
                    ticks: {
                        padding: 20,
                        beginAtZero: true,
                        fontColor: "rgba(0,0,0,0.5)",
                        fontStyle: "bold"
                    }
                }]
            }
        }
    });
    a(".ms-graph-metrics .day").on("click", function() {
        var k = i.config.data;
        k.datasets[0].data = b;
        k.datasets[1].data = c;
        k.labels = h;
        i.update()
    });
    a(".ms-graph-metrics .month").on("click", function() {
        var k = ["Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"];
        var m = [4800, 4900, 4300, 4800, 5000, 5200, 5400, 4800, 5600, 4900, 4800, 5500];
        var n = [3100, 4000, 3200, 3400, 3800, 3600, 3800, 3600, 3300, 3900, 3800, 2500];
        var l = i.config.data;
        l.datasets[0].data = m;
        l.datasets[1].data = n;
        l.labels = k;
        i.update()
    });
    a(".ms-graph-metrics .year").on("click", function() {
        var k = ["2007", "2008", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"];
        var m = [6800, 6900, 6300, 6800, 7000, 7200, 7400, 6800, 7600, 6900, 6800, 7500];
        var n = [5100, 6000, 5200, 5400, 5800, 5600, 5800, 5600, 5300, 5900, 5800, 4500];
        var l = i.config.data;
        l.datasets[0].data = m;
        l.datasets[1].data = n;
        l.labels = k;
        i.update()
    })
})(jQuery);