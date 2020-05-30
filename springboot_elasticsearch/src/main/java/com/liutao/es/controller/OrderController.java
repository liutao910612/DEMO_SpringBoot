package com.liutao.es.controller;

import com.alibaba.fastjson.JSON;
import com.liutao.es.util.EsUtil;
import com.liutao.es.vo.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Author:LIUTAO
 * @Description:
 * @Date:Created in 15:54 2020/5/30
 * @Modified By:
 */
@Slf4j
@Api(tags = "Order Api", description = "maintain the order info")
@RestController
@RequestMapping("/liutao/v1")
public class OrderController {

    @Autowired
    private RestHighLevelClient restClient;

    /**
     * Create order
     *
     * @return
     */
    @ApiOperation(value = "Create order")
    @PostMapping("order")
    public IndexResponse createOrder(@RequestBody Order order) {
        IndexResponse result = null;
        try {
            IndexRequest request = new IndexRequest();
            request.index(Order.class.getSimpleName().toLowerCase());
            request.id(order.getId().toString());
            String source = JSON.toJSONString(order);
            request.source(source, XContentType.JSON);
            try {
                result = restClient.index(request, RequestOptions.DEFAULT);
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                restClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Get order
     *
     * @return
     */
    @ApiOperation(value = "Get order")
    @GetMapping("order")
    public Object getOrder(@RequestParam("id") Long id) {
        GetResponse result = null;
        try {
            GetRequest request = new GetRequest();
            request.index(Order.class.getSimpleName().toLowerCase());
            request.id(id.toString());
            try {
                result = restClient.get(request, RequestOptions.DEFAULT);
                log.debug("the response is : {}",result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                restClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return EsUtil.processGetResponse(result);
    }


}
