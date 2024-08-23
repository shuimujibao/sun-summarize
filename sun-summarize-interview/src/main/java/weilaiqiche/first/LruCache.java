package weilaiqiche.first;

import java.util.LinkedHashMap;

/**
 * 移除最近未使用
 *
 * @description: LRU
 * @author: xy.sun06
 * @create: 2024-08-22 17:18
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class LruCache {
	int cap;
	LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

	public LruCache(int capacity) {
		this.cap = capacity;
	}

	public int get(int key) {
		if (!cache.containsKey(key)) {
			return -1;
		}
		// 将 key 变为最近使用
		makeRecently(key);
		return cache.get(key);
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			// 修改 key 的值
			cache.put(key, value);
			// 将 key 变为最近使用
			makeRecently(key);
			return;
		}
		if (cache.size() >= this.cap) {
			// 链表头部就是最久未使用的 key
			int oldestKey = cache.keySet().iterator().next();
			cache.remove(oldestKey);
		}
		// 将新的 key 添加链表尾部
		cache.put(key, value);
	}

	private void makeRecently(int key) {
		int val = cache.get(key);
		// 删除 key，重新插入到队尾
		cache.remove(key);
		cache.put(key, val);
	}
}
