$(function () {
    /**
     * 搜索功能
     */
    $("#search").click(function () {
        $('#skuInfoTable').datagrid('load', {
            skucode: $('#skucode').val(),
            skuname: $('#skuname').val(),
        });
    });
})
/**
 * 删除选中行
 * @param index
 */
function deleteItem(index) {
    var currentRow = $('#skuInfoTable').datagrid('getData').rows[index];
    console.log("row:" + currentRow.id)
    console.log("enter deleteItem,index:" + index + ",id:" + currentRow.id);
    $.ajax({
        type: "DELETE",
        url: '/bms/material/basskuinfo/' + currentRow.id,
        async: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        contentType: "application/json",
        error: function (request) {
            alert("删除失败！")
        },
        success: function (data) {
            $('#skuInfoTable').datagrid('deleteRow', index);
            alert("删除成功！")
        }
    });
};

/**
 * 添加物料信息
 */
function addItem() {
    var data = getDataOfSelect();
    if (data == 0){
        alert('初始化页面失败！');
    }
    $('#addDialog').dialog({   //打开新增框
        title: '新增物料信息'   //名称
    });
    //重置
    $('#addForm').form('clear');
    $("#addForm").get(0).reset();
    $("#addDialog").dialog('open');


}

/**
 * 删除物料信息
 */
function deleteItems() {
    console.log("begin delete")
    var deletedData = $('#skuInfoTable').datagrid('getChecked');
    var ids = "";
    for (var i = deletedData.length - 1; i >= 0; i--) {
        var rowIndex = $('#skuInfoTable').datagrid('getRowIndex', deletedData[i]);
        if (i != 0) {
            ids = ids + deletedData[i].id + ",";
        } else {
            ids = ids + deletedData[i].id;
        }
    }
    console.log("ids:" + ids);
    var jsonStr = {
        "id": ids
    };
    var data = JSON.stringify(jsonStr);//string类型
    $.ajax({
        type: "DELETE",
        url: '/bms/material/basskuinfo/' + ids,
        data: data,
        async: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        contentType: "application/json",
        error: function (request) {
            alert("删除失败！")
        },
        success: function (data) {
            for (var i = deletedData.length - 1; i >= 0; i--) {
                var rowIndex = $('#skuInfoTable').datagrid('getRowIndex', deletedData[i]);
                $('#skuInfoTable').datagrid('deleteRow', rowIndex);
            }
            alert("删除成功！")
        }
    });
}

/**
 * 查看详情
 */
function findBasInfoDetail(index) {
    console.log("enter findBasInfoDetail,index:"+index);
    var currentRow = $('#skuInfoTable').datagrid('getData').rows[index];
    var id = currentRow.id;
    console.log("id:"+id);
    $.ajax({
        type: "GET",
        url: '/bms/material/basskuinfo/detail/' + id,
        async: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        contentType: "application/json",
        error: function (request) {
            alert("请求失败！")
        },
        success: function (data) {
            var basSkuInfo = data.data;
            $("td[id=skucode]").html(basSkuInfo.skucode);
            $("td[id=skuname]").html(basSkuInfo.skuname);
            $("td[id=customername]").html(basSkuInfo.customername);
            $("td[id=catename]").html(basSkuInfo.catename);
            $("td[id=unitname]").html(basSkuInfo.unitname);
            $("td[id=constname]").html(basSkuInfo.constname);
            $("td[id=length]").html(basSkuInfo.length);
            $("td[id=width]").html(basSkuInfo.width);
            $("td[id=height]").html(basSkuInfo.height);
            $("td[id=volume]").html(basSkuInfo.volume);
            $("td[id=weight]").html(basSkuInfo.weight);
            $("td[id=netweight]").html(basSkuInfo.netweight);
            $("td[id=convertweight]").html(basSkuInfo.convertweight);
            $("td[id=traystack]").html(basSkuInfo.traystack);
        }
    });
}

/**
 * 修改物料信息
 */
function modifyBasSkuInfo(index) {
    //获取修改信息的id
    console.log("enter findBasInfoDetail,index:"+index);
    var currentRow = $('#skuInfoTable').datagrid('getData').rows[index];
    var id = currentRow.id;
    console.log("id:"+id);

    flag = 'modify';
    var data = getDataOfSelect();
    if (data == 0){
        alert('初始化页面失败！');
    }
    $('#modifyDialog').dialog({   //打开新增框
        title: '编辑物料信息'   //名称
    });
    //重置
    $('#modifyForm').form('clear');
    $("#modifyDialog").dialog('open');
}


/**
 * 获取select所需参数
 */
function getDataOfSelect() {
    $.ajax({
        type: "GET",
        url: '/bms/material/basskuinfo/otherData',
        async: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        contentType: "application/json",
        error: function (request) {
            return 0;
        },
        success: function (data) {
            if(data.data.customers.length>0){
                console.log("customers:"+data.data.customers);
                var options;
                $.each(data.data.customers, function (index, item) {
                    options = options + '<option value="' + item.id + '">' + item.customerName + '</option>'
                })
                $("select[name=customerid]").html(options);

            }

            if(data.data.units.length>0){
                options = "";
                $.each(data.data.units, function (index, item) {
                    options = options + '<option value="' + item.id + '">' + item.unitname + '</option>'
                })
                $("select[name=defaultunitid]").html(options);

            }

            if(data.data.basMaterials.length>0){
                options = "";
                $.each(data.data.basMaterials, function (index, item) {
                    options = options + '<option value="' + item.id + '">' + item.materialName + '</option>'
                })
                $("select[name=materialid]").html(options);

            }

            return 1;
        }
    });
}

/**
 * 提交表单
 */
function submitAddForm(){
    alert(form2Json('addForm'));

    $.ajax({
        type: "POST",
        url: '/bms/material/basskuinfo',
        async: false,
        data:form2Json('addForm'),
        contentType: false,
        processData: false,
        dataType: 'json',
        contentType: "application/json",
        error: function (request) {
            alert("fail");
        },
        success: function (data) {
           alert("success");
           $('#addDialog').dialog('close');
        }
    });


}

/**
 * 清空表单
 */
function clearForm(){
    $('#ff').form('clear');
}


/**
 * 将表单数据转换成json
 * @returns {{}}
 */
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