package record.leetcode.editor.cn;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
//
//提示：
//
//
// 链表中的节点数目为 n
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
//
//
//
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
//
//
//
//
// Related Topics 递归 链表 👍 2289 👎 0

import structure.link.ListNode;

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		Solution solution = new ReverseNodesInKGroup().new Solution();

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
		public ListNode reverseKGroup(ListNode head, int k) {
			if (head == null) return null;
			// 区间 [a, b) 包含 k 个待反转元素
			ListNode a, b;
			a = b = head;
			for (int i = 0; i < k; i++) {
				// 不足 k 个，不需要反转，base case
				if (b == null) return head;
				b = b.next;
			}
			// 反转前 k 个元素
			ListNode newHead = reverse(a, b);
			// 递归反转后续链表并连接起来
			a.next = reverseKGroup(b, k);

			return newHead;
		}

		// 反转区间 [a, b) 的元素，注意是左闭右开
		ListNode reverse(ListNode a, ListNode b) {
			ListNode pre, cur, nxt;
			pre = null;
			cur = a;
			// while 终止的条件改一下就行了
			while (cur != b) {
				nxt = cur.next;
				cur.next = pre;
				pre = cur;
				cur = nxt;
			}
			// 返回反转后的头结点
			return pre;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
