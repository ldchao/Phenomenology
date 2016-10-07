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

    <link href="../css/common.css" rel="stylesheet">
    <link href="../css/cssreset.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<div class="top_title">

    <div class="ch_eng" onclick="changeVersion(0)">中文</div>
    <div class="ch_eng ch_eng_not" style="width: 60px;right: 25px;" onclick="changeVersion(1)">English</div>

</div>

<div class="main_body">

    <%--左侧导航栏--%>
    <div class="left_nav">

        <div class="nav_bar" onclick="window.location.href='HomePage'">
            <i class="fa fa-angle-right"></i>
            <span>&nbsp;首&nbsp;页</span>
        </div>

        <div class="nav_bar active" onclick="window.location.href='Situation'">
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
    <div class="right_content">

        <div id="situation_name" class="article_index" style="margin-left: 40px; margin-top: 30px;">
            南京大学现象研究所
        </div>

        <div id="introduce" class="article_text" style="width: 810px; margin-left: 40px; margin-top: 22px;">

            从现象学的角度来谈论技术问题显然肇始于海德格尔。他在1927年出版的《存在与时间》中对工具的现象学分析，
            为后来现象学技术哲学的发展开启了思路。这种思路甚至影响到了当代的计算机设计，例如，
            麻省理工学院计算机专业的学生就要学习海德格尔的这一思想。
            海德格尔后期对技术的追问虽然给人许多启迪，但是后来的技术哲学家们却从各种角度出发，
            试图摆脱技术宿命论。<br>
            <br>
            几乎在海德格尔出版《存在与时间》的同时，西班牙哲学家奥特加（JoséOrtega y
            Gasset，1883－1955）也通过批判胡塞尔的意识分析，
            发展出了与海德格尔类似的存在主义意向性或者作为自我与其环境并存的“真实的人的生活”。
            奥特加的哲学沉思是一种对现实生活的理性反思，他认为人是一种技术的存在，可以把人定义为制作，
            但是这种制作不限于物质制作，而且也包括精神性的创造。<br>
            <br>
            海德格尔的早期弟子之一汉斯·乔纳斯（HansJonas）移居美国后，也开始从现象学的角度关注技术问题。
            但是由于乔纳斯是犹太人，具有很强的宗教背景，他主要关注是技术与责任的问题。

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

<script src="../js/common.js"></script>
<script src="../js/situation.js"></script>
<script src="../js/jquery.js"></script>
</body>
</html>
