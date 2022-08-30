package util;

import structure.link.ListNode;

/**
 * 链表工具类
 *
 * @summary LinkListUtil
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年08月23日 15:12:00
 */
public class LinkListUtil {

	/**
	 * 链表打印
	 *
	 * @param head 链表
	 */
	public static void printlnListNode(ListNode head) {
		print(head);
	}

	/**
	 * 带文案链表打印
	 *
	 * @param head 链表
	 */
	public static void printlnListNode(String explain, ListNode head) {
		System.out.print(explain + " ");
		print(head);
	}

	/**
	 * 输出
	 *
	 * @param head 链表
	 */
	private static void print(ListNode head) {
		while (head != null) {
			if (head.next == null) {
				System.out.print(head.val);
			} else {
				System.out.print(head.val + "-->");
			}
			head = head.next;
		}
		System.out.println("");
	}
}
