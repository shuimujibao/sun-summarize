package record.leetcode.editor.cn;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
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
// Related Topics 递归 链表
// 👍 2712 👎 0

import structure.link.LinkNodePrint;
import structure.link.ListNode;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Solution solution = new ReverseLinkedList().new Solution();
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);

		head.setNext(head2);
		head2.setNext(head3);
		head3.setNext(head4);
		LinkNodePrint.printlnListNode(head);
		ListNode reverseListResult = solution.reverseList(head);
		LinkNodePrint.printlnListNode(reverseListResult);
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
//			ListNode pre = new ListNode(-1);
//			ListNode temp;
//			while (head != null) {
//				temp = head;
//				head = head.next;
//				temp.next = pre.next;
//				pre.next = temp;
//			}
//			return pre.next;
			// 头结点
			ListNode pre = new ListNode(-1);
			// 临时存储值
			ListNode temp;
			while (head != null) {
				// 记录头结点后面的值
				temp = pre.next;
				// 插入刚遍历到的链表值
				pre.next = head;
				// 遍历下一个结点
				head = head.next;
				// 将原来的结点值赋值
				pre.next.next = temp;
			}
			return pre.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
}
