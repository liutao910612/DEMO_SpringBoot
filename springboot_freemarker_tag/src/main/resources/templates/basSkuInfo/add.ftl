<!--添加-->
<div class="row" style="margin-bottom: 20px">
    <div id="addDialog" class="easyui-dialog" closed="true" style="width:620px;top:150;">
        <fieldset class="tableStyle">
            <form id="addForm" method="post">
                <table cellpadding="5">
                    <tr>
                        <td>基础物料:</td>
                        <td>
                            <select class="form-control" id="materialid" name="materialid">
                            </select>
                        </td>
                        <td>物料编码:</td>
                        <td><input class="form-control" type="text" id="skucode" name="skucode" ></input>
                        </td>
                    </tr>
                    <tr>
                        <td>物料名称:</td>
                        <td><input class="form-control" type="text" id="skuname" name="skuname"></input></td>
                        <td>默认单位:</td>
                        <td>

                        </td>
                    </tr>
                    <tr>
                        <td>所属客户:</td>
                        <td>
                            <select class="form-control" id="customerid" name="customerid" >
                            </select>
                        </td>
                        <td>物料分类:</td>
                        <td>
                            <select class="form-control" id="categoryid" name="categoryid">
                            </select>
                        </td>
                    </tr>
                    <tr>

                        <td>包装类型:</td>
                        <td>
                            <select class="form-control" id="packageid" name="packageid">
                                <option value="ar">FASDF</option>
                                <option value="vi">VieFASDFtnamese</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>长(CM):</td>
                        <td><input class="form-control" type="text" id="length" name="length" ></input>
                        </td>
                        <td>宽(CM):</td>
                        <td><input class="form-control" type="text" id="width" name="width"></input></td>
                        <td>高(CM):</td>
                        <td><input class="form-control" type="text" id="height" name="height"></input></td>
                    </tr>

                    <tr>
                        <td>体积(M3):</td>
                        <td><input class="form-control" type="text" id="volume" name="volume" ></input>
                        </td>
                        <td>毛重(KG):</td>
                        <td><input class="form-control" type="text" id="weight" name="weight"></input></td>
                        <td>净重(KG):</td>
                        <td><input class="form-control" type="text" id="netweight" name="netweight"></input></td>
                    </tr>

                    <tr>
                        <td>折算重量(KG):</td>
                        <td><input class="form-control" type="text" id="convertweight" name="convertweight" ></input>
                        </td>
                        <td>托盘堆码数:</td>
                        <td><input class="form-control" type="text" id="traystack" name="traystack"></input></td>
                    </tr>
                </table>
            </form>
            <div style="text-align:center;padding:5px">
                <button  class="btn btn-primary" onclick="submitAddForm()">确认</button>
                <a href="javascript:void(0)" class="btn btn-default"
                   onclick="javascript:$('#addDialog').dialog('close')">取消</a>
            </div>
    </div>
</div>
