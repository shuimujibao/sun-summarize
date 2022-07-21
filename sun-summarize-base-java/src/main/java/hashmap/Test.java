package hashmap;

import structure.link.ListNode;

import java.util.Arrays;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年07月20日 19:06:00
 */
public class Test {
	public static void main(String[] args) {

		// 数组
		int[] arr = new int[]{1, 2, 3};

		System.out.println(Arrays.toString(arr));


		System.out.println("=======================");

		// 链表
		ListNode listNode4 = new ListNode(4, null);
		ListNode listNode3 = new ListNode(3, listNode4);
		ListNode listNode2 = new ListNode(2, listNode3);
		ListNode listNode1 = new ListNode(1, listNode2);

		while (listNode1 != null) {
			System.out.print(listNode1.val + "-->");
			listNode1 = listNode1.next;
		}

		// 红黑树
	}
}
