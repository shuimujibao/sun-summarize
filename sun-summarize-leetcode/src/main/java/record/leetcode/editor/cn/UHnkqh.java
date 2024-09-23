package record.leetcode.editor.cn;

//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
//
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
//
//
//
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/
// Related Topics 递归 链表
// 👍 87 👎 0

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

public class UHnkqh {
	public static void main(String[] args) {
		Solution solution = new UHnkqh().new Solution();
		ListNode build = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4).build();

		ListNode listNode = solution.reverseList(build);

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
		public ListNode reverseList(ListNode head) {

			// 如果链表为null，则直接返回了
			// 如果链表只剩一个节点，则直接返回节点
			if (head == null || head.next == null) return head;

			ListNode nextNode = head.next;

			// 需要递归head的下一个节点，所以上述先定义下下个节点
			ListNode result = reverseList(nextNode);

			// 此时如果head=4，那么head.next=5，head.next(nextNode)的指针执行head，即指向4
			nextNode.next = head;

			// 5->4...这个顺序执行，则4的prev为5,4的next为null
			head.next = null;

			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
}
