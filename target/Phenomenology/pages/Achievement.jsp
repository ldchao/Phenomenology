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

    <link href="css/common.css" rel="stylesheet">
    <link href="css/cssreset.css" rel="stylesheet">
    <link href="css/achievement.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<div class="top_title">

    <div style="width: 1135px; margin: 0 auto; position: relative">
        <div class="ch_eng" onclick="changeVersion(0)">中文</div>
        <div class="ch_eng ch_eng_not" style="width: 60px; right: 0;" onclick="changeVersion(1)">English</div>

        <div>
            <input id="search_key" class="search" type="text" placeholder="搜索您想要的…">
            <i class="fa fa-search search_btn" style="font-size: 22px;"></i>
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

        <div class="nav_bar active" onclick="window.location.href='Achievement'">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>科研成果</span>
        </div>


    </div>

    <%--右侧内容块--%>
    <div id="achieve_list" class="right_content">

        <div class="tab_achieve article_index" style="border-bottom: 3px solid #1a799f;" onclick="changeTab(0)">
            书籍出版
        </div>
        <div class="tab_achieve article_index" style="margin-left: 20px" onclick="changeTab(1)">文章发表</div>


        <div id="books" class="achieves_div">

            <div id="book_copy" class="each_book_div" style="display: none;">
                <div class="book_pic"></div>
                <div class="article_text name_link">《现象屠龙》</div>
                <a style="display: none;">1</a>
            </div>

        </div>

        <div id="articles" class="achieves_div">

            <div id="lecture_copy" class="each_lecture" style="display: none;">
                <span class="lecture_title article_list_title">2016年南京大学超级现象学大会召开并且标题非常非常非常非常的长</span>
                <span class="article_list_title"
                      style="float: right; margin-right: 17px; color: #b8b9b9;">2016/9/30</span>
                <a style="display: none;">1</a>
            </div>

        </div>
    </div>

    <%-- 出版书籍的详情 --%>
    <div id="book_detail" class="right_content" style="display: none">

        <div class="article_index back_lbl">
            <span>书籍出版</span> <i class="fa fa-angle-right"></i>
        </div>

        <span class="article_index name">《现象屠龙》</span>

        <div class="achieves_div">
            <div class="introduction article_text">
                李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
                李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
                李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
                李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人
            </div>

            <div class="photo"></div>
        </div>

    </div>

    <%-- 文章详情 --%>
    <div id="article_content" class="right_content" style="height: 956px; display: none;">

        <div class="article_index back_lbl">
            <span>文章发表</span> <i class="fa fa-angle-right"></i>
        </div>

        <div class="news_title article_title">2016年南京大学超级现象学大会召开</div>

        <div class="text_content article_text">
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，李四是一个好人，
            李四是一个好人，
        </div>

    </div>

    <%--滚动图片--%>
    <div class="roll_pic">

        <div id="rollpic" style="width: 2133px; position: absolute;">

            <div class="each_pic"></div>
            <div class="each_pic"></div>
            <div class="each_pic"></div>
            <div class="each_pic"></div>
            <div class="each_pic"></div>
            <div class="each_pic"></div>

        </div>

        <div class="next_pic" style="left: 20px;"><i class="fa fa-arrow-circle-o-left"></i></div>
        <div class="next_pic"><i class="fa fa-arrow-circle-o-right"></i></div>

    </div>

</div>


<%--底栏--%>
<div class="bottom_nav">

    <div style="width: 48%; float: left; display: inline-block">
        <div style="float: right; text-align: right;">

            <span style="color: #a0a0a0; font-size: 12px;">通讯地址</span><br>
            <span>南京市仙林大道163号</span><br>
            <span>南京大学仙林校区薛光林楼</span><br>
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


<script src="js/achievement.js"></script>
<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
</body>
</html>
