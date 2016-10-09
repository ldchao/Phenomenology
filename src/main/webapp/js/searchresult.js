/**
 * Created by L.H.S on 2016/10/8.
 */

var Tab_Selected = 0;   // 记录当前在哪个tab标签下
var language = "ch";

window.onload = function () {

    language = judgeVersion();
    getPics();

    var key = document.getElementById("storage").innerHTML.trim();
    getArticle(key);
    getStaff(key);
    getBook(key);
};


function getArticle(key) {

    var article = document.getElementById("article_title");
    var copy = document.getElementById("article_copy");

    $.ajax({
        type: "get",
        async: false,
        url: "searchEssay",
        data: {
            "key": key,
        },
        dataType: "json",
        success: function (result) {

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


        },
        error: function () {
            alert("搜索失败");
        }
    });
}

function getStaff(key) {

    var staff = document.getElementById("staff_title");
    var copy = document.getElementById("staff_copy");

    $.ajax({
        type: "get",
        async: false,
        url: "searchPerson",
        data: {
            "key": key,
        },
        dataType: "json",
        success: function (result) {

            for (var i = 0; i < result.length; i++) {
                var div = document.createElement("div");
                div.innerHTML = copy.innerHTML;

                var title = div.getElementsByClassName("more_title")[0].innerHTML.trim();
                title.innerHTML = result[i].name;
                title.onclick = function () {
                    showSearch(this, "getPersonURL");
                };
                
                var img = document.createElement("img");
                img.style.width = "70px";
                img.style.height = "75px";
                img.src = result[i].imageLocation;
                div.getElementsByClassName("more_img")[0].appendChild(img);
                
                setHtml(result[i].descriptionLocation, div.getElementsByClassName("more_text")[0]);
                
                div.getElementsByTagName("a")[0].innerHTML = result[i].id;

                staff.appendChild(div);
            }
        },
        error: function () {
            // alert("科研成果数据获取失败");
        }
    });

    $("#staff_title").hide();
}

function getBook(key) {
    
    var book = document.getElementById("book_title");
    var copy = document.getElementById("staff_copy");

    $.ajax({
        type: "get",
        async: false,
        url: "searchAchievement",
        data: {
            "key": key,
        },
        dataType: "json",
        success: function (result) {

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
            
        },
        error: function() {
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
            window.location.href = result;
        },
        error: function () {
            // alert("科研成果数据获取失败");
        }
    });
}

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