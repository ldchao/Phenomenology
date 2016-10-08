/**
 * Created by L.H.S on 2016/9/26.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下
var language = "ch";

window.onload = function () {
    getLectures();
    getMeetings();
    getVisitings();

    language = judgeVersion();
};

// 学术讲座
function getLectures() {

    var lecture = document.getElementById("lecture");

    $.ajax({
        type: "get",
        async: false,
        url: "../academicCommunicate/lecture/get",
        data: {
            "language": "ch"
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
        url: "../academicCommunicate/communicate/get",
        data: {
            "language": "ch"
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
        url: "../academicCommunicate/visit/get",
        data: {
            "language": "ch"
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
    var tabs = document.getElementsByClassName("tab_achieve");

    tabs[index].style.borderBottom = "3px solid #1a799f";
    tabs[(index + 1) % 3].style.borderBottom = "";
    tabs[(index + 2) % 3].style.borderBottom = "";

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 3])).hide();
    $(document.getElementById(Ids[(index + 2) % 3])).hide();

}

function showArticle(link) {

    var tabs = ["学术讲座", "学术会议", "师生出访"];
    
    if(language == "eng") {
        tabs = ["AcademicForum", "AcademicConference", "Visitings"];
    }
    
    var Ids = ["lecture", "communicate", "visit"];

    var content = document.getElementById("news_content");

    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();

    $.ajax({
        type: "get",
        async: false,
        url: "../academicCommunicate/" + Ids[Tab_Selected] + "/getOne",
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
            // alert("出访数据获取失败");
        }
    });

    var backbtn = content.getElementsByClassName("back_lbl")[0];
    backbtn.getElementsByTagName("span")[0].innerHTML = tabs[Tab_Selected];
    
    if(language == "eng") {
        backbtn.style.width = "240px";
        document.getElementById("writer_lbl").innerHTML = "Author";
        document.getElementById("time_lbl").innerHTML = "Time";
        document.getElementById("viewer_lbl").innerHTML = "PageView";
    }
    
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

// 标题汉译英
function changeVersion_content() {
    var tabs = document.getElementsByClassName("tab_achieve");
    var eng_title = ["AcademicForum", "AcademicConference", "Visitings"];
    for (var i=0; i<3; i++) {
        tabs[i].innerHTML = eng_title[i];
        tabs[i].style.fontSize = "16px";
    }
    tabs[0].style.width = "120px";
    tabs[1].style.width = "160px";
    tabs[2].style.width = "70px";
}