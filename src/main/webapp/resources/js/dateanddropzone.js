! function($) {
    $(document).on("click", "ul.nav li.parent > a > span.icon", function() {
        $(this).find('em:first').toggleClass("glyphicon-minus");
    });
    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
}(window.jQuery);

$(window).on('resize', function() {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
})
$(window).on('resize', function() {
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
})

Dropzone.options.dropzone = {
    url: "/user/upload/ProductPicture",
    method:'post',
    addRemoveLinks: true,
    autoProcessQueue: false,
    uploadMultiple: true,
    maxFilesize: 10.0,
    maxFiles: 10,
    acceptedFiles: '.jpg,.jpeg,.png',
    dictRemoveFile: "删除",
    dictInvalidFileType:"无效文件",
    dictCancelUpload:"取消上传",
    init: function () {
        var submitButton = document.querySelector("#submit-all")
        dropzone = this;
        submitButton.addEventListener("click", function () {
            dropzone.on("processing", function(file) {
                this.options.url += "?brdname=" + $("#brd").val() + "&prdname=" + $("#prd").val();
            })
            dropzone.processQueue();
        });
        this.on("addedfile", function () {
            $("#submit-all").removeAttr("disabled");
        });
        this.on("complete", function (data) {
            if (this.getUploadingFiles().length === 0 && this.getQueuedFiles().length === 0) {
                var msg;
                if (data.errormsg) {
                    msg = "恭喜，已成功上传张照片！";
                }
                else {
                    msg = data.errormsg;
                }
                $("#message").text(msg);
                $("#dialog").dialog("open");
            }
        });
        this.on("removedfile", function () {
            if (this.getAcceptedFiles().length === 0) {
                $("#submit-all").attr("disabled", true);
            }
        });
    }
};
