<%--
  Created by IntelliJ IDEA.
  User: L.H.S
  Date: 16/9/20
  Time: 下午3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>南京大学现象学研究所</title>

    <link href="css/common.css" rel="stylesheet">
    <link href="css/cssreset.css" rel="stylesheet">
    <link href="css/achievement.css" rel="stylesheet">
    <link href="css/homepage.css" rel="stylesheet">
    <link href="css/searchresult.css" rel="stylesheet">
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
                   onkeydown="if(event.keyCode==13){search(1);}">
            <i class="fa fa-search search_btn" style="font-size: 22px;" onclick="search(1)"></i>
        </div>

    </div>

</div>

<div class="nav_bar_2">
    <div class="nav_2" style="margin-left: 100px;" onclick="window.location.href='HomePage'">首页</div>
    <div class="nav_2" onclick="window.location.href='Situation'">本所概况</div>

    <div class="nav_2" onclick="window.location.href='Organization'">
        机构人员
        <div class="sub_nav_bar_2">
            <div class="sub_nav_2" style="margin-left: -106px;">在职人员</div>
            <div class="sub_nav_2">本所学生</div>
            <div class="sub_nav_2">访问学者</div>
        </div>
    </div>

    <div class="nav_2" onclick="window.location.href='AcademicCommunicate'">
        学术交流
        <div class="sub_nav_bar_2">
            <div class="sub_nav_2" style="margin-left: 174px;">学术讲座</div>
            <div class="sub_nav_2">学术会议</div>
            <div class="sub_nav_2">师生出访</div>
        </div>
    </div>

    <div class="nav_2" onclick="window.location.href='AcademicSource'">
        学术资源
        <div class="sub_nav_bar_2">
            <div class="sub_nav_2" style="margin-left: 454px;">讲座实录</div>
            <div class="sub_nav_2">课程资源</div>
            <div class="sub_nav_2">学界动态</div>
        </div>
    </div>

    <div class="nav" onclick="window.location.href='Achievement'">
        科研成果
        <div class="sub_nav_bar_2">
            <div class="sub_nav_2" style="margin-left: 594px;">书籍出版</div>
            <div class="sub_nav_2">文章发表</div>
        </div>
    </div>
</div>

<div class="main_body">

    <%--右侧内容块--%>
    <div id="search_lis"
         style="width: 1030px; height: 830px; margin: 50px auto; background-color: #fff">

        <div class="tab_achieve article_index" style="border-bottom: 3px solid #1a799f; margin-left: 50px"
             onclick="changeTab(0)">
            相关文章
        </div>

        <div class="tab_achieve article_index" onclick="changeTab(1)">
            相关人员
        </div>

        <div class="tab_achieve article_index" onclick="changeTab(2)">
            相关书籍
        </div>

        <%-- 文章 --%>
        <div id="article_title" class="search_list">

            <div id="article_copy" style="display: none;">

                <div class="each_search">
                    <div class="article_list_title more_title">现象学研究所接见了世界级现象学大师</div>

                    <div class="search_text article_preview">
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                    </div>

                    <a style="display: none;"></a>
                </div>

            </div>

        </div>

        <%-- 人员 --%>
        <div id="staff_title" class="search_list" style="display: none;">

            <div id="staff_copy" style="display: none;">

                <div class="each_more">
                    <div class="article_list_title more_title">某某某</div>
                    <div style="width: 930px;">
                        <div class="more_img"></div>
                        <div class="more_text article_preview" style="width: 850px;">
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        </div>
                    </div>

                    <a style="display: none"></a>
                </div>

            </div>

        </div>

        <%-- 书籍 --%>
        <div id="book_title" class="search_list" style="display: none;">

        </div>

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

<a id="storage" style="display: none">${key}</a>

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/version.js"></script>
<script src="js/searchresult.js"></script>
</body>
</html>
