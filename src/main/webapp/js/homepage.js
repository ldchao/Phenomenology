/**
 * Created by L.H.S on 2016/9/25.
 */

window.onload = function () {

    var copy = document.getElementById("title_copy");
    var dynamic = document.getElementById("dynamic_news");
    var source = document.getElementById("source_water");

    // 动态新闻
    for (var i = 0; i < 5; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_title");

        dynamic.appendChild(div);
    }

    // 源头活水
    for (var i = 0; i < 5; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_title");

        dynamic.appendChild(div);
        source.appendChild(div);
    }

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