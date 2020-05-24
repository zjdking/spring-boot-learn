package com.cn.zj.service;

import com.cn.zj.dao.DeptDao;
import com.cn.zj.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zjdking
 * 2020/5/23 0023.
 * @version 1.0
 */
@Service
public class CacheService {
    @Autowired
    private DeptDao deptDao;

    /**
     * cacheProvicer --》 cacheManage  ==> cache
     *
     * 缓存参数  cacheNames 缓存的名称
     *          key 缓存的key   默认就是方法的参数
     *          cacheManager 缓存管理
     *          condition 满足条件才缓存
     *
     * 本地缓存==》 memcached==》 redis
     * 缓存的原理: 肯定会有一个个自动配置类 CacheAutoConfiguration
     *           ==》CacheConfigurationImportSelector 导入缓存中需要的组件
     *           想容器中注入了10种缓存组件，默认是org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
     *           SimpleCacheConfiguration 给容器中注册一个  ConcurrentMapCacheManager组件
     *           这个组件作用是？ 获取缓存getCache 和创建缓存createConcurrentMapCache
     *           缓存存在 ConcurrentMap  中；
     * 在启动执行的时候首先判断是否有缓存，如果有就从缓存中那
     *
     *
     * @param id
     * @return
     */
    @Cacheable(value = "dept")
    public Dept getDetp(int id){
        return deptDao.findById(id);
    }


    /**
     * cachePut 既调用方法，有更新缓存； 这个方法执行是在方法动用后执行的
     * 在使用的时候注意的是key，缓存在更新的时候是靠着key进行更新的
     *
     */
    @CachePut(value = "dept",key = "#dept.id")
    public void updateDept(Dept dept){
        deptDao.update(dept);
    }
    /**
     * cacheEvict  删除缓存
     * 他也是更具key 进行删除的
     * 具体参数看代码，参数中有可以删除所有缓存的allEntries=true
     * 还可以确定清除动作在执行方法的前后执行；
     */
    @CacheEvict(value = "dept",key = "#id")
    public void delete(int id){
        System.out.println("已被删除");
    }

    /**
     * @caching组合注解 put Evict cacheable
     * @CacheConfig 书写公共配置
     */

}
