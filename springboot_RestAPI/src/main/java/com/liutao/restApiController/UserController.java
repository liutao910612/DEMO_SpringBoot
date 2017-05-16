package com.liutao.restApiController;

import com.liutao.model.User;
import com.liutao.service.UserService;
import com.wordnik.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
//为控制器默认设置消息转换
@RestController
@Api(value = "test")
@RequestMapping("/liutao/v1")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUserList",method=RequestMethod.GET,produces = "application/json")
    public List<User> getUserList(@RequestParam(value="name",defaultValue = "liutao") String name){
        logger.info("name from front:"+name);
        User user1 = new User("liutao",12,"123");
        User user2 = new User("liubei",12,"123");
        User user3 = new User("liubang",12,"123");
        User user4 = new User("liuche",12,"123");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        return userList;
    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    //为控制器默认设置消息转换
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getUserInfo();
        if(user!=null){
            logger.info("user.getAge():"+user.getAge());
        }
        return user;
    }

    /**
     * 在请求体中接收资源状态
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveUser",method=RequestMethod.POST,consumes = "application/json")
    public User saveUser(@RequestBody User user){
        logger.debug("enter saveUser");
        logger.debug("name:"+user.getName());
        return user;
    }

    /**
     * 发送错误信息到客户端
     */


}
