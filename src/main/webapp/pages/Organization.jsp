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

    <link href="css/achievement.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <link href="css/cssreset.css" rel="stylesheet">
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

    <%--左侧导航栏--%>
    <div class="left_nav">

        <div class="nav_bar" onclick="window.location.href='HomePage'">
            <i class="fa fa-angle-right"></i>
            <span>&nbsp;首&nbsp;页</span>
        </div>

        <div class="nav_bar" onclick="window.location.href='Situation'">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>本所概况</span>
        </div>

        <div class="nav_bar active" onclick="window.location.href='Organization'">
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


    </div>

    <%--右侧内容块--%>
    <div class="right_content">

        <div class="tab_achieve article_index" style="border-bottom: 3px solid #1a799f;" onclick="changeTab(0)">
            在职人员
        </div>
        <div class="tab_achieve article_index" style="margin-left: 20px" onclick="changeTab(1)">访问学者</div>
        <div class="tab_achieve article_index" style="margin-left: 20px" onclick="changeTab(2)">本所学生</div>

        <div id="office" class="achieves_div">
            <div id="office_copy" class="each_photo_div" style="display: none;width: 130px; height: 140px;">
                <div class="book_pic" style="width: 130px; height: 140px;"></div>
                <div class="article_text name_link">某某某</div>
                <a style="display: none;">1</a>
            </div>
        </div>

        <div id="visiting" class="achieves_div"></div>

        <div id="student" class="achieves_div"></div>

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

<script src="js/organization.js"></script>
<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/version.js"></script>
</body>
</html>
