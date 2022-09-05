(function(a) {
    var b = (function() {
        function r() {
            i();
            D();
            k();
            m(".ms-sortable", ".ms-draggable", "enable", false);
            E();
            if (a(".ms-quick-bar").length > 0) {
                B();
                x();
                y()
            }
            j();
            I();
            C();
            t();
            v();
            w();
            l();
            e();
            d();
            c();
            h();
            H();
            F();
            p();
            n();
            o();
            s()
        }
        a(window).on("load", function() {
            a("#preloader-wrap").addClass("loaded")
        });

        function i() {
            var J = document.getElementsByClassName("ms-quick-bar-item");
            a("body").on("keyup", function(K) {
                if (K.keyCode == 27) {
                    z()
                }
                if (K.altKey && K.keyCode == 81) {
                    a(".ms-configure-qa").trigger("click")
                }
                if (K.altKey && K.keyCode == 49) {
                    a(J[0]).find("a:first-child").trigger("click")
                }
                if (K.altKey && K.keyCode == 50) {
                    a(J[1]).find("a:first-child").trigger("click")
                }
                if (K.altKey && K.keyCode == 51) {
                    a(J[2]).find("a:first-child").trigger("click")
                }
                if (K.altKey && K.keyCode == 52) {
                    a(J[3]).find("a:first-child").trigger("click")
                }
                if (K.altKey && K.keyCode == 53) {
                    a(J[4]).find("a:first-child").trigger("click")
                }
                if (K.altKey && K.keyCode == 54) {
                    a(J[5]).find("a:first-child").trigger("click")
                }
            })
        }

        function g() {
            return (location.protocol == "http:" || location.protocol == "https:")
        }

        function G(K, J) {
            localStorage[K] = JSON.stringify(J)
        }

        function q(J) {
            if (localStorage[J]) {
                return JSON.parse(localStorage[J])
            } else {
                return []
            }
        }

        function D() {
            var J = location.pathname.split("/").slice(-1)[0].replace(/^\/|\/$/g, "");
            a(".ms-main-aside .menu-item a", a("#ms-side-nav")).each(function() {
                var K = a(this);
                if (J === "" || J === "index.html") {
                    if (K.attr("href").indexOf("index.html") !== -1) {
                        a(this).addClass("active");
                        a(this).parents(".collapse").prev().addClass("active");
                        if (a(this).parents(".collapse").length) {
                            a(this).closest(".collapse").addClass("show")
                        }
                    }
                } else {
                    if (K.attr("href").indexOf(J) !== -1) {
                        a(this).addClass("active");
                        a(this).parents(".collapse").prev().addClass("active");
                        if (a(this).parents(".collapse").length) {
                            a(this).closest(".collapse").addClass("show")
                        }
                    }
                }
            })
        }

        function k() {
            a(".ms-toggler").bind("click", function() {
                var J = a(this).data("target");
                var K = a(this).data("toggle");
                switch (K) {
                    case "slideLeft":
                        a(J).toggleClass("ms-aside-open");
                        a(".ms-aside-overlay.ms-overlay-left").toggleClass("d-block");
                        a("body").toggleClass("ms-aside-left-open");
                        break;
                    case "slideRight":
                        a(J).toggleClass("ms-aside-open");
                        a(".ms-aside-overlay.ms-overlay-right").toggleClass("d-block");
                        break;
                    case "slideDown":
                        a(J).toggleClass("ms-slide-down");
                        break;
                    case "hideQuickBar":
                        z();
                        break;
                    default:
                        return
                }
            })
        }

        function m(K, J, M, L) {
            a(K).sortable({
                scroll: false,
                placeholder: "ui-state-highlight",
                start: function(N, O) {
                    O.placeholder.height(O.item.height());
                    O.placeholder.width(O.item.width())
                }
            });
            a(K).sortable(M);
            a(J).draggable({
                opacity: 0.75,
                connectToSortable: K,
                containment: "parent",
                revert: "invalid",
                disabled: L,
            });
            a(K).disableSelection()
        }

        function E() {
            a(".ms-sortable-list").sortable({
                opacity: 0.75,
                connectWith: ".ms-sortable-list",
                placeholder: "ui-state-highlight",
                start: function(J, K) {
                    K.placeholder.height(K.item.height())
                }
            }).disableSelection()
        }

        function B() {
            a(".ms-quick-bar-list").on("click", ".ms-has-qa", function() {
                if (u() == false) {
                    a(".ms-quick-bar").addClass("ms-quick-bar-open");
                    a(".ms-quick-bar-title").text(a(this).data("title"))
                }
            })
        }

        function u() {
            return a(".ms-quick-bar-list").hasClass("ms-qa-configure-mode")
        }

        function z() {
            a(".ms-quick-bar").removeClass("ms-quick-bar-open");
            a(".ms-quick-bar-item > a").removeClass("active show");
            a(".ms-quick-bar-item > a").attr("aria-selected", "false");
            a(".ms-quick-bar > .tab-content .tab-pane").removeClass("active show")
        }

        function f(J) {
            if (!a(J).hasClass("animated")) {
                a(J).css("stroke-dashoffset", 358.141563 - (358.141563 / 100) * a(J).attr("aria-valuenow"));
                a(J).addClass("animated")
            }
        }

        function t() {
            var J = a(".progress-cicle");
            J.each(function() {
                f(this)
            })
        }

        function x() {
            var K, J;
            m(".ms-quick-bar-list", ".ms-has-qa", "disable", true);
            a(".ms-configure-qa").on("click", function(L) {
                L.preventDefault();
                a(".ms-quick-bar-item a").removeAttr("data-toggle");
                z();
                a(".ms-quick-bar-list").toggleClass("ms-qa-configure-mode");
                K = (a(".ms-quick-bar-list").hasClass("ms-qa-configure-mode")) ? "enable" : "disable";
                J = (K == "disable") ? true : false;
                if (K == "disable") {
                    a(".ms-quick-bar-item a").attr("data-toggle", "tab");
                    A()
                }
                m(".ms-quick-bar-list", ".ms-has-qa", K, J)
            })
        }

        function A() {
            if (g()) {
                var J = a(".ms-quick-bar-list")[0].innerHTML;
                G("quickbar_layout", J)
            }
        }

        function y() {
            if (g()) {
                var J = q("quickbar_layout");
                if (J.length > 0) {
                    a(".ms-quick-bar-list")[0].innerHTML = J
                }
            }
        }

        function j() {
            if (a(".ms-scrollable").length > 0) {
                a(".ms-scrollable").each(function() {
                    var K = new PerfectScrollbar(a(this)[0], {
                        maxScrollbarLength: 700,
                        wheelPropagation: true
                    })
                })
            }
            if (a(".ms-aside-scrollable").length > 0) {
                var J = new PerfectScrollbar(a(".ms-aside-scrollable")[0], {
                    maxScrollbarLength: 700,
                    wheelPropagation: true,
                    wheelSpeed: 0.5
                });
                a(".ms-main-aside").on("click", ".has-chevron", function() {
                    J.update()
                })
            }
        }

        function I() {
            a("body").tooltip({
                selector: '[data-toggle="tooltip"]',
                trigger: "hover",
                template: '<div class="tooltip" role="tooltip"><div class="tooltip-inner"></div></div>'
            })
        }

        function C() {
            Popper.Defaults.modifiers.computeStyle.gpuAcceleration = false
        }

        function v() {
            a(".ms-members-list").on("click", "a", function() {
                var J = a(this).find("img").attr("src");
                a(this).closest(".ms-card-footer").prev().find(".ms-note-members").append('<li class="ms-deletable"> <img src="' + J + '" alt="member"> </li>')
            })
        }

        function w() {
            a(".ms-note-members").on("click", ".ms-deletable", function() {
                a(this).remove()
            })
        }

        function l() {
            a("body").on("click", ".ms-delete-trigger", function() {
                a(this).closest(".ms-deletable").slideUp("slow", function() {
                    a(this).closest(".ms-deletable").remove()
                })
            })
        }

        function e() {
            a(".ms-add-task-block").on("submit", function(J) {
                J.preventDefault();
                a(".ms-quickbar-container .ms-todo-list").prepend('<div class="ms-card ms-qa-card ms-deletable"> <div class="ms-card-header clearfix"><h6 class="ms-card-title">' + a("#task-block").val() + '</h6> <button data-toggle="tooltip" data-placement="left" title="Add a Task to this block" class="ms-add-task-to-block ms-btn-icon float-right"><i class="material-icons">add</i> </button> </div> <div class="ms-card-body"> <ul class="ms-list ms-task-block"> </ul></div><div class="ms-card-footer clearfix"><a href="#" class="text-disabled mr-2"> <i class="flaticon-archive"> </i> Archive </a><a href="#" class="text-disabled ms-delete-trigger float-right"><i class="flaticon-trash"> </i> Delete </a> </div> </div>')
            })
        }

        function d() {
            a(".ms-add-task-block-2").on("submit", function(J) {
                J.preventDefault();
                a(".ms-todo-list").prepend('<div class="col-xl-4 col-md-6 col-sm-12 ms-deletable"> <div class="ms-card"> <div class="ms-card-header clearfix"><h6 class="ms-card-title">' + a("#task-block-2").val() + '</h6> <button data-toggle="tooltip" data-placement="left" title="Add a Task to this block" class="ms-add-task-to-block ms-btn-icon float-right"><i class="material-icons">add</i> </button> </div> <div class="ms-card-body"> <ul class="ms-list ms-task-block"> </ul></div><div class="ms-card-footer clearfix"><a href="#" class="text-disabled mr-2"> <i class="flaticon-archive"> </i> Archive </a><a href="#" class="text-disabled ms-delete-trigger float-right"><i class="flaticon-trash"> </i> Delete </a> </div> </div> </div>')
            })
        }

        function c() {
            a(".ms-todo-list").on("click", ".ms-add-task-to-block", function() {
                var J = a(this).parent().next().find(".ms-task-block");
                J.append('<li class="ms-list-item ms-to-do-task ms-deletable"><label class="ms-checkbox-wrap ms-todo-complete" for=""><input type="checkbox" name="" value=""><i class="ms-checkbox-check"></i></label><form class="ms-confirm-task-form"> <input type="text" class="ms-task-input ms-task-edit"/><button type="submit" class="close"><i class="material-icons fs-16 ms-confirm-trigger">check</i></button></form></li>');
                J.find(".ms-task-edit").focus()
            })
        }

        function h() {
            a(".ms-todo-list").on("submit", ".ms-confirm-task-form", function(K) {
                K.preventDefault();
                var J = a(this).find("i");
                var L = a(this).find(".ms-task-input");
                J.removeClass("material-icons fs-14 ms-confirm-trigger");
                J.addClass("");
                J.text("");
                a(this).replaceWith("<span>" + L.val() + '</span><button class="close"><i class="flaticon-trash ms-delete-trigger"> </i></button>')
            })
        }

        function H() {
            a(".ms-todo-list").on("click", ".ms-todo-complete", function() {
                a(this).parent().toggleClass("task-complete")
            })
        }

        function F() {
            a(".ms-star-rating").on("click", ".ms-rating-item", function() {
                a(this).prevAll().removeClass("rated");
                a(this).addClass("rated");
                a(this).nextAll().addClass("rated")
            })
        }

        function p() {
            window.addEventListener("load", function() {
                var J = document.getElementsByClassName("needs-validation");
                var K = Array.prototype.filter.call(J, function(L) {
                    L.addEventListener("submit", function(M) {
                        if (L.checkValidity() === false) {
                            M.preventDefault();
                            M.stopPropagation()
                        }
                        L.classList.add("was-validated")
                    }, false)
                })
            }, false)
        }

        function n() {
            a(".ms-email-check-all").on("click", function() {
                a(".ms-email input").not(this).prop("checked", this.checked)
            })
        }

        function o() {
            a(".ms-email-content").on("click", ".ms-pin-email", function() {
                a(this).closest(".ms-email").toggleClass("pinned")
            })
        }

        function s() {
            a(".datepicker").each(function() {
                a(this).datepicker()
            })
        }
        return {
            init: r
        }
    })();
    b.init()
})(jQuery);