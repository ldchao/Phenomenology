/**
 * Created by L.H.S on 2016/9/26.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下
var language = "ch";

window.onload = function () {
    language = judgeVersion();

    enterSubNav();

    getPics();
    
    getLectures();
    getMeetings();
    getVisitings();
};

// 学术讲座
function getLectures() {

    var lecture = document.getElementById("lecture");

    $.ajax({
        type: "get",
        async: false,
        url: "academicCommunicate/lecture/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {
            // 讲座
            setTitle(result, lecture);
        },
        error: function () {
            alert("学术交流数据获取失败");
        }
    });

}

// 学术交流
function getMeetings() {
    var meeting = document.getElementById("meeting");

    $.ajax({
        type: "get",
        async: false,
        url: "academicCommunicate/communicate/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {

            // 交流
            setTitle(result, meeting);
        },
        error: function () {
            // alert("交流数据获取失败");
        }
    });

    $(meeting).hide();
}

// 师生出访
function getVisitings() {
    var visiting = document.getElementById("visiting");

    $.ajax({
        type: "get",
        async: false,
        url: "academicCommunicate/visit/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {
            // 出访
            setTitle(result, visiting);
        },
        error: function () {
            // alert("出访数据获取失败");
        }
    });

    $(visiting).hide();
}

function changeTab(index) {

    Tab_Selected = index;

    var Ids = ["lecture", "meeting", "visiting"];
    var dirs = ["学术讲座", "学术会议", "师生出访"];
    var tabs = document.getElementsByClassName("nav_bar");

    $(tabs[index]).addClass("active");
    $(tabs[(index + 1) % 3]).removeClass("active");
    $(tabs[(index + 2) % 3]).removeClass("active");

    $(".direction_div").find("span").html(dirs[index]);

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 3])).hide();
    $(document.getElementById(Ids[(index + 2) % 3])).hide();

}

function showArticle(link) {
    var Ids = ["lecture", "communicate", "visit"];
    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();
    window.location.href = "academicCommunicate/" + Ids[Tab_Selected] + "/detail?id=" + id;
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

// 标题汉译英
function changeVersion_content() {
    var tabs = document.getElementsByClassName("tab_achieve");
    var eng_title = ["AcademicForum", "AcademicConference", "Visitings"];
    for (var i = 0; i < 3; i++) {
        tabs[i].innerHTML = eng_title[i];
        tabs[i].style.fontSize = "16px";
    }
}
