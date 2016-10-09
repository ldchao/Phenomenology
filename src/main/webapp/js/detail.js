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
        url: "/getHtml",
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
};

function changeVersion_content() {

    var index = parseInt(document.getElementById("storage").innerHTML);

    if (language == "eng" && (index == 3 || index == 4)) {
        document.getElementById("writer_lbl").innerHTML = "Author";
        document.getElementById("time_lbl").innerHTML = "Time";
        document.getElementById("viewer_lbl").innerHTML = "PageView";
    }
}
