package record.leetcode.editor.cn;

//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,1,2]
//输出：[1,2]
//
//
// 示例 2：
//
//
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//
//
// Related Topics 链表 👍 1113 👎 0

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

		ListNode l1 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(1)
			.addNextNode(2)
			.build();

		LinkNodePrint.printlnListNode(l1);

		ListNode listNode = solution.deleteDuplicates(l1);

		LinkNodePrint.printlnListNode(listNode);
	}

//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			// 非空判断
			if (head == null) {
				return null;
			}

			// 记录头节点位置
			ListNode newHead = head;

			// 遍历链表，重复值直接跳过
			while (head.next != null) {
				if (head.val == head.next.val) {
					head.next = head.next.next;
				} else {
					head = head.next;
				}
			}

			return newHead;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
