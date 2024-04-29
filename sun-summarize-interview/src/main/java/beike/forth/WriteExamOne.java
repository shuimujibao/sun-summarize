package beike.forth;

import structure.link.ListNode;

/**
 * WriteExamOne
 *
 * @summary 判断链表是否成环
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月24日 12:02:00
 */
public class WriteExamOne {

	public static void main(String[] args) {

	}

	/**
	 * 判断链表是否成环
	 *
	 * @param head 头节点
	 * @return
	 */
	private boolean isCircle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode low = head;
		ListNode fast = head.next;

		while (low != null && fast != null && fast.next != null) {
			if (low == fast) {
				return true;
			}
			low = low.next;
			fast = fast.next.next;
		}

		return false;
	}
}

