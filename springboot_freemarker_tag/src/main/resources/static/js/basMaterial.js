$(function () {
    $('#dg').datagrid({
        url: '/hongtu/v1/supplychain/bms/material/basInfo/list',
        title: '物料基础信息',
        method:'get',
        columns: [[
            {field: 'materialCode', title: '物料编码'},
            {field: 'materialName', title: '物料名称'},
            {field: 'industryType', title: '行业类型'},
            {
                field: 'isSystem', title: '是否系统数据', formatter: function (value) {
                    return value==0?'是':'否';
            }
            },
            {
                field: 'isEnabled', title: '是否启用', formatter: function (value) {
                return value==0?'是':'否';
            }
            },
            {field: 'addAccountName', title: '添加用户名'},
            {field: 'addDepartName', title: '添加部门'},
            {field: 'defaultunitname', title: '默认单位'},
            {field: 'categoryname', title: '分类名称'},
            {field: 'wholeSpell', title: '完整拼音'},
            {field: 'janeSpell', title: '简拼'},
            {
                field: 'id', align: 'center', formatter: function (value, row, index) {
              return  "<a href='#' onclick=showDetail('" + value + "')>查看详情</a> &nbsp;&nbsp;<a href='#' onclick=modify('" + value + "')>编辑</a> &nbsp;&nbsp;<a href='#' onclick=deleteItem('" + value + "')>删除</a>";
            }, title: '操作'
            }
        ]],
        toolbar: [          //顶部工具栏的DataGrid面板
            {
                text: '新增',      //文本名称
                iconCls: 'icon-add',    //增加图标
                handler: function () {     //点击按钮时触发一个事件
                    flag = 'add';
                    $('#addDialog').dialog({   //打开新增框
                        title: '新增物料基础信息'   //名称
                    });
                    $("#parentId").combotree('reload');
                    fillCombox();
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
                        $('#dg').datagrid('remove', id);
                        deleteItem(id);
                    }
                }
            }

        ],
        // frozenColumns: [[
        //     {field: 'ck', checkbox: true}
        // ]],
        singleSelect: true,//是否单选
        pagination: true,
        fitColumns: false,
        striped: true,
        pagination: true,
        rownumbers: true,
        pageNumber: 1,
        pageSize: 10,
        // onSelect: function (rowIndex, rowData) {
        //     showDetail(rowData.id);
        // },
    });
    //设置分页控件
    var p = $('#dg').datagrid('getPager');
    $(p).pagination({
        pageSize: 10,//每页显示的记录条数，默认为10
        pageList: [5, 10, 20],//可以设置每页记录条数的列表
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',

    });




    //新增框组合树
    $("#categoryId").combotree({
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
    $("#modify-categoryId").combotree({
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




    //提交新增表单
    $("#confirm").click(function () {
        submitAddForm();
    });

    //提交修改表单
    $("#modifyConfirm").click(function () {
      submitModifyForm();
    });


});

//提交查询
function checkInputQuery() {

    console.log("cateCode:" + $('#cateCode').val());
    console.log("cateName:" + $('#cateName').val());
    console.log("industryType:" + $('#industryType').val());
    $('#dg').datagrid('load', {
        materialCode: $('#cateCode').val(),
        materialName: $('#cateName').val(),
        industryType: $('#industryType').val()
    });
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
        url: '/hongtu/v1/supplychain/bms/material/basInfo/delete/' + id,
        type: 'delete', //GET
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
    $('#modifyDialog').dialog({   //打开新增框
        title: '编辑分类信息'   //名称
    });
    //重置
    $('#modifyForm').form('clear');
    $("#modifyForm").get(0).reset();
    $("#modifyDialog").dialog('open');

    $.ajax({
        type: "GET",
        url: '/hongtu/v1/supplychain/bms/material/basInfo/detail/' + index,
        async: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        contentType: "application/json",
        error: function (request) {
            alert("请求失败！")
        },
        success: function (data) {
            fillCombox();
            var obj = data.data;
            $("#modifyDialog input[id=id]").val(obj.id);
            $("#modifyDialog input[id=materialCode]").textbox('setValue',obj.materialCode);
            $("#modifyDialog input[id=materialName]").textbox('setValue',obj.materialName);
            $("#modifyDialog input[id=industryType]").textbox('setValue',obj.industryType);
            // $("#modifyDialog input[id=isSystem]").val(obj.isSystem==0?'是':'否');
            // $("#modifyDialog input[id=isEnable]").val(obj.isEnabled==0?'禁用':'启用');
            // $("#modifyDialog input[id=defaultUnitName]").val(obj.defaultUnitName);
            // $("#modifyDialog input[id=categoryName]").val(obj.categoryName);
            // $("#modifyDialog input[id=wholeSpell]").textbox('setValue',obj.wholeSpell);
            // $("#modifyDialog input[id=janeSpell]").textbox('setValue',obj.janeSpell);
            $("#modifyDialog select[id=isSystem]").combobox('setValue',obj.isSystem);
            $("#modifyDialog select[id=isEnabled]").combobox('setValue',obj.isEnabled);
            $("#modifyDialog input[id=defaultUnitId]").combobox('setValue',obj.defaultUnitId);
            $("#modify-categoryId").combotree('setValue', obj.categoryId);
        }
    });
}
/**
 * 查看详情
 */
function showDetail(value) {

    $.ajax({
        type: "GET",
        url: '/hongtu/v1/supplychain/bms/material/basInfo/detail/' + value,
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
            $("td[id=materialCode]").html(obj.materialCode);
            $("td[id=materialName]").html(obj.materialName);
            $("td[id=industryType]").html(obj.industryType);
            $("td[id=isSystem]").html(obj.isSystem==0?'是':'否');
            $("td[id=isEnable]").html(obj.isEnable==0?'禁用':'启用');
            $("td[id=addAccountName]").html(obj.addAccountName);
            $("td[id=addDepartName]").html(obj.addDepartName);
            $("td[id=defaultUnitName]").html(obj.defaultunitname);
            $("td[id=categoryName]").html(obj.categoryname);
            $("td[id=wholeSpell]").html(obj.wholeSpell);
            $("td[id=janeSpell]").html(obj.janeSpell);

        }
    });
}

function  fillCombox() {
    $(' input[id=defaultUnitId]').combobox({
        url:'/hongtu/v1/supplychain/bms/material/basUnits/allUnits',
        valueField:'id',
        textField:'unitname',
        method:'get'
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
                    url:"/hongtu/v1/supplychain/bms/material/basInfo/add",
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
                    url:"/hongtu/v1/supplychain/bms/material/basInfo/update",
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



$.fn.serializeObject = function() {
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

