function disabledjump() {
    $('#disabledjump').submit();
    return false;
}

function todaytrySubmit() {
    $("#todayTry").ajaxSubmit(function (message) {
        if (message == true)
            alert("发布成功");
        else
            alert("发布失败,请后台人员联系");
    });
    return false;
}

function noticeSubmit() {
    $("#notice").ajaxSubmit(function (message) {
        if (message == true)
            alert("发布成功");
        else
            alert("发布失败,请后台人员联系");
    });
    return false;
}

function SubmitType(type) {

    var canSubmit = true;
    //上传商品信息到后台先行校验

    if (isNaN($("#prdprice").val()) && isNaN($("#prdcode").val())
        && isNaN($("#prdcapacity").val())) {
        alert("请重新确认商品价格或者一维码或者容量为数字");
        canSubmit = false;
    }

    if (type){
        document.getElementById("submittype").value = "upload";
    }
    else if (!type){
        document.getElementById("submittype").value = "update";
    }

    if (canSubmit) {
        $("#disabledjump").ajaxSubmit(function (message) {
            //do nothing
        });
    }
}

/**
 * 商家上传视频文件表单与用于上传的视频文件格式验证
 * @returns {boolean}
 */
function vid_submit() {
    var file = document.getElementById("prdvideo").files[0];
    if (file == null || file == ""){
        alert("您还未上传相关视频文件");
        return false;
    }
    var filename = file.name;
    if (FileVerification(filename)) {
        $('#vid_form').ajaxSubmit(function (message) {
        });
        return false;
    }
    else {
        alert("视频文件格式不是 .mp4/.flv/ .avi中的一种");
        return false;
    }
}

function FileVerification(filename) {
    var position = filename.lastIndexOf(".");
    var format = filename.substring(position + 1, filename.length);
    if (format == "mp4" || format == "flv" ||format == "aiv")
        return true;
    return false;
}