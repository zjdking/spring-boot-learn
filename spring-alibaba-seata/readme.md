对于GlobalTransactional注解他是通过使用  自动装配和aop 实现的；
我们引入alibaba-seata 包在他的mata-info 下边的spring.factories； 注入了com.alibaba.cloud.seata.GlobalTransactionAutoConfiguration
在GlobalTransactionAutoConfiguration 
    1.如果没有配置seata的分组 默认是服务名称+seata-service-group
    2.给容器注入一个GlobalTransactionScanner 组件
        这个组件extends AbstractAutoProxyCreator  implements InitializingBean, ApplicationContextAware,DisposableBean
        AbstractAutoProxyCreator（生成一个代理类） 是aop事务源码的顶级父类；   InitializingBean初始化类(初始化rm tm)； 
        ApplicationContextAware为了使用appicationContext中的bean; 他的作用就是覆盖原有的spring的配置文件
    3.在GlobalTransactionScanner 会尽心个判断是否添加GlobalTransactional注解 / GlobalLock注解    
SPI 是一种服务发现机制；service provider interface ;他会去找classpath 下的meta-inf/services 下的类；    
       
                                                  





##seata 配置
1.修改conf 文件   
  vgroup_mapping.my_test_tx_group = "bank_tx_group"   后边的服务器组需要与我们工程中file.conf的匹配对应;
(工程下边需要添加file,registry file中需要修改对应的vgroup_mapping.bank_tx_group = "xxx")  
修改 store--》 mode  改成db;
紧接着修改db 对应的数据库配置；
2.修改registry.conf
type 改成nacos   并修改对应nacos 配置；

4.创建数据库；对应你配置的sql   创建的表在db_store.sql
5.对于每个业务下边都需要创建一个undo_log

底层原理通过自动装配 + aop 方式实现
使用netty 保证性能

-----------------------

seata-server中注册中心为nacos,下面不再提及
---

seata使用db模式为高可用模式，全局事务会话信息通过db共享，相应性能差些
通过以下的修改,启动多个seata-server,即可实现其高可用

---

服务端部分配置文件修改

1.修改file.conf文件
    将store修改成为db;修改下方db{}内的url,username,password和driver
	这里使用到oracle的话,需要在seata中lib目录内 将oracl.jar放进去

2.修改registry.conf
    修改registry的type为nacos;config的type也修改成为nacos

3.修改nacos-config.txt
	service.vgroup_mapping.**微服务名称**-fescar-service-group=default
	这一块有多少个微服务,就写多少个相应的配置信息;
	在下方的store.xx这块和file.conf里面的配置文件同理,修改url,username,password和driver

4.在config目录执行 
    sh nacos-config.sh 127.0.0.1 (127.0.0.1是nacos的地址)
	windows电脑使用git提供的命令行工具也可使用
	这一步的目的是将seata的配置信息写入到nacos当中

5.将seata的db模式的sql导入到所连接库当中,sql在最后可查看

---

客户端部分配置文件修改

1.将服务端的file.conf和registry.conf都复制到项目的resource目录下

2.修改registry.conf
    将config的type修改成file

3.修改file.conf
	1) 将vgroup_mapping.**微服务名称** = "default"
	   ps:**微服务名称**在yml文件中进行配置
	2) 将default.grouplist = "seata.ip" 进行修改

4.修改每个微服务中yml文件,添加
	spring.cloud.alibaba.seata.tx-service-group= **微服务名称**



---

seata-server中sql

全局事务会话信息由3块内容构成，全局事务-->分支事务-->全局锁，对应表global_table、branch_table、lock_table

-- the table to store GlobalSession data

```

CREATE TABLE global_table
(
    xid                       VARCHAR2(128) NOT NULL,
    transaction_id            NUMBER(19),
    status                    NUMBER(3)     NOT NULL,
    application_id            VARCHAR2(32),
    transaction_service_group VARCHAR2(32),
    transaction_name          VARCHAR2(128),
    timeout                   NUMBER(10),
    begin_time                NUMBER(19),
    application_data          VARCHAR2(2000),
    gmt_create                TIMESTAMP(0),
    gmt_modified              TIMESTAMP(0),
    PRIMARY KEY (xid)
);

CREATE INDEX idx_gmt_modified_status ON global_table (gmt_modified, status);
CREATE INDEX idx_transaction_id ON global_table (transaction_id);

```

-- the table to store BranchSession data

```

CREATE TABLE branch_table
(
    branch_id         NUMBER(19)    NOT NULL,
    xid               VARCHAR2(128) NOT NULL,
    transaction_id    NUMBER(19),
    resource_group_id VARCHAR2(32),
    resource_id       VARCHAR2(256),
    branch_type       VARCHAR2(8),
    status            NUMBER(3),
    client_id         VARCHAR2(64),
    application_data  VARCHAR2(2000),
    gmt_create        TIMESTAMP(6),
    gmt_modified      TIMESTAMP(6),
    PRIMARY KEY (branch_id)
);

CREATE INDEX idx_xid ON branch_table (xid);

```

-- the table to store lock data

```

CREATE TABLE lock_table
(
    row_key        VARCHAR2(128) NOT NULL,
    xid            VARCHAR2(96),
    transaction_id NUMBER(19),
    branch_id      NUMBER(19)    NOT NULL,
    resource_id    VARCHAR2(256),
    table_name     VARCHAR2(32),
    pk             VARCHAR2(36),
    gmt_create     TIMESTAMP(0),
    gmt_modified   TIMESTAMP(0),
    PRIMARY KEY (row_key)
);

CREATE INDEX idx_branch_id ON lock_table (branch_id);

```
