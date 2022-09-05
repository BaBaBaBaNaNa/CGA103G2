(function(a) {
    new Morris.Line({
        element: "line-chart",
        data: [{
            year: "2008",
            value: 20
        }, {
            year: "2009",
            value: 10
        }, {
            year: "2010",
            value: 5
        }, {
            year: "2011",
            value: 5
        }, {
            year: "2012",
            value: 20
        }],
        xkey: "year",
        ykeys: ["value"],
        labels: ["Value"]
    });
    new Morris.Bar({
        element: "bar-chart",
        data: [{
            y: "2006",
            a: 100,
            b: 90
        }, {
            y: "2007",
            a: 75,
            b: 65
        }, {
            y: "2008",
            a: 50,
            b: 40
        }, {
            y: "2009",
            a: 75,
            b: 65
        }, {
            y: "2010",
            a: 50,
            b: 40
        }, {
            y: "2011",
            a: 75,
            b: 65
        }, {
            y: "2012",
            a: 100,
            b: 90
        }],
        xkey: "y",
        ykeys: ["a", "b"],
        labels: ["Series A", "Series B"]
    });
    new Morris.Donut({
        element: "doughnut-chart",
        data: [{
            label: "Download Sales",
            value: 12
        }, {
            label: "In-Store Sales",
            value: 30
        }, {
            label: "Mail-Order Sales",
            value: 20
        }]
    });
    new Morris.Bar({
        element: "stacked-bar-chart",
        data: [{
            x: "2011 Q1",
            y: 3,
            z: 2,
            a: 3
        }, {
            x: "2011 Q2",
            y: 2,
            z: null,
            a: 1
        }, {
            x: "2011 Q3",
            y: 0,
            z: 2,
            a: 4
        }, {
            x: "2011 Q4",
            y: 2,
            z: 4,
            a: 3
        }],
        xkey: "x",
        ykeys: ["y", "z", "a"],
        labels: ["Y", "Z", "A"],
        stacked: true
    });
    var d = 0;

    function b(f) {
        var g = [];
        for (var i = 0; i <= 360; i += 10) {
            var h = (f + i) % 360;
            g.push({
                x: i,
                y: Math.sin(Math.PI * h / 180).toFixed(4),
                z: Math.cos(Math.PI * h / 180).toFixed(4)
            })
        }
        return g
    }
    var c = new Morris.Line({
        element: "real-time-chart",
        data: b(0),
        xkey: "x",
        ykeys: ["y", "z"],
        labels: ["sin()", "cos()"],
        parseTime: false,
        ymin: -1,
        ymax: 1,
        hideHover: true
    });

    function e() {
        d++;
        c.setData(b(5 * d));
        a("#reloadStatus").text(d + " reloads")
    }
    setInterval(e, 1000);
    new Morris.Area({
        element: "area-chart",
        data: [{
            y: "2006",
            a: 100,
            b: 90
        }, {
            y: "2007",
            a: 75,
            b: 65
        }, {
            y: "2008",
            a: 50,
            b: 40
        }, {
            y: "2009",
            a: 75,
            b: 65
        }, {
            y: "2010",
            a: 50,
            b: 40
        }, {
            y: "2011",
            a: 75,
            b: 65
        }, {
            y: "2012",
            a: 100,
            b: 90
        }],
        xkey: "y",
        ykeys: ["a", "b"],
        labels: ["Series A", "Series B"]
    })
})(jQuery);