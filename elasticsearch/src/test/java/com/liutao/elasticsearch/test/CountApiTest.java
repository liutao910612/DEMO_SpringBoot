package com.liutao.elasticsearch.test;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @author: LIUTAO
 * @Date: Created in 2020/06/07  10:40
 * @Modified By:
 */
public class CountApiTest extends BasicTest {


    @Test
    public void test() {
        CountRequest request = new CountRequest("order");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("orderName","康师傅"));
        request.source(searchSourceBuilder);

        try {
            CountResponse response = restClient.count(request, RequestOptions.DEFAULT);

            //统计请求对应的结果命中数
            long count = response.getCount();

            //Http状态码
            RestStatus status = response.status();

            //请求是否提前终止
            Boolean teminatedEarly = response.isTerminatedEarly();
            System.out.println("count is " + count + ",status is " + status.getStatus() + ";teminatedEarly is "+teminatedEarly);

            //与统计请求对应的分片总数
            int totalShards = response.getTotalShards();

            //执行统计请求跳过的分片数量
            int skippedShards = response.getSkippedShards();

            //执行统计请求成功的分片数量
            int successfulShards = response.getSuccessfulShards();
            System.out.println("totalShards is " + totalShards + ",skippedShards is "+ skippedShards + ",successfulShards is " + successfulShards);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
