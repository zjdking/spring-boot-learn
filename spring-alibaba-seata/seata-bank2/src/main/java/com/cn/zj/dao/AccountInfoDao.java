package com.cn.zj.dao;

import com.cn.zj.dto.AccountInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author zjdking
 * 2020/6/17 0017.
 * @version 1.0
 */
@Mapper
public interface AccountInfoDao {
    @Update("update account_info set account_name =#{accountName} , account_balance = #{accountBalance}" +
            " where id =#{id}")
    int update(AccountInfoDTO accountInfo);
}
