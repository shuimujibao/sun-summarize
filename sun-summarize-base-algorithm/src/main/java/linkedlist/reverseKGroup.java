package linkedlist;

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

import java.util.Objects;

/**
 * @description: k个一组反转链表
 * @author: xy.sun06
 * @create: 2024-08-24 18:51
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class reverseKGroup {
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

		reverseKGroup reverseN = new reverseKGroup();

		ListNode listNode = reverseN.reverseKGroupMain(head, 2);

		LinkNodePrint.printlnListNode("反转后:", listNode);
	}

	public ListNode reverseKGroupMain(ListNode head, int k) {

		if (head == null) return null;

		// 区间 [a, b) 包含 k 个待反转元素
		ListNode a, b;
		a = b = head;

		for (int i = 0; i < k; i++) {
			// 不足 k 个，不需要反转了
			if (b == null) return head;
			b = b.next;
		}
		// 反转前 k 个元素
		ListNode newHead = reverseN(a, k);

		// 此时 b 指向下一组待反转的头结点
		// 递归反转后续链表并连接起来
		a.next = reverseKGroupMain(b, k);

		return newHead;
	}

	/**
	 * 反转链表前n个节点
	 *
	 * @param head 头节点
	 * @param n    个数
	 * @return ListNode
	 */
	private ListNode reverseN(ListNode head, int n) {
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


}
