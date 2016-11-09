/**
 * Created by L.H.S on 2016/10/9.
 */

var language = "ch";

window.onload = function () {
    language = judgeVersion_detail();
    getPics_detail();

    var index = parseInt(document.getElementById("storage").innerHTML);
    document.getElementsByClassName("nav_bar")[index].setAttribute("class", "nav_bar active");

    if (index == 5) {
        document.getElementsByClassName("info")[0].style.display = "none";
    }

    var location = document.getElementById("storage_location").innerHTML.trim();
    $.ajax({
        type: "get",
        async: false,
        url: "../../getHtml",
        data: {
            "filename": location
        },
        dataType: "html",
        success: function (text) {
            document.getElementById("content").innerHTML = text;
        },
        error: function () {
            alert("html数据获取失败");
        }
    });

    var tag = document.getElementById("storage").innerHTML.trim();
    if (tag == 3 || tag == 4) {
        getAttach("getEssayAccessory");
    } else {
        getAttach("getSaAccessory");
    }

};

function changeVersion_content() {

    var index = parseInt(document.getElementById("storage").innerHTML);

    if (language == "eng" && (index == 3 || index == 4)) {
        document.getElementById("writer_lbl").innerHTML = "Author";
        document.getElementById("time_lbl").innerHTML = "Time";
        document.getElementById("viewer_lbl").innerHTML = "PageView";
    }
}

function getAttach(url) {

    var id = document.getElementById("storage_id").innerHTML.trim();
    var attach = document.getElementById("attach");

    $.ajax({
        type: "get",
        async: false,
        url: "../../" + url,
        data: {
            "id": id
        },
        dataType: "json",
        success: function (result) {

            if (result != null) {

                attach.getElementsByTagName("span")[0].innerHTML = result.name;

                $("#attach").show();
                attach.onclick = function () {
                    submit(result.location);
                }

            }
        },
        error: function () {
            alert("html数据获取失败");
        }
    });

}

function submit(location) {
    var form = $("<form>");//定义一个form表单
    form.attr("style", "display:none");
    form.attr("target", "");
    form.attr("method", "post");
    form.attr("action", "/Phenomenology/download");

    var input1 = $("<input>");
    input1.attr("type", "hidden");
    input1.attr("name", "fileName");
    input1.attr("value", location);//路径名
    $("body").append(form);//将表单放置在web中
    form.append(input1);

    form.submit();//表单提交
}
