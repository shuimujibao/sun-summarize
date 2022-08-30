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

		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode prev = new ListNode(-1);
//			ListNode prev = prehead;

			while (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					prev.next = l1;
					l1 = l1.next;
				} else {
					prev.next = l2;
					l2 = l2.next;
				}
				prev = prev.next;
			}

			// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
			prev.next = l1 == null ? l2 : l1;
			return prev.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
}
