/**
 * Created by L.H.S on 2016/9/26.
 */

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

        visiting.appendChild(div);
    }

    $(visiting).hide();
}

function changeTab(index) {

    var Ids = ["lecture", "meeting", "visiting"];
    var tabs = document.getElementsByClassName("tab_achieve");

    tabs[index].style.borderBottom = "3px solid #1a799f";
    tabs[(index + 1) % 3].style.borderBottom = "";
    tabs[(index + 2) % 3].style.borderBottom = "";

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 3])).hide();
    $(document.getElementById(Ids[(index + 2) % 3])).hide();

}