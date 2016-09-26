/**
 * Created by L.H.S on 2016/9/27.
 */

window.onload = function () {
    getOffice();
    getVisiting();
    getStudent();
};

function getOffice() {
    var copy = document.getElementById("office_copy");
    var lecture = document.getElementById("office");

    for (var i = 0; i < 15; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_book_div");

        lecture.appendChild(div);
    }

}

function getVisiting() {
    var copy = document.getElementById("office_copy");
    var meeting = document.getElementById("visiting");

    for (var i = 0; i < 10; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_book_div");

        meeting.appendChild(div);
    }

    $(meeting).hide();
}

function getStudent() {
    var copy = document.getElementById("office_copy");
    var visiting = document.getElementById("student");

    for (var i = 0; i < 5; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_book_div");

        visiting.appendChild(div);
    }

    $(visiting).hide();
}

function changeTab(index) {

    var Ids = ["office", "visiting", "student"];
    var tabs = document.getElementsByClassName("tab_achieve");

    tabs[index].style.borderBottom = "3px solid #1a799f";
    tabs[(index + 1) % 3].style.borderBottom = "";
    tabs[(index + 2) % 3].style.borderBottom = "";

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 3])).hide();
    $(document.getElementById(Ids[(index + 2) % 3])).hide();

}