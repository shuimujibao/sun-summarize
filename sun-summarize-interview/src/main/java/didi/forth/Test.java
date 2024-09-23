package didi.forth;

import structure.link.ListNode;

/**
 * @description:
 * @author: xy.sun06
 * @create: 2024-09-03 14:32
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class Test {

	/**
	 * @param head1 1->2->3
	 * @param head2 2->3
	 * @return 1->4->6
	 */
	private ListNode add(ListNode head1, ListNode head2) {

		// 3->2->1
		ListNode head1New = revert(head1);

		// 3->2
		ListNode head2New = revert(head2);

		ListNode dummy = new ListNode(-1);
		ListNode totalHead = dummy;

		// 进位
		int curr = 0;

		while (head1New != null || head2New != null) {

			int val1 = head1New == null ? 0 : head1New.val;
			int val2 = head2New == null ? 0 : head2New.val;

			int res = (val1 + val2 + curr) % 10;
			curr = (val1 + val2 + curr) / 10;

			totalHead.val = res;

			totalHead = totalHead.next;

			head1New = head1New == null ? null : head1New.next;
			head2New = head2New == null ? null : head2New.next;
		}

		if (curr != 0) {
			totalHead.next.val = curr;
		}

		return revert(dummy);
	}

	private ListNode revert(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode lastNode = revert(head);

		head.next.next = head;

		head.next = null;

		return lastNode;
	}
}
