package com.cn.zj.controller;

import com.cn.zj.domain.Dept;
import com.cn.zj.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;


    @RequestMapping("/getDept")
    public Dept getDept(@RequestParam int id){
        Dept detp = cacheService.getDetp(id);
        return detp;
    }

    @PostMapping("/updateDept")
    public String updateDept(@RequestBody Dept dept){
        cacheService.updateDept(dept);
        return "success";
    }

    @DeleteMapping("/del/{id}")
    public String deleteCache(@PathVariable  int id){
        cacheService.delete(id);
        return "success";
    }

}
