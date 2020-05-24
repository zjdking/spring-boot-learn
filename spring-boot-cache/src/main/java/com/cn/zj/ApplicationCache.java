package com.cn.zj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@SpringBootApplication
@EnableCaching
public class ApplicationCache {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationCache.class,args);
    }
}
