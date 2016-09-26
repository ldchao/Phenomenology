<%--
  Created by IntelliJ IDEA.
  User: L.H.S
  Date: 16/9/20
  Time: 下午3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>南京大学现象学研究所</title>

    <link href="../css/achievement.css" rel="stylesheet">
    <link href="../css/common.css" rel="stylesheet">
    <link href="../css/cssreset.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<div class="top_title"></div>

<div class="main_body">

    <%--左侧导航栏--%>
    <div class="left_nav">

        <div class="nav_bar" onclick="window.location.href='HomePage'">
            <i class="fa fa-angle-right"></i>
            &nbsp;首&nbsp;页
        </div>

        <div class="nav_bar" onclick="window.location.href='Situation'">
            <i class="fa fa-angle-right"></i>&nbsp;
            本所概况
        </div>

        <div class="nav_bar" onclick="window.location.href='Organization'">
            <i class="fa fa-angle-right"></i>&nbsp;
            机构人员
        </div>

        <div class="nav_bar active" onclick="window.location.href='AcademicCommunicate'">
            <i class="fa fa-angle-right"></i>&nbsp;
            学术交流
        </div>

        <div class="nav_bar" onclick="window.location.href='AcademicSource'">
            <i class="fa fa-angle-right"></i>&nbsp;
            学术资源
        </div>

        <div class="nav_bar" onclick="window.location.href='Achievement'">
            <i class="fa fa-angle-right"></i>&nbsp;
            科研成果
        </div>


    </div>

    <%--右侧内容块--%>
    <div class="right_content">

        <div class="tab_achieve article_index" style="border-bottom: 3px solid #1a799f;" onclick="changeTab(0)">
            学术讲座
        </div>
        <div class="tab_achieve article_index" style="margin-left: 20px" onclick="changeTab(1)">学术交流</div>
        <div class="tab_achieve article_index" style="margin-left: 20px" onclick="changeTab(2)">师生出访</div>

        <div id="lecture" class="achieves_div">

            <div id="lecture_copy" class="each_lecture" style="display: none;">
                <span class="lecture_title article_list_title">2016年南京大学超级现象学大会召开并且标题非常非常非常非常的长</span>
                <span class="article_list_title" style="float: right; margin-right: 17px; color: #b8b9b9;">2016/9/30</span>
            </div>

        </div>

        <div id="meeting" class="achieves_div"></div>

        <div id="visiting" class="achieves_div"></div>

    </div>

    <%--滚动图片--%>
    <div class="roll_pic">

        <div class="next_pic"><i class="fa fa-arrow-circle-o-right"></i></div>

        <div class="each_pic"></div>
        <div class="each_pic"></div>
        <div class="each_pic"></div>
        <div class="each_pic"></div>
        <div class="each_pic"></div>

    </div>

</div>


<%--底栏--%>
<div class="bottom_nav">

    <div style="width: 48%; float: left; display: inline-block">
        <div style="float: right; text-align: right;">

            <span style="color: #a0a0a0; font-size: 12px;">通讯地址</span><br>
            南京市仙林大道163号<br>
            南京大学仙林校区薛光林楼<br>
            <br>
            <span style="color: #a0a0a0; font-size: 12px;">邮编</span><br>
            210023
        </div>
    </div>

    <hr class="bottom_hr">

    <div style="width: 48%; float: right; display: inline-block;position: relative; left: -5px;">
        <div style="float: left; text-align: left;">
            <span style="color: #a0a0a0; font-size: 12px;">友情链接</span><br>
            <a>弗莱堡大学胡塞尔档案馆</a><br>
            <a>科隆大学胡塞尔档案馆</a><br>
            <a>鲁汶大学胡塞尔档案馆</a><br>
            <a>巴黎一大胡塞尔档案馆</a><br>
            <a>中国现象学网</a><br>
        </div>
    </div>

</div>

<script src="../js/jquery.js"></script>
<script src="../js/communicate.js"></script>
</body>
</html>
