/**
 * Created by L.H.S on 2016/10/4.
 */

var tab = document.getElementById("rollpic");
var speed = 25;
var width;
var auto;
var stop = 0;  // stop=1 在setTimeout 中，不能再次启动roll

tab.onmouseover = function () {
    clearInterval(auto);
};
tab.onmouseout = function () {
    if (stop != 1) {
        startRoll();
    }
};

function getPics() {
    getPics_ajax("homepage/CarouselFigure/getAll", 0);
}

function getPics_detail() {
    getPics_ajax("/Phenomenology/homepage/CarouselFigure/getAll", 1);
}

function getPics_ajax(url, syb) {

    tab.innerHTML = "";
    $.ajax({
        type: "get",
        async: false,
        url: url,
        dataType: "json",
        success: function (result) {

            width = result.length * 237;
            tab.style.width = width;

            for (var i = 0; i < result.length; i++) {
                var div = document.createElement("div");
                div.className = "each_pic";
                tab.appendChild(div);

                var img = document.createElement("img");
                img.style.width = "220px";
                img.style.height = "111px";

                if (syb == 1) {
                    img.src = "/Phenomenology/" + result[i].location;
                } else {
                    img.src = result[i].location;
                }

                div.appendChild(img);

                var a = document.createElement("a");
                a.innerHTML = result[i].url;
                a.style.display = "none";
                div.appendChild(a);

                div.onclick = function () {
                    window.open(this.getElementsByTagName("a")[0].innerHTML);
                };

            }

            if (result.length > 5) {
                auto = setInterval(autoScroll, speed);
            }

        },
        error: function () {
            alert("滚动新闻获取失败");
        }
    });

}

function autoScroll() {

    if (tab.offsetLeft > (1004 - width)) {
        tab.style.left = tab.offsetLeft - 1;

        if (tab.offsetLeft == (1005 - width)) {
            stop = 1;
        }

    } else {
        clearInterval(auto);
        setTimeout("initPos()", 1500);
    }

}

function initPos() {
    tab.style.left = "";
    tab.offsetLeft = 0;
    setTimeout("startRoll()", 1500);
}

function startRoll() {
    auto = setInterval(autoScroll, speed);
    stop = 0;
}

var next = document.getElementsByClassName("next_pic")[1];
next.onmouseover = function () {
    clearInterval(auto);
};
next.onmouseout = function () {
    if (stop != 1) {
        startRoll();
    }
};
next.onclick = function () {
    clearInterval(auto);
    var shift = (Math.floor(-tab.offsetLeft / 237) + 1) * 237;
    if ((shift + 1004) >= width) {
        shift = width - 1124;
    }

    if (tab.offsetLeft > (1004 - width)) {
        tab.style.left = -shift;
    }
};

var previous = document.getElementsByClassName("next_pic")[0];
previous.onmouseover = function () {
    clearInterval(auto);
};
previous.onmouseout = function () {
    if (stop != 1) {
        startRoll();
    }
};
previous.onclick = function () {
    clearInterval(auto);
    var shift = (Math.ceil(-tab.offsetLeft / 237) - 1) * 237;

    if (tab.offsetLeft < 0) {
        tab.style.left = -shift;
    }
};

// 搜索 0,新窗口；1
function search(syb) {
    var key = document.getElementById("search_key").value;

    if (key != "") {

        if (syb == 0) {
            window.open("/Phenomenology/Search?key=" + key);
        } else {
            window.location.href = "/Phenomenology/Search?key=" + key;
        }

    }
}

// 文章详情界面 返回
function goBack() {
    var pos = parseInt(document.getElementById("storage").innerHTML);
    var urls = ["Organization", "AcademicCommunicate", "AcademicSource", "Achievement"];
    window.location.href = "/Phenomenology/" + urls[pos - 2];
}

// 返回顶部
function backToTop() {
    $(window).scroll(function () {
        if ($(this).scrollTop() > 150) {
            $("#back-to-top").fadeIn(200);
        } else {
            $("#back-to-top").fadeOut(200);
        }
    });
    $("#back-to-top").click(function () {
        $("html, body").animate({scrollTop: 0}, 500);
    });
}