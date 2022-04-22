package structure.link;

import lombok.Data;

/**
 * ListNode
 *
 * @summary ListNode
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月21日 17:43:00
 */
@Data
public class ListNode {

	/**
	 * 当前节点值
	 */
	public int val;

	/**
	 * 下一个节点
	 */
	public ListNode next;

	/**
	 * 值构造器
	 *
	 * @param val 节点值
	 */
	ListNode(int val) {
		this.val = val;
	}

	/**
	 * 节点构造器
	 *
	 * @param val  当前节点值
	 * @param next 下一个节点值
	 */
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
