/**
 * Created by marioquer on 2016/10/13.
 */


$('#key').bind('keyup', function(event) {
    if (event.keyCode == "13") {
        //回车执行查询
        $('.loginButton').click();
    }
});

function login() {
    var name = $("input[id='userName']").val();
    var password = $("input[id='key']").val();
    if (name == "" || password == "") {
        alert("用户名或密码未填写完成");
    }



    $.ajax({
        type: "post",
        async: "false",
        data: {
            "name": name,
            "password": password
        },
        url: "Login",
        success: function (result) {
            if (result == "SUCCEED") {
                window.location.href = 'Introduce';
            }
        },
        error: function () {
            alert("登录失败，请重试~");
        }
    });
}

