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
    <link href="css/homepage.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<div class="top_title">

    <div style="width: 1135px; margin: 0 auto; position: relative">
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

        <div class="nav_bar active" onclick="window.location.href='HomePage'">
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


    </div>

    <%--右侧内容块--%>
    <div id="simple_content" class="right_content">

        <div class="sub_field">

            <div class="sub_title_div">
                <div class="div_decorate"></div>

                <div class="article_index sub_title">动态新闻</div>

                <div class="article_index more" onclick="getMore(this)">
                    <span>更多</span>&nbsp;<i class="fa fa-angle-right"></i>
                </div>
            </div>

            <%-- 动态新闻的父块 --%>
            <div id="dynamic_news" style="margin-top: 5px;">

                <%-- 每个标题 --%>
                <div id="title_copy" class="each_title" style="display: none;">

                    <div class="each_img"></div>

                    <div class="right_title">
                        <div class="big_div article_list_title">
                            现象学研究所新接见了世界级现象学大师
                        </div>

                        <div class="small_div article_preview">
                            2016年12月，现象学大师来到南京大学现象现象学大师来到南京大学现象
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <hr class="sub_hr">

        <div class="sub_field">

            <div class="sub_title_div">
                <div class="div_decorate"></div>

                <div class="article_index sub_title">源头活水</div>

                <div class="article_index more" onclick="getMore(this)">
                    <span>更多</span>&nbsp;<i class="fa fa-angle-right"></i>
                </div>
            </div>

            <%-- 源头活水的父块 --%>
            <div id="source_water" style="margin-top: 5px;"></div>

        </div>
    </div>

    <%-- 更多 --%>
    <div id="more_content" class="right_content" style="height: 860px; display: none;">

        <div class="sub_title_div" style="margin-top: 30px; margin-left: 42px;">
            <div class="div_decorate"></div>
            <div class="article_index sub_title">动态新闻</div>
        </div>

        <div id="eachpage" class="each_page"></div>

        <div id="more_copy" style="display: none;">
            <div class="each_more">
                <div class="article_list_title more_title">现象学研究所接见了世界级现象学大师</div>
                <div>
                    <div class="more_img"></div>
                    <div class="more_text article_preview">啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
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

        <%-- 分页标签 --%>
        <div id="paging" style="margin-left: 38px; margin-top: 20px;">

            <i class="fa fa-chevron-left next_page" onclick="nextPage(1)"></i>

            <%-- 页码 --%>
            <div id="pages" style="display: inline-block;"></div>

            <div class="pages_each pages_selected" style="display: none;">1</div>

            <i class="fa fa-chevron-right next_page" style="margin-left: 10px;" onclick="nextPage(0)"></i>

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


<script src="js/homepage.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.js"></script>
</body>
</html>
