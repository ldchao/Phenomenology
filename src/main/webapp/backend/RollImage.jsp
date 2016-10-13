<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>南京大学现象学研究所</title>
    <link href="css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="css/backend.css">
    <link href="css/cssreset.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="log" onclick="logout()">登出</div>
<header>你好！
</header>

<div class="left_block">
    <ul>
        <li class="intent" onclick="window.location.href='Introduce'">本所概况</li>
        <li class="title">首页</li>
        <li class="intent" onclick="window.location.href='DynamicNews'">动态新闻</li>
        <li class="intent" onclick="window.location.href='WaterSource'">源头活水</li>
        <li class="intent active" onclick="window.location.href='RollImage'">底部滚动图</li>
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
            <tr class="none" id="listRow" style="height: 100px;">
                <td class="td1">1</td>
                <td class="td5"><img class="headImage" style="width: 80px;height: 80px;"></td>
                <td class="td4"></td>
                <td class="td3">
                    <%--<a onclick="editItem(this)"><i class="fa fa-pencil" aria-hidden="true"></i></a>--%>
                    <a onclick="deleteItem(this)"><i class="fa fa-trash" aria-hidden="true"></i></a>
                </td>
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
            <div class="buttons">
                <input id="name" type="text" class="textfield left div-10" placeholder="引用链接">
            </div>

            <div class="buttons">
                <form action="/CarouselFigure/upload.action" method="post" enctype="multipart/form-data"
                      onsubmit="return false;">
                    <a class="chooseFile left div-5">
                        <input style="opacity: 0;" type="file" name="carouselFigure" id="carouselFigure"/>点击这里上传缩略图
                    </a>
                    <button class="submitButton right div-5" onclick="publish()">提交</button>

                </form>
            </div>
        </div>
    </div>
</div>

<script src="js/backend.js"></script>
<script type="text/javascript" src="dist/js/lib/jquery-1.10.2.min.js"></script>
<script src="http://malsup.github.io/jquery.form.js"></script>

<script>
    var id;
    var isEdit = 0;

    var h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;   //height

    //输入框高度设置
    if ($(".innerForm").find("#editDiv").length != 0) {
        $(".editForm").css({height: (h - 100)});
    }
    $("#editDiv").css({height: (h - 250)});

    //初始化数据
    var list;
    var tableHtml = document.getElementById("listRow").innerHTML;

    $.ajax({
        type: "get",
        async: false,
        url: "homepage/CarouselFigure/getAll",
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                var tr = document.createElement("tr");
                tr.innerHTML = tableHtml;
                tr.children[0].innerHTML = result[i].id;
                tr.children[1].children[0].src = result[i].location;
                tr.children[2].innerHTML = result[i].url;
                document.getElementsByClassName("list")[0].appendChild(tr);
            }
            list = document.getElementsByClassName("list")[0].innerHTML;
        },
        error: function () {
            alert("出故障了请稍候再试0");
        }
    });

    function editItem(ele) {
        isEdit = 1;
        var id = ele.parentNode.parentNode.getElementsByClassName("td1")[0].innerHTML;

        $.ajax({
            type: "get",
            async: false,
            url: "homepage/CarouselFigure/getOne",
            data: {
                "id": id
            },
            success: function (result) {
                $("input[id='name']").val(result.url);
                $(".submitButton").html("提交修改");
                $(".editBody").fadeIn(300);
            },
            error: function () {
                alert("出故障了请稍候再试2");
            }
        });
    }

    function deleteItem(ele) {
        var id = ele.parentNode.parentNode.getElementsByClassName("td1")[0].innerHTML;
        $.ajax({
            type: "post",
            async: false,
            url: "homepage/CarouselFigure/delete",
            data: {
                "id": id
            },
            success: function (result) {
                if (result == "SUCCEED") {
                    window.location.reload();
                }
            },
            error: function () {
                alert("服务器出问题了，删除失败");
            }
        });
    }



    function publish() {
        var carouselFigure = $("#carouselFigure").val();
        var url = $("input[id='name']").val();


        //提交附件
        if (carouselFigure != "") {
            $('form').ajaxSubmit({
                type: "post",
                async: false,
                data: {
                    "carouselFigure": carouselFigure,
                    "url": url
                },
                url: "homepage/CarouselFigure/upload",
                success: function (result) {
                    alert(result);
                    window.location.reload();
                },
                error: function () {
                    alert("出故障了请稍候再试1");
                }
            });
        } else {
            alert("请选择缩略图再提交");
        }

    }


    function showForm() {
        $(".submitButton").html("提交");
        $(".editBody").fadeIn(300);
    }

    function closeForm() {
        if (isEdit == 1) {
            $("input[id='name']").val("");
            $("#coverImg").val("");
            isEdit = 0;
        }
        $(".editBody").fadeOut(300);
    }

</script>
</body>
</html>


