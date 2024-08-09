package record.leetcode.editor.cn;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内
// -10⁵ <= Node.val <= 10⁵
//
//
//
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
// Related Topics链表 | 双指针 | 分治 | 排序 | 归并排序
//
// 👍 2346, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import structure.link.ListNode;

public class SortList {
	public static void main(String[] args) {
		Solution solution = new SortList().new Solution();
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
		 * 要求使用插入排序的方法对链表进行排序，插入排序的时间复杂度是 O(n2)，其中 n 是链表的长度。这道题考虑时间复杂度更低的排序算法。
		 * 题目的进阶问题要求达到 O(nlogn)的时间复杂度和 O(1) 的空间复杂度，
		 * 时间复杂度是 O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n2)），
		 * 其中最适合链表的排序算法是归并排序。
		 * <p>
		 * 归并排序基于分治算法。最容易想到的实现方式是自顶向下的递归实现，考虑到递归调用的栈空间，
		 * 自顶向下归并排序的空间复杂度是 O(logn)。如果要达到 O(1) 的空间复杂度，则需要使用自底向上的实现方式。
		 * <p>
		 * ===================================
		 * ========方法一：自顶向下归并排序=======
		 * ===================================
		 * 对链表自顶向下归并排序的过程如下。
		 * 1、找到链表的中点，以中点为分界，将链表拆分成两个子链表。
		 * 寻找链表的中点可以使用快慢指针的做法，快指针每次移动 2 步，慢指针每次移动 1 步，
		 * 当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
		 * 2、对两个子链表分别排序。
		 * 3、将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
		 * <p>
		 * 上述过程可以通过递归实现。递归的终止条件是链表的节点个数小于或等于 1，
		 * 即当链表为空或者链表只包含 1 个节点时，不需要对链表进行拆分和排序。
		 * <p>
		 * 复杂度分析
		 * 时间复杂度：O(nlogn)，其中 n 是链表的长度。
		 * 空间复杂度：O(logn)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间。
		 * <p>
		 * * ===================================
		 * ========方法二：自底向上归并排序=======
		 * ===================================
		 * 使用自底向上的方法实现归并排序，则可以达到 O(1) 的空间复杂度。
		 * 首先求得链表的长度 length，然后将链表拆分成子链表进行合并。
		 *
		 * @param head 链表头节点
		 * @return
		 */
		public ListNode sortList(ListNode head) {
			return sortList(head, null);
		}

		public ListNode sortList(ListNode head, ListNode tail) {
			if (head == null) {
				return head;
			}
			if (head.next == tail) {
				head.next = null;
				return head;
			}
			ListNode slow = head, fast = head;
			while (fast != tail) {
				slow = slow.next;
				fast = fast.next;
				if (fast != tail) {
					fast = fast.next;
				}
			}
			ListNode mid = slow;
			ListNode list1 = sortList(head, mid);
			ListNode list2 = sortList(mid, tail);
			ListNode sorted = merge(list1, list2);
			return sorted;
		}

		public ListNode merge(ListNode head1, ListNode head2) {
			ListNode dummyHead = new ListNode(0);
			ListNode temp = dummyHead;
			ListNode temp1 = head1;
			ListNode temp2 = head2;
			while (temp1 != null && temp2 != null) {
				if (temp1.val <= temp2.val) {
					temp.next = temp1;
					temp1 = temp1.next;
				} else {
					temp.next = temp2;
					temp2 = temp2.next;
				}
				temp = temp.next;
			}
			if (temp1 != null) {
				temp.next = temp1;
			} else if (temp2 != null) {
				temp.next = temp2;
			}
			return dummyHead.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
