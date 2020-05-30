package com.liutao.es.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;

/**
 * @Author:LIUTAO
 * @Description:
 * @Date:Created in 17:02 2020/5/30
 * @Modified By:
 */
@Slf4j
public class EsUtil {

    private void processIndexResponse(IndexResponse indexResponse){

    }

    public static Object processGetResponse(GetResponse getResponse){
        String index = getResponse.getIndex();
        String id = getResponse.getId();
        log.debug("index is {} , id is {}",index,id);
        if(getResponse.isExists()){
            String source = getResponse.getSourceAsString();
            return JSON.parse(source);
        }else{
            return null;
        }
    }
}
