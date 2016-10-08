/**
 * Created by L.H.S on 2016/10/8.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下
var language = "ch";

window.onload = function () {
    
    language = judgeVersion();

};

function changeTab(index) {

    Tab_Selected = index;

    var Ids = ["article_title", "staff_title", "book_title"];
    var tabs = document.getElementsByClassName("tab_achieve");

    tabs[index].style.borderBottom = "3px solid #1a799f";
    tabs[(index + 1) % 3].style.borderBottom = "";
    tabs[(index + 2) % 3].style.borderBottom = "";

    $(document.getElementById(Ids[index])).show();
    $(document.getElementById(Ids[(index + 1) % 3])).hide();
    $(document.getElementById(Ids[(index + 2) % 3])).hide();

}

function changeVersion_content() {

    var tabs = document.getElementsByClassName("tab_achieve");
    var eng_title = ["RelatedArticles", "RelatedStaff", "RelatedBooks"];
    for (var i = 0; i < 3; i++) {
        tabs[i].innerHTML = eng_title[i];
        tabs[i].style.fontSize = "18px";
    }
}