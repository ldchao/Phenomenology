<%--
  Created by IntelliJ IDEA.
  User: L.H.S
  Date: 2016/12/2
  Time: 00:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>南京大学现象学研究所</title>

    <link href="css/common.css" rel="stylesheet">
    <link href="css/blogroll.css" rel="stylesheet">
    <link href="css/cssreset.css" rel="stylesheet">
    <link href="css/homepage.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<div class="top_title">

    <div style="width: 1135px; margin: 0 auto; position: relative">
        <img src="css/NJUPh.svg">

        <div class="ch_eng" onclick="changeVersion(0)">中文</div>
        <div class="ch_eng ch_eng_not" style="width: 60px; right: 0;" onclick="changeVersion(1)">English</div>

        <div>
            <input id="search_key" class="search" type="text" placeholder="搜索您想要的…"
                   onkeydown="if(event.keyCode==13){search(0);}">
            <i class="fa fa-search search_btn" style="font-size: 22px;" onclick="search(0)"></i>
        </div>

    </div>
</div>

<div class="main_body">


    <div style="display: inline-block; vertical-align: top;">

        <%-- 轮播图 --%>
        <div class="banner_div">

            <div id="banner" style="position: absolute;"></div>

            <div id="dotpages" class="dot_div"></div>
        </div>

        <%--左侧导航栏--%>
        <div class="left_nav" style="height: 260px; margin-top: 10px; padding-top: 15px;">

            <div class="nav_bar" onclick="window.location.href='HomePage'">
                <i class="fa fa-angle-right"></i>
                <span>&nbsp;首&nbsp;页</span>
            </div>

            <div class="nav_bar" onclick="window.location.href='Situation'">
                <i class="fa fa-angle-right"></i>&nbsp;
                <span>本所概况</span>
            </div>

            <div class="nav_bar" onclick="window.location.href='Organization'">
                <i class="fa fa-angle-right"></i>&nbsp;
                <span>机构人员</span>
            </div>

            <div class="nav_bar" onclick="window.location.href='AcademicCommunicate'">
                <i class="fa fa-angle-right"></i>&nbsp;
                <span>学术交流</span>
            </div>

            <div class="nav_bar" onclick="window.location.href='AcademicSource'">
                <i class="fa fa-angle-right"></i>&nbsp;
                <span>学术资源</span>
            </div>

            <div class="nav_bar" onclick="window.location.href='Achievement'">
                <i class="fa fa-angle-right"></i>&nbsp;
                <span>科研成果</span>
            </div>

            <div class="nav_bar active" onclick="window.location.href='Blogroll'">
                <i class="fa fa-angle-right"></i>&nbsp;
                <span>友情链接</span>
            </div>
        </div>

    </div>

    <%--右侧内容块--%>
    <div id="simple_content" class="right_content" style="height: 445px;">

        <div class="article_index title_div">友情链接</div>


        <div style="margin-left: 5px; margin-top: 5px;">

            <div id="link1" class="links_div" onclick="window.open('http://hiw.kuleuven.be/ned')">
                <div class="mask">鲁汶大学胡塞尔档案馆</div>
            </div>

            <div id="link2" class="links_div" onclick="window.open('http://www.husserlarchiv.de')">
                <div class="mask">弗莱堡大学胡塞尔档案馆</div>
            </div>

        </div>

        <div style="margin-left: 5px;">

            <div id="link3" class="links_div" onclick="window.open('http://www.phaenomenologie.com.cn')">
                <div class="mask">中国现象学网</div>
            </div>

            <div id="link4" class="links_div" onclick="window.open('http://www.husserl.phil-fak.uni-koeln.de/7757.html')">
                <div class="mask">科隆大学胡塞尔档案馆</div>
            </div>

        </div>

    </div>


    <%--滚动图片--%>
    <div class="roll_pic">

        <div id="rollpic" style="width: 2133px; position: absolute;"></div>

        <div class="next_pic" style="left: 20px;"><i class="fa fa-arrow-circle-o-left"></i></div>
        <div class="next_pic"><i class="fa fa-arrow-circle-o-right"></i></div>

    </div>

</div>


<%--底栏--%>
<div class="bottom_nav">
    <span class="span_title">通讯地址</span>
    <span>南京市仙林大道163号</span>&nbsp;
    <span>南京大学仙林校区薛光林楼</span>
    <span style="margin-left: 25px;" class="span_title">邮编</span>
    210023
    <span style="margin-left: 25px;" class="span_title">邮箱</span>
    phenomenology@nju.edu.cn
</div>


<script src="js/blogroll.js"></script>
<script src="js/common.js"></script>
<script src="js/banner.js"></script>
<script src="js/version.js"></script>
<script src="js/jquery.js"></script>
</body>
</html>

