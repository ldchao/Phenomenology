/**
 * Created by L.H.S on 2016/9/27.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下

window.onload = function () {
    getOffice();
    getVisiting();
    getStudent();

    //  切换语言
    $.ajax({
        type: "get",
        async: false,
        url: "../getVersion",
        dataType: "json",
        success: function (result) {
            if(result == "eng") {
                var btns = document.getElementsByClassName("ch_eng");
                btns[0].setAttribute("class", "ch_eng ch_eng_not");
                btns[1].setAttribute("class", "ch_eng");

                changeVersion_title();
            }
        },
        error: function () {
            alert("语言版本获取失败");
        }
    });
};

// 在职人员
function getOffice() {
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
            setId(result, lecture);
        },
        error: function () {
            alert("在职人员数据获取失败");
        }
    });
}

// 访问学者
function getVisiting() {
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
            setId(result, meeting);

        },
        error: function () {
            alert("访问学者数据获取失败");
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
        url: "../organization/student/get",
        data: {
            "language": "ch"
        },
        dataType: "json",
        success: function (result) {

            // 访问学者
            setId(result, visiting);

        },
        error: function () {
            alert("访问学者数据获取失败");
        }
    });

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

    var backbtn = detail.getElementsByClassName("back_lbl")[0];
    backbtn.getElementsByTagName("span")[0].innerHTML = tabs[Tab_Selected];
    backbtn.onclick = function () {
        $("#staff_detail").hide();
        $("#staff_list").show();
    };

    detail.getElementsByClassName("name")[0].innerHTML = name;

    $.ajax({
        type: "get",
        async: false,
        url: "../organization/" + Ids[Tab_Selected] + "/getOne",
        data: {
            "id": id
        },
        dataType: "json",
        success: function (result) {

            var img = document.createElement("img");
            img.style.width = "130px";
            img.style.height = "140px";
            img.src = result.imageLocation;
            detail.getElementsByClassName("photo")[0].innerHTML = "";
            detail.getElementsByClassName("photo")[0].appendChild(img);

            // 简介
            $.ajax({
                type: "get",
                async: false,
                url: "../getHtml",
                data: {
                    "filename": result.descriptionLocation,
                },
                dataType: "html",
                success: function (text) {
                    detail.getElementsByClassName("introduction")[0].innerHTML = text;
                },
                error: function () {
                    alert("html数据获取失败");
                }
            });
            
        },
        error: function () {
            alert("人员数据获取失败");
        }
    });

    $("#staff_list").hide();
    $("#staff_detail").show();

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
        img.src = result[i].imageLocation;
        div.getElementsByClassName("book_pic")[0].innerHTML = "";
        div.getElementsByClassName("book_pic")[0].appendChild(img);
        
        parent.appendChild(div);
    }
}