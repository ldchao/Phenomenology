/**
 * Created by L.H.S on 2016/9/25.
 */

var language = "ch";

window.onload = function () {
    showBooks();
    showArticles();

    language = judgeVersion();
};

function changeTab(index) {

    var tabs = document.getElementsByClassName("tab_achieve");
    var Ids = ["books", "articles"];


    tabs[index].style.borderBottom = "3px solid #1a799f";
    tabs[(index + 1) % 2].style.borderBottom = "";

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
        url: "../achievement/book/get",
        data: {
            "language": "ch"
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
                img.src = result[i].thumbnailLocation;
                div.getElementsByClassName("book_pic")[0].innerHTML = "";
                div.getElementsByClassName("book_pic")[0].appendChild(img);

                books.appendChild(div);
            }

        },
        error: function () {
            alert("书籍列表获取失败");
        }
    });
}

function showBookDetail(link) {

    var name = link.innerHTML.trim();
    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();

    var detail = document.getElementById("book_detail");

    $.ajax({
        type: "get",
        async: false,
        url: "../achievement/book/getOne",
        data: {
            "id": id
        },
        dataType: "json",
        success: function (result) {

            var img = document.createElement("img");
            img.style.width = "100px";
            img.style.height = "125px";
            img.src = result.thumbnailLocation;
            var photo = detail.getElementsByClassName("photo")[0];
            photo.style.width = "100px";
            photo.style.height = "125px";
            photo.innerHTML = "";
            photo.appendChild(img);

            // 简介
            $.ajax({
                type: "get",
                async: false,
                url: "../getHtml",
                data: {
                    "filename": result.descriptionLocation,
                },
                dataType: "html",
                success: function (text) {
                    detail.getElementsByClassName("introduction")[0].innerHTML = text;
                },
                error: function () {
                    alert("html数据获取失败");
                }
            });

        },
        error: function () {
            alert("书籍内容数据获取失败");
        }
    });

    var backbtn = detail.getElementsByClassName("back_lbl")[0];

    if (language == "ch") {
        backbtn.getElementsByTagName("span")[0].innerHTML = "书籍出版";
    } else {
        backbtn.getElementsByTagName("span")[0].innerHTML = "BookPublishing";
        backbtn.style.width = "180px";
    }

    backbtn.onclick = function () {
        $("#book_detail").hide();
        $("#achieve_list").show();
    };

    detail.getElementsByClassName("name")[0].innerHTML = name;

    $("#achieve_list").hide();
    $("#book_detail").show();

}

// 文章列表
function showArticles() {
    var articles = document.getElementById("articles");
    var copy = document.getElementById("lecture_copy");

    $.ajax({
        type: "get",
        async: false,
        url: "../achievement/article/get",
        data: {
            "language": "ch"
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

    var content = document.getElementById("article_content");

    var id = link.parentNode.getElementsByTagName("a")[0].innerHTML.trim();

    $.ajax({
        type: "get",
        async: false,
        url: "../achievement/article/getOne",
        data: {
            "id": id
        },
        dataType: "json",
        success: function (result) {

            content.getElementsByClassName("article_title")[0].innerHTML = result.title;

            $.ajax({
                type: "get",
                async: false,
                url: "../getHtml",
                data: {
                    "filename": result.descriptionLocation,
                },
                dataType: "html",
                success: function (text) {
                    content.getElementsByClassName("text_content")[0].innerHTML = text;
                },
                error: function () {
                    alert("html数据获取失败");
                }
            });


        },
        error: function () {
            alert("书籍内容数据获取失败");
        }
    });

    var backbtn = content.getElementsByClassName("back_lbl")[0];

    if (language == "ch") {
        backbtn.getElementsByTagName("span")[0].innerHTML = "文章发表";
    } else {
        backbtn.getElementsByTagName("span")[0].innerHTML = "ArticlePublishing";
        backbtn.style.width = "205px";
    }

    backbtn.onclick = function () {
        $("#article_content").hide();
        $("#achieve_list").show();
    };


    $("#achieve_list").hide();
    $("#article_content").show();

}

// 标题汉译英
function changeVersion_content() {
    var tabs = document.getElementsByClassName("tab_achieve");
    var eng_title = ["BookPublishing", "ArticlePublishing"];
    for (var i = 0; i < 2; i++) {
        tabs[i].innerHTML = eng_title[i];
        tabs[i].style.fontSize = "16px";
    }
    tabs[0].style.width = "115px";
    tabs[1].style.width = "125px";
}