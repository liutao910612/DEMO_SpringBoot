package com.liutao.elasticsearch.test;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.settings.Settings;
import org.junit.Test;

import java.io.IOException;

/**
 * Note: CreateIndexRequest,GetIndexRequest and DeleteIndexRequest
 *
 * @author: LIUTAO
 * @Date: Created in 2020/06/07  17:16
 * @Modified By:
 */
public class CreateIndexApiTest extends BasicTest {


    @Test
    public void test() {
        CreateIndexRequest request = new CreateIndexRequest("animal");
        request.settings(Settings.builder().put("index.number_of_shards",3).put("index.number_of_replicas",2));
        CreateIndexResponse response = null;
        try {
            response = restClient.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //所有节点是否已经确认请求
        boolean ackownledged = response.isAcknowledged();

        //是否在超时间前为索引中的每个分片启动了所需数量的分片副本
        boolean shardsAcknowledged = response.isShardsAcknowledged();
        System.out.println("ackownledged : " + ackownledged + "，shardsAcknowledged ：" + shardsAcknowledged);

    }
}
