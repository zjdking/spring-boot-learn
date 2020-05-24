package com.cn.zj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@RestController
@PropertySource("classpath:/test.yml")
public class PropertiesController {

    @Value("${zjdking}")
    private String  name;

    @RequestMapping("/test")
    public String get(){
        return name;
    }


}
