package com.liutao.es.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liutao.es.util.EsUtil;
import com.liutao.es.vo.Order;
import com.liutao.es.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author:LIUTAO
 * @Description:
 * @Date:Created in 15:54 2020/5/30
 * @Modified By:
 */
@Slf4j
@Api(tags = "User Api", description = "maintain the user info")
@RestController
@RequestMapping("/liutao/v1")
public class UserController {

    @Autowired
    private RestHighLevelClient restClient;

    /**
     * Batch create users
     * BulkProcessor demo
     *
     * @param users
     * @return
     */
    @ApiOperation(value = "Create users")
    @PostMapping("users")
    public Map<String, Object> createOrders(@RequestBody List<User> users) {
        BulkProcessor.Listener listener = new BulkProcessor.Listener() {

            //Before the batch operation
            @Override
            public void beforeBulk(long executionId, BulkRequest bulkRequest) {
                int numOfActions = bulkRequest.numberOfActions();
                log.debug("Executing bulk {} with {} requests", executionId, numOfActions);
            }

            //After the batch operation
            @Override
            public void afterBulk(long executionId, BulkRequest bulkRequest, BulkResponse bulkResponse) {
                if (bulkResponse.hasFailures()) {
                    log.debug("Bulk {} executed with failures", executionId);
                } else {
                    log.debug("Bulk {} completed in {}", executionId, bulkResponse.getTook().getMillis());
                }
            }

            //After the batch operation with exception
            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, Throwable throwable) {
                log.debug("Failed to execute bulk", throwable);
            }
        };

        BulkProcessor bulkProcessor = BulkProcessor
                .builder((bulkRequest, bulkResponseActionListener) -> restClient.bulkAsync(bulkRequest, RequestOptions.DEFAULT, bulkResponseActionListener), listener)
                .setFlushInterval(TimeValue.timeValueSeconds(2))
                .build();

        for (User user : users) {
            IndexRequest indexRequest = new IndexRequest(Order.class.getSimpleName().toLowerCase())
                    .id(user.getId().toString());
            indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
            bulkProcessor.add(indexRequest);
        }
        try {
            bulkProcessor.awaitClose(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get users
     * MultiGetRequest demo
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "Create users")
    @GetMapping ("users")
    public List<JSONObject> getOrders(@RequestBody List<Integer> ids) {
        MultiGetRequest request = new MultiGetRequest();

        //add request
        ids.forEach(id -> request.add(new MultiGetRequest.Item(User.class.getSimpleName(),id+"")));
        MultiGetResponse response = null;
        try {
            response = restClient.mget(request,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EsUtil.processMultiGetResponse(response);
    }
}
