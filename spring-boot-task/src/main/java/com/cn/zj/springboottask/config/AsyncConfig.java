package com.cn.zj.springboottask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义一个线程池
 *
 * 几种常见的线程池
 *      1.
 *      2.
 *      3.
 *      4.
 *      5.
 *
 *
 * 线程池的7个参数以及四个回收策略 回顾一下
 *    7大参数
 *      1.核心线程数
 *      2.最大线程数
 *      3.核心线程之外的线程存活时间
 *      4.时间单位
 *      5.队列
 *      6.工厂
 *      7.拒绝策略
 *    4个拒绝策略
 *      1.抛异常  2.将任务退回给调用者 3.丢弃等待时间最长的  4.直接丢弃
 *    线程池的执行原理： 核心线程  ——》 队列  -->核心线程与最大线程之间的线程  ---》拒绝策略
 *
 *
 * @author zjdking
 * 2020/5/19 0019.
 * @version 1.0
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("taskExecutor")
    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程
        executor.setCorePoolSize(5);
        // 最大线程数
        executor.setMaxPoolSize(20);
        // 队列中存储
        executor.setQueueCapacity(100);
        // 存活时间
        executor.setKeepAliveSeconds(60);
        // 线程池的前缀
        executor.setThreadNamePrefix("taskOperationExecutor--");
        //
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}
