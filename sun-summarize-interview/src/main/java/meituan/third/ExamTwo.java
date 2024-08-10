package meituan.third;

/**
 * @description: sql
 * 姓名	课程	分数
 * 张三	语文	78
 * 张三	数学	65
 * 李四	语文	58
 * 李四	英语	88
 * 王五	数学	99
 * 题目：查询出所有课程都大于60分的学生的姓名,不能使用子查询或关联查询
 * <p>
 * =======
 * SELECT SID
 * FROM SCORE
 * GROUP BY SID
 * HAVING MIN(GRADE) > 60
 * ========
 * @author: xy.sun06
 * @create: 2024-08-09 21:25
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class ExamTwo {
}
