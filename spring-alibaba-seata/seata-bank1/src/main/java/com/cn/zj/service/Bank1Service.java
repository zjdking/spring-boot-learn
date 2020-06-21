package com.cn.zj.service;

import com.cn.zj.client.SeataBank2Client;
import com.cn.zj.dao.AccountInfoDao;
import com.cn.zj.domain.AccountInfo;
import com.cn.zj.dto.AccountInfoDTO;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zjdking
 * 2020/6/17 0017.
 * @version 1.0
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Bank1Service {
    private final AccountInfoDao accountInfoDao;
    private final SeataBank2Client seataBank2Client;
    public void updateAccount(AccountInfo accountInfo){
        accountInfoDao.update(accountInfo);
    }

//    @GlobalTransactional(name="bank1-service",rollbackFor = Exception.class)
@GlobalTransactional
@Transactional(rollbackFor = Exception.class)

    public void updateBank2(AccountInfo accountInfo){
        accountInfoDao.update(accountInfo);
        seataBank2Client.updateAccount(new AccountInfoDTO(3,"dk",accountInfo.getAccountBalance()));
        System.out.println(1/0);


    }
}
