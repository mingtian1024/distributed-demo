package com.sky.nacosdemoprovider1;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.sky.api.system.User;
import com.sky.nacosdemoprovider1.entity.AppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@RefreshScope // 实时刷新配置变化
@RestController
@EnableConfigurationProperties(AppEntity.class)
public class MyController {

//    @Value("${app.name}")
    private String appName;

//    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private AppEntity app;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @PostConstruct
    public void init(){
        System.out.printf("[init] name: %s     version: %s\n ",appName,appVersion);
    }

    @PreDestroy
    public void destroy(){
        System.out.printf("[destroy] name: %s     version: %s\n ",appName,appVersion);

    }


    @RequestMapping("/sayHi/{name}")
    public String say(@PathVariable String name){
        return "Hello , " + name;
    }

    @RequestMapping("/config/name")
    public String getConfig1( ){
        return "provider1   app-name: " + appName;
    }

    @RequestMapping("/config/version")
    public String getConfig2( ){
        return "provider1   app-version: " + appVersion;
    }

    @RequestMapping("/config")
    public String getConfig3( ){
        return "[HTTP] 配置详情" + app;
    }

    public User getUserByid(){
        User user = new User();
        return user;
    }

    // 主动监听配置变化
    @Bean
    public ApplicationRunner runner() {
        return args -> {
            String dataId = "nacos-demo-provider1.properties";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("[Listener] " + configInfo);
                }
            });
        };
    }

}
