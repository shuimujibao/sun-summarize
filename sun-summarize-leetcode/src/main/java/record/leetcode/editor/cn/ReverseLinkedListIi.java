package record.leetcode.editor.cn;
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//
//
// 示例 2：
//
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//
//
// 提示：
//
//
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//
// 进阶： 你可以使用一趟扫描完成反转吗？
//
// Related Topics链表
//
// 👍 1831, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

import java.util.Objects;

public class ReverseLinkedListIi {
	public static void main(String[] args) {
		Solution solution = new ReverseLinkedListIi().new Solution();

		ListNode head = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4)
			.addNextNode(5)
			.build();


		LinkNodePrint.printlnListNode("翻转前：", head);

		ListNode listNode = solution.reverseBetween(head, 2, 4);

		LinkNodePrint.printlnListNode("翻转后：", listNode);
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
		public ListNode reverseBetween(ListNode head, int left, int right) {

			if (left == 1) {
				return reverseN(head, right);
			}
			// 找到第 left 个节点的前驱
			ListNode pre = head;
			for (int i = 1; i < left - 1; i++) {
				pre = pre.next;
			}
			// 从第 left 个节点开始反转
			pre.next = reverseN(pre.next, right - left + 1);
			return head;
		}

		/**
		 * 反转链表前n个节点
		 *
		 * @param head 头节点
		 * @param n    个数
		 * @return ListNode
		 */
		private ListNode reverseN(ListNode head, int n) {

			if (head == null || head.next == null) {
				return head;
			}

			ListNode cur = head;
			ListNode pre = null;
			ListNode next = head.next;

			while (n > 0) {
				cur.next = pre;

				pre = cur;
				cur = next;

				next = Objects.nonNull(next) ? next.next : null;
				n--;
			}
			head.next = cur;
			return pre;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
