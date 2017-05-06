<%--
  Created by IntelliJ IDEA.
  User: L.H.S
  Date: 2017/5/6
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
</body>
</html>
