/**
 * Created by L.H.S on 2016/9/26.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下

window.onload = function () {
    getLectures();
    getMeetings();
    getVisitings();
};

function getLectures() {
    var copy = document.getElementById("lecture_copy");
    var lecture = document.getElementById("lecture");

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

function getMeetings() {
    var copy = document.getElementById("lecture_copy");
    var meeting = document.getElementById("meeting");

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

function getVisitings() {
    var copy = document.getElementById("lecture_copy");
    var visiting = document.getElementById("visiting");

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

    var title = link.innerHTML.trim();
    var content = document.getElementById("news_content");
    
    var backbtn = content.getElementsByClassName("back_lbl")[0];
    backbtn .getElementsByTagName("span")[0].innerHTML = tabs[Tab_Selected];
    backbtn.onclick = function () {
        $("#news_content").hide();
        $("#news_list").show();
    };


    $("#news_list").hide();
    $("#news_content").show();
}