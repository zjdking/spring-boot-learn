package com.cn.zj.springboottask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author zjdking
 * 2020/5/19 0019.
 * @version 1.0
 */
@Service
public class AsyncService {

    @Async
    public String test_task(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我爱中国";
    }

    @Async
    public Future<String> test_return(String str){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(str);
    }
}
