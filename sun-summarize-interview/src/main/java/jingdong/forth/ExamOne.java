package jingdong.forth;

import lombok.Data;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @description: 根据输入字符串的频率进行排序 （不区分大小写）
 * @author: xy.sun06
 * @create: 2024-08-14 09:37
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class ExamOne {

	public static void main(String[] args) {
		String[] words = new String[]{"Hello", "world", "world", "Hello", "Java", "hello"};
		ExamOne test = new ExamOne();
		List<String> count = test.count(words);
		System.out.println(Arrays.asList(count));
	}

	/**
	 * 根据输入字符串的频率进行排序 （不区分大小写）
	 *
	 * @param words 输入数据源
	 * @return List<String>
	 */
	public List<String> count(String[] words) {
		// 排序后结果
		List<String> res = new ArrayList<>();

		// 统计每个字符串出现的频率
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			String curStr = words[i];
			String replace = curStr.toLowerCase();
			map.put(replace, map.getOrDefault(replace, 0) + 1);
		}

		// 遍历统计map，利用优先级队列进行排序
		Set<String> strings = map.keySet();
		SortModel sortModel;
		PriorityBlockingQueue<SortModel> sortQueue = new PriorityBlockingQueue<>
			(new TreeSet<>(new Comparator<SortModel>() {
				@Override
				public int compare(SortModel o1, SortModel o2) {
					return o2.getCurStrNums() - o1.getCurStrNums();
				}
			}));

		for (String str : strings) {
			sortModel = new SortModel();
			sortModel.setCurStr(str);
			sortModel.setCurStrNums(map.get(str));
			sortQueue.add(sortModel);
		}

		// 组装返回值
		while (!sortQueue.isEmpty()) {
			SortModel poll = sortQueue.poll();
			Integer curStrNums = poll.getCurStrNums();
			res.add(poll.curStr + curStrNums);
			curStrNums--;
		}
		return res;
	}

	/**
	 * 排序对象
	 */
	@Data
	public static class SortModel {
		/**
		 * 当前字符串
		 */
		String curStr;
		/**
		 * 当前字符串出现的频率
		 */
		Integer curStrNums;
	}
}
