package com.cn.zj.client;

import com.cn.zj.dto.AccountInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zjdking
 * 2020/6/17 0017.
 * @version 1.0
 */
@FeignClient(name = "bank2-service",url = "127.0.0.1:8002",path = "/")
public interface SeataBank2Client {
    @PostMapping("/test2")
    void updateAccount(@RequestBody AccountInfoDTO accountInfo);
}
