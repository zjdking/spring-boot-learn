package com.cn.zj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zjdking
 * 2020/6/26 0026.
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lock {
    private String lockId;// 88
    private String path; //
    private boolean active;
    public Lock(String lockId,String path){
        this.lockId=lockId;
        this.path = path;
    }

}
