package com.cn.zj.controller;

import com.cn.zj.dto.AccountInfoDTO;
import com.cn.zj.service.Bank2Service;
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
public class Bank2Controller {
    @Autowired
    Bank2Service bank2Service;
    @PostMapping("/test2")
    public void updateAccount(@RequestBody AccountInfoDTO accountInfo){
        bank2Service.updateAccount(accountInfo);
    }
}
