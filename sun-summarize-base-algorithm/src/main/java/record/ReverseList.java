package record;

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

import java.util.Objects;

/**
 * @description: 反转链表
 * @author: xy.sun06
 * @create: 2024-05-17 10:20
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class ReverseList {

	public static void main(String[] args) {
		ListNode head = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4)
			.build();

		LinkNodePrint.printlnListNode("反转前:", head);

		ListNode listNode = ReverseList.reverseListRecursion(head);

		LinkNodePrint.printlnListNode("反转后:", listNode);
	}

	/**
	 * 遍历方式 反转链表
	 * 头插法
	 *
	 * @param head 头节点
	 * @return ListNode
	 */
	public static ListNode reverseListErgodic(ListNode head) {

		ListNode cur = head;

		ListNode pre = null;

		while (cur != null) {

			// 记录当前节点之后的节点，用于继续遍历
			ListNode temp = cur.next;

			// 当前节点的下一个节点，指向前一个节点
			cur.next = pre;

			pre = cur;

			// 继续遍历
			cur = temp;
		}

		return pre;
	}

	/**
	 * 递归方式 反转链表
	 *
	 * @param head 头节点
	 * @return ListNode
	 */
	public static ListNode reverseListRecursion(ListNode head) {

		// 递归中止条件
		if (Objects.isNull(head.next)) {
			return head;
		}

		// 当前节点的下一个节点
		ListNode lastNode = reverseListRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return lastNode;
	}
}
