$(function () {
    // 管理员管理商家表格
    initTableforAdminSeller();
    // 管理员管理商品表格
    initTableforAdminProduct();
    // 管理员管理品牌表格
    initTableforAdminBrand();
    // 管理员管理帖子表格
    initTableforAdminPost();
    // 管理员管理用户账户表格
    initTableforAdminUser();

    // 商家管理商品表格
    initTableforSellerProduct();
    intiTableforSellerBrand();
})

// 管理员管理商家信息表格
function initTableforAdminSeller() {
    $('#seller_contro').bootstrapTable({
        classes: 'table table-hover',
        height: undefined,
        undefinedText: '-',
        sortName: undefined,
        sortOrder: 'asc',
        striped: false,
        editable: true,
        columns: [{
            checkbox: true
        },{
            field: 'no',
            title: '编号',
        },{
            field: 'mctaccount',
            title: '商家名称',
        },{
            field: 'time',
            title: '商家创建时间',
        }, {
            field: 'mctstate',
            title: '商家权限',
            editable: {
                type: 'select',
                title: '商家权限',
                pk: 1,
                source:[
                    {value:"1", text:"可登陆"}, {value:"0", text:"待审核"}, {value:"-1", text:"被禁止"}
                ],
                noeditFormatter: function (value,row,index) {
                    var result={filed:"mctstate",value:value,class:"badge",style:"background:#333;padding:5px 10px;"};
                    return result;
                }
            }
        }],
        data: [],
        method: 'post',
        url: '/reportSellerInfo',
        cache: true,
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
        showColumns: false,
        showRefresh: true,
        showToggle: true,
        smartDisplay: false,
        minimumCountColumns: 1,
        uniqued: 'no',
        idField: 'no',
        cardView: false,
        clickToSelect: false,
        singleSelect: false,
        toolbar: '#toolbar',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,

        onEditableSave:function (field, row, oldValue, $el) {
            $.ajax({
                type: 'post',
                url: '/editforMerchant?ID=' + row['no'],
                data: JSON.stringify(row),
                dataType: 'JSON',
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (!data.judge)
                        alert("修改失败,请联系后台人员")
                    if (data.judge)
                        alert("更改成功")
                }
            });
        }
    })
}

// 管理员管理商品信息表格
function initTableforAdminProduct() {
    $('#proTable').bootstrapTable({
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
            field: 'brdname',
            title: '品牌名称',
        },{
            field: 'prdname',
            title: '化妆品名称',
            editable: {
                type: 'text',
                title: '化妆品名称',
                validate: function (v) {
                    if (!v) return '化妆品名称不能为空';
                }
            }
        },{
            field: 'prdcode',
            title: '一维码',
        },{
            field: 'prdpic',
            title: '化妆品图片',
        },{
            field: 'prdprice',
            title: '化妆品价格',
            editable: {
                type: 'text',
                title: '化妆品价格',
                validate: function (v) {
                    if (v <= 0) return '化妆品价格必须为非负数';
                }
            }
        },{
            field: 'prdcapacity',
            title: '容量',
            editable: {
                type: 'text',
                title: '容量',
                validate: function (v) {
                    if (v <= 0) return '容量必须为非负数';
                }
            }

        },{
            field: 'prdintro',
            title: '化妆品简介',
            editable: {
                type: 'text',
                title: '化妆品简介',
                validate: function (v) {
                    if (!v) return '化妆品简介不能为空';
                }
            }
        }],
        onEditableSave:function (field, row, oldValue, $el) {
            $.ajax({
                type: 'post',
                url: '/editforProduct?ID=' + row['no'],
                data: JSON.stringify(row),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.judge == true)
                        alert("修改成功");
                },
                compile: function () {
                }
            });
        },
        data: [],
        method: 'post',
        url: '/reportProductInfo',
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
        toolbar: '#toolbar_prd',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,
    })
}

// 管理员管理品牌信息表格
function initTableforAdminBrand() {
    $('#brdTable').bootstrapTable({
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
            field: 'brdname',
            title: '品牌名称',
            editable: {
                type: 'text',
                title: '品牌名称',
                validate: function (v) {
                    if (!v) return '品牌名称不能为空';
                }
            }
        },{
            field: 'brdintro',
            title: '品牌简介',
            editable: {
                type: 'text',
                title: '品牌简介',
                validate: function (v) {
                    if (!v) return '品牌简介不能为空';
                }
            }
        },{
            field: 'brdlogi',
            title: '品牌logo',
        }],
        onEditableSave:function (field, row, oldValue, $el) {
            $.ajax({
                type: 'post',
                url: '/editforBrand?ID=' + row['no'],
                data: JSON.stringify(row),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.judge == true)
                        alert("修改成功");
                },
                compile: function () {
                }
            });
        },
        data: [],
        method: 'post',
        url: '/reportBrandInfo',
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
        toolbar: '#toolbar_brd',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,
    })
}

// 管理员管理发帖信息表格
function initTableforAdminPost() {
    $('#postTable').bootstrapTable({
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
            field: 'postitle',
            title: '帖子标题',
        },{
            field: 'postmain',
            title: '帖子内容',
        },{
            field: 'posttime',
            title: '帖子发布时间',
        }],
        data: [],
        method: 'post',
        url: '',
        cache: false,
        contentType: 'application/json',
        queryParams: function (params) {
            return params;
        },
        queryParamsType: 'limit', // undefined
        responseHandler: function (res) {
            return res;
        },
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
        toolbar: '#toolbar_post',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,
    })
}

// 管理员管理用户账户状态表格
function initTableforAdminUser() {
    $('#userTable').bootstrapTable({
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
            title: '用户名',
        },{
            field: 'usrimage',
            title: '用户头像',
        },{
            field: 'usrintro',
            title: '用户介绍',
        },{
            field: 'usrstatus',
            title: '用户账户状态',
            editable: {
                type: 'select',
                title: '用户账户状态',
                pk: 1,
                source:[
                    {value:"1", text:"可登陆"}, {value:"-1", text:"被禁止"}
                ],
                noeditFormatter: function (value,row,index) {
                    var result={filed:"usrstatus",value:value,class:"badge",style:"background:#333;padding:5px 10px;"};
                    return result;
                }
            }
        }],
        onEditableSave:function (field, row, oldValue, $el) {
            $.ajax({
                type: 'post',
                url: '/editforUser?ID=' + row['no'],
                data: JSON.stringify(row),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.judge == true)
                        alert("修改成功");
                },
                compile: function () {
                }
            });
        },
        data: [],
        method: 'post',
        url: '',
        cache: false,
        contentType: 'application/json',
        queryParams: function (params) {
            return params;
        },
        queryParamsType: 'limit', // undefined
        responseHandler: function (res) {
            return res;
        },
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
        toolbar: '#toolbar_user',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,
    })
}

// 商家管理商品信息（表格不能编辑商品信息，只能从上传商品信息页面进行更改）
function initTableforSellerProduct() {
    $('#sellerTable').bootstrapTable({
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
            field: 'prdname',
            title: '商品名称',
        },{
            field: 'brdname',
            title: '商品品牌',
        },{
            field: 'prdcode',
            title: '商品一维码',
        },{
            field: 'prdpic',
            title: '商品图片',
        },{
            field: 'prdintro',
            title: '商品介绍',
        },{
            field: 'prdcapacity',
            title: '容量',
        },{
            field: 'prdprice',
            title: '商品价格',
        }],
        data: [],
        method: 'post',
        url: '/reportProductInfo',
        cache: false,
        contentType: 'application/json',
        queryParams: function (params) {
            return params;
        },
        queryParamsType: 'limit', // undefined
        responseHandler: function (res) {
            return res;
        },
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
        toolbar: '#toolbar',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,
    })
}

function intiTableforSellerBrand() {
    $('#mctbrdTable').bootstrapTable({
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
            field: 'brdname',
            title: '品牌名称',
            editable: {
                type: 'text',
                title: '品牌名称',
                validate: function (v) {
                    if (!v) return '品牌名称不能为空';
                }
            }
        },{
            field: 'brdintro',
            title: '品牌简介',
            editable: {
                type: 'text',
                title: '品牌简介',
                validate: function (v) {
                    if (!v) return '品牌简介不能为空';
                }
            }
        },{
            field: 'brdlogi',
            title: '品牌logo',
        }],
        onEditableSave:function (field, row, oldValue, $el) {
            $.ajax({
                type: 'post',
                url: '/editforBrand?ID=' + row['no'],
                data: JSON.stringify(row),
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.judge == true)
                        alert("修改成功");
                },
                compile: function () {
                }
            });
        },
        data: [],
        method: 'post',
        url: '/reportBrandInfo',
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
        toolbar: '#toolbar_brd',
        checkboxHeader: true,
        sortable: true,
        maintainSelected: false,
    })
}

/**
 * bootstrtapable 删除选中行操作
 * @param tableId
 * @param requestUrl
 */
deleInfo = function (tableId, requestUrl) {
    deleteItem(tableId, true, requestUrl);
}

function deleteItem($table, reLoad, requestUrl){
    var data = new Array();
    var selRow = $table.bootstrapTable('getAllSelections');
    for (i in selRow){
        var o = selRow[i];
        data.push(o['no']);
    }
    if(selRow!=null){
        if (confirm("确定此不可逆的删除操作吗")){
            $.ajax({
                type: "post",
                cache:false,
                async : true,
                dataType : "json",
                url: requestUrl,
                data: {"no": data},
                traditional: true,
                success: function(data){
                    if(reLoad){
                        $table.bootstrapTable('refresh');
                    }
                }
            });
        }
    }else{
        alert('请选取要删除的数据行！');
    }
}