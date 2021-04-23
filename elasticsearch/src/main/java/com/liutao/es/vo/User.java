package com.liutao.es.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author: LIUTAO
 * @Date: Created in 2018/11/30  18:19
 * @Modified By:
 */
@ApiModel("User")
@Data
public class User {
    private Long id;
    private String userName;
    private String mobile;
    private int sex;
}
