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

function showBooks() {
    var copy = document.getElementById("book_copy");
    var books = document.getElementById("books");

    for (var i = 0; i < 7; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_book_div");

        books.appendChild(div);
    }
}

function showArticles() {
    var articles = document.getElementById("articles");

    var copy = document.getElementById("book_copy");
    for (var i = 0; i < 2; i++) {
        var div = document.createElement("div");
        div.innerHTML = copy.innerHTML;
        div.setAttribute("class", "each_book_div");

        articles.appendChild(div);
    }

    $(articles).hide();
}