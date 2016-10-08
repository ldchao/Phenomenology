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

function judgeVersion() {

    var language = "ch";
    //  切换语言
    $.ajax({
        type: "get",
        async: false,
        url: "../getVersion",
        dataType: "json",
        success: function (result) {
            if (result == "eng") {
                language = "eng";

                var btns = document.getElementsByClassName("ch_eng");
                btns[0].setAttribute("class", "ch_eng ch_eng_not");
                btns[1].setAttribute("class", "ch_eng");

                changeVersion_title();
                changeVersion_content();
            }
        },
        error: function () {
            // alert("语言版本获取失败");
        }
    });

    return language;
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
       if(i<titles.length - 1) {
           titles[i].style.fontSize = "16px";
       } else {
           titles[i].style.fontSize = "15px";
       }

    }
    
    var bottom = document.getElementsByClassName("bottom_nav")[0];
    var spans = bottom.getElementsByTagName("span");
    var links = bottom.getElementsByTagName("a");

    var eng_title = ["Forwarding Address", "No.163,Xianlin Avenue,Nanjing",
        "Xianlin Campus of Nanjing University Xue Guanglin building", "Postcodes", "Friendship link"];
    var eng_a = ["Husserl archives of Freiburg University", "Husserl archives of University of Cologne",
        "Leuven Husserl University Archives", "Husserl archives of Université de Paris I", "Chinese phenomena network"];

    for (var i = 0; i < eng_title.length; i++) {
        spans[i].innerHTML = eng_title[i];
    }

    for (var j = 0; j < eng_a.length; j++) {
        links[j].innerHTML = eng_a[j];
    }

    document.getElementById("search_key").placeholder = "Search what you want…";
}
