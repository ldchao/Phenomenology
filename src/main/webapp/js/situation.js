/**
 * Created by L.H.S on 2016/10/6.
 */

window.onload = function () {

    $.ajax({
        type: "get",
        async: false,
        url: "../situation/getHtml",
        data: {
            "language": "ch"
        },
        dataType: "html",
        success: function (result) {
            if(result != null) {
                document.getElementById("introduce").innerHTML = result;
            }
        },
        error: function () {
            alert("数据获取失败");
        }
    });

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