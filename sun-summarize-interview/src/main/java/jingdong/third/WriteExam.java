package jingdong.third;

import cn.hutool.core.collection.ListUtil;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 切割 list
 * @author: xy.sun06
 * @create: 2024-04-29 10:08
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExam {
	private static final List<String> OLD_LIST = Arrays.asList(
		"唐僧,悟空,八戒,沙僧,曹操,刘备,孙权".split(","));

	private static final List<Integer> OLD_LIST2 = Arrays.asList(
		1, 2, 3, 4, 5, 6);


	public static void main(String[] args) {
		// 集合分片-Guava
		List<List<String>> newList = Lists.partition(OLD_LIST, 3);
		newList.forEach(i -> System.out.println("集合长度：" + i.size()));

		// 集合分片-ApacheCommons
		List<List<String>> newList2 = ListUtils.partition(OLD_LIST, 3);
		newList2.forEach(i -> {
			System.out.println("集合长度：" + i.size());
		});

		// 分片处理-Hutool
		List<List<String>> newList3 = ListUtil.partition(OLD_LIST, 3);
		newList3.forEach(i -> {
			System.out.println("集合长度：" + i.size());
		});

		// 集合分片：将大于 3 和小于等于 3 的数据分别分为两组
		Map<Boolean, List<Integer>> newMap = OLD_LIST2.stream().collect(
			Collectors.partitioningBy(i -> i > 3)
		);

		// 打印结果
		System.out.println(newMap);
	}
}
