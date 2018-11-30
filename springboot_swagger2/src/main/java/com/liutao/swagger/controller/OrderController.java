package com.liutao.swagger.controller;

import com.liutao.swagger.vo.Order;
import com.liutao.swagger.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * 演示restFul在springboot中的使用。
 * 注意：restFul是面向资源的，所以路径尽量全用名词，而不要包含动词。
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */
@Api(tags="基础接口",description = "基础内容接口")
@RestController
@RequestMapping("/liutao/v1")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * 获取订单资源集合
     * Get:获取、获得
     * @return
     */
    @ApiOperation(value="获取订单信息", notes="获取到的是所有订单")
    @GetMapping("orders")
    public List<Order> getOrders(){
        logger.info("enter get users");
        List<Order> orders = new ArrayList<>();
        return orders;
    }

}
