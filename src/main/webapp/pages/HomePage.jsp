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

<jsp:include page="common/NavBar.jsp"></jsp:include>

<div class="main_body">

    <div style="display: inline-block; vertical-align: top;">

        <%-- 轮播图 --%>
        <div class="banner_div">

            <div id="banner" style="position: absolute;"></div>

            <div id="dotpages" class="dot_div"></div>
        </div>

        <div class="blogroll_div" onclick="window.open('http://hiw.kuleuven.be/ned')"
             style="background-image: url('/Phenomenology/img/1.png');">

            <div class="cover_div">鲁汶大学胡塞尔档案馆</div>
        </div>

        <div class="blogroll_div" onclick="window.open('http://www.husserlarchiv.de')"
             style="background-image: url('/Phenomenology/img/2.png');">

            <div class="cover_div">弗莱堡大学胡塞尔档案馆</div>

        </div>

        <div class="blogroll_div" onclick="window.open('http://www.phaenomenologie.com.cn')"
             style="background-image: url('/Phenomenology/img/3.png');">

            <div class="cover_div">中国现象学网</div>
        </div>

        <div class="blogroll_div" onclick="window.open('http://www.husserl.phil-fak.uni-koeln.de/7757.html')"
             style="background-image: url('/Phenomenology/img/4.png');">

            <div class="cover_div">科隆大学胡塞尔档案馆</div>
        </div>

    </div>

    <%--右侧内容块--%>
    <div id="simple_content" class="right_content" style="width: 728px; height: 500px;">

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
    <div id="more_content" class="right_content" style="height: 860px; width: 720px; display: none;">

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
                    <div class="more_text article_preview">preview content
                    </div>
                </div>
            </div>
        </div>

        <%-- 分页标签 --%>
        <div id="paging" style="margin-left: 38px; margin-top: 20px; display: none;">

            <i class="fa fa-chevron-left next_page" onclick="nextPage(1)"></i>

            <%-- 页码 --%>
            <div id="pages" style="display: inline-block;"></div>

            <div class="pages_each pages_selected" style="display: none;">1</div>

            <i class="fa fa-chevron-right next_page" style="margin-left: 10px;" onclick="nextPage(0)"></i>

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


<script src="js/homepage.js"></script>
<script src="js/common.js"></script>
<script src="js/banner.js"></script>
<script src="js/version.js"></script>
<script src="js/jquery.js"></script>
<script>
    $(".nav_2").eq(0).addClass("active_2");
</script>
</body>
</html>
