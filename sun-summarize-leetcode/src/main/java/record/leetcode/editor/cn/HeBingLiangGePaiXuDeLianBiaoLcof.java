package record.leetcode.editor.cn;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// 限制：
//
// 0 <= 链表长度 <= 1000
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
// Related Topics 递归 链表
// 👍 272 👎 0

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
	public static void main(String[] args) {
		Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();

		ListNode l1 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(4)
			.build();

		ListNode l2 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(3)
			.addNextNode(4)
			.build();

		ListNode result = solution.mergeTwoLists(l1, l2);

		LinkNodePrint.printlnListNode(result);

	}

//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(-1), cur = dummy;
			while (l1 != null || l2 != null) {
				if (l1 != null && l2 != null) {
					if (l1.val < l2.val) {
						cur.next = l1;
						cur = cur.next;
						l1 = l1.next;
					} else {
						cur.next = l2;
						cur = cur.next;
						l2 = l2.next;
					}
				} else if (l1 != null) {
					cur.next = l1;
					cur = cur.next;
					l1 = l1.next;
				} else {
					cur.next = l2;
					cur = cur.next;
					l2 = l2.next;
				}
			}
			return dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
