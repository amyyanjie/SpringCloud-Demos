package com.amy.cloud.amycloudeureka.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: yanjie
 * @Description: 添加srcurity配置后，服务始终注册不上 -> 因为新版本的security默认开启了scrf
 * @Date: 2019/08/19 14:56
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    @SneakyThrows
    // 重写方法，将csrf拦截禁用
    protected void configure(HttpSecurity http) {
        http.csrf().disable()//关闭csrf
                //开启认证
                .authorizeRequests() //通过authorizeRequests()来开始请求权限配置
                .antMatchers("/actuator/**").permitAll() //表示任何用户都可访问/actuator开头的URL
                .anyRequest().authenticated() //尚未匹配的URL都需通过授权认证后可访问
                .and()
                .httpBasic(); //一种授权方式。另一种是：formLogin()

    }
}
