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
import structure.link.LinkNodePrint;
import structure.link.ListNode;

public class MergeTwoSortedLists {
	public static void main(String[] args) {

		Solution solution = new MergeTwoSortedLists().new Solution();

		// 有序链表一
		ListNode list1 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(4)
			.build();

		LinkNodePrint.printlnListNode("list1:", list1);

		// 有序链表二
		ListNode list2 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(3)
			.addNextNode(4)
			.build();

		LinkNodePrint.printlnListNode("list1:", list2);

		// 发起链表合并
		ListNode result = solution.mergeTwoLists(list1, list2);

		// 输出合并后链表
		LinkNodePrint.printlnListNode("合并后结果:", result);
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

		public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
			// 虚拟头结点
			ListNode dummy = new ListNode(-1);
			ListNode p = dummy;

			while (p1 != null && p2 != null) {
				// 比较 p1 和 p2 两个指针
				// 将值较小的的节点接到 p 指针
				if (p1.val > p2.val) {
					p.next = p2;
					p2 = p2.next;
				} else {
					p.next = p1;
					p1 = p1.next;
				}
				// p 指针不断前进
				p = p.next;
			}

			if (p1 != null) {
				p.next = p1;
			}

			if (p2 != null) {
				p.next = p2;
			}

			return dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
}
