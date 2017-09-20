$(function () {
    feedbackformct();
    feedbackforusr();
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
            field: 'issuetype',
            title: '分类'
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
            formatter:function(value,row,index){
                document.getElementById("mctemail").value = row['mctemail'];
                document.getElementById("account").value = row['mctname'];
                document.getElementById("quesname").value = row['quesname'];
                $("#form_data").attr('action', "/admin/feed/solve/merchant?ID=" + row['no']);
                return '<button class="btn btn-default issue" data-toggle="modal" data-target="#issueModal">反馈</button> ';
            }
        }],
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
            field: 'issuetype',
            title: '分类'
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
            formatter:function (value, row, index) {
                document.getElementById("mctemail").value = row['useraccount'];
                document.getElementById("account").value = row['username'];
                document.getElementById("quesname").value = row['quesname'];
                $("#form_data").attr('action', "/admin/feed/solve/user?ID=" + row['no']);
                return '<button class="btn btn-default issue" data-toggle="modal" data-target="#issueModal">反馈</button> ';
            }
        }],
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


function IssueSolve() {
    $("#form_data").ajaxSubmit(function (message) {
        if (message == false)
            alert("回复反馈失败，请与后台人员联系")
        else
            alert("回复反馈成功，已发送通知给改商户")
    })
}