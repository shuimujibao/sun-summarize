package coupang.question;

/**
 * @description:
 * We have a metric count system. For a metric, it consists of two parts: metric name & pairs of <key, value>. For example:
 * a) metric1(k1=v1,k2=v2,k3=v3)
 * b) metric1(k1=vv1,k2=vv2,k3=vv3)
 * c) metric2(k1=v1,k2=v2,k3=v3)
 * all of the above metrics are different. Only metric with same metric name and pairs of <key, value> is same. Please design and implement a class for this problem.
 * <p>
 * Requirements:
 * 1). both of key value are String
 * 2). user can customize metric value, if not, the default value is 1
 * 3). metric count is Double.
 * 4). high throughput for concurrent
 * <p>
 * Input:
 * metric1, k1,v1,k2,v2,k3,v3, 1.0
 * metric1, k1,v1,k2,v2,k3,v3, 2.0
 * metric2, k1,v1,k2,v2,k3,v3
 * <p>
 * Output:
 * metric1(k1=v1,k2=v2,k3=v3) = 3.0
 * metric2(k1=v1,k2=v2,k3=v3) = 1.0
 * @author: xy.sun06
 * @create: 2024-09-05 09:35
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 *
 *
 * 10 多个调用 保证高吞吐量、数据一致性
 */
public class Test2 {



}
