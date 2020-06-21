package com.cn.zj.service;

import com.cn.zj.dao.AccountInfoDao;
import com.cn.zj.dto.AccountInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zjdking
 * 2020/6/17 0017.
 * @version 1.0
 */
@Service
public class Bank2Service {
    @Autowired
    AccountInfoDao accountInfoDao;
    @Transactional
    public void updateAccount(AccountInfoDTO accountInfo){
        accountInfoDao.update(accountInfo);
    }
}
