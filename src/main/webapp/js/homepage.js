/**
 * Created by L.H.S on 2016/9/25.
 */

var language = "ch";

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

    language = judgeVersion();
};

function changeVersion_content() {
    var subtitles = document.getElementsByClassName("sub_title");
    var eng_title = ["DynamicNews", "SpringHead"];
    
    var more = document.getElementsByClassName("more");

    for (var i=0; i<2; i++) {
        subtitles[i].innerHTML = eng_title[i];
        more[i].getElementsByTagName("span")[0].innerHTML = "More";
    }
}

function getMore(link) {

    var subtitle = link.parentNode.getElementsByClassName("sub_title")[0].innerHTML;
    document.getElementById("more_content").getElementsByClassName("sub_title")[0].innerHTML = subtitle;
    
    var parent = document.getElementById("eachpage");
    var copy = document.getElementById("more_copy");

    parent.innerHTML = "";
    
    for(var i=0; i<6; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        parent.appendChild(div);
    }

    $("#simple_content").hide();
    $("#more_content").show();
    
    document.getElementsByClassName("active")[0].setAttribute("class", "nav_bar");
}