package com.liutao.es.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;

import java.util.HashMap;
import java.util.Map;
/**
 * @Author:LIUTAO
 * @Description:
 * @Date:Created in 17:02 2020/5/30
 * @Modified By:
 */
@Slf4j
public class EsUtil {

    private void processIndexResponse(IndexResponse indexResponse) {

    }

    public static Object processGetResponse(GetResponse getResponse) {
        String index = getResponse.getIndex();
        String id = getResponse.getId();
        log.debug("index is {} , id is {}", index, id);
        if (getResponse.isExists()) {
            String source = getResponse.getSourceAsString();
            return JSON.parse(source);
        } else {
            return null;
        }
    }

    public static Map<String,Object> processBulkRequest(BulkResponse bulkResponse) {
        if (bulkResponse == null) {
            return null;
        }

        Map<String,Object> responseMap = new HashMap();
        for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
            DocWriteResponse itemResponse = bulkItemResponse.getResponse();
            switch (bulkItemResponse.getOpType()){
                case INDEX:

                case CREATE:
                    IndexResponse indexResponse = (IndexResponse)itemResponse;
                    responseMap.put("CREATE",indexResponse);
                    break;
                case UPDATE:
                    UpdateResponse updateResponse = (UpdateResponse)itemResponse;
                    responseMap.put("UPDATE",updateResponse);
                    break;
                case DELETE:
                    DeleteResponse deleteResponse = (DeleteResponse)itemResponse;
                    responseMap.put("DELETE",deleteResponse);
                    break;
            }
        }
        return responseMap;
    }
}
