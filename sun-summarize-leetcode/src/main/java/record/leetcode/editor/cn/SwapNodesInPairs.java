package record.leetcode.editor.cn;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
// Related Topics 递归 链表
// 👍 2129 👎 0

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

import java.util.Objects;

public class SwapNodesInPairs {
	public static void main(String[] args) {
		Solution solution = new SwapNodesInPairs().new Solution();

		ListNode head = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4)
			.addNextNode(5)
			.addNextNode(6)
			.build();

		ListNode listNode = solution.swapPairs(head);


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
		public ListNode swapPairs(ListNode head) {
			return swap(head);
		}

		private ListNode swap(ListNode head) {

			if (Objects.isNull(head) || Objects.isNull(head.next)) {
				return head;
			}

			// 临时存储，第一个节点
			ListNode first = head;

			// 临时存储，第二个节点之后的链表
			ListNode third = head.next.next;

			// 将头节点复制为第二个节点
			head = head.next;

			// 此时头节点的下一个值为原节点的头节点
			head.next = first;

			// 恢复其他节点
			head.next.next = third;

			// 继续从第三个节点开始交换
			// 递归返回的值，递归前的链表中
			head.next.next = swap(head.next.next);

			return head;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
