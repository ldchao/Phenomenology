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

<div id="transfer" style="position:absolute;left: 20px;top:0px;">
    <div class="ch_eng" onclick="changeLan(0)" style="left: 0px;">中文</div>
    <div class="ch_eng ch_eng_not" style="width: 60px; left: 45px;" onclick="changeLan(1)">English</div>
</div>


<div class="left_block">
    <ul>
        <li class="intent active" onclick="window.location.href='Introduce'">本所概况</li>
        <li class="title">首页</li>
        <li class="intent" onclick="window.location.href='DynamicNews'">动态新闻</li>
        <li class="intent" onclick="window.location.href='WaterSource'">源头活水</li>
        <li class="intent" onclick="window.location.href='RollImage'">底部滚动图</li>
        <li class="title">机构人员</li>
        <li class="intent" onclick="window.location.href='Worker'">在职人员</li>
        <li class="intent" onclick="window.location.href='Visitor'">访问学者</li>
        <li class="intent" onclick="window.location.href='Student'">本所学生</li>
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

        </table>
        <button class="new blueButton" onclick="editItem()">修改
        </button>
    </div>
</div>

<div class="editBody">
    <div class="editForm">
        <a class="closeButton" onclick="closeForm
        ()"><i class="fa fa-times" aria-hidden="true"></i></a>
        <div class="innerForm">
            <div class="buttons">
                <div class="textfield right" style="width: 98%;">
                    <select id="language" class="mycombox div-10">
                        <option>ch</option>
                        <option>eng</option>
                    </select>
                </div>
            </div>

            <div id="editDiv">
                <p>在此输入文章正文......</p>
            </div>

            <div class="buttons">
                <button class="submitButton right div-10" onclick="publish()">提交</button>
            </div>
        </div>
    </div>
</div>

<script src="js/backend.js"></script>
<script type="text/javascript" src="dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="dist/js/wangEditor.min.js"></script>
<script src="http://malsup.github.io/jquery.form.js"></script>
<script>
    var h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;   //height
    var language = "ch";

    //wangeditor声明
    var editor = new wangEditor('editDiv');
    editor.config.menuFixed = false;

    // 上传图片（举例）
    //    editor.config.uploadImgUrl = '../uploadImgUrl';

    editor.config.colors = {
        '#454546': '深灰'
    };

    editor.config.menus = $.map(wangEditor.config.menus, function (item, key) {
        if (item === 'fullscreen') {
            return null;
        }
        return item;
    });

    editor.create();

    //输入框高度设置
    if ($(".innerForm").find("#editDiv").length != 0) {
        $(".editForm").css({height: (h - 100)});
    }
    $("#editDiv").css({height: (h - 250)});

    //初始化数据
    var intro;

    $.ajax({
        type: "get",
        async: false,
        url: "situation/getHtml",
        data: {
            "language": "ch"
        },
        success: function (result) {
            intro = result;
            document.getElementsByClassName("list")[0].innerHTML = intro;
        },
        error: function () {
            alert("出故障了请稍候再试2");
        }
    });

    function changeLan(flag) {
        if (flag == 1) {
            language = "eng";
            document.getElementById("transfer").children[1].className = "ch_eng";
            document.getElementById("transfer").children[0].className = "ch_eng ch_eng_not";

            document.getElementsByClassName("list")[0].innerHTML = "";
            $.ajax({
                type: "get",
                async: false,
                url: "situation/getHtml",
                data: {
                    "language": "eng"
                },
                success: function (result) {
                    document.getElementsByClassName("list")[0].innerHTML = result;
                },
                error: function () {
                    alert("出故障了请稍候再试2");
                }
            });
        }else{
            language = "ch";
            document.getElementById("transfer").children[0].className = "ch_eng";
            document.getElementById("transfer").children[1].className = "ch_eng ch_eng_not";
            document.getElementsByClassName("list")[0].innerHTML = intro;
        }

    }

    function editItem() {
        $.ajax({
            type: "get",
            async: false,
            url: "situation/getHtml",
            data: {
                "language": language
            },
            success: function (result) {
                $("#language").val(language);
                editor.$txt.html(result);
            },
            error: function () {
                alert("出故障了请稍候再试2");
            }
        });

        $(".editBody").fadeIn(300);
    }

    function publish() {
        var html = editor.$txt.html();
        language = $("#language").val();
        alert(language);

        //提交editor内容
        $.ajax({
            type: "post",
            async: false,
            url: "situation/uploadHtml",
            data: {
                "html": html,
                "language": language
            },
            success: function (result) {
                if (result == "SUCCEED") {
                    window.location.reload();
                }
            },
            error: function () {
                alert("出故障了请稍候再试啊啊");
            }
        });
    }

    function showForm() {
        $(".editBody").fadeIn(300);
    }

    function closeForm() {
        $(".editBody").fadeOut(300);
    }

</script>
</body>
</html>


