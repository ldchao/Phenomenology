<%--
  Created by IntelliJ IDEA.
  User: L.H.S
  Date: 2016/10/8
  Time: 下午11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>南京大学现象学研究所</title>

    <link href="../../css/achievement.css" rel="stylesheet">
    <link href="../../css/common.css" rel="stylesheet">
    <link href="../../css/cssreset.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<div class="top_title">

    <div style="width: 1135px; margin: 0 auto; position: relative">
        <img src="../../css/NJUPh.svg">

        <div class="ch_eng" onclick="changeVersion_detail(0)">中文</div>
        <div class="ch_eng ch_eng_not" style="width: 60px; right: 0;" onclick="changeVersion_detail(1)">English</div>

        <div>
            <input id="search_key" class="search" type="text" placeholder="搜索您想要的…"
                   onkeydown="if(event.keyCode==13){search(0);}">
            <i class="fa fa-search search_btn" style="font-size: 22px;" onclick="search(0)"></i>
        </div>

    </div>

</div>

<div class="main_body">

    <%--左侧导航栏--%>
    <div class="left_nav">

        <div class="nav_bar" onclick="window.location.href='/Phenomenology/HomePage'">
            <i class="fa fa-angle-right"></i>
            <span>&nbsp;首&nbsp;页</span>
        </div>

        <div class="nav_bar" onclick="window.location.href='/Phenomenology/Situation'">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>本所概况</span>
        </div>

        <div class="nav_bar" onclick="window.location.href='/Phenomenology/Organization'">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>机构人员</span>
        </div>

        <div class="nav_bar" onclick="window.location.href='/Phenomenology/AcademicCommunicate'">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>学术交流</span>
        </div>

        <div class="nav_bar" onclick="window.location.href='/Phenomenology/AcademicSource'">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>学术资源</span>
        </div>

        <div class="nav_bar" onclick="window.location.href='/Phenomenology/Achievement'">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>科研成果</span>
        </div>

        <div class="nav_bar" onclick="window.location.href='/Phenomenology/Blogroll'">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>友情链接</span>
        </div>
    </div>

    <%-- 文章 --%>
    <div id="news_content" class="right_content_detail">

        <div class="article_index back_lbl">
            <span onclick="goBack()">${Tag2}</span> <i class="fa fa-angle-right"></i>
        </div>

        <div class="news_title article_title">${AcademicVO.title}</div>

        <div class="info article_list_title" style="color: #9d9d9d;">
            <div style="display: inline-block"><span id="writer_lbl">发布人</span>: <span
                    id="writer">${AcademicVO.author}</span></div>
            <div style="margin-left: 20px; display: inline-block"><span id="time_lbl">发布时间</span>: <span
                    id="time">${AcademicVO.time}</span>
            </div>
            <div style="margin-left: 20px; display: inline-block"><span id="viewer_lbl">浏览量</span>: <span
                    id="viewer">${AcademicVO.pageView}</span>
            </div>
        </div>

        <div id="content" class="text_content article_text"></div>

        <div id="attach" class="download_icon" style="display: none">
            <i class="fa fa-download"></i>
            附件：<span>《现象屠龙》</span>
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

<%-- 返回顶部 --%>
<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i></a>

<a id="storage" style="display: none">${Tag1}</a>
<a id="storage_location" style="display: none">${AcademicVO.location}</a>
<a id="storage_id" style="display: none">${AcademicVO.id}</a>

<script src="../../js/jquery.js"></script>
<script src="../../js/common.js"></script>
<script src="../../js/version.js"></script>
<script src="../../js/detail.js"></script>
</body>
</html>
