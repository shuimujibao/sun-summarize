package xiaomi.second;

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

/**
 * @description: 题目描述
 * 链表右移k个元素，移出的元素放到链表头部
 * 实例:
 * 输入:1->2->3->4->5  k = 3
 * 输出:3->4->5->1->2
 * @author: xy.sun06
 * @create: 2024-08-23 21:03
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class WriteExam {

	public static void main(String[] args) {
		ListNode head = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4)
			.addNextNode(5)
			.build();

		WriteExam writeExam = new WriteExam();

		LinkNodePrint.printlnListNode("翻转前：",head);

		ListNode listNode = writeExam.reverseKGroup(head, 3);

		LinkNodePrint.printlnListNode("翻转后：",listNode);


	}

	public ListNode reverseKGroup(ListNode head, int k) {

		// 反转整个链表 5->4->3->2->1
		ListNode newHead = reverse(head, null);

		// 反转0~k  3->4->5->2->1
		ListNode headK = newHead;
		while (k > 0) {
			headK = headK.next;
			k--;
		}
		ListNode newHeadK = reverse(newHead, headK);

		// 反转k+1~最后 3->4->5->1->2
		ListNode newHeadLast = reverse(headK, null);

        // 组装数据
		ListNode dummy = newHeadK;
		while (newHeadK.next != null){
			newHeadK =newHeadK.next;
		}

		newHeadK.setNext(newHeadLast);
		return dummy;
	}

	// 反转区间 [a, b) 的元素，注意是左闭右开
	ListNode reverse(ListNode a, ListNode b) {
		ListNode pre;
		ListNode cur;
		ListNode next;

		pre = null;
		cur = a;
		// while 终止的条件改一下就行了
		while (cur != b) {
			// 记录当前节点下一个节点
			next = cur.next;

			cur.next = pre;
			pre = cur;

			// 下一个节点变成当前节点
			cur = next;
		}
		// 返回反转后的头结点
		return pre;
	}
}
