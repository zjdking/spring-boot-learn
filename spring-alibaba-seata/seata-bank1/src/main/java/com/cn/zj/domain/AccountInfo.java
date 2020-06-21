package com.cn.zj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zjdking
 * 2020/6/17 0017.
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {
    private int id ;
    private String accountName;
    private double accountBalance;
}
