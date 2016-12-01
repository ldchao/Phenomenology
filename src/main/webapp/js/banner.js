/**
 * Created by L.H.S on 2016/11/28.
 */

var banner = document.getElementById("banner");
var dotpages = document.getElementById('dotpages');
var banner_width;
var banner_auto;
var banner_speed = 2000;
var currentPage = 1;
var dots;

banner.onmouseover = function () {
    clearInterval(banner_auto);
};

banner.onmouseout = function () {
    banner_auto = setInterval(switchPic, banner_speed);
};

function getBanners(imgs, titles, urls) {

    banner_width = imgs.length * 230;
    banner.style.width = banner_width;

    for (var i = 0; i < imgs.length; i++) {
        var div = document.createElement("div");
        div.className = "banner_pic";
        banner.appendChild(div);

        var img = document.createElement("img");
        img.style.width = "230px";
        img.style.height = "160px";
        img.src = imgs[i];
        img.style.border = 'none';
        div.appendChild(img);

        var a = document.createElement("a");
        a.innerHTML = urls[i];
        a.style.display = "none";
        div.appendChild(a);

        var title_div = document.createElement('div');
        title_div.className = 'pic_title article_list_title';
        title_div.style.fontSize = '13px';
        title_div.innerHTML = titles[i];
        div.appendChild(title_div);

        div.onclick = function () {
            window.open(this.getElementsByTagName("a")[0].innerHTML);
        };

        var dot = document.createElement('div');
        dot.className = 'dot';
        dotpages.appendChild(dot);
        if (i == 0) {
            dot.style.backgroundColor = '#1a799f';
        }
        dot.onclick = function () {
            clearInterval(banner_auto);
            gotopage(this);
        };
    }

    if (imgs.length > 1) {
        banner_auto = setInterval(switchPic, banner_speed);
    }
    dots = dotpages.getElementsByClassName('dot');
}

function switchPic() {

    if (banner.offsetLeft > (231 - banner_width)) {
        banner.style.left = banner.offsetLeft - 230;

        dots[currentPage - 1].style.backgroundColor = '#d8d8d8';
        currentPage++;
        dots[currentPage - 1].style.backgroundColor = '#1a799f';
    } else {
        banner.style.left = "";
        banner.offsetLeft = 0;

        dots[currentPage - 1].style.backgroundColor = '#d8d8d8';
        currentPage = 1;
        dots[currentPage - 1].style.backgroundColor = '#1a799f';
    }
}

function gotopage(node) {

    var index = $(node).parents("#dotpages").find(".dot").index($(node));

    dots[currentPage - 1].style.backgroundColor = '#d8d8d8';
    currentPage = index + 1;
    dots[currentPage - 1].style.backgroundColor = '#1a799f';

    banner.style.left = 0 - index * 230;
    banner_auto = setInterval(switchPic, banner_speed);
}