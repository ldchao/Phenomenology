/**
 * Created by L.H.S on 2016/11/28.
 */

var banner = document.getElementById("banner");
var banner_width;
var banner_auto;
var banner_speed = 2000;

function getBanners() {

    banner_width = 6 * 230;
    banner.style.width = banner_width;

    for (var i = 0; i < 6; i++) {
        var div = document.createElement("div");
        div.className = "banner_pic";
        banner.appendChild(div);

        if(i%2==0) {
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

    }

    // if (result.length > 1) {
        banner_auto = setInterval(switchPic, banner_speed);
    // }
    
}

function switchPic() {

    if (banner.offsetLeft > (231 - banner_width)) {
        banner.style.left = banner.offsetLeft - 230;

        //    设置页码点

    } else {
        banner.style.left = "";
        banner.offsetLeft = 0;
    }
}

function gotopage() {

}