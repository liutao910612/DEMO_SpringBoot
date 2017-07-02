/**
 * Created by LIUTAO on 2017/6/22.
 */

/**
 * 将表单数据转换成json
 * @param id
 */
function form2Json(id) {

    var jsonStr = $("#" + id).serializeObject();
    var json = JSON.stringify(jsonStr)
    return json
}
