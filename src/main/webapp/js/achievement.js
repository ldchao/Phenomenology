/**
 * Created by L.H.S on 2016/9/25.
 */

window.onload = function () {
    showBooks();
    showArticles();
}

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

            // 书籍列表

        },
        error: function () {
            alert("书籍列表获取失败");
        }
    });
    
    for (var i = 0; i < 7; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_book_div");

        var link = div.getElementsByClassName("name_link")[0];
        link.onclick = function () {
            showBookDetail(this);
        };

        books.appendChild(div);
    }
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

            // 书籍内容

        },
        error: function () {
            alert("书籍内容数据获取失败");
        }
    });

    var backbtn = detail.getElementsByClassName("back_lbl")[0];
    backbtn.getElementsByTagName("span")[0].innerHTML = "书籍出版";
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

            // 文章列表

        },
        error: function () {
            alert("书籍内容数据获取失败");
        }
    });
    
    for (var i = 0; i < 7; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_lecture");
       
        var title = div.getElementsByClassName("lecture_title")[0];
        title.onclick = function() {
            showArticleDetail(this);
        };
        
        articles.appendChild(div);
    }

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

            // 文章内容

        },
        error: function () {
            alert("书籍内容数据获取失败");
        }
    });

    var backbtn = content.getElementsByClassName("back_lbl")[0];
    backbtn .getElementsByTagName("span")[0].innerHTML = "文章发表";
    backbtn.onclick = function () {
        $("#article_content").hide();
        $("#achieve_list").show();
    };


    $("#achieve_list").hide();
    $("#article_content").show();
    
}