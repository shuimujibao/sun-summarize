### 一、jvm调优的参数
### 二、cms、G1、Zgc垃圾回收器
### 三、JDK17、JDK9、JDK8增加了哪些新特性
### 四、欠款追缴的设计
### 五、多线程相关知识有哪些
### 六、CAS的过程
### 七、AQS流转过程
### 八、重量级锁的升级过程
### 九、贝壳的项目
### 十、好未来的项目
### 十一、rocketmq实现原理
### 十二、rockerMq事物
### 十三、死信队列的作用
### 十四、mysql索引

数据库结构
`表：products(产品)
product_id(INT, 主键)
product_name(VARCHAR)
category(VARCHAR)
price(DECIMAL)
`
`表：customers(客户)
customer_id(INT, 主键)
first_name(VARCHAR)
last_name(VARCHAR)
email(VARCHAR)`

`表：orders(订单)
order_id(INT, 主键)
customer_id(INT)
order_date(DATE)`

`表：order_items(订单明细)
order_item_id(INT, 主键)
order_id(INT)
product_id(INT)
quantity(INT)
price(DECIMAL)`

`SELECT o.order_id, o.order_date, p.product_name, oi.quantity, oi.price
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id
WHERE o.customer_id = 1;`


`orders left join orders.order_id = order_items.order_id
left join  order_items.product_id =products.product_id`

`orders(订单)
idx_customerId_orderId_orderDate
order_items(订单明细)
idx_product_id
idx_orderId_productId_quantityPrice
products(产品)
idx_productId_productName`

执行计划：
rows 到底走了多少行找的数据
type 看联表
const
ref
extra:


