package com.liutao.mapper;

import com.liutao.entity.User;

import java.util.List;

/**
 * 用户数据访问
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */
public interface UserMapper {

    User findByName(String loginName);

    List<User> getList();
}
