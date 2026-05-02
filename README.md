# cloud2020-alibaba-seata

基于 Seata AT 模式的分布式事务演示项目。

## 架构

```
seata-order-service2001 → 订单服务
seata-storage-service2002 → 库存服务
seata-account-service2003 → 账户服务
```

## 事务流程

用户下单 → 扣库存 → 扣余额 → 创建订单（原子提交/回滚）

其中账户余额不足时触发 Seata 全局回滚，三服务数据保持一致。

## 技术栈

- Spring Boot 2.2.2
- Spring Cloud Alibaba 2.2.0
- Seata 1.4.0（AT模式）
- MyBatis + MySQL
- Nacos 注册中心
- OpenFeign 远程调用

## 启动顺序

1. 启动 Nacos Server（注册中心）
2. 启动 Seata Server（TC事务协调器）
3. 启动 account-service（2003）
4. 启动 storage-service（2002）
5. 启动 order-service（2001）
6. 调用 `http://localhost:2001/order/create` 测试
