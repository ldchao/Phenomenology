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
<div class="log" onclick="logout()">登出</div>
<header>你好！
</header>

<div id="transfer" style="position:absolute;left: 20px;top:0px;">
    <div class="ch_eng" onclick="changeLan(0)" style="left: 0px;">中文</div>
    <div class="ch_eng ch_eng_not" style="width: 60px; left: 45px;" onclick="changeLan(1)">English</div>
</div>


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
        <li class="intent active" onclick="window.location.href='Book'">书籍出版</li>
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
                <td class="td3"><a onclick="editItem(this)"><i class="fa fa-pencil" aria-hidden="true"></i></a>
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
                <input id="name" type="text" class="textfield left div-7" placeholder="书名">
                <div class="textfield right div-3">
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
                <form id="image" action="/uploadCover.action" method="post" enctype="multipart/form-data"
                      onsubmit="return false;">
                    <a class="chooseFile left div-10">
                        <input style="opacity: 0;" type="file" name="coverImg" id="coverImg"/>点击这里上传头像
                    </a>
                </form>
            </div>

            <div class="buttons">
                <form id="acce" action="/uploadSaAccessory.action" method="post" enctype="multipart/form-data"
                      onsubmit="return false;">
                    <a class="chooseFile left div-5">
                        <input style="opacity: 0;" type="file" name="accessory" id="accessory"/>点击这里上传附件(可选)
                    </a>
                    <button class="submitButton right div-5" onclick="publish()">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="js/backend.js"></script>
<script type="text/javascript" src="dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="dist/js/wangEditor.min.js"></script>
<script src="http://malsup.github.io/jquery.form.js"></script>

<script>
    var id;
    var isEdit = 0;

    var h = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;   //height
    var language = "ch";

    //wangeditor声明
    var editor = new wangEditor('editDiv');
    editor.config.menuFixed = false;

    // 上传图片（举例）
    editor.config.uploadImgUrl = 'uploadImgUrl';

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
    $("#editDiv").css({height: (h - 286)});

    //初始化数据
    var list;
    var tableHtml = document.getElementById("listRow").innerHTML;

    $.ajax({
        type: "get",
        async: false,
        url: "achievement/book/get",
        data: {
            "language": language
        },
        success: function (result) {
            for (var i = 0; i < result.length; i++) {
                var tr = document.createElement("tr");
                tr.innerHTML = tableHtml;
                tr.children[0].innerHTML = result[i].id;
                tr.children[1].children[0].src = result[i].thumbnailLocation;
                tr.children[2].innerHTML = result[i].title;
                document.getElementsByClassName("list")[0].appendChild(tr);
            }
            list = document.getElementsByClassName("list")[0].innerHTML;
        },
        error: function () {
            alert("出故障了请稍候再试0");
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
                url: "achievement/book/get",
                data: {
                    "language": language
                },
                success: function (result) {
                    for (var i = 0; i < result.length; i++) {
                        var tr = document.createElement("tr");
                        tr.innerHTML = tableHtml;
                        tr.children[0].innerHTML = result[i].id;
                        tr.children[1].children[0].src = result[i].thumbnailLocation;
                        tr.children[2].innerHTML = result[i].title;
                        document.getElementsByClassName("list")[0].appendChild(tr);
                    }
                },
                error: function () {
                    alert("出故障了请稍候再试0");
                }
            });


        } else {
            language = "ch";
            document.getElementById("transfer").children[0].className = "ch_eng";
            document.getElementById("transfer").children[1].className = "ch_eng ch_eng_not";
            document.getElementsByClassName("list")[0].innerHTML = list;
        }

    }

    function editItem(ele) {
        isEdit = 1;
        var id = ele.parentNode.parentNode.getElementsByClassName("td1")[0].innerHTML;

        $.ajax({
            type: "get",
            async: false,
            url: "achievement/book/getOne",
            data: {
                "id": id
            },
            success: function (result) {
                $("input[id='name']").val(result.title);
                $("#language").val(result.language);

                //填充editor
                $.ajax({
                    type: "get",
                    async: false,
                    url: "getHtml",
                    data: {
                        "filename": result.descriptionLocation,
                    },
                    success: function (html) {
                        editor.$txt.html(html);
                    },
                    error: function () {
                        alert("获取正文失败");
                    }
                });

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
            url: "achievement/book/delete",
            data: {
                "id": id
            },
            success: function (result) {
                if (result == "SUCCEED") {
                    alert("删除成功！");
                    window.location.reload();
                }
            },
            error: function () {
                alert("服务器出问题了，删除失败");
            }
        });
    }

    function publish() {
        var html = editor.$txt.html();
        var accessory = $("#accessory").val();
        var coverImg = $("#coverImg").val();
        var name = $("input[id='name']").val();
        language = $("#language").val();
        var htmlPath;

        //提交editor内容
        $.ajax({
            type: "post",
            async: false,
            url: "uploadHtml",
            data: {
                "html": html
            },
            success: function (result) {
                htmlPath = result;

            },
            error: function () {
                alert("出故障了请稍候再试2");
            }
        });


        //提交附件
        if (coverImg != "") {
            $('#image').ajaxSubmit({
                type: "post",
                async: false,
                data: {
                    "coverImg": coverImg
                },
                url: "uploadCover",
                success: function (result) {

                    //提交附件
                    if (accessory != "") {
                        $('#acce').ajaxSubmit({
                            type: "post",
                            async: false,
                            data: {
                                "accessory": accessory,
                                "id": id
                            },
                            url: "uploadSaAccessory",
                            success: function (para) {
                                //提交表单其余内容
                                $.ajax({
                                    type: "post",
                                    async: false,
                                    url: "achievement/book/update",
                                    data: {
                                        "id": id,
                                        "title": name,
                                        "thumbnailLocation": result,
                                        "descriptionLocation": htmlPath,
                                        "language": language
                                    },
                                    success: function (flag) {
                                        if (flag == "SUCCEED") {
                                            window.location.reload();
                                        } else {
                                            alert("抱歉提交失败啦");
                                        }
                                    },
                                    error: function () {
                                        alert("表单提交失败");
                                    }
                                });
                            },
                            error: function () {
                                alert("提交附件失败");
                            }
                        });
                    } else {
                        window.location.reload();
                    }
                },
                error: function () {
                    alert("图片上传失败");
                }
            });
        } else {
            alert("请选择缩略图再提交");
        }

    }


    function showForm() {


        $.ajax({
            type: "post",
            async: false,
            url: "achievement/book/getID",
            success: function (result) {
                id = result;
            },
            error: function () {
                alert("出故障了请稍候再试4");
            }
        });


        $(".submitButton").html("提交");
        $("#language").val(language);
        $(".editBody").fadeIn(300);
    }

    function closeForm() {
        if (isEdit == 1) {
            $("input[id='name']").val("");
            $("#language").val("ch");
            editor.$txt.html("");
            $("#coverImg").val("");
            isEdit = 0;
        }
        $(".editBody").fadeOut(300);
    }

</script>
</body>
</html>


