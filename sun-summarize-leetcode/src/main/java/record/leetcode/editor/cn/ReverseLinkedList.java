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

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

import java.util.Objects;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Solution solution = new ReverseLinkedList().new Solution();

		ListNode head = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(2)
			.addNextNode(3)
			.addNextNode(4)
			.addNextNode(5)
			.build();

		ListNode reverseListResult = solution.reverseList(head);

		System.out.println("======反转后结果======");
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
		/**
		 * 反转链表（递归）
		 * <p>
		 * 第一次：1->2->3->4->5
		 * <p>
		 * 第二次：2->1->3->4->5
		 * <p>
		 * 第三次：3->2->1->4->5
		 * <p>
		 * ...
		 *
		 * @param head 头节点
		 * @return ListNode
		 */
		public ListNode reverseList(ListNode head) {

			// 递归中止条件
			if (Objects.isNull(head)) {
				return head;
			}

			// 当前节点的下一个节点
			ListNode lastNode = reverseList(head.next);
			LinkNodePrint.printlnListNode("后序：",head);
//			head.next.next = head;
//			head.next = null;
			return lastNode;
		}

		/**
		 * 反转链表
		 * <p>非递归</p>
		 *
		 * @param head 头节点
		 * @return ListNode
		 */
		public ListNode reverseList2(ListNode head) {

			ListNode cur = head;

			ListNode pre = null;

			while (cur != null) {

				// 记录当前节点之后的节点，用于继续遍历
				ListNode temp = cur.next;

				System.out.println("记录当前节点之后的节点，用于继续遍历temp");
				LinkNodePrint.printlnListNode(temp);

				// 当前节点的下一个节点，指向前一个节点
				cur.next = pre;

				pre = cur;

				// 继续遍历
				cur = temp;
			}


            return pre;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
}
