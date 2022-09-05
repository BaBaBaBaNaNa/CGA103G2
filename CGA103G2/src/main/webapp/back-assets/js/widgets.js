(function(a) {
    var b = document.getElementById("line-chart").getContext("2d");
    var j = b.createLinearGradient(0, 0, 0, 450);
    j.addColorStop(0, "#000000");
    var f = b.createLinearGradient(0, 0, 0, 450);
    f.addColorStop(0, "rgba(25, 25, 25, 0.12)");
    f.addColorStop(1, "rgba(25, 25, 25, 0.12)");
    var d = [4100, 3800, 3200, 3400, 2700, 3600, 3300, 3700, 4900];
    var e = [2800, 2600, 2300, 2800, 3600, 2900, 3000, 3100, 3600, 3000, 3100, 3200];
    var n = ["Jan-11", "Jan-12", "Jan-13", "Jan-14", "Jan-15", "Jan-16", "Jan-17", "Jan-18", "Jan-19"];
    var o = ["Jan-11", "Jan-12", "Jan-13", "Jan-14", "Jan-15", "Jan-16", "Jan-17", "Jan-18", "Jan-19", "Jan-20", "Jan-21", "Jan-22"];
    var p = new Chart(b, {
        type: "line",
        data: {
            labels: n,
            datasets: [{
                label: "Data",
                borderColor: j,
                pointBorderColor: j,
                pointBackgroundColor: j,
                pointHoverBackgroundColor: j,
                pointHoverBorderColor: j,
                pointBorderWidth: 0,
                pointHoverRadius: 0,
                pointHoverBorderWidth: 0,
                pointRadius: 0,
                fill: true,
                backgroundColor: f,
                borderWidth: 2,
                data: d
            }]
        },
        options: {
            elements: {
                line: {
                    tension: 0
                }
            },
            legend: {
                display: false,
                position: "bottom"
            },
            scales: {
                yAxes: [{
                    display: false,
                }],
                xAxes: [{
                    display: false,
                }]
            }
        }
    });
    var c = document.getElementById("line-chart-2").getContext("2d");
    var k = b.createLinearGradient(0, 0, 0, 450);
    k.addColorStop(0, "#ff0018");
    var g = b.createLinearGradient(0, 0, 0, 450);
    g.addColorStop(0, "rgba(255, 0, 24, 0.11)");
    g.addColorStop(1, "rgba(255, 0, 24, 0.11)");
    var q = new Chart(c, {
        type: "line",
        data: {
            labels: o,
            datasets: [{
                label: "Data",
                borderColor: k,
                pointBorderColor: k,
                pointBackgroundColor: k,
                pointHoverBackgroundColor: k,
                pointHoverBorderColor: k,
                pointBorderWidth: 0,
                pointHoverRadius: 0,
                pointHoverBorderWidth: 0,
                pointRadius: 0,
                fill: true,
                backgroundColor: g,
                borderWidth: 2,
                data: e
            }]
        },
        options: {
            elements: {
                line: {
                    tension: 0
                }
            },
            legend: {
                display: false,
                position: "bottom"
            },
            scales: {
                yAxes: [{
                    display: false,
                }],
                xAxes: [{
                    display: false,
                }]
            }
        }
    });
    var s = document.getElementById("line-chart-3").getContext("2d");
    var m = s.createLinearGradient(0, 0, 0, 450);
    m.addColorStop(0, "#000000");
    var i = s.createLinearGradient(0, 0, 0, 450);
    i.addColorStop(0, "rgba(25, 25, 25, 0.12)");
    i.addColorStop(1, "rgba(25, 25, 25, 0.12)");
    new Chart(s, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
            datasets: [{
                label: "Data",
                borderColor: m,
                pointBorderColor: m,
                pointBackgroundColor: m,
                pointHoverBackgroundColor: m,
                pointHoverBorderColor: m,
                pointBorderWidth: 0,
                pointHoverRadius: 0,
                pointHoverBorderWidth: 0,
                pointRadius: 0,
                fill: true,
                backgroundColor: i,
                borderWidth: 2,
                data: [5, 6, 8, 1, 5, 3, 9, 7, 5, 8, 7, 3, 6, 9, 1]
            }]
        },
        options: {
            elements: {
                line: {
                    tension: 0
                }
            },
            legend: {
                display: false,
                position: "bottom"
            },
            scales: {
                yAxes: [{
                    display: false,
                }],
                xAxes: [{
                    display: false,
                }]
            }
        }
    });
    var r = document.getElementById("line-chart-4").getContext("2d");
    var l = r.createLinearGradient(0, 0, 0, 450);
    l.addColorStop(0, "#ff0018");
    var h = r.createLinearGradient(0, 0, 0, 450);
    h.addColorStop(0, "rgba(255, 0, 24, 0.11)");
    h.addColorStop(1, "rgba(255, 0, 24, 0.11)");
    new Chart(r, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
            datasets: [{
                label: "Data",
                borderColor: l,
                pointBorderColor: l,
                pointBackgroundColor: l,
                pointHoverBackgroundColor: l,
                pointHoverBorderColor: l,
                pointBorderWidth: 0,
                pointHoverRadius: 0,
                pointHoverBorderWidth: 0,
                pointRadius: 0,
                fill: true,
                backgroundColor: h,
                borderWidth: 2,
                data: [1, 4, 7, 3, 5, 7, 6, 5, 8, 3, 5, 5, 4, 3, 7]
            }]
        },
        options: {
            elements: {
                line: {
                    tension: 0
                }
            },
            legend: {
                display: false,
                position: "bottom"
            },
            scales: {
                yAxes: [{
                    display: false,
                }],
                xAxes: [{
                    display: false,
                }]
            }
        }
    })
})(jQuery);