/**
 * Created by L.H.S on 2016/10/4.
 */

var tab = document.getElementById("rollpic");
var speed = 25;
var width = tab.getElementsByClassName("each_pic").length * 237;
tab.style.width = width;
var auto = setInterval(autoScroll, speed);
var stop = 0;  // stop=1 在setTimeout 中，不能再次启动roll

tab.onmouseover = function () {
    clearInterval(auto);
};
tab.onmouseout = function () {
    if (stop != 1) {
        startRoll();
    }
};

function autoScroll() {

    if (tab.offsetLeft > (1124 - width)) {
        tab.style.left = tab.offsetLeft - 1;

        if (tab.offsetLeft == (1125 - width)) {
            stop = 1;
        }

    } else {
        clearInterval(auto);
        setTimeout("initPos()", 3000);
    }

}

function initPos() {
    tab.style.left = "";
    tab.offsetLeft = 0;
    setTimeout("startRoll()", 3000);
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
    if ((shift + 1124) >= width) {
        shift = width - 1124;
    }

    if (tab.offsetLeft > (1124 - width)) {
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

// 更换中英文版本
function changeVersion(index) {

    var btns = document.getElementsByClassName("ch_eng");

    var version = ["ch", "eng"];

    if (btns[index].getAttribute("class") != "ch_eng") {

        btns[index].setAttribute("class", "ch_eng");
        btns[(index + 1) % 2].setAttribute("class", "ch_eng ch_eng_not");

        $.ajax({
            type: "get",
            async: false,
            url: "../setVersion",
            data: {
                "version": version[index],
            },
            dataType: "json",
            success: function () {
                window.location.reload();
            },
            error: function () {
                alert("语言切换失败");
            }
        });
    }
}

function changeVersion_title() {
    var titles = document.getElementsByClassName("left_nav")[0].getElementsByTagName("span");
    var divs = document.getElementsByClassName("left_nav")[0].getElementsByClassName("nav_bar");
    var Engs = ["&nbsp;HomePage", "OurSituation", "AgencyPersonnel",
        "AcademicExchange", "AcademicResources", "ScientificAchievements"];

    for (var i = 0; i < titles.length; i++) {
        titles[i].innerHTML = Engs[i];

        divs[i].style.paddingLeft = "20px";
        divs[i].style.width = "210px";
        titles[i].style.fontSize = "16px";
    }
}
