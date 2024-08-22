package baidu.second;

import structure.link.ListNode;

/**
 * WriteExam
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @summary 反转单链表
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月24日 12:11:00
 */
public class WriteExam {
	public ListNode reverseList(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode pre = dummy.next;

		/**
		 * 1->2->3->4->5->NULL
		 * 2->1->3->4->5->NULL
		 * 3->2->1->4->5->NULL
		 * 3->2->1->4->5->NULL
		 */
		while (head != null) {

			ListNode temp = head.next;

			head = head.next;
		}

		return dummy.next;
	}
}
