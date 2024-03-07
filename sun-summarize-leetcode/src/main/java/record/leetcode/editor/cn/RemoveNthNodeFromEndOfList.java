package record.leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
// Related Topics 链表 双指针 👍 2820 👎 0

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
		ListNode linkNodeManager = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4)
			.build();

		LinkNodePrint.printlnListNode(linkNodeManager);

		ListNode listNode = solution.removeNthFromEnd(linkNodeManager, 2);

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
		public ListNode removeNthFromEnd(ListNode head, int n) {
			// 非空判断
			if (head == null) {
				return null;
			}

			// 虚拟头节点
			ListNode preNode = head;
			// 当前节点
			ListNode curNode = head;

			// 当前节点快走n步，当前节点到达末尾时，原节点则处于倒数第n个节点
			for (int i = 0; i < n; i++) {
				curNode = curNode.next;
			}

			if (curNode == null) {
				return preNode.next;
			}

			while (curNode.next != null) {
				preNode = preNode.next;
				curNode = curNode.next;
			}

			// 跳过倒数第n个节点
			preNode.next = preNode.next.next;

			return head;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
