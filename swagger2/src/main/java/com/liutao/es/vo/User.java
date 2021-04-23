package com.liutao.es.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author LIUTAO
 * @version 2018/3/20 9:53
 */
@ApiModel(value="user对象",description="订单对象user")
public class User implements Serializable {
    @ApiModelProperty(hidden = true)
    private String id;
    @ApiModelProperty(value="订单名",name="name",example="xingguo")
    private String name;
    @ApiModelProperty(value="密码",name="password",required=true)
    private String password;

    public User() {
    }

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
