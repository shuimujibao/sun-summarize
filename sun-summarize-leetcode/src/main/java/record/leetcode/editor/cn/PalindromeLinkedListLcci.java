package record.leetcode.editor.cn;

//编写一个函数，检查输入的链表是否是回文的。
//
//
//
// 示例 1：
//
// 输入： 1->2
//输出： false
//
//
// 示例 2：
//
// 输入： 1->2->2->1
//输出： true
//
//
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 栈 递归 链表 双指针
// 👍 120 👎 0

import structure.link.LinkNodeManager;
import structure.link.ListNode;

import java.util.Stack;

public class PalindromeLinkedListLcci {
	public static void main(String[] args) {
		Solution solution = new PalindromeLinkedListLcci().new Solution();

		ListNode build = LinkNodeManager.builder()
			.addNextNode(0)
			.addNextNode(0).build();

		boolean palindrome = solution.isPalindrome(build);

		System.out.println(palindrome);
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
		public boolean isPalindrome(ListNode head) {
			Stack<ListNode> stack = new Stack<>();
			ListNode currentListNode = head;
			while (head != null) {
				stack.push(head);
				head = head.next;
			}

			while (currentListNode != null) {
				ListNode top = stack.peek();
				if (top.val == currentListNode.val) {
					stack.pop();
					currentListNode = currentListNode.next;
					continue;
				}
				return false;

			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
