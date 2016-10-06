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

};