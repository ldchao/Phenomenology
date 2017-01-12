/**
 * Created by L.H.S on 2016/10/9.
 */

// 更换中英文版本
function changeVersion(index) {

    var btns = document.getElementsByClassName("ch_eng");

    var version = ["ch", "eng"];

    if (btns[index].getAttribute("class") != "ch_eng") {

        $.ajax({
            type: "get",
            async: false,
            url: "setVersion",
            data: {
                "version": version[index],
            },
            dataType: "json",
            success: function () {
                btns[index].setAttribute("class", "ch_eng");
                btns[(index + 1) % 2].setAttribute("class", "ch_eng ch_eng_not");
                window.location.reload();
            },
            error: function () {
                alert("语言切换失败");
            }
        });
    }
}

function changeVersion_detail(index) {

    var btns = document.getElementsByClassName("ch_eng");

    var version = ["ch", "eng"];

    if (btns[index].getAttribute("class") != "ch_eng") {

        $.ajax({
            type: "get",
            async: false,
            url: "../../setVersion",
            data: {
                "version": version[index],
            },
            dataType: "json",
            success: function () {
                btns[index].setAttribute("class", "ch_eng");
                btns[(index + 1) % 2].setAttribute("class", "ch_eng ch_eng_not");

                var pos = parseInt(document.getElementById("storage").innerHTML);
                var urls = ["Organization", "AcademicCommunicate", "AcademicSource", "Achievement"];
                window.location.href = "/Phenomenology/" + urls[pos - 2];
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
        url: "getVersion",
        dataType: "json",
        success: function (result) {

            if (result == "eng") {
                language = "eng";

                var btns = document.getElementsByClassName("ch_eng");
                btns[0].setAttribute("class", "ch_eng ch_eng_not");
                btns[1].setAttribute("class", "ch_eng");

                if (document.getElementsByClassName("left_nav").length > 0) {
                    changeVersion_title();
                }
                
                changeVersion_content();
            }
        },
        error: function () {
            alert("语言版本获取失败");
        }
    });

    return language;
}

function judgeVersion_detail() {

    var language = "ch";
    //  切换语言
    $.ajax({
        type: "get",
        async: false,
        url: "../../getVersion",
        dataType: "json",
        success: function (result) {
            if (result == "eng") {
                language = "eng";

                var btns = document.getElementsByClassName("ch_eng");
                btns[0].setAttribute("class", "ch_eng ch_eng_not");
                btns[1].setAttribute("class", "ch_eng");

                if (document.getElementsByClassName("left_nav").length > 0) {
                    changeVersion_title();
                }
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
        "AcademicExchange", "AcademicResources", "ScientificAchievements", "Blogroll"];

    for (var i = 0; i < titles.length; i++) {
        titles[i].innerHTML = Engs[i];

        divs[i].style.paddingLeft = "20px";
        divs[i].style.width = "210px";
        if (i < titles.length - 1) {
            titles[i].style.fontSize = "16px";
        } else {
            titles[i].style.fontSize = "15px";
        }

    }

    var bottom = document.getElementsByClassName("bottom_nav")[0];
    var spans = bottom.getElementsByTagName("span");

    var eng_bottom = ["Forwarding Address", "No.163,Xianlin Avenue,Nanjing",
        "Xianlin Campus of Nanjing University Xue Guanglin building", "Postcodes", "Mailbox"];

    for (var i = 0; i < eng_bottom.length; i++) {
        spans[i].innerHTML = eng_bottom[i];
    }

    document.getElementById("search_key").placeholder = "Search what you want…";
}

function setImage() {
    document.getElementById("img").src = "/Phenomenology/" + document.getElementById("storage_img").innerHTML;
}