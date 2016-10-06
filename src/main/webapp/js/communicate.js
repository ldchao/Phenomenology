/**
 * Created by L.H.S on 2016/9/26.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下

window.onload = function () {
    getLectures();
    getMeetings();
    getVisitings();
};

// 学术讲座
function getLectures() {

    var copy = document.getElementById("lecture_copy");
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

        },
        error: function () {
            alert("讲座数据获取失败");
        }
    });
    
    for (var i = 0; i < 15; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_lecture");
        
        var title = div.getElementsByClassName("lecture_title")[0];
        title.onclick = function() {
            showArticle(this);
        };

        lecture.appendChild(div);
    }

}

// 学术交流
function getMeetings() {
    var copy = document.getElementById("lecture_copy");
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

        },
        error: function () {
            alert("交流数据获取失败");
        }
    });

    for (var i = 0; i < 10; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_lecture");

        var title = div.getElementsByClassName("lecture_title")[0];
        title.onclick = function() {
            showArticle(this);
        };

        meeting.appendChild(div);
    }

    $(meeting).hide();
}

// 师生出访
function getVisitings() {
    var copy = document.getElementById("lecture_copy");
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

        },
        error: function () {
            alert("出访数据获取失败");
        }
    });

    for (var i = 0; i < 5; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_lecture");

        var title = div.getElementsByClassName("lecture_title")[0];
        title.onclick = function() {
            showArticle(this);
        };

        visiting.appendChild(div);
    }

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

    var tabs = ["学术讲座", "学术交流", "师生出访"];
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

            // 出访

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