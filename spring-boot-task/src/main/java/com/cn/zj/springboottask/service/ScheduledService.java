package com.cn.zj.springboottask.service;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 关于定时任务，就是两个注解和一个 cron表达式需要理解；
 * 具体的cron 属于api层面；可以百度
 * spring 的 Scheduled 是 一款轻量级的 Quartz
 *
 * spring 中的定时任务实际上使用的是 jdk自带的 scheduledExecutorService
 * 默认情况下是单线程的
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@Service
@PropertySource(value={"classpath:/taskScheduled.yml"})
public class ScheduledService {
    /**
     *  s m h d M  week
     * "0 * * * * MON-FRI"
     *
     */
    // 表示分钟执行一次； 也就是每周的0-7日中的每个0秒开始执行
//    @Scheduled(cron = "0 * * * * 0-7")
    @Scheduled(cron = "${zjdking}")
    public void scheduled(){
        System.out.println("zjdking");
    }

}
