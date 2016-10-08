/**
 * Created by L.H.S on 2016/10/8.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下
var language = "ch";

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