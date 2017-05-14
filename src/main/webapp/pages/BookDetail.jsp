<%--
  Created by IntelliJ IDEA.
  User: L.H.S
  Date: 2016/10/8
  Time: 下午11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>南京大学现象学研究所</title>

    <link href="../../css/achievement.css" rel="stylesheet">
    <link href="../../css/common.css" rel="stylesheet">
    <link href="../../css/cssreset.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<jsp:include page="common/NavBarDetail.jsp"></jsp:include>

<div class="main_body">

    <%--左侧导航栏--%>
    <div class="left_nav_outer">

        <%-- 标签 --%>
        <div class="left_nav label_div" style="margin-top: 0">
            <div class="label_title">相关标签</div>

            <div id="labelDiv">

                <c:forEach items="${OrganizationVO.tags}" var="tag">
                    <div class="each_label" onclick="window.open('/Phenomenology/SearchByTag?key=' + this.innerHTML)">${tag}</div>
                </c:forEach>
                <%--<div class="each_label">讲座</div>--%>
            </div>
        </div>
    </div>

    <div id="staff_detail" class="right_content_detail">

        <div class="article_index back_lbl" onclick="goBack()">
            <span>${Tag2}</span> <i class="fa fa-angle-right"></i>
        </div>

        <span class="article_index name">${AchievementVO.title}</span>

        <div class="staff_detail">
            <div id="content" class="introduction article_text"></div>

            <div class="photo" style="width: 100px; height: 125px;">
                <img id="img" style="width: 100px; height: 125px;">
            </div>
        </div>

        <div id="attach" class="download_icon" style="display: none">
            <i class="fa fa-download"></i>
            附件：<span>《现象屠龙》</span>
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

<%-- 返回顶部 --%>
<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i></a>

<a id="storage" style="display: none">${Tag1}</a>
<a id="storage_location" style="display: none">${AchievementVO.descriptionLocation}</a>
<a id="storage_id" style="display: none;">${AchievementVO.id}</a>
<a id="storage_img" style="display: none">${AchievementVO.thumbnailLocation}</a>

<script src="../../js/jquery.js"></script>
<script src="../../js/common.js"></script>
<script src="../../js/version.js"></script>
<script src="../../js/detail.js"></script>
<script>
    setImage();
</script>
</body>
</html>
