package com.example.demo.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements InitializingBean {

    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(){
        return "Welcome!";
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("HelloController is initialized");

    }
}
