package com.sky.nacosdemoconsumer1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {


    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/say")
    public String say(String name){
        return restTemplate.getForObject("http://nacos-demo-provider1/sayHi/" + name, String.class);

    }

    @RequestMapping("/say2")
    public String test2(String name){
        return restTemplate.getForObject("http://nacos-demo-provider2/sayHi2?name=" + name, String.class);

    }
}
