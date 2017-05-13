/**
 * Created by L.H.S on 2016/9/25.
 */

var language = "ch";

window.onload = function () {
    language = judgeVersion();
    getPics();

    showBooks();
    showArticles();
};

function changeTab(index) {

    var tabs = document.getElementsByClassName("nav_bar");
    var Ids = ["books", "articles"];
    var dirs = ["书籍出版", "文章发表"];

    $(tabs[index]).addClass("active");
    $(tabs[(index + 1) % 2]).removeClass("active");

    $(".direction_div").find("span").html(dirs[index]);

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 2])).hide();

}

// 书籍列表
function showBooks() {
    var copy = document.getElementById("book_copy");
    var books = document.getElementById("books");

    $.ajax({
        type: "get",
        async: false,
        url: "achievement/book/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {

            for (var i = 0; i < result.length; i++) {

                var div = document.createElement("div");
                div.innerHTML = copy.innerHTML;
                div.setAttribute("class", "each_book_div");

                var link = div.getElementsByClassName("name_link")[0];
                link.innerHTML = result[i].title;
                link.onclick = function () {
                    showBookDetail(this);
                };

                div.getElementsByTagName("a")[0].innerHTML = result[i].id;

                // 图片地址
                var img = document.createElement("img");
                img.style.width = "100px";
                img.style.height = "125px";
                img.style.cursor = "pointer";
                img.src = result[i].thumbnailLocation;
                div.getElementsByClassName("book_pic")[0].innerHTML = "";
                div.getElementsByClassName("book_pic")[0].appendChild(img);
                img.onclick = function () {
                    showBookDetail(this.parentNode);
                };

                books.appendChild(div);
            }

        },
        error: function () {
            alert("科研成果数据获取失败");
        }
    });
}

function showBookDetail(link) {
    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();
    window.location.href = "achievement/book/detail?id=" + id;
}

// 文章列表
function showArticles() {
    var articles = document.getElementById("articles");
    var copy = document.getElementById("lecture_copy");

    $.ajax({
        type: "get",
        async: false,
        url: "achievement/article/get",
        data: {
            "language": language
        },
        dataType: "json",
        success: function (result) {

            for (var i = 0; i < result.length; i++) {

                var div = document.createElement("div");
                div.innerHTML = copy.innerHTML;
                div.setAttribute("class", "each_lecture");

                var title = div.getElementsByClassName("lecture_title")[0];
                title.innerHTML = result[i].title;
                title.onclick = function () {
                    showArticleDetail(this);
                };

                div.getElementsByTagName("span")[1].innerHTML = result[i].time;
                div.getElementsByTagName("a")[0].innerHTML = result[i].id;

                articles.appendChild(div);
            }

        },
        error: function () {
            alert("书籍内容数据获取失败");
        }
    });

    $(articles).hide();
}

function showArticleDetail(link) {
    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();
    window.location.href = "achievement/article/detail?id=" + id;
}

// 标题汉译英
function changeVersion_content() {
    var tabs = document.getElementsByClassName("tab_achieve");
    var eng_title = ["BookPublishing", "ArticlePublishing"];
    for (var i = 0; i < 2; i++) {
        tabs[i].innerHTML = eng_title[i];
        tabs[i].style.fontSize = "16px";
    }
}