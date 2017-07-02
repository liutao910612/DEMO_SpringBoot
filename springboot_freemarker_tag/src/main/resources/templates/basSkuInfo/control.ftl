<div class="row" style="margin-bottom: 20px">
    <div class="col-md-7">
    <@addButton/>&nbsp;&nbsp;
    <@deleteButton/>
    </div>

    <div class="col-md-5">
        <!--搜索-->
        <form name="searchform" method="post" class="form-inline" action="" id="searchform">
            <div class="form-group">
                <label for="skucode">物料编号：</label>
                <input type="text" class="form-control" id="skucode" name="skucode">
            </div>
            <div class="form-group">
                <label for="skuname">物料名称：</label>
                <input type="text" class="form-control" id="skuname" name="skuname">
            </div>
            <button type="button" id="search" class="btn btn-primary">搜索</button>
        </form>
    </div>
</div>