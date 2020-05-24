package com.cn.zj;

import com.cn.zj.dao.DeptDao;
import com.cn.zj.domain.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zjdking
 * 2020/5/24 0024.
 * @version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    // 操作对象的 kv 都是对象
    @Autowired
    RedisTemplate redisTemplate;
    // 操作字符串的  kv都是字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    DeptDao deptDao;
    @Test
    public void test_stringRedisTemplate_(){
        stringRedisTemplate.opsForValue().set("k1","zjdking");
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        System.out.println(k1);
    }
    @Test
    public void test_redisTemplet_(){
        Dept dept = deptDao.findById(1);
        redisTemplate.opsForValue().set("dept-2", dept);
        Object o = redisTemplate.opsForValue().get("dept-2");
        System.out.println(o);
    }
}
