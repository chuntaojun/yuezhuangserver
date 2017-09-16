$(function () {
    feedbackformct()
    feedbackforusr()
})

function feedbackformct() {
    $('#feed-mct-table').bootstrapTable({
        classes: 'table table-hover',
        height: undefined,
        undefinedText: '-',
        sortName: undefined,
        sortOrder: 'asc',
        striped: false,
        columns: [{
            checkbox: true
        },{
            field: 'no',
            title: '编号',
        },{
            field: 'mctname',
            title: '商户名称',
        },{
            field: 'mctemail',
            title: '商户邮箱',
        },{
            field: 'quesname',
            title: '问题名称',
        },{
            field: 'questime',
            title: '反馈时间',
        },{
            field: 'solve',
            title: '解决疑问',
            editable: {
                type: 'text',
                title: '解决疑问',
                validate: function (v) {
                }
            }
        }],
        onEditableSave:function (field, row, oldValue, $el) {
            $.ajax({
                type: 'post',
                url: '/solve/issue/merchant?ID=' + row['no'],
                data: JSON.stringify(row),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.judge == true)
                        alert("ok");
                },
                compile: function () {
                }
            });
        },
        data: [],
        method: 'post',
        url: '/feed/merchant',
        cache: false,
        contentType: 'application/json',
        queryParams: function (params) {return params;},
        queryParamsType: 'limit', // undefined
        responseHandler: function (res) {return res;},
        pagination: true,
        sidePagination: 'client', // client or server
        totalRows: 0, // server side need to set
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 25, 50, 100],
        search: true,
        selectItemName: 'btSelectItem',
        showHeader: true,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        smartDisplay: false,
        minimumCountColumns: 1,
        idField: 'no',
        cardView: false,
        clickToSelect: false,
        singleSelect: false,
        toolbar: '#feed-mct',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,
    })
}

function feedbackforusr() {
    $('#feed-usr-table').bootstrapTable({
        classes: 'table table-hover',
        height: undefined,
        undefinedText: '-',
        sortName: undefined,
        sortOrder: 'asc',
        striped: false,
        columns: [{
            checkbox: true
        },{
            field: 'no',
            title: '编号',
        },{
            field: 'usrname',
            title: '用户名称',
        },{
            field: 'usraccount',
            title: '用户账户',
        },{
            field: 'quesname',
            title: '问题名称',
        },{
            field: 'questime',
            title: '反馈时间',
        },{
            field: 'solve',
            title: '解决疑问',
            editable: {
                type: 'text',
                title: '解决疑问',
                validate: function (v) {
                }
            }
        }],
        onEditableSave:function (field, row, oldValue, $el) {
            $.ajax({
                type: 'post',
                url: '/solve/issue/usr?ID=' + row['no'],
                data: JSON.stringify(row),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.judge == true)
                        alert("ok");
                },
                compile: function () {
                }
            });
        },
        data: [],
        method: 'post',
        url: '/feed/user',
        cache: false,
        contentType: 'application/json',
        queryParams: function (params) {return params;},
        queryParamsType: 'limit', // undefined
        responseHandler: function (res) {return res;},
        pagination: true,
        sidePagination: 'client', // client or server
        totalRows: 0, // server side need to set
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 25, 50, 100],
        search: true,
        selectItemName: 'btSelectItem',
        showHeader: true,
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        smartDisplay: false,
        minimumCountColumns: 1,
        idField: 'no',
        cardView: false,
        clickToSelect: false,
        singleSelect: false,
        toolbar: '#feed-usr',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,
    })
}