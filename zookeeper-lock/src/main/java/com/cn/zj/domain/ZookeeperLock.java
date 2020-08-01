package com.cn.zj.domain;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author zjdking
 * 2020/6/26 0026.
 * @version 1.0
 */
public class ZookeeperLock {

    //连接客户端
    private ZkClient zkclient;
    public ZookeeperLock(){
        zkclient = new ZkClient("139.9.95.160:2181",5000,20000);
    }



    // 获取锁
    public Lock lock(String lockId,long timeOut){
        createTemplate(lockId);
        return null;
    }

    // 激活锁
    public Lock tryActiveLock(Lock lock){
        return null;
    }
    // 释放锁
    public void unLock(Lock lock){

    }

    // 创建临时序号节点
    public Lock createTemplate(String lockId){
        zkclient.createEphemeralSequential(""+lockId,"w");
        return null;

    }

}
