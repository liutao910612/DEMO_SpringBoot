$(function () {
    $('#dg').treegrid({
        url: '/hongtu/v1/supplychain/bms/material/basSkuCategory/root',
        idField: "id",
        treeField: "cateName",
        title: '物料分类',
        width: 'auto',   //列的宽度
        height: 400,     //列的高度
        striped: true,  //是否显示斑马线效果
        fitColumns: 'true', //真正的自动展开/收缩列的大小
        animate: true,//是否用动画效果
        collapsible: true,//是否可折叠
        pagination: true,//分页控件
        rownumbers: true,//行号
        method: 'get',
        autoRowHeight: true,
        showFooter: false,//是否使用页脚
        // sortName: 'cateName',//默认排序字段,后台通过参数名“sort”获取
        // sortOrder: 'desc',//默认排序规则，后台通过参数名“order”获取
        columns: [[
            {field: 'cateName', title: '分类名称',},
            {field: 'remark', title: '备注',},
            {field: 'accountname', title: '添加人',},
            {
                field: 'addTime', title: '添加时间', formatter: function (value, row, index) {
                return formatDate(value);
            },
            },
            {field: 'editAccountname', title: '修改人',},
            {
                field: 'editTime', title: '修改时间', formatter: function (value, row, index) {
                return formatDate(value);
            },
            },
            {field: 'wholeSpell', title: '完整拼音',},
            {field: 'janeSpell', title: '简拼',},
            {
                field: 'id', align: 'center', formatter: function (value, row, index) {
                return  "<a href='#' onclick=showDetail('" + value + "')>查看详情</a> &nbsp;&nbsp;<a href='#' onclick=modify('" + value + "')>编辑</a> &nbsp;&nbsp;<a href='#' onclick=deleteItem('" + value + "')>删除</a>";
            }, title: '操作',
            }

        ]],
        onBeforeExpand: function (node) {
            $('#dg').treegrid('options').url = '/hongtu/v1/supplychain/bms/material/basSkuCategory/children?parentId=' + node.id;
        },
        onLoadSuccess: function () {
            //每次数据加载完成以后，还原查询URL
            $("#dg").treegrid('options').url = '/hongtu/v1/supplychain/bms/material/basSkuCategory/root';
        },
        singleSelect: false,//是否单选
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        toolbar: [          //顶部工具栏的DataGrid面板
            {
                text: '新增',      //文本名称
                iconCls: 'icon-add',    //增加图标
                handler: function () {     //点击按钮时触发一个事件
                    flag = 'add';
                    $('#addDialog').dialog({   //打开新增框
                        title: '新增分类'   //名称
                    });
                    $("#parentId").combotree('reload');
                    //重置
                    $('#addForm').form('clear');
                    $("#addForm").get(0).reset();
                    $("#addDialog").dialog('open');
                }
            }, '-', {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {

                    var deletedData = $('#dg').treegrid('getChecked');
                    for (var i = deletedData.length - 1; i >= 0; i--) {
                        var id = deletedData[i].id;
                        // $('#dg').treegrid('remove', id);
                        deleteItem(id);
                    }
                    // $('#dg').treegrid('reload');

                }
            }

        ],
        // onClickCell: function (rowIndex, rowData) {
        //     $(this).treegrid('unselect', rowIndex);
        // },
        // onClickRow: function (rowIndex) {
        //     showDetail(rowIndex.id);
        // },

    });
    //设置分页控件
    var p = $('#dg').treegrid('getPager');
    $(p).pagination({
        pageSize: 10,//每页显示的记录条数，默认为10
        pageList: [5, 10, 15],//可以设置每页记录条数的列表
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        /*onBeforeRefresh:function(){
         $(this).pagination('loading');
         alert('before refresh');
         $(this).pagination('loaded');
         }*/
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
    $("#parentId").combotree({
        url: '/hongtu/v1/supplychain/bms/material/basSkuCategory/allGorys',
        required: true,
        valueField: 'id',
        textField: 'text',
        required: false

    });
    //修改框组合树
    $('#modify-parentId').combotree({
        url: '/hongtu/v1/supplychain/bms/material/basSkuCategory/allGorys',
        required: true,
        valueField: 'id',
        textField: 'text',
        required: false
    });

})




//删除操作
function deleteItem(id) {

    $.ajax({
        url: '/hongtu/v1/supplychain/bms/material/basSkuCategory/delete/' + id,
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
            // $('#dg').treegrid('remove', id);
            // if(data.code==0){
            //     $.messager.show({
            //         title:"提示消息",
            //         msg:data.message,
            //     });
            // }
            $("#dg").treegrid('reload');
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

    $("#parentId").combotree('reload');
    // flag = 'modify';
    $('#modifyDialog').dialog({   //打开新增框
        title: '编辑分类信息'   //名称
    });
    //重置
    $('#modifyForm').form('clear');
    $("#modifyForm").get(0).reset();
    $("#modifyDialog").dialog('open');
    $.ajax({
        type: "GET",
        url: '/hongtu/v1/supplychain/bms/material/basSkuCategory/detail/' + index,
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
            $("#modifyDialog input[id=cateName]").textbox('setValue',obj.cateName);
            $("#modifyDialog input[id=remark]").textbox('setValue',obj.remark);
            // $("#modifyDialog input[id=wholeSpell]").textbox('setValue',obj.wholeSpell);
            // $("#modifyDialog input[id=janeSpell]").textbox('setValue',obj.janeSpell);
            // $("#modifyDialog input[id=parentId]").val(obj._parentId);
            $('#modify-parentId').combotree('setValue', obj._parentId);//设置默认值
        }
    });
}
/**
 * 查看详情
 */
function showDetail(index) {

    $.ajax({
        type: "GET",
        url: '/hongtu/v1/supplychain/bms/material/basSkuCategory/detail/' + index,
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
            $("td[id=cateName]").html(obj.cateName);
            $("td[id=remark]").html(obj.remark);
            $("td[id=accountName]").html(obj.accountname);
            $("td[id=addTime]").html(formatDate(obj.addTime));
            $("td[id=editAccountName]").html(obj.editaccountname);
            $("td[id=editTime]").html(formatDate(obj.editTime));
            $("td[id=wholeSpell]").html(obj.wholeSpell);
            $("td[id=janeSpell]").html(obj.janeSpell);
        }
    });
}


//格式化日期格式
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



function submitAddForm(){
    var formBeanJson = $('#addForm').serializeObject();
    $('#addForm').form('submit',{
        onSubmit:function(){
            var validateResult = $(this).form('enableValidation').form('validate');
            if(validateResult){
                $.ajax({
                    cache: true,
                    type: "POST",
                    url:"/hongtu/v1/supplychain/bms/material/basSkuCategory/add",
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
                            $("#dg").treegrid('reload');
                            $('#addForm').form('clear');
                        }else{
                            alert(data.message+":"+data.data);
                        }
                    }
                });
            }else {
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
                    url:"/hongtu/v1/supplychain/bms/material/basSkuCategory/update",
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
                            $("#dg").treegrid('reload');
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

