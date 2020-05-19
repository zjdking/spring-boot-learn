package com.cn.zj.springboottask;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author zjdking
 * 2020/5/20 0020.
 * @version 1.0
 */
public class AsyncTest {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        // 自己手动创建线程池
        ExecutorService executor = new ThreadPoolExecutor(2,5,1,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(30),Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

        long start = System.currentTimeMillis();
        Callable<String> s1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return test1("我爱");
            }
        };

        Callable<String> s2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return test1("中国");
            }
        };
        Future<String> submit1 = executor.submit(s1);
        Future<String> submit2 = executor.submit(s2);
        String get1 = submit1.get();
        String get2 = submit2.get();
        long end = System.currentTimeMillis();
        System.out.println(end - start +get1+get2);

    }
    public String test1(String str){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }


}
