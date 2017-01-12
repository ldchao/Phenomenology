/**
 * Created by L.H.S on 2016/12/2.
 */

window.onload = function () {

    var language = judgeVersion();

    $.ajax({
        type: "get",
        async: false,
        url: "homepage/News/getFive",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {

            var imgs = [];
            var titles = [];
            var urls = [];
            for (var i = 0; i < result.length; i++) {
                imgs[i] = result[i].thumbnailLocation;
                titles[i] = result[i].title;
                urls[i] = result[i].url;
            }
            getBanners(imgs, titles, urls);

        },
        error: function () {
            alert("首页数据获取失败");
        }
    });

    getPics();
};

function changeVersion_content() {

    document.getElementsByClassName("title_div")[0].innerHTML = "Friendly Links";

    var masks = document.getElementsByClassName("mask");
    var eng_mask = ["Leuven Husserl University Archives", "Husserl archives of Freiburg University",
        "Chinese phenomena network", "Husserl archives of University of Cologne"];

    for (var i = 0; i < masks.length; i++) {
        masks[i].innerHTML = eng_mask[i];
    }

}