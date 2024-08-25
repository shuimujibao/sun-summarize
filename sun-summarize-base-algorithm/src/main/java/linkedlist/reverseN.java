package linkedlist;

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

import java.util.Objects;

/**
 * @description: 反转链表前n个节点
 * @author: xy.sun06
 * @create: 2024-08-24 17:38
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class reverseN {

	public static void main(String[] args) {
		ListNode head = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4)
			.addNextNode(5)
			.addNextNode(6)
			.build();

		LinkNodePrint.printlnListNode("反转前:", head);

		reverseN reverseN = new reverseN();

		ListNode listNode = reverseN.reverseRecursion(head, 3);

		LinkNodePrint.printlnListNode("反转后:", listNode);
	}

	/**
	 * =================================================================================================================
	 * =================================================================================================================
	 * ==========================================迭代解法！！！！==========================================================
	 * ==========================================迭代解法！！！！==========================================================
	 * =================================================================================================================
	 */

	public static ListNode reverseListErgodic(ListNode head, int n) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = null;
		ListNode cur = head;
		ListNode next = head.next;

		while (n > 0) {

			cur.next = pre;

			pre = cur;
			cur = next;

			next = Objects.nonNull(next) ? next.next : null;

			n--;
		}

		// head 一直是1
		head.next = cur;

		return pre;
	}


	/**
	 * =================================================================================================================
	 * =================================================================================================================
	 * ==========================================递归解法！！！！==========================================================
	 * ==========================================递归解法！！！！==========================================================
	 * =================================================================================================================
	 */

	/**
	 * 将链表的前 n 个节点反转（n <= 链表长度）
	 *
	 * @param head 头节点
	 * @param n    终止节点数
	 * @return ListNode
	 */

	/**
	 * 后驱节点
	 */
	ListNode successor = null;

	private ListNode reverseRecursion(ListNode head, int n) {

		if (n == 1) {
			// 记录第 n + 1 个节点
			successor = head.next;
			return head;
		}

		ListNode lastNode = reverseRecursion(head.next, n - 1);

		head.next.next = head;

		head.next = successor;

		return lastNode;
	}
}
