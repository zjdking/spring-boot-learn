package com.cn.zj.controller;

import com.cn.zj.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {

    @Autowired
    private Person person;
    @Test
    public void test(){
        System.out.println(person.getName());
    }
}
