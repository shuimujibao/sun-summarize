package linkedlist;

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
			.addNextNode(5)
			.build();

		LinkNodePrint.printlnListNode("反转前:", head);

		ListNode listNode = ReverseList.reverseListRecursion(head, 1);

		LinkNodePrint.printlnListNode("反转后:", listNode);
	}

	/**
	 * 反转以 head 为起点的但链表
	 * 头插法
	 * <p>
	 * 参数说明：cur 是当前遍历的节点，pre 是 cur 的前驱结点，nxt 是 cur 的后继结点
	 * pre->cur->nxt
	 * </p>
	 * 遍历过程  1->2->3->4
	 * ===========================================================================
	 * 第1次进入链表:pre=null
	 * 第1次进入链表:cur=  1-->2-->3-->4
	 * 第1次进入链表:nxt=  2-->3-->4
	 * <p>
	 * * 第1次进入链表，当前节点后继节点变成前驱节点:cur=  1->null    ---> cur.next = pre;
	 * * 第1次进入链表，前驱节点变成当前节点：pre=  1->null          ---> pre = cur;
	 * * 第1次进入链表，当前节点变成后继节点:cur=  2-->3-->4         ---> cur = nxt
	 * ===========================================================================
	 * 第2次进入链表:pre=  1
	 * 第2次进入链表:cur=  2-->3-->4
	 * 第2次进入链表:nxt=  3-->4
	 * <p>
	 * * 第2次进入链表，当前节点后继节点变成前驱节点:cur=  2-->1      ---> cur.next = pre;
	 * * 第2次进入链表，前驱节点变成当前节点：pre=  2-->1            ---> pre = cur;
	 * * 第2次进入链表，当前节点变成后继节点:cur=  3-->4             ---> cur = nxt
	 * ===========================================================================
	 * 第3次进入链表:pre=  2-->1
	 * 第3次进入链表:cur=  3-->4
	 * 第3次进入链表:nxt=  4
	 * * 第3次进入链表，当前节点后继节点变成前驱节点:cur=  3-->2-->1
	 * * 第3次进入链表，前驱节点变成当前节点：pre=  3-->2-->1
	 * * 第3次进入链表，当前节点变成后继节点:cur=  4
	 * ===========================================================================
	 * 第4次进入链表:pre=  3-->2-->1
	 * 第4次进入链表:cur=  4
	 * 第4次进入链表:nxt=
	 * <p>
	 * * 第4次进入链表，当前节点后继节点变成前驱节点:cur=  4-->3-->2-->1
	 * * 第4次进入链表，前驱节点变成当前节点：pre=  4-->3-->2-->1
	 * * 第4次进入链表，当前节点变成后继节点:cur=
	 *
	 * @param head 头节点
	 * @return ListNode
	 */
	public static ListNode reverseListErgodic(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 由于单链表的结构，至少要用三个指针才能完成迭代反转
		// cur 是当前遍历的节点，pre 是 cur 的前驱结点，nxt 是 cur 的后继结点
		ListNode pre, cur, nxt;
		pre = null;
		cur = head;
		nxt = head.next;
		while (cur != null) {
			// 逐个结点反转
			cur.next = pre;
			// 更新指针位置
			pre = cur;
			cur = nxt;
			if (nxt != null) {
				nxt = nxt.next;
			}
		}
		// 返回反转后的头结点
		return pre;
	}

	/**
	 * 递归方式 反转链表
	 * <p>
	 * ================================================================================================================
	 * =============================================子问题从内向外出栈============================================================
	 * ================================================================================================================
	 * <p>
	 * 第4次递归前,head= 4-->5 （递归中止条件 Objects.isNull(head.next)）
	 * 第4次递归后,head= 4-->5
	 * 第4次递归后,lastNode= 5
	 * head.next.next = head ===>4->5->4
	 * head.next = null      ===> 5->4
	 * 此时lastNode = 5->4
	 * <p>
	 * 第3次递归前,head= 3-->4-->5
	 * 第3次递归后,head= 3-->4
	 * 第3次递归后,lastNode= 5-->4
	 * head.next.next = head ===> 3-->4-->3
	 * head.next = null      ===> 4-->3
	 * 此时lastNode = 5-->4-->3
	 * <p>
	 * 第2次递归前,head= 2-->3-->4-->5
	 * 第2次递归后,head= 2-->3
	 * 第2次递归后,lastNode= 5-->4-->3
	 * <p>
	 * 第1次递归前,head= 1-->2-->3-->4-->5
	 * 第1次递归后,head= 1-->2
	 * 第1次递归后,lastNode= 5-->4-->3-->2
	 * <p>
	 * ================================================================================================================
	 * =============================================宏观角度============================================================
	 * ================================================================================================================
	 * <p>
	 * 第2次递归前,head= 2-->3  ========> 第2次递归后,head= 2-->3,lastNode= 3 ====> head.next.next 2->3->2 head.next =null  lastNode=3->2
	 * </p>
	 * 第1次递归前,head= 1-->reverseListRecursion(2-->3) ========>
	 * 第1次递归后,head= 1-->2,lastNode= 3-->2
	 * ====> head.next.next 1->2->1 ; head.next = 2->1 ;lastNode= 3-->2->1
	 *
	 * @param head 头节点
	 * @return ListNode
	 */
	public static ListNode reverseListRecursion(ListNode head, int times) {

		// 递归中止条件
		if (Objects.isNull(head.next)) {
			return head;
		}

		// 当前节点的下一个节点
		LinkNodePrint.printlnListNode("第" + times + "次递归前,head=", head);
		ListNode lastNode = reverseListRecursion(head.next, times + 1);
		LinkNodePrint.printlnListNode("第" + times + "次递归后,head=", head);
		LinkNodePrint.printlnListNode("第" + times + "次递归后,lastNode=", lastNode);
		head.next.next = head;
		head.next = null;
		return lastNode;
	}
}
