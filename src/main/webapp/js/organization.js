/**
 * Created by L.H.S on 2016/9/27.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下

window.onload = function () {
    getOffice();
    getVisiting();
    getStudent();
};

// 在职人员
function getOffice() {
    var copy = document.getElementById("office_copy");
    var lecture = document.getElementById("office");

    $.ajax({
        type: "get",
        async: false,
        url: "../organization/officeBearer/get",
        data: {
            "language": "ch"
        },
        dataType: "json",
        success: function (result) {

            // 在职人员

        },
        error: function () {
            alert("在职人员数据获取失败");
        }
    });

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

// 访问学者
function getVisiting() {
    var copy = document.getElementById("office_copy");
    var meeting = document.getElementById("visiting");

    $.ajax({
        type: "get",
        async: false,
        url: "../organization/scholar/get",
        data: {
            "language": "ch"
        },
        dataType: "json",
        success: function (result) {

            // 访问学者

        },
        error: function () {
            alert("访问学者数据获取失败");
        }
    });

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

// 本所学生
function getStudent() {
    var copy = document.getElementById("office_copy");
    var visiting = document.getElementById("student");

    $.ajax({
        type: "get",
        async: false,
        url: "../organization/student/get",
        data: {
            "language": "ch"
        },
        dataType: "json",
        success: function (result) {

            // 访问学者

        },
        error: function () {
            alert("访问学者数据获取失败");
        }
    });

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
    var Ids = ["officeBearer", "scholar", "student"];

    var name = link.innerHTML.trim();
    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();

    var detail = document.getElementById("staff_detail");

    $.ajax({
        type: "get",
        async: false,
        url: "../organization/" + Ids[Tab_Selected] + "/getOne",
        data: {
            "id": id
        },
        dataType: "json",
        success: function (result) {

            // 出访

        },
        error: function () {
            alert("人员数据获取失败");
        }
    });

    var backbtn = detail.getElementsByClassName("back_lbl")[0];
    backbtn.getElementsByTagName("span")[0].innerHTML = tabs[Tab_Selected];
    backbtn.onclick = function () {
        $("#staff_detail").hide();
        $("#staff_list").show();
    };

    detail.getElementsByClassName("name")[0].innerHTML = name;

    $("#staff_list").hide();
    $("#staff_detail").show();

}