package com.sky.dubboconsumer1;

import com.alibaba.dubbo.config.annotation.Service;
import com.sky.dubbo.EchoService;

@Service
public class SimpleEchoService implements EchoService {
    @Override
    public String echo(String s) {
        return "[ECHO] " + s;
    }
}
