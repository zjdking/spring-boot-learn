package com.cn.zj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zjdking
 * 2020/6/17 0017.
 * @version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfoDTO implements Serializable {
    private int id ;
    private String accountName;
    private double accountBalance;
}
