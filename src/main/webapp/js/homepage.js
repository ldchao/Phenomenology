/**
 * Created by L.H.S on 2016/9/25.
 */

var language = "ch";
var currentPage = 1;  // 当前页数
var allPages;  // 所有新闻

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

    for (var i = 0; i < 2; i++) {
        subtitles[i].innerHTML = eng_title[i];
        more[i].getElementsByTagName("span")[0].innerHTML = "More";
    }
}

function getMore(link) {

    var subtitle = link.parentNode.getElementsByClassName("sub_title")[0].innerHTML;
    document.getElementById("more_content").getElementsByClassName("sub_title")[0].innerHTML = subtitle;

    var parent = document.getElementById("eachpage");
    var pagelbl = document.getElementById("pages");
    var copy = document.getElementById("more_copy");

    parent.innerHTML = "";

    for (var i = 0; i < 6; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        parent.appendChild(div);
    }

    // 分页
    var result = new Array(30);
    if (result.length > 6) {
        var pages = Math.ceil(result.length / 6);
        for (var j = 0; j < pages; j++) {
            var div = document.createElement("div");
            div.innerHTML = j + 1;

            if (j == 0) {
                div.setAttribute("class", "pages_each pages_selected");
            } else {
                div.setAttribute("class", "pages_each");
            }

            div.onclick = function () {
                gotoPage_node(this);
            };

            pagelbl.appendChild(div);
        }
    } else {
        $("#paging").hide();
    }

    $("#simple_content").hide();
    $("#more_content").show();

    document.getElementsByClassName("active")[0].setAttribute("class", "nav_bar");
}

function gotoPage_node(node) {
    var index = node.innerHTML.trim();
    gotoPage(index);
}

// 0，下一页；1，上一页
function nextPage(symbol) {
    var nums = document.getElementById("pages").getElementsByClassName("pages_each").length;

    if (symbol == 0) {

        if (currentPage < nums) {
            gotoPage(currentPage + 1);
        }
    } else {
        if (currentPage - 1 > 0) {
            gotoPage(currentPage - 1);
        }
    }
}

function gotoPage(index) {

    var pagelbls = document.getElementById("pages").getElementsByClassName("pages_each");
    pagelbls[currentPage - 1].setAttribute("class", "pages_each");
    pagelbls[index - 1].setAttribute("class", "pages_each pages_selected");

    currentPage = parseInt(index);

    var parent = document.getElementById("eachpage");
    var copy = document.getElementById("more_copy");

    // parent.innerHTML = "";

    // (index-1) * 6 , index * 6 <= result.length
    if (index * 6 <= allPages.length) {

    }

}