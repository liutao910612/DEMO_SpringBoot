<!--展示物料信息-->
<div class="row">
    <div class="col-md-12">
        <div fit=true style="width:100%; height:100%">
            <div>
            <@treeGrid id = 'tt'url = '/bms/material/basskuinfo/test' pageList= "[5,20,30,50]" pageSize = "5">
                    <@col field = 'id' title = '编号' width="50"></@col>
                    <@col field = 'name' title = '分类名' width="150"></@col>
                    <@col field = 'begin' title = '开始时间' width="50"></@col>
                    <@col field = 'end' title = '结束时间' width="50"></@col>
                    <@operate field = "_operate" title = "操作" width="100">
                <@link onclick="findBasInfoDetail(\"+index+\")" text="查看详情"/>
                <@link onclick="modifyBasSkuInfo(\"+index+\")" text="编辑"/>
                <@link onclick="deleteItem(\"+index+\")" text="删除"/>
            </@operate>
            </@treeGrid>
            </div>
        </div>
    </div>
</div>
