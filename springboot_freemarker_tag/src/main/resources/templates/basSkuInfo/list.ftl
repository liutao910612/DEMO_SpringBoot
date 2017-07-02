<!--展示物料信息-->
<div class="row">
    <div class="col-md-12">
        <div fit=true style="width:100%; height:100%">
            <div>
                <table id="skuInfoTable" style="width:auto;width:auto">
                </table>
            </div>
        </div>
    </div>
</div>
<table id="skuInfoTable" style="width:auto;width:auto">
<script type="text/javascript">
    $(function () {
        var dg = $('#skuInfoTable').datagrid({
            method: 'post',
            dataType: 'json',
            remoteFilter: true,
            remoteFilterUrl: '/liutao/springboot/freemark/users',
            url: '/liutao/springboot/freemark/users',
            width: 'auto',
            height: 'auto',

            //开启合计功能
            showFooter:true,

            striped: true,
            fitColumns: 'false',
            loadMsg: "数据加载中，请稍后……",
            pagination: true,
            scrollOnSelect:true,
            frozenColumns: [[
            {
                field: 'ck', //列字段名称
                width: 10,   //列宽度
                checkbox:true
            },]],
            columns: [[          //列配置对象
                {field: 'id', hidden: true, sortable: false, title: '用户id', width: 20},
                {field: 'name', hidden: false,  title: '姓名', width: 20},
                {field: 'age', hidden: false, sortable: false, sortable: true,title: '年龄', width: 20},
                {field: 'password', hidden: false, sortable: false, title: '密码', width: 20},
                {field: 'email', hidden: false, sortable: false, title: '邮箱', width: 20},
                {field: 'type', hidden: false, sortable: false, title: '年龄阶段', width: 20},
                {
                    field: '_operate',
                    width: 100,
                    align: 'center',
                    formatter: function (value, row, index) {
                        return "<a href='#' onclick='findBasInfoDetail(" + index + ")'>查看详情</a>&nbsp;&nbsp;<a href='#' onclick='modifyBasSkuInfo(" + index + ")'>编辑</a>&nbsp;&nbsp;<a href='#' onclick='deleteItem(" + index + ")'>删除</a>&nbsp;&nbsp;"
                    },
                    title: '操作'
                },

            ]],
            onClickRow: function (rowIndex, rowData) {
                $(this).datagrid('unselectRow', rowIndex);
            }
        });

//        添加过滤
        dg.datagrid('enableFilter', [
            {
                field: 'name',
                type: 'text'
            },
            {
                field: 'type',
                type: 'combobox',
                options: {
                    panelHeight: 'auto',
                    data: [
                            {value: '', text: '所有'},
                            {value: '老', text: '老'},
                            {value: '中', text: '中'},
                            {value: '青', text: '青'},
                            {value: '少', text: '少'},
                            {value: '幼', text: '幼'}
                    ],
                    onChange: function (value) {
                        if (value == '') {
                            dg.datagrid('removeFilterRule', 'type');
                        } else {
                            dg.datagrid('addFilterRule', {
                                field: 'type',
                                op: 'equal',
                                value: value
                            });
                        }
                        dg.datagrid('doFilter');
                    }
                }
            }
        ]);

        //设置分页控件
        var p = dg.datagrid('getPager');
        $(p).pagination({
            pageSize: 10,//每页显示的记录条数，默认为5
            pageList: [10, 20, 30, 50],//可以设置每页记录条数的列表
//            pageHeight:auto;
            beforePageText: '第',//页数文本框前显示的汉字
            afterPageText: '页    共 {pages} 页',
            displayMsg: '显示 {from} - {to} 条,共 {total} 条'
        });
    });
</script>