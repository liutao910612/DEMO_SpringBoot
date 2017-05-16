package com.liutao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringSecurity配置类
 *
 * @author LIUTAO
 * @version 2017/5/10
 * @see
 * @since
 */
@Configuration
@EnableWebSecurity //注解开启SpringSecurity的功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()                      //定义需要被保护的URL
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()                              //定义当需要用户登录的时候转到登录页
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()                 //在内存中创建一个用户，用户名是user，密码是password，角色是USER
                .withUser("user").password("password").roles("USER");
    }
}
