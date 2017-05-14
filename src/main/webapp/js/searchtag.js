/**
 * Created by L.H.S on 2017/5/14.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下
var language = "ch";

window.onload = function () {

    language = judgeVersion();

    var key = document.getElementById("storage").innerHTML.trim();

    getArticle(key);
    getBook(key);
};


function getArticle(key) {

    var article = document.getElementById("article_title");
    var copy = document.getElementById("article_copy");

    $.ajax({
        type: "get",
        async: false,
        url: "searchEssayByTag",
        data: {
            "tag": key
        },
        dataType: "json",
        success: function (result) {

            if (result.length > 0) {
                for (var i = 0; i < result.length; i++) {
                    var div = document.createElement("div");
                    div.innerHTML = copy.innerHTML;

                    var title = div.getElementsByClassName("more_title")[0];
                    title.innerHTML = result[i].title;
                    title.onclick = function () {
                        showSearch(this, "getEssayURL");
                    };

                    div.getElementsByTagName("a")[0].innerHTML = result[i].id;

                    setHtml(result[i].location, div.getElementsByClassName("search_text")[0]);

                    article.appendChild(div);
                }
            } else {
                var no_div = document.createElement("div");
                no_div.className = "no_search";
                no_div.innerHTML = "没有搜索到相关文章";
                article.appendChild(no_div);
            }
        },
        error: function () {
            alert("搜索失败");
        }
    });
}

function getBook(key) {

    var book = document.getElementById("book_title");
    var copy = document.getElementById("staff_copy");

    $.ajax({
        type: "get",
        async: false,
        url: "searchAchievementByTag",
        data: {
            "tag": key
        },
        dataType: "json",
        success: function (result) {

            if (result.length > 0) {
                for (var i = 0; i < result.length; i++) {
                    var div = document.createElement("div");
                    div.innerHTML = copy.innerHTML;

                    var title = div.getElementsByClassName("more_title")[0].innerHTML.trim();
                    title.innerHTML = result[i].title;
                    title.onclick = function () {
                        showSearch(this, "getAchievementURL");
                    };

                    var img = document.createElement("img");
                    img.style.width = "70px";
                    img.style.height = "75px";
                    img.src = result[i].thumbnailLocation;
                    div.getElementsByClassName("more_img")[0].appendChild(img);

                    setHtml(result[i].descriptionLocation, div.getElementsByClassName("more_text")[0]);

                    div.getElementsByTagName("a")[0].innerHTML = result[i].id;

                    book.appendChild(div);
                }
            } else {
                var no_div = document.createElement("div");
                no_div.className = "no_search";
                no_div.innerHTML = "没有搜索到相关书籍";
                book.appendChild(no_div);
            }

        },
        error: function () {
            // alert("科研成果数据获取失败");
        }
    });

    $("#book_title").hide();
}

function setHtml(location, textfield) {

    $.ajax({
        type: "get",
        async: false,
        url: "getHtml",
        data: {
            "filename": location,
        },
        dataType: "html",
        success: function (text) {
            textfield.innerHTML = text;
        },
        error: function () {
            alert("文本获取失败")
        }
    });

}

function showSearch(link, url) {
    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();
    $.ajax({
        type: "get",
        async: false,
        url: url,
        data: {
            "id": id,
        },
        dataType: "json",
        success: function (result) {
            window.location.href = "/Phenomenology/" + result;
        },
        error: function () {
            // alert("科研成果数据获取失败");
        }
    });
}

function changeTab(index) {

    Tab_Selected = index;

    var Ids = ["article_title", "book_title"];
    var tabs = document.getElementsByClassName("tab_achieve");

    tabs[index].style.borderBottom = "3px solid #1a799f";
    tabs[(index + 1) % 2].style.borderBottom = "";

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 2])).hide();
}

function changeVersion_content() {

    var tabs = document.getElementsByClassName("tab_achieve");
    var eng_title = ["RelatedArticles", "RelatedStaff", "RelatedBooks"];
    for (var i = 0; i < 3; i++) {
        tabs[i].innerHTML = eng_title[i];
        tabs[i].style.fontSize = "18px";
    }
}