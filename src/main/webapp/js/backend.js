/**
 * Created by marioquer on 2016/10/6.
 */


function logout() {
    $.ajax({
        type: "post",
        async: "false",
        url: "Logout",
        success: function (result) {
            if (result == "SUCCEED") {
                window.location.href = 'Login';
            }
        },
        error: function () {
            alert("登录失败，请重试~");
        }
    });
}