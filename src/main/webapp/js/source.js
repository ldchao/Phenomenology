/**
 * Created by L.H.S on 2016/10/6.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下
var language = "ch";

window.onload = function () {
    language = judgeVersion();
    getPics();

    getLectures();
    getMeetings();
    getVisitings();
};

// 讲座实录
function getLectures() {

    var lecture = document.getElementById("lecture");

    $.ajax({
        type: "get",
        async: false,
        url: "academic/cathedra/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {
            // 讲座实录
            setTitle(result, lecture);
        },
        error: function () {
            alert("学术资源数据获取失败");
        }
    });
}

// 课程资源
function getMeetings() {
    var meeting = document.getElementById("meeting");

    $.ajax({
        type: "get",
        async: false,
        url: "academic/course/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {
            // 课程资源
            setTitle(result, meeting);
        },
        error: function () {
            // alert("课程资源数据获取失败");
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
        url: "academic/circleNews/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {
            // 学界动态
            setTitle(result, visiting);
        },
        error: function () {
            // alert("学界动态数据获取失败");
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
    var Ids = ["cathedra", "course", "circleNews"];
    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();
    window.location.href = "academic/" + Ids[Tab_Selected] + "/detail?id=" + id;
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
    var eng_title = ["LectureRecord", "CourseResources", "AcademicDynamics"];
    for (var i = 0; i < 3; i++) {
        tabs[i].innerHTML = eng_title[i];
        tabs[i].style.fontSize = "16px";
    }
}