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