package com.liutao.es.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/11/30  18:19
 * @Modified By:
 */
@ApiModel("Order")
@Data
public class Order {
    private Long id;
    private String orderName;
    private String orderType;
    private String orderNo;
    private int num;
}
