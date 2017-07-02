$(function () {
    $('#dg').datagrid({

        url: '/hongtu/v1/supplychain/bms/material/basUnits/list',
        method:'get',
        columns: [[
            {field: 'unitName', title: '单位名称'},
            {field: 'categoryname', title: '分类'},
            {field: 'accountname', title: '添加人'},
            {
                field: 'addTime', title: '添加时间', formatter: function (value, row, index) {
                return formatDate(value);
            }
            },
            {field: 'editaccountname', title: '修改人'},
            {field: 'editTime', title: '修改时间'},
            {
                field: 'isStorageUnit', title: '是否库存单位', formatter: function (value) {
                return value==0?'是':'否';
            }
            },
            // {field:'isDeleted',title:'是否删除'},
            {
                field: 'id', align: 'center', formatter: function (value, row, index) {
                return  "<a href='#' onclick=showDetail('" + value + "')>查看详情</a> &nbsp;&nbsp;<a href='#' onclick=modify('" + value + "')>编辑</a> &nbsp;&nbsp;<a href='#' onclick=deleteItem('" + value + "')>删除</a>";
            }, title: '操作',
            }
        ]],
        frozenColumns: [[
            {field: 'ck', checkbox: true}
        ]],
        toolbar: [          //顶部工具栏的DataGrid面板
            {
                text: '新增',      //文本名称
                iconCls: 'icon-add',    //增加图标
                handler: function () {     //点击按钮时触发一个事件
                    flag = 'add';
                    $('#addDialog').dialog({   //打开新增框
                        title: '新增分类'   //名称
                    });
                    // $("#parentId").combotree('reload');
                    //重置
                    $('#addForm').form('clear');
                    $("#addForm").get(0).reset();
                    $("#addDialog").dialog('open');
                }
            }, '-', {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    alert("删除！");
                    var deletedData = $('#dg').datagrid('getChecked');
                    for (var i = deletedData.length - 1; i >= 0; i--) {
                        var id = deletedData[i].id;
                        // $('#dg').datagrid('remove', id);
                        deleteItem(id);
                    }
                    // $('#dg').treegrid('reload');

                }
            }

        ],
        singleSelect: false,//是否单选
        pagination: true,
        fitColumns: false,
        striped: true,
        pagination: true,
//            rownumbers:true,
        pageNumber: 1,
        pageSize: 10,
        queryParams: {
            isStorageUnit: 2,
        }
        // onSelect: function (rowIndex, rowData) {
        //     showDetail(rowData.id);
        // },
    });
    //设置分页控件
    var p = $('#dg').datagrid('getPager');
    $(p).pagination({
        pageSize: 10,//每页显示的记录条数，默认为10
        pageList: [10, 15, 20],//可以设置每页记录条数的列表
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
    });


    //提交新增表单
    $("#confirm").click(function () {
        submitAddForm();
    });

    //提交修改表单
    $("#modifyConfirm").click(function () {
        submitModifyForm();
    });

    //新增框组合树
    $('#categoryId').combotree({
        // data: json,
        url: '/hongtu/v1/supplychain/bms/material/basSkuCategory/allGorys',
        required: true,
        valueField: 'id',
        textField: 'text',
        onBeforeSelect:function (node) {
            var rows = node.children;
            if(rows.length>0){
                $('#categoryId').treegrid("unselect");
            }
        }
    });

    //修改框组合树
    $('#modify-categoryId').combotree({
        // data: json,
        url: '/hongtu/v1/supplychain/bms/material/basSkuCategory/allGorys',
        required: true,
        valueField: 'id',
        textField: 'text',
        onBeforeSelect:function (node) {
            var rows = node.children;
            if(rows.length>0){
                $('#modify-categoryId').treegrid("unselect");
            }
        }
    });


});

//条件查询查询
function checkInputQuery() {

    var unitName=$('#unitName').val()
        var isStorageUnit=$('#isStorageUnit').val()
    console.log("unitName:" +unitName);
    console.log("isStorageUnit:" + isStorageUnit);
    if(isStorageUnit==""){
        $('#dg').datagrid('load', {
            unitName: unitName,
        });
    }else {
    $('#dg').datagrid('load', {
        unitName: unitName,
        isStorageUnit: isStorageUnit,

    });}
};
//格式化日期
function formatDate(val) {
    if(val==null){
        return;
    }
    var time = new Date(val);
    var y = time.getFullYear();//年
    var m = time.getMonth() + 1;//月
    var d = time.getDate();//日
    var h = time.getHours();//时
    var mm = time.getMinutes();//分
    var s = time.getSeconds();//秒
    return y + "-" + m + "-" + d + " " + h + ":" + mm + ":" + s;
}

//删除操作
function deleteItem(id) {

    $.ajax({
        url: '/hongtu/v1/supplychain/bms/material/basUnits/delete/' + id,
        type: 'PUT', //GET
        async: true,    //或false,是否异步
        data: {},
        timeout: 5000,    //超时时间
        contentType: "application/json",
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        beforeSend: function (xhr) {
            console.log(xhr)
            console.log('发送前')
        },
        success: function (data, textStatus, jqXHR) {
            // alert(data.code)
            // $('#dg').datagrid('deleteRow', id);
            $('#dg').datagrid('reload');
        },
        error: function (xhr, textStatus) {
            console.log('错误')
            console.log(xhr)
            console.log(textStatus)
        },
        complete: function () {
            console.log('结束')
        }


    })

}

/**
 * 修改弹出框
 */
function modify(index) {

    flag = 'modify';
    $('#modifyDialog').dialog({   //打开修改框
        title: '编辑单位信息'   //名称
    });
    //重置
    $('#modifyForm').form('clear');
    $("#modifyForm").get(0).reset();
    $("#modifyDialog").dialog('open');

    $.ajax({
        type: "GET",
        url: '/hongtu/v1/supplychain/bms/material/basUnits/detail/' + index,
        async: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        contentType: "application/json",
        error: function (request) {
            alert("请求失败！")
        },
        success: function (data) {
            var obj = data.data;
            $("#modifyDialog input[id=id]").val(obj.id);
            $("#modifyDialog input[id=unitName]").val(obj.unitName);
            // $("#modifyDialog input[id=categoryName]").val(obj.categoryname);
            $("#modifyDialog input[id=isStorageUnit]").val(obj.isStorageUnit);
            // obj.isStorageUnit==0? $("#modifyDialog select[id=y]").attr("selected","selected"):
            //     $("#modifyDialog select[id=n]").attr("selected","selected");
            $("#modifyDialog select[id=isStorageUnit]").combobox('setValue',obj.isStorageUnit);
            $("#modify-categoryId").combotree('setValue', obj.categoryId);
        }
    });
}
/**
 * 查看详情
 */
function showDetail(index) {

    $.ajax({
        type: "GET",
        url: '/hongtu/v1/supplychain/bms/material/basUnits/detail/' + index,
        async: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        contentType: "application/json",
        error: function (request) {
            alert("请求失败！")
        },
        success: function (data) {
            var obj = data.data;
            $("td[id=unitName]").html(obj.unitName);
            $("td[id=categoryName]").html(obj.categoryname);
            $("td[id=accountName]").html(obj.accountname);
            $("td[id=addTime]").html(formatDate(obj.addTime));
            $("td[id=editAccountName]").html(obj.editaccountname);
            $("td[id=editTime]").html(formatDate(obj.editTime));
            $("td[id=isStorageUnit]").html(obj.isStorageUnit==0?'是':'否');
        }
    });
}



function submitAddForm(){
    var formBeanJson = $('#addForm').serializeObject();
    $('#addForm').form('submit',{
        onSubmit:function(){
            var validateResult = $(this).form('enableValidation').form('validate');
            if(validateResult){
                $.ajax({
                    cache: true,
                    type: "POST",
                    url:"/hongtu/v1/supplychain/bms/material/basUnits/add",
//                        data:JSON.parse($('#add').serialize()),// 你的formid
                    contentType: "application/json",
                    dataType: "json",
                    data:JSON.stringify(formBeanJson),
                    error: function (xmlHttpRequest,errMsg,exception) {
                        $.messager.alert("提示消息",errMsg,"error")
                    },
                    success: function(data) {
                        if(data.code == 0) {
                            $.messager.show({
                                title:"提示消息",
                                msg:data.message,
                            });
                            $("#addDialog").dialog('close');//关闭修改框
                            $("#dg").datagrid('reload');
                            $('#addForm').form('clear');
                        }else{
                            alert(data.message+":"+data.data);
                        }
                    }
                });
            }else{
                $.messager.alert("提示信息", "请输入完整的信息！", "info");
            }
        }
    });
}


function submitModifyForm(){
    var formBeanJson = $('#modifyForm').serializeObject();
    $('#modifyForm').form('submit',{
        onSubmit:function(){
            var validateResult = $(this).form('enableValidation').form('validate');
            if(validateResult){
                $.ajax({
                    cache: true,
                    type: "put",
                    url:"/hongtu/v1/supplychain/bms/material/basUnits/update",
//                        data:JSON.parse($('#add').serialize()),// 你的formid
                    contentType: "application/json",
                    dataType: "json",
                    data:JSON.stringify(formBeanJson),
                    error: function (xmlHttpRequest,errMsg,exception) {
                        $.messager.alert("提示消息",errMsg,"error")
                    },
                    success: function(data) {
                        if(data.code == 0) {
                            $.messager.show({
                                title:"提示消息",
                                msg:data.message,
                            });
                            $("#modifyDialog").dialog('close');//关闭修改框
                            $("#dg").datagrid('reload');
                            $('#modifyForm').form('clear');
                        }else{
                            alert(data.message+":"+data.data);
                        }
                    }
                });
            }else{
                $.messager.alert("提示信息", "请输入完整的信息！", "info");
            }
        }
    });
}




$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
