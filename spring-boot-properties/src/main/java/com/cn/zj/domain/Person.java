package com.cn.zj.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
}
