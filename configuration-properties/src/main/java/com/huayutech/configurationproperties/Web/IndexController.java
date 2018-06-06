package com.huayutech.configurationproperties.Web;

import com.huayutech.configurationproperties.config.MyConfiguration;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@ConfigurationProperties(prefix = "my")
public class IndexController {

    private String name;

    @Autowired
    MyConfiguration.MyResource myResource;

    @GetMapping("/")
    protected String doGet() {

        return myResource.getGreeting()+ name + " version:" + myResource.getVersion();

    }

}
