<!--查看物料详情-->
<div class="row ">
    <div class="col-md-12">
    <@detail id="infoDetail">
        <div title="常规信息" class="tabItem">
            <form id="basInfo" method="post">
                <table cellpadding="5">
                    <tr>
                        <td class="content_title">物料编码:</td>
                        <td class="content" id="skucode"></td>
                        <td class="content_title">物料名称:</td>
                        <td class="content" id="skuname"></td>
                        <td class="content_title">所属客户:</td>
                        <td class="content" id="customername"></td>
                    </tr>
                    <tr>
                        <td class="content_title">一级分类:</td>
                        <td class="content" id="catename"></td>
                        <td class="content_title">二级分类:</td>
                        <td class="content" id="email"></td>
                        <td class="content_title">有效期(天):</td>
                        <td class="content" id="email"></td>
                    </tr>
                    <tr>
                        <td class="content_title">默认单位:</td>
                        <td class="content" id="unitname"></td>
                        <td class="content_title">包装类型:</td>
                        <td class="content" id="constname"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div title="物料规格" class="tabItem">
            <form id="basUnit" method="post">
                <table cellpadding="5">
                    <tr>
                        <td class="content_title">长:</td>
                        <td class="content" id="length"></td>
                        <td class="content_title">宽:</td>
                        <td class="content" id="width"></td>
                        <td class="content_title">高:</td>
                        <td class="content" id="height"></td>
                        <td class="content_title">体积:</td>
                        <td class="content" id="volume"></td>
                    </tr>
                    <tr>
                        <td class="content_title">净重:</td>
                        <td class="content" id="weight"></td>
                        <td class="content_title">毛重:</td>
                        <td class="content" id="netweight"></td>
                        <td class="content_title">折算重量:</td>
                        <td class="content" id="convertweight"></td>
                        <td class="content_title">托盘堆码数:</td>
                        <td class="content" id="traystack"></td>
                    </tr>
                </table>
            </form>
        </div>
    </@detail>
    </div>
</div>