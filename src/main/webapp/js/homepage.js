/**
 * Created by L.H.S on 2016/9/25.
 */

var language = "ch";
var currentPage = 1;  // 当前页数
var allPages;  // 所有新闻

window.onload = function () {

    language = judgeVersion();
    getPics();

    // 动态新闻
    getDynamic();
    // 源头活水
    getSource();

};

// 动态新闻
function getDynamic() {

    var dynamic = document.getElementById("dynamic_news");
    $.ajax({
        type: "get",
        async: false,
        url: "homepage/News/getFive",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {
            setTitle(result, dynamic);
        },
        error: function () {
            alert("首页数据获取失败");
        }
    });

}

// 源头活水
function getSource() {

    var source = document.getElementById("source_water");
    $.ajax({
        type: "get",
        async: false,
        url: "homepage/Fountainhead/getFive",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {
            setTitle(result, source);
        },
        error: function () {
            // alert("源头活水数据获取失败");
        }
    });

}

function setTitle(result, parent) {

    var copy = document.getElementById("title_copy");
    for (var i = 0; i < result.length; i++) {

        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_title");

        var img = document.createElement("img");
        img.style.width = "70px";
        img.style.height = "70px";
        img.src = result[i].thumbnailLocation;
        div.getElementsByClassName("each_img")[0].appendChild(img);

        var title = div.getElementsByClassName("big_div")[0]
        title.innerHTML = result[i].title;
        title.onclick = function () {
            window.location.href = result[i].url;
        };

        $.ajax({
            type: "get",
            async: false,
            url: "getHtml",
            data: {
                "filename": result[i].textLocation,
            },
            dataType: "json",
            success: function (text) {
                div.getElementsByClassName("small_div")[0].innerHTML = text;
            },
            error: function () {
                alert("科研成果数据获取失败");
            }
        });

        parent.appendChild(div);
    }

}

function getMore(link) {

    var subtitle = link.parentNode.getElementsByClassName("sub_title")[0].innerHTML;
    document.getElementById("more_content").getElementsByClassName("sub_title")[0].innerHTML = subtitle;

    var titleId = "News";
    if (subtitle == "源头活水") {
        titleId = "Fountainhead";
    }

    var pagelbl = document.getElementById("pages");

    parent.innerHTML = "";

    $.ajax({
        type: "get",
        async: false,
        url: "homepage/" + titleId + "/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {

            if (result.length > 0) {
                allPages = result;

                // 分页
                if (result.length > 6) {
                    $("#paging").show();

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

                    gotoPage(1);

                } else {
                    for (var i=0; i < result.length; i++) {
                        setMore(result[i]);
                    }
                }

            }

            $("#simple_content").hide();
            $("#more_content").show();

            document.getElementsByClassName("active")[0].setAttribute("class", "nav_bar");

        },
        error: function () {
            alert("更多数据获取失败");
        }
    });
}

function setMore(result) {
    var parent = document.getElementById("eachpage");
    var copy = document.getElementById("more_copy");

    var div = document.createElement("div");
    div.innerHTML = copy.innerHTML;

    var title = div.getElementsByClassName("more_title")[0];
    title.innerHTML = result.title;
    title.onclick = function () {
        window.location.href = result.url;
    };

    var img = document.createElement("img");
    img.style.width = "70px";
    img.style.height = "75px";
    img.src = result.thumbnailLocation;
    div.getElementsByClassName("more_img")[0].appendChild(img);

    $.ajax({
        type: "get",
        async: false,
        url: "getHtml",
        data: {
            "filename": result.textLocation,
        },
        dataType: "html",
        success: function (text) {
            div.getElementsByClassName("more_text")[0].innerHTML = text;
        },
        error: function () {
            alert("文本获取失败")
        }
    });

    parent.appendChild(div);
}

function changeVersion_content() {
    var subtitles = document.getElementsByClassName("sub_title");
    var eng_title = ["DynamicNews", "SpringHead"];

    var more = document.getElementsByClassName("more");

    for (var i = 0; i < 2; i++) {
        subtitles[i].innerHTML = eng_title[i];
        more[i].getElementsByTagName("span")[0].innerHTML = "More";
    }
}


/*  分页  */
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

    document.getElementById("eachpage").innerHTML = "";

    // (index-1) * 6 , index * 6 <= result.length
    if (index * 6 <= allPages.length) {
        for (var i = (index - 1) * 6; i < index * 6; i++) {
            setMore(allPages[i]);
        }
    } else {
        for (var j = (index - 1) * 6; j < allPages.length; j++) {
            setMore(allPages[j]);
        }
    }

}

