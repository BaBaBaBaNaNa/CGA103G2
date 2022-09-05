(function(a) {
    var c = document.getElementById("audience-metrics-chart").getContext("2d");
    var q = c.createLinearGradient(0, 0, 0, 450);
    q.addColorStop(0, "#ff0018");
    var j = c.createLinearGradient(0, 0, 0, 450);
    j.addColorStop(0, "rgba(53,127,250,0.4)");
    j.addColorStop(1, "rgba(255,255,255,0)");
    var r = c.createLinearGradient(0, 0, 0, 450);
    r.addColorStop(0, "#ec4e3f");
    var k = c.createLinearGradient(0, 0, 0, 450);
    k.addColorStop(0, "rgba(236, 78, 63,0.4)");
    k.addColorStop(1, "rgba(255, 255, 255,0)");
    var e = [3800, 3900, 3300, 3800, 4000, 4200, 4400, 3800, 4600, 3900, 3800];
    var f = [2100, 3000, 2200, 2400, 2800, 2600, 2800, 2600, 2300, 2900, 2800];
    var u = ["12 AM", "2 PM", "4 PM", "6 PM", "8 PM", "10 PM", "12 PM", "2 PM", "6 PM", "8 AM", "10 PM"];
    var b = new Chart(c, {
        type: "line",
        data: {
            labels: u,
            datasets: [{
                label: "Traffic",
                borderColor: q,
                pointBorderWidth: 9,
                pointRadius: 9,
                pointBorderColor: "transparent",
                pointHoverRadius: 8,
                pointHoverBorderWidth: 3,
                pointHoverBackgroundColor: "white",
                pointHoverBorderColor: "#ff0018",
                pointBackgroundColor: "transparent",
                fill: true,
                backgroundColor: j,
                borderWidth: 2,
                data: e
            }, {
                label: "Sales",
                borderColor: r,
                pointBorderWidth: 9,
                pointRadius: 9,
                pointBorderColor: "transparent",
                pointHoverRadius: 8,
                pointHoverBorderWidth: 3,
                pointHoverBackgroundColor: "white",
                pointHoverBorderColor: "#ec4e3f",
                pointBackgroundColor: "transparent",
                fill: true,
                backgroundColor: k,
                borderWidth: 2,
                data: f
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
        var G = b.config.data;
        G.datasets[0].data = e;
        G.datasets[1].data = f;
        G.labels = u;
        b.update()
    });
    a(".ms-graph-metrics .month").on("click", function() {
        var G = ["Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"];
        var I = [4800, 4900, 4300, 4800, 5000, 5200, 5400, 4800, 5600, 4900, 4800, 5500];
        var J = [3100, 4000, 3200, 3400, 3800, 3600, 3800, 3600, 3300, 3900, 3800, 2500];
        var H = b.config.data;
        H.datasets[0].data = I;
        H.datasets[1].data = J;
        H.labels = G;
        b.update()
    });
    a(".ms-graph-metrics .year").on("click", function() {
        var G = ["2007", "2008", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"];
        var I = [6800, 6900, 6300, 6800, 7000, 7200, 7400, 6800, 7600, 6900, 6800, 7500];
        var J = [5100, 6000, 5200, 5400, 5800, 5600, 5800, 5600, 5300, 5900, 5800, 4500];
        var H = b.config.data;
        H.datasets[0].data = I;
        H.datasets[1].data = J;
        H.labels = G;
        b.update()
    });
    var F = new Datamap({
        element: document.getElementById("world-map"),
        highlightOnHover: false,
        responsive: true,
        fills: {
            defaultFill: "rgb(199,206,234)",
            USA: "#445cc8",
            RUS: "#f0ad4e",
            AUS: "#5cb85c",
            IND: "#d9534f",
            BRA: "#ff0018",
        },
        geographyConfig: {
            highlightFillColor: "rgb(50,92,204)",
            borderColor: "transparent",
            highlightBorderColor: "transparent",
            popupOnHover: false
        },
        data: {
            USA: {
                fillKey: "USA"
            },
            RUS: {
                fillKey: "RUS"
            },
            AUS: {
                fillKey: "AUS"
            },
            IND: {
                fillKey: "IND"
            },
            BRA: {
                fillKey: "BRA"
            },
        }
    });
    a(window).on("resize", function() {
        F.resize()
    });
    var d = document.getElementById("bounce-rate").getContext("2d");
    var n = d.createLinearGradient(0, 0, 0, 450);
    n.addColorStop(0, "#07be6e");
    var g = d.createLinearGradient(0, 0, 0, 450);
    g.addColorStop(0, "rgba(7, 190, 110,0.3)");
    g.addColorStop(1, "rgba(255,255,255,0)");
    new Chart(d, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
            datasets: [{
                label: "Data",
                borderColor: n,
                pointBorderColor: n,
                pointBackgroundColor: n,
                pointHoverBackgroundColor: n,
                pointHoverBorderColor: n,
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
    var x = document.getElementById("page-views").getContext("2d");
    var p = x.createLinearGradient(0, 0, 0, 450);
    p.addColorStop(0, "#ec4e3f");
    var i = x.createLinearGradient(0, 0, 0, 450);
    i.addColorStop(0, "rgba(236, 78, 63,0.4)");
    i.addColorStop(1, "rgba(255, 255, 255,0)");
    new Chart(x, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
            datasets: [{
                label: "Data",
                borderColor: p,
                pointBorderColor: p,
                pointBackgroundColor: p,
                pointHoverBackgroundColor: p,
                pointHoverBorderColor: p,
                pointBorderWidth: 0,
                pointHoverRadius: 0,
                pointHoverBorderWidth: 0,
                pointRadius: 0,
                fill: true,
                backgroundColor: i,
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
    });
    var v = document.getElementById("new-sessions").getContext("2d");
    var o = v.createLinearGradient(0, 0, 0, 450);
    o.addColorStop(0, "#ec4e3f");
    var h = v.createLinearGradient(0, 0, 0, 450);
    h.addColorStop(0, "rgba(236, 78, 63,0.4)");
    h.addColorStop(1, "rgba(255, 255, 255,0)");
    new Chart(v, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
            datasets: [{
                label: "Data",
                borderColor: o,
                pointBorderColor: o,
                pointBackgroundColor: o,
                pointHoverBackgroundColor: o,
                pointHoverBorderColor: o,
                pointBorderWidth: 0,
                pointHoverRadius: 0,
                pointHoverBorderWidth: 0,
                pointRadius: 0,
                fill: true,
                backgroundColor: h,
                borderWidth: 2,
                data: [1, 6, 3, 8, 3, 4, 5, 1, 8, 5, 8, 4, 2, 4, 6, 8, 5, 3, 7, 5, 8]
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
    var z = document.getElementById("time-site").getContext("2d");
    var t = z.createLinearGradient(0, 0, 0, 450);
    t.addColorStop(0, "#07be6e");
    var m = z.createLinearGradient(0, 0, 0, 450);
    m.addColorStop(0, "rgba(7, 190, 110,0.3)");
    m.addColorStop(1, "rgba(255,255,255,0)");
    new Chart(z, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
            datasets: [{
                label: "Data",
                borderColor: t,
                pointBorderColor: t,
                pointBackgroundColor: t,
                pointHoverBackgroundColor: t,
                pointHoverBorderColor: t,
                pointBorderWidth: 0,
                pointHoverRadius: 0,
                pointHoverBorderWidth: 0,
                pointRadius: 0,
                fill: true,
                backgroundColor: m,
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
    var y = document.getElementById("site-impressions").getContext("2d");
    var s = y.createLinearGradient(0, 0, 0, 450);
    s.addColorStop(0, "#07be6e");
    var l = y.createLinearGradient(0, 0, 0, 450);
    l.addColorStop(0, "rgba(7, 190, 110,0.3)");
    l.addColorStop(1, "rgba(255,255,255,0)");
    new Chart(y, {
        type: "line",
        data: {
            labels: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
            datasets: [{
                label: "Data",
                borderColor: s,
                pointBorderColor: s,
                pointBackgroundColor: s,
                pointHoverBackgroundColor: s,
                pointHoverBorderColor: s,
                pointBorderWidth: 0,
                pointHoverRadius: 0,
                pointHoverBorderWidth: 0,
                pointRadius: 0,
                fill: true,
                backgroundColor: l,
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
    });
    var A = [1, 3, 5, 4, 3, 3, 4, 8, 5];
    var B = [3, 2, 5, 4, 8, 4, 5, 2, 3];
    var C = [7, 5, 4, 5, 4, 7, 5, 5, 4];
    var D = [3, 3, 4, 6, 7, 6, 6, 4, 3];
    var E = [5, 4, 6, 7, 6, 5, 5, 7, 4];
    var u = ["Jan-11", "Jan-12", "Jan-13", "Jan-14", "Jan-15", "Jan-16", "Jan-17", "Jan-18", "Jan-19"];
    var w = {
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
        },
        elements: {
            point: {
                radius: 0
            }
        }
    };
    new Chart(document.getElementById("trend-01").getContext("2d"), {
        type: "line",
        data: {
            labels: u,
            datasets: [{
                label: "Data",
                borderColor: "#07be6e",
                backgroundColor: "transparent",
                borderWidth: 2,
                data: A
            }]
        },
        options: w
    });
    new Chart(document.getElementById("trend-02").getContext("2d"), {
        type: "line",
        data: {
            labels: u,
            datasets: [{
                label: "Data",
                borderColor: "#ec4e3f",
                backgroundColor: "transparent",
                borderWidth: 2,
                data: B
            }]
        },
        options: w
    });
    new Chart(document.getElementById("trend-03").getContext("2d"), {
        type: "line",
        data: {
            labels: u,
            datasets: [{
                label: "Data",
                borderColor: "#07be6e",
                backgroundColor: "transparent",
                borderWidth: 2,
                data: C
            }]
        },
        options: w
    });
    new Chart(document.getElementById("trend-04").getContext("2d"), {
        type: "line",
        data: {
            labels: u,
            datasets: [{
                label: "Data",
                borderColor: "#07be6e",
                backgroundColor: "transparent",
                borderWidth: 2,
                data: D
            }]
        },
        options: w
    });
    new Chart(document.getElementById("trend-05").getContext("2d"), {
        type: "line",
        data: {
            labels: u,
            datasets: [{
                label: "Data",
                borderColor: "#ec4e3f",
                backgroundColor: "transparent",
                borderWidth: 2,
                data: E
            }]
        },
        options: w
    })
})(jQuery);