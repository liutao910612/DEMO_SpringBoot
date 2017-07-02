package com.liutao.controller;

import com.liutao.entity.User;
import com.liutao.service.UserService;
import com.liutao.tag.model.FilterRuleModel;
import com.liutao.tag.model.RequestModel;
import com.wordnik.swagger.annotations.Api;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.T;

/**
 * 用户控制层
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */
@Controller
@Api(value = "test")
@RequestMapping("/liutao/springboot/freemark")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userServiceImpl;

    /**
     * 获取首页
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView getUserInfo() throws Exception {
        logger.debug("index");
        System.out.println("index");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","熊大");
        modelAndView.setViewName("basSkuInfo/index");
        return modelAndView;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "users",method = {RequestMethod.POST,RequestMethod.GET})
    public Map<String,Object> getUsers(HttpServletRequest request, @ModelAttribute RequestModel requestModel) {

        Map<String,Object> resultMap = new HashMap();

        logger.debug("parameterObject:"+requestModel.toString());
        logger.debug("");
        List<User> users = userServiceImpl.getUserList(requestModel);
//
        logger.debug("users:"+users);
        resultMap.put("rows",users);
        resultMap.put("total",userServiceImpl.countUsers());
        return resultMap;
    }
}
