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
    <link href="css/homepage.css" rel="stylesheet">
    <link href="css/searchresult.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<div class="top_title">

    <div style="width: 1135px; margin: 0 auto; position: relative">
        <div class="ch_eng" onclick="changeVersion(0)">中文</div>
        <div class="ch_eng ch_eng_not" style="width: 60px; right: 0;" onclick="changeVersion(1)">English</div>

        <div>
            <input id="search_key" class="search" type="text" placeholder="搜索您想要的…"
                   onkeydown="if(event.keyCode==13){search(1);}">
            <i class="fa fa-search search_btn" style="font-size: 22px;" onclick="search(1)"></i>
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

            <div id="article_copy" style="display: block;">

                <div class="each_more">
                    <div class="article_list_title more_title">现象学研究所接见了世界级现象学大师</div>

                    <div class="search_text article_preview">
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                        啊啊啊啊啊啊啊啊
                    </div>
                </div>
            </div>

        </div>

        <%-- 人员 --%>
        <div id="staff_title" class="search_list" style="display: none;">

            <div id="staff_copy" style="display: block;">
                <div class="each_more">
                    <div class="article_list_title more_title">某某某</div>

                    <div style="width: 930px;">
                        <div class="more_img"></div>
                        <div class="more_text article_preview" style="width: 850px;">
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
                            啊啊啊啊啊啊啊啊
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <%-- 书籍 --%>
        <div id="book_title" class="search_list" style="display: none;">

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

<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/searchresult.js"></script>
</body>
</html>
