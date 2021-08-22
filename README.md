# 极客时间的成长笔记
极客时间Java训练营作业

###### [第一周作业](https://github.com/zerolbsony/geektime/blob/main/week1/作业.md)

###### [第二周作业](https://github.com/zerolbsony/geektime/blob/main/week2/作业.md)

###### [第三周作业](https://github.com/zerolbsony/geektime/blob/main/week3/作业.md)

###### [第四周作业](https://github.com/zerolbsony/geektime/blob/main/week4/作业.md)

###### [第五周作业](https://github.com/zerolbsony/geektime/blob/main/week5/作业.md)

###### [第六周作业](https://github.com/zerolbsony/geektime/blob/main/week6/作业.md)

###### [第七周作业](https://github.com/zerolbsony/geektime/blob/main/week7/作业.md)

###### [第八周作业](https://github.com/zerolbsony/geektime/blob/main/week8/作业.md)

###### [第九周作业]@todo

###### [第十周作业]@todo

###### [第十一周作业](https://github.com/zerolbsony/geektime/blob/main/week11/作业.md)

###### [第十二周作业](https://github.com/zerolbsony/geektime/blob/main/week12/作业.md)

###### 毕业项目
1、(必做)分别用 100 个字以上的一段话，加上一幅图 (架构图或脑图)，总结自己对下列技术的关键点思考和经验认识:
1)JVM
```markdown
  jvm是java虚拟机，它提供了一套编译的字节码运行环境，不同的jvm内存结构，存储的不同类型的数据。jvm提供了几种GC算法，常见的如:cms、G1。
  jvm在多线程场景下，要注意它的语义和内存模型，volatile解决指令重排序，是由于jvm指令封装了对字节码操作的判断，触发对STOR、LOAD语义的执行。
  相关图片：
  img/jvm各区域存储内容.webp
  img/jvm知识图谱.png
  img/jvm运行机制.webp
  img/jvm内存模型.png
```

2)NIO
```markdown
  在NIO之前，需要借助操作系统提供的网络IO模型select或epoll来实现。原有的IO是面向流的、阻塞的，NIO则是面向块的、非阻塞的。
```

3)并发编程
```markdown
  java借助多线程库可以解决多任务同步执行的问题。多线程可以借助线程类、线程池、JUC库、异步Future等方式结合场景来灵活使用。
  在线程安全方面，可以使用synchronized和juc提供的ReentrantLock。
```

4)Spring 和 ORM 等框架
```markdown
  spring实现了mvc，提升了整个项目开发的开发速度。推出的spring boot解决了多个服务的独立部署，spring cloud提供了微服务体系下的各种主流技术实现。
  orm框架主要以mybatis为主，提供了java类和sql语句之间的映射。
```

5)MySQL 数据库和 SQL
```markdown
  mysql是OLTP场景下流行的数据库，支持ACID，完善的隔离级别和MVCC机制保证了不同场景下的数据一致性要求。
  mysql的innodb引擎适合写多读少的场景，isam引擎适合读多写少场景。
```

6)分库分表
```markdown
  分表解决了单表查询性能问题，分库解决了两个问题：垂直拆分（使得高并发业务用单独的库维护互不影响）；水平拆分（数据量大的库可以进一步拆分成多库解决查询性能瓶颈）。
  当磁盘IO读写压力大时，分库比分表好。分库可以将数据分散到不同的数据库实例，使用不同的磁盘，可以提高整个集群的并行数据处理能力。
  分表的方法按分配策略常见的可以分为：hash取模、按主键的范围（如0～100万、100万～200万）。分库一般分为：按业务划分、按机器负载划分。
  shardingsphere-jdbc提供了丰富的路由分配策略可以灵活定义分库分表的划分策略。
```

7)RPC 和微服务
```markdown
  RPC（远程过程调用）允许调用另一个地址空间的函数，隐藏了网络通信的具体实现，可以像调用本地函数一样调用远程函数获得返回结果。微服务相比RPC
增加了业务语义，偏向于基于业务提供独立的服务。
  微服务提供了分布式服务化，每个微服务可以定义服务名称，通过注册中心提供服务注册、发现，使微服务之间可以使用服务名+接口地址的方式点对点通信。
配置中心集中化远程存储微服务的各项业务或代码参数配置，可以使得在多个微服务间共享配置。
  Spring Cloud框架给java微服务生态提供了网关及路由、负载均衡、熔断等技术。feign集成了ribbon实现了客户端http接口调用和负载均衡，通过
低代码实现了接口调用。熔断和降级使用hstrix配置，流控方面可以使用阿里的Sentinel。
  微服务治理可以借助skywalking做链路追踪和Prometheus等。
```

8)分布式缓存
```markdown
  分布式缓存目前主流是redis，像搜索领域也会用到mongo（因为mongo中存储的文档适合检索）。java jdk推荐使用jedis，分布式锁可以用redission，
mongo可以使用MongoTemplate。
  redis常用的结构为string、list、set、zset、hash，在实际使用中redis缓存用于两种场景：数据缓存和锁。前者用于减少每次查数据库，后者用于高并发
时解决请求无法保证顺序性而造成数据不一致。
  redis缓存使用时要考虑缓存失效以及缓存内存占用问题，前者是要熟悉缓存穿透、缓存击穿、缓存雪崩时应对方案，后者是要从运维角度熟悉redis（如LRU、
info memory查看内存占用）。这里可以结合自身业务情况配置maxmemory-samples【样本数】来达到LRU功能的性能和精确双平衡。
  redis支持单机、主从、哨兵、集群模式，其中哨兵和集群模式实现了高可用，集群增加了数据分片功能，可以达到分散存储的目的，同时其slot的特性方便了
扩容和缩容。
  相关图片见：
  img/redis cluster架构图
  img/redis lru.webp
  img/redis slot.png
  img/redis slot迁移.png
```

9)分布式消息队列
```markdown
  每个系统依据硬件配置和网络环境配置，有固定的吞吐量。消息队列主要解决多个系统之间存在上下游依赖关系时，产生的请求等待及积压问题。
  以kafka为主的分布式消息队列相比传统的单机消息队列引入了多副本复制，选举实现高可用，提供多种ACK机制应对多种场景，允许重复消费，及支持事务高级特性，
同时使用有序存储的方式实现了对日志的高速读写，完备的多副本与主副本的同步方案解决数据一致性问题（HW和LEO）。
  尤其在OLAP场景ETL方面非常注重消息消费可以精确一次，kafka通过幂等性和事务来实现。前者能解决单分区的幂等及单个会话内的幂等（不允许宕机），后者是解决宕机情况下的幂等。
  在OLTP场景下，主要应用在异步化的系统之间的消息生产和订阅，一般高并发场景下系统同步调用想快速执行完成复杂业务逻辑并返回结果是不太现实的，只有靠队列+
异步消费处理的方式来完成。
  高并发场景下要利用好多分区和分区分配策略来最大化并行生产和消费消息，如果需要消息有序，需要依据分区内有序还是全分区有序来具体设计。producer端可以使用
官方自带的hash或自定义分区策略方式，consumer端可以使用consumer group官方实现三种消费策略。官方的rebalance机制可以很好应对节点故障的问题，实现分区再分配。
  kafka java jdk分：kafka-clients、spring-kafka、spring-streams。推荐第二种。
  相关图片见：
  img/kafka架构图.png
  img/kafka生产消费.png
  img/kafka高低水位.png
```
