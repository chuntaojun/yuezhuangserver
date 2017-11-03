function $getId(name) {
    return document.getElementById(name)
}

function check_user_email() {
    var res=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
    var email = $("#username").val()
    if (email == "")
        $getId("email_error").innerHTML = "记得填写邮箱信息";
    else if (!res.test(email))
        document.getElementById("email_error").innerHTML = "邮箱格式错误，请重新检查";
}

function check_user_name() {
    var reg = /^[\u4e00-\u9fa5]/
    var name = $("#username").val()
    if (!reg.test(name))
        $getId("user_error").innerHTML = "商家店名请输入中文名称"
    else
        $getId("user_error").innerHTML = "";
}

function check_user_password() {
    var reg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$/
    var password = $("#userpassword").val()
    if (password == "")
        $getId("password_error").innerHTML = "记得输入密码哦"
    else if (!reg.test(password))
        $getId("password_error").innerHTML = "密码强度有点弱哦"
    else
        $getId("password_error").innerHTML = "";
}

function check_user_account() {
    var reg = /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/
    var account = $("#useraccount").val()
    if (account == "")
        $getId("account_error").innerHTML = "记得填写账户名称"
    else if (!reg.test(account))
        $("#account_error").innerHTML = "账户格式错误，必须以字母开头"
    else
        $getId("account_error").innerHTML = "";
}

function check_user_password_again() {
    var password = $("#userpassword").val()
    var password_again = $("#userpassword-again").val()
    if (password !== password_again)
        $getId("password_error_again").innerHTML = "两次密码输入不一致"
    else
        $getId("password_error_again").innerHTML = "";
}