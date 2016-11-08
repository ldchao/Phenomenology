<%--
  Created by IntelliJ IDEA.
  User: marioquer
  Date: 2016/10/12
  Time: 下午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>南京大学现象学研究所</title>
    <link href="css/cssreset.css" rel="stylesheet">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/backLogin.css">
</head>

<body>


<div class="outerBlock">
    <div class="innerBlock">
        <p>后台登录</p>
        <input type="text" id="userName" placeholder="用户名">
        <input type="password" id="key" placeholder="密码" onkeydown="enter(event);">
        <div class="buttons">
            <div id="login" class="loginButton" onclick="login()">登录</div>
            <%--<div class="logupButton" onclick="logup()">注册</div>--%>
        </div>
        <a href="javascript:alert('请联系开发人员');">忘记密码？</a>
    </div>
</div>


<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login.js"></script>

</body>
</html>
