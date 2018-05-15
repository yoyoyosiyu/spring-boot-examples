package com.huayutech.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@Order(11)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManagerConfigurer<?> c = auth.inMemoryAuthentication();
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
            .and()
                .withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        下面这个例子中 /user/**和 /admin/**都必须只能允许具有ADMIN角色的账号访问
        我的初衷是让 /user/** 能被USER角色访问，而/admin/**能被ADMIN角色访问，但是
        requestMatchers的原理是后一个requestMatchers调用不会覆盖前一个requestMatchers调用的设置
        那么因为第一个requestMatchers调用指定了/user/**,那么第二个requestMatchers调用指定了/admin/**
        所以最后一个authorizeRequests()的作用范围就是/user/**和/admin/**,所以hasRole（"ADMIN")
        使得这两个URI的访问权限都必须符合ADMIN角色
        http
            .httpBasic()
                .and()
            .requestMatchers().antMatchers("/user/**")
                .and()
                    .authorizeRequests().antMatchers("/**").hasRole("user")
                .and()
            .requestMatchers().antMatchers("/admin/**")
                .and()
                    .authorizeRequests().antMatchers("/**").hasRole("ADMIN");
         */

        // requestMatcher是会覆盖上一个requestMatcher、requestMatchers、mvcMatcher、antMatcher、regexMatcher
        http
            .httpBasic().and()
                .authorizeRequests().antMatchers("/user/**").authenticated().antMatchers("/admin/**").hasRole("ADMIN");


    }
}
