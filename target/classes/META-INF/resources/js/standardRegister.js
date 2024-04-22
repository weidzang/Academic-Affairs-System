window.onload = function () {
    //显示用户不存在或密码不正确
    var state = '<%=request.getAttribute("state")%>';
    if(state=='success'){
        alert("注册成功！");
    }
    else if(state=='error'){
        alert("注册失败，账号已有，请更换账号注册")
    }

}
function $(id){
    return document.getElementById(id);
}
function test(){
    var user_name = $("user_name").value;
    var password = $("password").value;
    var re_password = $("re_password").value;
    if(user_name.length==0){
        $("msg").innerHTML = "用户名不能为空！";
        $("user_name").focus();
        return false;
    }
    if(user_name.length>12){
        $("msg").innerHTML = "用户名不能超过12个字符！";
        $("user_name").focus();
        return false;
    }

    if(password.length==0){
        $("msg").innerHTML = "密码不能为空！";
        $("password").focus();
        return false;
    }
    if(password.length>15){
        $("msg").innerHTML = "密码不能超过15个字符！";
        $("password").focus();
        return false;
    }

    if(password!=re_password ){
        $("msg").innerHTML="错误！密码不一致！";
        $("re_password").focus();
        return false;
    }
    console.log("注册成功！");
    return true;
}