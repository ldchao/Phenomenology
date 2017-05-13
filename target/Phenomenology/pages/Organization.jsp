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

<jsp:include page="common/NavBar.jsp"></jsp:include>

<div class="main_body">

    <%--左侧导航栏--%>
    <div class="left_nav">

        <div class="nav_bar active" onclick="changeTab(0)">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>在职人员</span>
        </div>

        <div class="nav_bar" onclick="changeTab(1)">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>访问学者</span>
        </div>

        <div class="nav_bar" onclick="changeTab(2)">
            <i class="fa fa-angle-right"></i>&nbsp;
            <span>本所学生</span>
        </div>
    </div>

    <%--右侧内容块--%>
    <div class="right_content">

        <div class="direction_div">
            机构人员 <i class="fa fa-angle-right"></i> <span>在职人员</span>
        </div>

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
    <span class="span_title">通讯地址</span>
    <span>南京市仙林大道163号</span>&nbsp;
    <span>南京大学仙林校区薛光林楼</span>
    <span style="margin-left: 25px;" class="span_title">邮编</span>
    210023
    <span style="margin-left: 25px;" class="span_title">邮箱</span>
    phenomenology@nju.edu.cn
</div>

<script src="js/organization.js"></script>
<script src="js/jquery.js"></script>
<script src="js/common.js"></script>
<script src="js/version.js"></script>
<script>
    $(".nav_2").eq(2).addClass("active_2");
</script>
</body>
</html>
