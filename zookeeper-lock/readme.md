1. ZooKeeper是什么？
2. ZooKeeper提供了什么？
3. Zookeeper文件系统
4. ZAB协议？
5. 四种类型的数据节点 Znode
6. Zookeeper Watcher 机制 -- 数据变更通知
7. 客户端注册Watcher实现
8. 服务端处理Watcher实现
9. 客户端回调Watcher
10. ACL权限控制机制
UGO（User/Group/Others）
ACL（Access Control List）访问控制列表
11. Chroot特性
12. 会话管理
13. 服务器角色
Leader
Follower
Observer
14. Zookeeper 下 Server工作状态
15. Leader 选举
16. 数据同步
直接差异化同步（DIFF同步）
先回滚再差异化同步（TRUNC+DIFF同步）
仅回滚同步（TRUNC同步）
全量同步（SNAP同步）
17. zookeeper是如何保证事务的顺序一致性的？
18. 分布式集群中为什么会有Master？
19. zk节点宕机如何处理？
20. zookeeper负载均衡和nginx负载均衡区别
21. Zookeeper有哪几种几种部署模式？
22. 集群最少要几台机器，集群规则是怎样的?
23. 集群支持动态添加机器吗？
24. Zookeeper对节点的watch监听通知是永久的吗？为什么不是永久的?
25. Zookeeper的java客户端都有哪些？
26. chubby是什么，和zookeeper比你怎么看？
27. 说几个zookeeper常用的命令。
28. ZAB和Paxos算法的联系与区别？
29. Zookeeper的典型应用场景
1. 数据发布/订阅
2. 负载均衡