(function(a) {
    new Chart(document.getElementById("pie-chart"), {
        type: "pie",
        data: {
            labels: ["Hunger House", "Food Lounge", "Delizious", "Red Resturant", "Hunger Lounge"],
            datasets: [{
                label: "Users (thousands)",
                backgroundColor: ["#ff0018", "#f7b11b", "#ff6c60", "#8663e1", "#08bf6f"],
                data: [725, 890, 729, 316, 275]
            }]
        },
        options: {
            title: {
                display: false,
                text: "Users By Country"
            },
            legend: {
                display: false
            },
        }
    });
    var b = document.getElementById("line-chart").getContext("2d");
    var i = b.createLinearGradient(0, 0, 0, 450);
    i.addColorStop(0, "#ff0018");
    var f = b.createLinearGradient(0, 0, 0, 450);
    f.addColorStop(0, "rgba(53,127,250,0.4)");
    f.addColorStop(1, "rgba(255,255,255,0)");
    var c = [1800, 1600, 2300, 2800, 3600, 2900, 3000, 3800, 3600];
    var d = [4100, 3800, 3200, 3400, 2700, 2600, 3300, 3000, 2900];
    var l = ["Jan-11", "Jan-12", "Jan-13", "Jan-14", "Jan-15", "Jan-16", "Jan-17", "Jan-18", "Jan-19"];
    var m = new Chart(b, {
        type: "line",
        data: {
            labels: l,
            datasets: [{
                label: "Users",
                borderColor: i,
                pointBorderColor: i,
                pointBackgroundColor: i,
                pointHoverBackgroundColor: i,
                pointHoverBorderColor: i,
                pointBorderWidth: 1,
                pointHoverRadius: 4,
                pointHoverBorderWidth: 1,
                pointRadius: 2,
                fill: true,
                backgroundColor: f,
                borderWidth: 1,
                data: c
            }]
        },
        options: {
            legend: {
                display: false,
                position: "bottom"
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
                        fontColor: "rgba(0,0,0,0.5)",
                        fontStyle: "bold"
                    }
                }]
            }
        }
    });
    var e = document.getElementById("engaged-users").getContext("2d");
    var j = e.createLinearGradient(0, 0, 0, 450);
    j.addColorStop(0, "#07be6e");
    var g = e.createLinearGradient(0, 0, 0, 450);
    g.addColorStop(0, "rgba(7, 190, 110,0.3)");
    g.addColorStop(1, "rgba(255,255,255,0)");
    new Chart(e, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
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
                backgroundColor: g,
                borderWidth: 2,
                data: [5, 1, 8, 1, 3, 7, 8, 4, 3, 6, 8, 9, 4, 5, 8, 2, 6, 4, 8, 3]
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
    var n = document.getElementById("page-impressions").getContext("2d");
    var k = n.createLinearGradient(0, 0, 0, 450);
    k.addColorStop(0, "#07be6e");
    var h = n.createLinearGradient(0, 0, 0, 450);
    h.addColorStop(0, "rgba(7, 190, 110,0.3)");
    h.addColorStop(1, "rgba(255,255,255,0)");
    new Chart(n, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
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
                backgroundColor: h,
                borderWidth: 2,
                data: [8, 5, 1, 8, 5, 9, 4, 3, 4, 5, 8, 4, 4, 8, 9, 5, 5, 1, 3, 6]
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