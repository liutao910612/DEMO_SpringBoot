package com.liutao.es.controller;

import com.liutao.es.vo.User;
import io.swagger.annotations.*;
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
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    static Map<String,User> users = Collections.synchronizedMap(new HashMap<String, User>());
    private static final String SUCCESS = "success";

    /**
     * 获取用户资源集合
     * Get:获取、获得
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="获取到的是所有的用户")
    @GetMapping("users")
    public List<User> getUsers(){
        logger.info("enter get users");
        List<User> userList = new ArrayList<>( users.values());
        return userList;
    }

    /**
     * 获取单个资源
     * Get:获取、获得
     * @return
     */
    @ApiOperation(value="获取用户", notes="获取到的是单个用户")
    @GetMapping("user")
    public User getUser(){
        User user = new User();
        user.setName("liutao");
        user.setId("1212");
        user.setPassword("123456");
        return user;
    }

    /**
     * 新增用户资源
     * Post：新增、添加
     * @param user
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @PostMapping("user")
    public String addUser(@RequestBody @ApiParam(name = "用户对象",value = "传入json格式",required = true) User user){
        logger.info("enter post users");
        users.put(user.getId(),user);
        return SUCCESS;
    }

    /**
     * 更新用户信息（提供全部信息）
     * Put:更新
     * @param user
     */
    @PutMapping("user")
    public void updateUser(@RequestBody @ApiParam(name = "用户对象",value = "传入json格式",required = true)User user){
        String id = user.getId();
        users.put(id,user);
    }

    /**
     * 更新用户信息（提供部分信息）
     * Patch:更新
     * @param name
     * @param id
     */
    @ApiOperation(value="更新用户详细信息", notes="根据id来跟新指定用户的name")
    @PatchMapping("user")
    public void updateUserBySome(
            @RequestParam @ApiParam(name="name",value="用户名称",required=true) String name,
            @RequestParam @ApiParam(name="id",value="用户名id",required=true)  String id){
        User user = users.get(id);
        user.setName(name);
        users.put(id,user);
    }

    /**
     * 删除用户信息
     * Delete:删除
     * @param id
     */
    @ApiIgnore
    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable("id")String id){
        users.remove(id);
    }
}
