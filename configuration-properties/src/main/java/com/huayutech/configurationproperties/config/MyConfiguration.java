package com.huayutech.configurationproperties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "my")
    public MyResource myResource() {
        return new MyResource();
    }

    @Data
    public static class MyResource {

        String greeting;
        String version;

    }

}
