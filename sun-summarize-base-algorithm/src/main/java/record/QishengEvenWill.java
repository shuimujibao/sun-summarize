package record;

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

/**
 * @description: 对链表进行排序，奇升偶降
 * @author: xy.sun06
 * @create: 2024-03-25 14:36
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class QishengEvenWill {

	public static void main(String[] args) {

		ListNode head = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(8)
			.addNextNode(3)
			.addNextNode(6)
			.addNextNode(5)
			.addNextNode(4)
			.addNextNode(7)
			.addNextNode(2)
			.build();

		LinkNodePrint.printlnListNode("排序前链表", head);

		ListNode listNode = QishengEvenWill.sortByRule(head);

		LinkNodePrint.printlnListNode("排序后链表", listNode);
	}


	/**
	 * 对链表进行排序，奇升偶降
	 * <p>
	 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
	 * <p>
	 * 输入: 1->8->3->6->5->4->7->2->NULL
	 * 输出: 1->2->3->4->5->6->7->8->NULL
	 * <p>
	 * 思路：
	 * 1. 按奇偶位置拆分链表，得1->3->5->7->NULL和8->6->4->2->NULL
	 * 2. 反转偶链表，得1->3->5->7->NULL和2->4->6->8->NULL
	 * 3. 合并两个有序链表，得1->2->3->4->5->6->7->8->NULL
	 *
	 * @param head 头节点
	 * @return ListNode
	 */
	private static ListNode sortByRule(ListNode head) {
		// =========按奇偶位置拆分链表=========
		if (head == null || head.next == null) {
			return head;
		}

		ListNode oddHead = head;
		ListNode evenHead = head.next;
		ListNode evenTail = evenHead;

		while (evenTail.next != null && evenTail.next.next != null) {
			oddHead.next = oddHead.next.next;
			evenTail.next = evenTail.next.next;

			oddHead = oddHead.next;
			evenTail = evenTail.next;
		}

		LinkNodePrint.printlnListNode("oddHead", oddHead);
		LinkNodePrint.printlnListNode("evenHead", evenHead);
		LinkNodePrint.printlnListNode("head", head);
		// =========反转偶链表=========
		// =========合并两个有序链表=========

		return head;
	}

}
