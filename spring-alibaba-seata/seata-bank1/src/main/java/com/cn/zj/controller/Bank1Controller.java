package com.cn.zj.controller;

import com.cn.zj.domain.AccountInfo;
import com.cn.zj.service.Bank1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjdking
 * 2020/6/17 0017.
 * @version 1.0
 */
@RestController
public class Bank1Controller {

    @Autowired
    Bank1Service bank1Service;
    @PostMapping("/test")
    public void updateAccount(@RequestBody AccountInfo accountInfo){
        bank1Service.updateAccount(accountInfo);
    }
    @PostMapping("/test1")
    public void updateBank2(@RequestBody AccountInfo accountInfo){
        bank1Service.updateBank2(accountInfo);
    }
}
