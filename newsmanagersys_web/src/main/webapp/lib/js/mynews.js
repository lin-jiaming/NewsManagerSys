
/*
 *用户详细信息
 */
//图像预览
$(function() {
    $(".pic").click(function () {
        $(".uimg").click(); //隐藏了input:file样式后，点击头像就可以本地上传
        $(".uimg").on("change",function(){
            var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
            if (objUrl) {
                $(".pic").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
            }
        });
    });
});

//建立一個可存取到該file的url
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}

//验证用户密码的方法
function updateUserPwd(){
    var oldPwd=document.forms[0].oldPwd;
    if(oldPwd.value.length==0){
        alert("旧密码不能为空");
        name.focus();
        return false;
    }
    var newPwd=document.forms[0].upwd.value;
    var patrn=/^(\w){6,10}$/;
    if(newPwd.length==0){
        alert("新密码不能为空!");
        name.focus();
        return false;
    }
    if(!patrn.exec(newPwd)){
        alert("密码格式不正确!");
        name.focus();
        return false;
    }
    var newPwd1=document.forms[0].newPwd.value;
    if(newPwd1!=newPwd){
        alert("密码不一致！");
        name.focus();
        return false;
    }
}
/**
 * 新闻信息
 */
//图像预览
$(function() {
    $(".pic").click(function () {
        $(".nimg").click(); //隐藏了input:file样式后，点击头像就可以本地上传
        $(".nimg").on("change",function(){
            var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
            if (objUrl) {
                $(".pic").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
            }
        });
    });
});

//建立一個可存取到該file的url
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}

//分页查询之下一页
function doPage(num){
    $("input[name='cpage']").val(num);
    $("#seachFrm")[0].submit();
}

//定时关闭成功弹出框
setTimeout(function(){
    setTimeout(function(){
        $('#success').hide(); //将成功操作的弹出框隐藏。
    }, 1000);
}, 1000);

//定时关闭成功弹出框
setTimeout(function(){
    setTimeout(function(){
        $('#danger').hide(); //将失败操作的弹出框隐藏。
    }, 1000);
}, 1000);