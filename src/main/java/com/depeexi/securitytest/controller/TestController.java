package com.depeexi.securitytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("demo")
public class TestController {

    public TestController(){
        System.out.println("a");
    }

    @Resource
    UserDetailsService userDetailsService;

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        System.out.println(userDetailsService);
        return "hello world";
    }
}
