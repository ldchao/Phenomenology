/**
 * Created by L.H.S on 2016/9/25.
 */

window.onload = function () {

    var copy = document.getElementById("title_copy");
    var dynamic = document.getElementById("dynamic_news");
    var source = document.getElementById("source_water");

    // 动态新闻
    for(var i=0; i<5; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_title");
        
        dynamic.appendChild(div);
    }

    // 源头活水
    for(var i=0; i<5; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_title");

        dynamic.appendChild(div);
        source.appendChild(div);
    }
};