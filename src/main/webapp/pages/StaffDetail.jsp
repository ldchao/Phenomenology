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

    <div id="staff_detail" class="right_content_detail">

        <div class="article_index back_lbl" onclick="goBack()">
            <span>${Tag2}</span> <i class="fa fa-angle-right"></i>
        </div>

        <span class="article_index name">${OrganizationVO.name}</span>

        <div class="staff_detail">
            <div id="content" class="introduction article_text"></div>

            <div class="photo">
                <img id="img" style="width: 130px; height: 140px;">
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
    <span>通讯地址</span>
    南京市仙林大道163号&nbsp;
    南京大学仙林校区薛光林楼
    <span style="margin-left: 25px;">邮编</span>
    210023
    <span style="margin-left: 25px;">邮箱</span>
    phenomenology@nju.edu.cn
</div>

<%-- 返回顶部 --%>
<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i></a>

<a id="storage" style="display: none">${Tag1}</a>
<a id="storage_location" style="display: none">${OrganizationVO.descriptionLocation}</a>
<a id="storage_img" style="display: none">${OrganizationVO.imageLocation}</a>

<script src="../../js/jquery.js"></script>
<script src="../../js/common.js"></script>
<script src="../../js/version.js"></script>
<script src="../../js/detail.js"></script>
<script>
    setImage();
</script>
</body>
</html>
