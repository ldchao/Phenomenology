/**
 * Created by L.H.S on 2016/10/6.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下

window.onload = function () {
    getLectures();
    getMeetings();
    getVisitings();

    //  切换语言
    $.ajax({
        type: "get",
        async: false,
        url: "../getVersion",
        dataType: "json",
        success: function (result) {
            if(result == "eng") {
                var btns = document.getElementsByClassName("ch_eng");
                btns[0].setAttribute("class", "ch_eng ch_eng_not");
                btns[1].setAttribute("class", "ch_eng");

                changeVersion_title();
            }
        },
        error: function () {
            alert("语言版本获取失败");
        }
    });
};

// 讲座实录
function getLectures() {

    var lecture = document.getElementById("lecture");

    $.ajax({
        type: "get",
        async: false,
        url: "../academic/cathedra/get",
        data: {
            "language": "ch"
        },
        dataType: "json",
        success: function (result) {
            // 讲座实录
            setTitle(result, lecture);
        },
        error: function () {
            alert("讲座数据获取失败");
        }
    });
}

// 课程资源
function getMeetings() {
    var meeting = document.getElementById("meeting");

    $.ajax({
        type: "get",
        async: false,
        url: "../academic/course/get",
        data: {
            "language": "ch"
        },
        dataType: "json",
        success: function (result) {
            // 课程资源
            setTitle(result, meeting);
        },
        error: function () {
            alert("课程资源数据获取失败");
        }
    });

    $(meeting).hide();
}

// 学界动态
function getVisitings() {
    var visiting = document.getElementById("visiting");

    $.ajax({
        type: "get",
        async: false,
        url: "../academic/circleNews/get",
        data: {
            "language": "ch"
        },
        dataType: "json",
        success: function (result) {
            // 学界动态
            setTitle(result, visiting);
        },
        error: function () {
            alert("学界动态数据获取失败");
        }
    });

    $(visiting).hide();
}

function changeTab(index) {

    Tab_Selected = index;

    var Ids = ["lecture", "meeting", "visiting"];
    var tabs = document.getElementsByClassName("tab_achieve");

    tabs[index].style.borderBottom = "3px solid #1a799f";
    tabs[(index + 1) % 3].style.borderBottom = "";
    tabs[(index + 2) % 3].style.borderBottom = "";

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 3])).hide();
    $(document.getElementById(Ids[(index + 2) % 3])).hide();

}

function showArticle(link) {

    var tabs = ["讲座实录", "课程资源", "学界动态"];
    var Ids = ["cathedra", "course", "circleNews"];

    var content = document.getElementById("news_content");

    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();

    $.ajax({
        type: "get",
        async: false,
        url: "../academic/" + Ids[Tab_Selected] + "/getOne",
        data: {
            "id": id
        },
        dataType: "json",
        success: function (result) {
           
            content.getElementsByClassName("article_title")[0].innerHTML = result.title;
            document.getElementById("writer").innerHTML = result.author;
            document.getElementById("time").innerHTML = result.time;
            document.getElementById("viewer").innerHTML = result.pageView;

            $.ajax({
                type: "get",
                async: false,
                url: "../getHtml",
                data: {
                    "filename": result.location
                },
                dataType: "html",
                success: function (text) {
                    content.getElementsByClassName("text_content")[0].innerHTML = text;
                },
                error: function () {
                    alert("html数据获取失败");
                }
            });
        },
        error: function () {
            alert("出访数据获取失败");
        }
    });

    var backbtn = content.getElementsByClassName("back_lbl")[0];
    backbtn .getElementsByTagName("span")[0].innerHTML = tabs[Tab_Selected];
    backbtn.onclick = function () {
        $("#news_content").hide();
        $("#news_list").show();
    };


    $("#news_list").hide();
    $("#news_content").show();
}

function setTitle(result, parent) {
    var copy = document.getElementById("lecture_copy");

    for (var i = 0; i < result.length; i++) {

        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_lecture");

        var title = div.getElementsByClassName("lecture_title")[0];
        title.innerHTML = result[i].title;
        title.onclick = function () {
            showArticle(this);
        };

        div.getElementsByTagName("span")[1].innerHTML = result[i].time;
        div.getElementsByTagName("a")[0].innerHTML = result[i].id;

        parent.appendChild(div);
    }
}