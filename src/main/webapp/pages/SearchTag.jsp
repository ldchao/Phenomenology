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

<jsp:include page="common/NavBar.jsp"></jsp:include>

<div class="main_body">

    <%--右侧内容块--%>
    <div id="search_lis"
         style="width: 1030px; height: 830px; margin: 50px auto; background-color: #fff">

        <div class="tab_achieve article_index" style="border-bottom: 3px solid #1a799f; margin-left: 50px"
             onclick="changeTab(0)">
            相关文章
        </div>

        <div class="tab_achieve article_index" onclick="changeTab(1)">
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
<script src="js/searchtag.js"></script>
</body>
</html>
