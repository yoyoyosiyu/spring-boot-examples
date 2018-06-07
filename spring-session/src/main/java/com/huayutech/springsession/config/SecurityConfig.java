package com.huayutech.springsession.config;

import com.huayutech.springsession.security.RemoteAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
        http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();
        http.formLogin().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.authenticationProvider(new RemoteAuthenticationProvider());
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("user")).roles("USER");

    }
}
