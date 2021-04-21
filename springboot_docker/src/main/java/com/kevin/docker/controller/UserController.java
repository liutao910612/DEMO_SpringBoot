package com.kevin.docker.controller;

import com.google.common.collect.Lists;
import com.kevin.publiz.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

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
public class UserController {

    /**
     * 获取用户资源集合
     * Get:获取、获得
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="获取到的是所有的用户")
    @GetMapping("users")
    public List<User> getUsers(){
        User user= new User();
        user.setId(1);
        user.setEmail("kevin@demo.com");
        user.setPassword("123");
        user.setUsername("kevin");
        List<User> userList = Lists.newArrayList(user);
        return userList;
    }

    /**
     * 删除用户信息
     * Delete:删除
     * @param id
     */
    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable("id")String id){
       return;
    }
}
