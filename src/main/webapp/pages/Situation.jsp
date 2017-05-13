<%--
  Created by IntelliJ IDEA.
  User: L.H.S
  Date: 16/9/20
  Time: 下午3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>南京大学现象学研究所</title>

    <link href="css/common.css" rel="stylesheet">
    <link href="css/cssreset.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        .introduce_div {
            width: 100%;
            padding: 0 40px;
            margin-top: 20px;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
    </style>
</head>

<body>

<jsp:include page="common/NavBar.jsp"></jsp:include>

<div class="main_body">

    <%--右侧内容块--%>
    <div class="right_content" style="width: 100%; margin-left: 0;">

        <div id="situation_name" class="article_index" style="margin-left: 40px; margin-top: 30px;">
            南京大学现象研究所
        </div>

        <div id="introduce" class="article_text introduce_div"></div>

    </div>

    <%--滚动图片--%>
    <div class="roll_pic">

        <div id="rollpic" style="width: 2133px; position: absolute;">

        </div>

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

<%-- 返回顶部 --%>
<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i></a>

<script src="js/common.js"></script>
<script src="js/version.js"></script>
<script src="js/situation.js"></script>
<script src="js/jquery.js"></script>
<script>
    $(".nav_2").eq(1).addClass("active_2");
</script>
</body>
</html>
