package com.huayutech.springsessionrest.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
        http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();
        http.httpBasic();
    }
}
