<%--
  Created by IntelliJ IDEA.
  User: lvdechao
  Date: 2016/9/22
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--引入wangEditor.css-->
    <link rel="stylesheet" type="text/css" href="../dist/css/wangEditor.min.css">
</head>
<body>
<!--用父容器来控制宽度-->
<div style="width:90%">
    <!--用当前元素来控制高度-->
    <div id="div1" style="height:400px;max-height:500px;">
        <p>请输入内容...</p>
    </div>
</div>
<button id="btn1">提交</button>
<button id="btn2">获取</button>



<!--引入jquery和wangEditor.js-->   <!--注意：javascript必须放在body最后，否则可能会出现问题-->
<script type="text/javascript" src="../dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../dist/js/wangEditor.min.js"></script>
<!--这里引用jquery和wangEditor.js-->
<script type="text/javascript">
    var editor = new wangEditor('div1');

    // 上传图片（举例）
    editor.config.uploadImgUrl = '../uploadImgUrl';

    editor.create();
//*********************************************************************************
    $('#btn1').click(function () {
        // 获取编辑器区域完整html代码
//        var html = editor.$txt.html();
//
//        // 获取编辑器纯文本内容
//        var text = editor.$txt.text();
//
//        // 获取格式化后的纯文本
//        var formatText = editor.$txt.formatText();

        $.ajax({
            type: "post",
            async: false,
            url: "../test",
        });
    });

//***********************************************************************************
//    $('#btn1').click(function () {
//        editor.$txt.append('<p>新追加的内容</p>');
//    });

//***********************************************************************************
    $('#btn2').click(function () {
        // 清空内容。
        // 不能传入空字符串，而必须传入如下参数

        $.ajax({
            type: "get",
            async: false,
            url: "../situation/getHtml",
            data:{"language":"ch"},
            dataType:'html',
            success: function (result) {
                var text=result;
                editor.$txt.html(text);
            },
            error: function () {
                alert("出故障了请稍候再试");
            }
        });
//
    });
</script>
</body>
</html>
