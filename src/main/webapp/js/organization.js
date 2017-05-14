/**
 * Created by L.H.S on 2016/9/27.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下
var language = "ch";

window.onload = function () {
    language = judgeVersion();

    enterSubNav();

    getPics();
    
    getOffice();
    getVisiting();
    getStudent();

    getHotLabel();
};

// 在职人员
function getOffice() {
    var lecture = document.getElementById("office");

    $.ajax({
        type: "get",
        async: false,
        url: "organization/officeBearer/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {
            // 在职人员
            setId(result, lecture);
        },
        error: function () {
            alert("机构人员数据获取失败");
        }
    });
}

// 访问学者
function getVisiting() {
    var meeting = document.getElementById("visiting");

    $.ajax({
        type: "get",
        async: false,
        url: "organization/scholar/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {

            // 访问学者
            setId(result, meeting);

        },
        error: function () {
            // alert("访问学者数据获取失败");
        }
    });

    $(meeting).hide();
}

// 本所学生
function getStudent() {
    var visiting = document.getElementById("student");

    $.ajax({
        type: "get",
        async: false,
        url: "organization/student/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {

            // 访问学者
            setId(result, visiting);

        },
        error: function () {
            // alert("访问学者数据获取失败");
        }
    });

    $(visiting).hide();
}

function changeTab(index) {

    Tab_Selected = index;

    var Ids = ["office", "visiting", "student"];
    var dirs = ["在职人员", "访问学者", "本所学生"];
    var tabs = document.getElementsByClassName("nav_bar");

    $(tabs[index]).addClass("active");
    $(tabs[(index + 1) % 3]).removeClass("active");
    $(tabs[(index + 2) % 3]).removeClass("active");

    $(".direction_div").find("span").html(dirs[index]);

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 3])).hide();
    $(document.getElementById(Ids[(index + 2) % 3])).hide();

}

function showDetail(link) {
    var Ids = ["officeBearer", "scholar", "student"];
    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();
    window.location.href = "organization/" + Ids[Tab_Selected] + "/detail?id=" + id;
}

function setId(result, parent) {
    var copy = document.getElementById("office_copy");

    for (var i = 0; i < result.length; i++) {

        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_photo_div");

        var link = div.getElementsByClassName("name_link")[0];
        link.innerHTML = result[i].name;
        link.onclick = function () {
            showDetail(this);
        };

        div.getElementsByTagName("a")[0].innerHTML = result[i].id;

        // 图片地址
        var img = document.createElement("img");
        img.style.width = "130px";
        img.style.height = "140px";
        img.style.cursor = "pointer";
        img.src = result[i].imageLocation;
        div.getElementsByClassName("book_pic")[0].innerHTML = "";
        div.getElementsByClassName("book_pic")[0].appendChild(img);
        
        img.onclick = function () {
            showDetail(this.parentNode);
        };

        parent.appendChild(div);
    }
}

// 标题汉译英
function changeVersion_content() {
    var tabs = document.getElementsByClassName("tab_achieve");
    var eng_title = ["OfficeBearer", "VisitingScholar", "OurStudent"];
    for (var i = 0; i < 3; i++) {
        tabs[i].innerHTML = eng_title[i];
        tabs[i].style.fontSize = "18px";
    }
}