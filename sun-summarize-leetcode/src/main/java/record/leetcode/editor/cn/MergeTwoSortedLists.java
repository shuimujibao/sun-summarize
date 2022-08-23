package record.leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 2626 👎 0

import structure.link.LinkNodeManager;
import structure.link.ListNode;
import util.LinkListUtil;

public class MergeTwoSortedLists {
	public static void main(String[] args) {

		Solution solution = new MergeTwoSortedLists().new Solution();

		// 有序链表一
		ListNode list1 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(4)
			.build();

		LinkListUtil.printlnListNode("list1:", list1);

		// 有序链表二
		ListNode list2 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(3)
			.addNextNode(4)
			.build();

		LinkListUtil.printlnListNode("list1:", list2);

		// 发起链表合并
		ListNode result = solution.mergeTwoLists(list1, list2);

		// 输出合并后链表
		LinkListUtil.printlnListNode("合并后结果:", result);
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
		ListNode head = new ListNode(-1);

		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

			while (list1 != null || list2 != null) {
				if (list1 != null && list1.val <= list2.val) {
					insert(list1.val);
					list1 = list1.next;
				} else {
					insert(list2.val);
					list2 = list2.next;
				}
			}
			return head.next;
		}

		public void insert(int val) {
			//每次插入一条数据就要新建一个扣子
			ListNode listNode = new ListNode(val);
			if (head == null) {
				head = listNode;
				return;
			}
			ListNode tempNode = head;
			//循环到链表的末尾
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = listNode;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
}
