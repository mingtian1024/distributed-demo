package com.sky.gatewaydemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gateway")
public class GatewayController {

    @RequestMapping("test")
    public String test(String name){
        return "Hello,gateway  " + name;
    }
}
