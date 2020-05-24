package com.cn.zj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable{
    private static final long serialVersionUID = -6099455313880218162L;
    private int id;
    private String deptName;
    private String deptNo;
}
