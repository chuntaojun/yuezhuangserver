$(function () {
    $.ajax({
        url: '/search/brdName',
        type: 'post',
        cache: true,
        contentType: 'application/json',
        dataType: 'json',
        success: function (datas) {
            $("#brdname").autocomplete({
                source: datas.brdName
            })
        }
    })
})

$(function () {
    $.ajax({
        url: '/search/prdName',
        type: 'post',
        cache: true,
        contentType: 'application/json',
        dataType: 'json',
        success: function (datas) {
            $("#prdname").autocomplete({
                source: datas.prdName
            })
        }
    })
})