/**
 * Created by L.H.S on 2016/9/27.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下

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

        var link = div.getElementsByClassName("name_link")[0];
        link.onclick = function () {
            showDetail(this);
        };

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

        var link = div.getElementsByClassName("name_link")[0];
        link.onclick = function () {
            showDetail(this);
        };

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

        var link = div.getElementsByClassName("name_link")[0];
        link.onclick = function () {
            showDetail(this);
        };

        visiting.appendChild(div);
    }

    $(visiting).hide();
}

function changeTab(index) {
    
    Tab_Selected = index;

    var Ids = ["office", "visiting", "student"];
    var tabs = document.getElementsByClassName("tab_achieve");

    tabs[index].style.borderBottom = "3px solid #1a799f";
    tabs[(index + 1) % 3].style.borderBottom = "";
    tabs[(index + 2) % 3].style.borderBottom = "";

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 3])).hide();
    $(document.getElementById(Ids[(index + 2) % 3])).hide();

}

function showDetail(link) {

    var tabs = ["在职人员", "访问学者", "本所学生"];
    var name = link.innerHTML.trim();

    var detail = document.getElementById("staff_detail");
    var backbtn = detail.getElementsByClassName("back_lbl")[0];
    backbtn .getElementsByTagName("span")[0].innerHTML = tabs[Tab_Selected];
    backbtn.onclick = function () {
        $("#staff_detail").hide();
        $("#staff_list").show();
    };
    
    detail.getElementsByClassName("name")[0].innerHTML = name;
    
    $("#staff_list").hide();
    $("#staff_detail").show();

}