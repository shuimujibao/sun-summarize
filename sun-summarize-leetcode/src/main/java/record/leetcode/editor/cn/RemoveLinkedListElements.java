package record.leetcode.editor.cn;

//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点数目在范围 [0, 104] 内
// 1 <= Node.val <= 50
// 0 <= val <= 50
//
// Related Topics 递归 链表
// 👍 1008 👎 0

import structure.link.LinkNodeManager;
import structure.link.ListNode;
import util.LinkListUtil;

public class RemoveLinkedListElements {
	public static void main(String[] args) {
		Solution solution = new RemoveLinkedListElements().new Solution();

		ListNode build = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4)
			.addNextNode(3)
			.addNextNode(6).build();

		ListNode listNode = solution.removeElements(build, 3);

		LinkListUtil.printlnListNode(listNode);
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
		public ListNode removeElements(ListNode head, int val) {

			ListNode dummyHead = new ListNode(0);
			dummyHead.next = head;
			ListNode temp = dummyHead;
			while (temp.next != null) {
				if (temp.next.val == val) {
					temp.next = temp.next.next;
				} else {
					temp = temp.next;
				}
			}
			return dummyHead.next;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
