package com.sky.nacosdemoprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class NacosDemoProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoProvider2Application.class, args);
    }


    @RequestMapping("/sayHi2")
    public String test(String name){
        return "provider2 :" + name;
    }

}
