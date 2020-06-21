package com.cn.zj.springboottask.controller;

import com.cn.zj.springboottask.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zjdking
 * 2020/5/19 0019.
 * @version 1.0
 */
@RestController
@RequestMapping("/zjdking")
public class AsynController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String get(){
        String s = asyncService.test_task();

        return "success";
    }


    @RequestMapping("/return")
    public String getReturn(){
        long start = System.currentTimeMillis();
        Future<String> s = asyncService.test_return("我爱");
        Future<String> s1 = asyncService.test_return("中国");
        String s2 = null;
        String s3 = null;
        try {
            s2 = s.get();
            s3 = s1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        return "success"+(end-start)+s2+s3;
    }
}
