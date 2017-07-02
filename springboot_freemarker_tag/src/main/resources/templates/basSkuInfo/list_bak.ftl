<!--展示物料信息-->
<div class="row">
    <div class="col-md-12">
        <div fit=true style="width:100%; height:100%">
            <div>
            <@dataGrid id = 'skuInfoTable'url = '/bms/material/basskuinfo/basskuinfos' pageList= "[10,20,30,50]" pageSize = "10">
                    <@col field = 'id' title = '物料id' hidden = "true"></@col>
                    <@col field = 'skucode' title = '物料编码' sortable = "true"></@col>
                    <@col field = 'skuname' title = '物料名称'></@col>
                    <@col field = 'unitname' title = '单位名称'></@col>
                    <@col field = 'customername' title = '客户名称'></@col>
                    <@operate field = "_operate" title = "操作" width="100">
                        <@link onclick="findBasInfoDetail(\"+index+\")" text="查看详情"/>
                        <@link onclick="modifyBasSkuInfo(\"+index+\")" text="编辑"/>
                        <@link onclick="deleteItem(\"+index+\")" text="删除"/>
                    </@operate>
            </@dataGrid>
            </div>
        </div>
    </div>
</div>