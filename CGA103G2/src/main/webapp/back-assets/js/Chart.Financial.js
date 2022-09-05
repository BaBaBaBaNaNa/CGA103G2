/*
 * chartjs-chart-financial
 * Version: 0.1.0
 *
 * Copyright 2017 chartjs-chart-financial contributors
 * Released under the MIT license
 * https://github.com/chartjs/chartjs-chart-financial/blob/master/LICENSE.md
 */
(function() {
    function a(b, d, g) {
        function f(l, k) {
            if (!d[l]) {
                if (!b[l]) {
                    var j = "function" == typeof require && require;
                    if (!k && j) {
                        return j(l, !0)
                    }
                    if (h) {
                        return h(l, !0)
                    }
                    var e = new Error("Cannot find module '" + l + "'");
                    throw e.code = "MODULE_NOT_FOUND", e
                }
                var m = d[l] = {
                    exports: {}
                };
                b[l][0].call(m.exports, function(o) {
                    var i = b[l][1][o];
                    return f(i || o)
                }, m, m.exports, a, b, d, g)
            }
            return d[l].exports
        }
        for (var h = "function" == typeof require && require, c = 0; c < g.length; c++) {
            f(g[c])
        }
        return f
    }
    return a
})()({
    1: [function(c, b, a) {}, {}],
    2: [function(c, b, a) {
        b.exports = function(d) {
            d.defaults.candlestick = Object.assign({}, d.defaults.financial);
            d.defaults.candlestick.scales = {
                xAxes: [Object.assign({}, d.defaults.financial.scales.xAxes[0])],
                yAxes: [Object.assign({}, d.defaults.financial.scales.yAxes[0])]
            };
            d.controllers.candlestick = d.controllers.financial.extend({
                dataElementType: d.elements.Candlestick,
                updateElement: function(f, g, j) {
                    var h = this;
                    var i = h.getMeta();
                    var e = h.getDataset();
                    f._xScale = h.getScaleForId(i.xAxisID);
                    f._yScale = h.getScaleForId(i.yAxisID);
                    f._datasetIndex = h.index;
                    f._index = g;
                    f._model = {
                        datasetLabel: e.label || "",
                        color: e.color,
                        borderColor: e.borderColor,
                        borderWidth: e.borderWidth,
                    };
                    h.updateElementGeometry(f, g, j);
                    f.pivot()
                },
            })
        }
    }, {}],
    3: [function(c, b, a) {
        b.exports = function(d) {
            d.defaults.financial = {
                label: "",
                hover: {
                    mode: "label"
                },
                scales: {
                    xAxes: [{
                        type: "time",
                        distribution: "series",
                        categoryPercentage: 0.8,
                        barPercentage: 0.9,
                        ticks: {
                            source: "data"
                        }
                    }],
                    yAxes: [{
                        type: "financialLinear"
                    }]
                },
                tooltips: {
                    callbacks: {
                        label: function(m, f) {
                            var k = f.datasets[m.datasetIndex].data[m.index].o;
                            var i = f.datasets[m.datasetIndex].data[m.index].h;
                            var j = f.datasets[m.datasetIndex].data[m.index].l;
                            var e = f.datasets[m.datasetIndex].data[m.index].c;
                            var g = f.datasets[m.datasetIndex].fractionalDigitsCount;
                            if (g !== undefined) {
                                g = Math.max(0, Math.min(100, g));
                                k = k.toFixed(g);
                                i = i.toFixed(g);
                                j = j.toFixed(g);
                                e = e.toFixed(g)
                            }
                            return " O: " + k + "    H: " + i + "    L: " + j + "    C: " + e
                        }
                    }
                }
            };
            d.controllers.financial = d.controllers.bar.extend({
                dataElementType: d.elements.Financial,
                updateElementGeometry: function(h, j, o) {
                    var m = this;
                    var n = h._model;
                    var r = m.getValueScale();
                    var e = r.getBasePixel();
                    var i = r.isHorizontal();
                    var p = m._ruler || m.getRuler();
                    var q = m.calculateBarValuePixels(m.index, j);
                    var l = m.calculateBarIndexPixels(m.index, j, p);
                    var f = m.chart;
                    var g = f.data.datasets;
                    var k = g[m.index].data[j];
                    n.horizontal = i;
                    n.base = o ? e : q.base;
                    n.x = i ? o ? e : q.head : l.center;
                    n.y = i ? l.center : o ? e : q.head;
                    n.height = i ? l.size : undefined;
                    n.width = i ? undefined : l.size;
                    n.candleOpen = r.getPixelForValue(Number(k.o));
                    n.candleHigh = r.getPixelForValue(Number(k.h));
                    n.candleLow = r.getPixelForValue(Number(k.l));
                    n.candleClose = r.getPixelForValue(Number(k.c))
                },
                draw: function() {
                    var e = this.chart.chart.ctx;
                    var h = this.getMeta().data;
                    var g = this.getDataset();
                    var k = h.length;
                    var j = 0;
                    var f;
                    d.canvasHelpers.clipArea(e, this.chart.chartArea);
                    for (; j < k; ++j) {
                        f = g.data[j].o;
                        if (f !== null && f !== undefined && !isNaN(f)) {
                            h[j].draw()
                        }
                    }
                    d.canvasHelpers.unclipArea(e)
                },
            })
        }
    }, {}],
    4: [function(c, b, a) {
        b.exports = function(d) {
            d.defaults.ohlc = Object.assign({}, d.defaults.financial);
            d.defaults.ohlc.scales = {
                xAxes: [Object.assign({}, d.defaults.financial.scales.xAxes[0])],
                yAxes: [Object.assign({}, d.defaults.financial.scales.yAxes[0])]
            };
            d.defaults.ohlc.scales.xAxes[0].barPercentage = 1;
            d.defaults.ohlc.scales.xAxes[0].categoryPercentage = 1;
            d.controllers.ohlc = d.controllers.financial.extend({
                dataElementType: d.elements.Ohlc,
                updateElement: function(f, g, j) {
                    var h = this;
                    var i = h.getMeta();
                    var e = h.getDataset();
                    f._xScale = h.getScaleForId(i.xAxisID);
                    f._yScale = h.getScaleForId(i.yAxisID);
                    f._datasetIndex = h.index;
                    f._index = g;
                    f._model = {
                        datasetLabel: e.label || "",
                        lineWidth: e.lineWidth,
                        armLength: e.armLength,
                        armLengthRatio: e.armLengthRatio,
                        color: e.color,
                    };
                    h.updateElementGeometry(f, g, j);
                    f.pivot()
                },
            })
        }
    }, {}],
    5: [function(c, b, a) {
        b.exports = function(d) {
            var f = d.helpers;
            var e = d.defaults.global;
            e.elements.candlestick = Object.assign(e.elements.financial, {
                borderColor: e.elements.financial.color.unchanged,
                borderWidth: 1,
            });
            d.elements.Candlestick = d.elements.Financial.extend({
                draw: function() {
                    var k = this._chart.ctx;
                    var q = this._view;
                    var r = q.x;
                    var p = q.candleOpen;
                    var m = q.candleHigh;
                    var n = q.candleLow;
                    var j = q.candleClose;
                    var i = q.borderColor;
                    if (typeof i === "string") {
                        i = {
                            up: i,
                            down: i,
                            unchanged: i
                        }
                    }
                    var g;
                    if (j < p) {
                        g = f.getValueOrDefault(i ? i.up : undefined, e.elements.candlestick.color.up);
                        k.fillStyle = f.getValueOrDefault(q.color ? q.color.up : undefined, e.elements.candlestick.color.up)
                    } else {
                        if (j > p) {
                            g = f.getValueOrDefault(i ? i.down : undefined, e.elements.candlestick.color.down);
                            k.fillStyle = f.getValueOrDefault(q.color ? q.color.down : undefined, e.elements.candlestick.color.down)
                        } else {
                            g = f.getValueOrDefault(i ? i.unchanged : undefined, e.elements.candlestick.color.unchanged);
                            k.fillStyle = f.getValueOrDefault(q.color ? q.color.unchanged : undefined, e.elements.candlestick.color.unchanged)
                        }
                    }
                    k.lineWidth = f.getValueOrDefault(q.borderWidth, e.elements.candlestick.borderWidth);
                    k.strokeStyle = f.getValueOrDefault(g, e.elements.candlestick.borderColor);
                    k.beginPath();
                    k.moveTo(r, m);
                    k.lineTo(r, Math.min(p, j));
                    k.moveTo(r, n);
                    k.lineTo(r, Math.max(p, j));
                    k.stroke();
                    k.fillRect(r - q.width / 2, j, q.width, p - j);
                    k.strokeRect(r - q.width / 2, j, q.width, p - j);
                    k.closePath()
                },
            })
        }
    }, {}],
    6: [function(c, b, a) {
        b.exports = function(d) {
            var f = d.defaults.global;
            f.elements.financial = {
                color: {
                    up: "rgba(80, 160, 115, 1)",
                    down: "rgba(215, 85, 65, 1)",
                    unchanged: "rgba(90, 90, 90, 1)",
                },
                fractionalDigitsCount: undefined,
            };

            function g(h) {
                return h._view.width !== undefined
            }

            function e(h) {
                var j = h._view;
                var k, l, m, n;
                var i = j.width / 2;
                k = j.x - i;
                l = j.x + i;
                m = j.candleHigh;
                n = j.candleLow;
                return {
                    left: k,
                    top: m,
                    right: l,
                    bottom: n
                }
            }
            d.elements.Financial = d.Element.extend({
                height: function() {
                    var h = this._view;
                    return h.base - h.y
                },
                inRange: function(j, k) {
                    var i = false;
                    if (this._view) {
                        var h = e(this);
                        i = j >= h.left && j <= h.right && k >= h.top && k <= h.bottom
                    }
                    return i
                },
                inLabelRange: function(k, l) {
                    var j = this;
                    if (!j._view) {
                        return false
                    }
                    var i = false;
                    var h = e(j);
                    if (g(j)) {
                        i = k >= h.left && k <= h.right
                    } else {
                        i = l >= h.top && l <= h.bottom
                    }
                    return i
                },
                inXRange: function(i) {
                    var h = e(this);
                    return i >= h.left && i <= h.right
                },
                inYRange: function(i) {
                    var h = e(this);
                    return i >= h.top && i <= h.bottom
                },
                getCenterPoint: function() {
                    var i = this._view;
                    var j, k;
                    var h = i.width / 2;
                    j = i.x - h;
                    k = (i.candleHigh + i.candleLow) / 2;
                    return {
                        x: j,
                        y: k
                    }
                },
                getArea: function() {
                    var h = this._view;
                    return h.width * Math.abs(h.y - h.base)
                },
                tooltipPosition: function() {
                    var h = this._view;
                    return {
                        x: h.x,
                        y: (h.candleHigh + h.candleLow) / 2
                    }
                }
            })
        }
    }, {}],
    7: [function(c, b, a) {
        b.exports = function(d) {
            var f = d.helpers;
            var e = d.defaults.global;
            e.elements.ohlc = Object.assign(e.elements.financial, {
                lineWidth: 2,
                armLength: null,
                armLengthRatio: 0.8,
            });
            d.elements.Ohlc = d.elements.Financial.extend({
                draw: function() {
                    var k = this._chart.ctx;
                    var q = this._view;
                    var r = q.x;
                    var p = q.candleOpen;
                    var m = q.candleHigh;
                    var n = q.candleLow;
                    var j = q.candleClose;
                    var g = f.getValueOrDefault(q.armLength, e.elements.ohlc.armLength);
                    var i = f.getValueOrDefault(q.armLengthRatio, e.elements.ohlc.armLengthRatio);
                    if (g === null) {
                        g = q.width * i * 0.5
                    }
                    if (j < p) {
                        k.strokeStyle = f.getValueOrDefault(q.color ? q.color.up : undefined, e.elements.ohlc.color.up)
                    } else {
                        if (j > p) {
                            k.strokeStyle = f.getValueOrDefault(q.color ? q.color.down : undefined, e.elements.ohlc.color.down)
                        } else {
                            k.strokeStyle = f.getValueOrDefault(q.color ? q.color.unchanged : undefined, e.elements.ohlc.color.unchanged)
                        }
                    }
                    k.lineWidth = f.getValueOrDefault(q.lineWidth, e.elements.ohlc.lineWidth);
                    k.beginPath();
                    k.moveTo(r, m);
                    k.lineTo(r, n);
                    k.moveTo(r - g, p);
                    k.lineTo(r, p);
                    k.moveTo(r + g, j);
                    k.lineTo(r, j);
                    k.stroke()
                },
            })
        }
    }, {}],
    8: [function(d, c, b) {
        var a = d("chart.js");
        a = typeof a === "function" ? a : window.Chart;
        d("./scale.financialLinear.js")(a);
        d("./element.financial.js")(a);
        d("./element.candlestick.js")(a);
        d("./element.ohlc.js")(a);
        d("./controller.financial.js")(a);
        d("./controller.candlestick.js")(a);
        d("./controller.ohlc.js")(a)
    }, {
        "./controller.candlestick.js": 2,
        "./controller.financial.js": 3,
        "./controller.ohlc.js": 4,
        "./element.candlestick.js": 5,
        "./element.financial.js": 6,
        "./element.ohlc.js": 7,
        "./scale.financialLinear.js": 9,
        "chart.js": 1
    }],
    9: [function(c, b, a) {
        b.exports = function(d) {
            var g = d.helpers;
            var e = {
                position: "left",
                ticks: {
                    callback: d.Ticks.formatters.linear
                }
            };
            var f = d.scaleService.getScaleConstructor("linear").extend({
                determineDataLimits: function() {
                    var m = this;
                    var h = m.chart;
                    var i = h.data;
                    var j = i.datasets;
                    var l = m.isHorizontal();

                    function k(o) {
                        return l ? o.xAxisID === m.id : o.yAxisID === m.id
                    }
                    m.min = null;
                    m.max = null;
                    g.each(j, function(o, p) {
                        var q = h.getDatasetMeta(p);
                        if (h.isDatasetVisible(p) && k(q)) {
                            g.each(o.data, function(t) {
                                var r = t.h;
                                var s = t.l;
                                if (m.min === null) {
                                    m.min = s
                                } else {
                                    if (s < m.min) {
                                        m.min = s
                                    }
                                }
                                if (m.max === null) {
                                    m.max = r
                                } else {
                                    if (r > m.max) {
                                        m.max = r
                                    }
                                }
                            })
                        }
                    });
                    var n = (m.max - m.min) * 0.05;
                    m.min -= n;
                    m.max += n;
                    this.handleTickRangeOptions()
                }
            });
            d.scaleService.registerScaleType("financialLinear", f, e)
        }
    }, {}]
}, {}, [8]);