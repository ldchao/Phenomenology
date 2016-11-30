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

function getBanners() {

    banner_width = 6 * 230;
    banner.style.width = banner_width;

    for (var i = 0; i < 6; i++) {
        var div = document.createElement("div");
        div.className = "banner_pic";
        banner.appendChild(div);

        if (i % 2 == 0) {
            div.style.backgroundColor = '#76c06e';
        }

        div.innerHTML = i;
        // var img = document.createElement("img");
        // img.style.width = "230px";
        // img.style.height = "160px";
        // img.src = result[i].location;
        // div.appendChild(img);

        // var a = document.createElement("a");
        // a.innerHTML = result[i].url;
        // a.style.display = "none";
        // div.appendChild(a);

        // div.onclick = function () {
        //     window.open(this.getElementsByTagName("a")[0].innerHTML);
        // };

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

    // if (result.length > 1) {
    banner_auto = setInterval(switchPic, banner_speed);
    // }
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