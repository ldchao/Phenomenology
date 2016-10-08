<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>南京大学现象学研究所</title>
    <link href="css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="css/backend.css">
    <link href="css/cssreset.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="dist/css/wangEditor.min.css">
</head>
<body>
<div class="log">登出</div>
<header>你好，张三！
</header>


<div class="left_block">
    <ul>
        <li class="intent" onclick="window.location.href='Introduce'">本所概况</li>
        <li class="title">首页</li>
        <li class="intent" onclick="window.location.href='DynamicNews'">动态新闻</li>
        <li class="intent" onclick="window.location.href='WaterSource'">源头活水</li>
        <li class="intent" onclick="window.location.href='RollImage'">底部滚动图</li>
        <li class="title">机构人员</li>
        <li class="intent" onclick="window.location.href='Worker'">在职人员</li>
        <li class="intent" onclick="window.location.href='Visitor'">访问学者</li>
        <li class="intent active" onclick="window.location.href='Student'">本所学生</li>
        <li class="title">学术交流</li>
        <li class="intent" onclick="window.location.href='Lecture'">学术讲座</li>
        <li class="intent" onclick="window.location.href='Meeting'">学术会议</li>
        <li class="intent" onclick="window.location.href='Visiting'">师生出访</li>
        <li class="title">学术资源</li>
        <li class="intent" onclick="window.location.href='LectureRecord'">讲座实录</li>
        <li class="intent" onclick="window.location.href='Course'">课程资源</li>
        <li class="intent" onclick="window.location.href='AcademicNews'">学界动态</li>
        <li class="title">科研成果</li>
        <li class="intent" onclick="window.location.href='Book'">书籍出版</li>
        <li class="intent" onclick="window.location.href='Article'">文章发表</li>
    </ul>
</div>

<div class="right_block">
    <div class="right_intent">
        <table class="list">
            <tr>
                <td class="td1">1</td>
                <td class="td2">xxx项目</td>
                <td class="td3"><a><i class="fa fa-pencil" aria-hidden="true"></i></a>
                    <a onclick="editForm(this)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
            </tr>
            <tr>
                <td class="td1">1</td>
                <td class="td2">xxx项目</td>
                <td class="td3"><a><i class="fa fa-pencil" aria-hidden="true"></i></a>
                    <a onclick="editForm(this)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
            </tr>
            <tr>
                <td class="td1">1</td>
                <td class="td2">xxx项目</td>
                <td class="td3"><a><i class="fa fa-pencil" aria-hidden="true"></i></a>
                    <a onclick="editForm(this)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
            </tr>
            <tr>
                <td class="td1">1</td>
                <td class="td2">xxx项目</td>
                <td class="td3"><a><i class="fa fa-pencil" aria-hidden="true"></i></a>
                    <a onclick="editForm(this)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
            </tr>
            <tr>
                <td class="td1">1</td>
                <td class="td2">xxx项目</td>
                <td class="td3"><a><i class="fa fa-pencil" aria-hidden="true"></i></a>
                    <a onclick="editForm(this)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
            </tr>
            <tr>
                <td class="td1">1</td>
                <td class="td2">xxx项目</td>
                <td class="td3"><a><i class="fa fa-pencil" aria-hidden="true"></i></a>
                    <a onclick="editForm(this)"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
            </tr>
        </table>

        <button class="new blueButton" onclick="showForm()">新建
        </button>
    </div>
</div>

<div class="editBody">
    <div class="editForm">
        <a class="closeButton" onclick="closeForm
        ()"><i class="fa fa-times" aria-hidden="true"></i></a>
        <div class="innerForm">

            <div class="firstline">
                <input id="name" type="text" class="textfield" placeholder="姓名">

            </div>

            <div id="editDiv">
                <p>在此输入人物介绍......</p>
            </div>


            <div class="buttons">
                <a class="chooseFile">
                    <input style="opacity: 0;" type="file" name="coverImg" id="coverImg"/>点击这里上传头像
                </a>

                <%--<button id="chooseImage" class="formButton blueButton">选取缩略图</button>--%>
                <button class="submitButton">提交</button>

                <div class="none">
                    <input type="submit" name="submitFile" value="提交"/>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="js/backend.js"></script>
<script type="text/javascript" src="dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="dist/js/wangEditor.min.js"></script>
<script>
    var h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;   //height

    var editor = new wangEditor('editDiv');
    editor.config.menuFixed = false;

    // 上传图片（举例）
    //    editor.config.uploadImgUrl = '../uploadImgUrl';

    if ($(".innerForm").find("#editDiv").length != 0) {
        $(".editForm").css({height: (h - 100)});
    }
    $("#editDiv").css({height: (h - 250)});
    editor.create();

</script>
</body>
</html>


