package record.leetcode.editor.cn;

//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2772 👎 0

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MergeKSortedLists {
	public static void main(String[] args) {

		// 有序链表一
		ListNode list1 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(4)
			.addNextNode(5)
			.build();

		LinkNodePrint.printlnListNode("list1:", list1);

		// 有序链表二
		ListNode list2 = LinkNodeManager.builder()
			.addNextNode(1)
			.addNextNode(3)
			.addNextNode(4)
			.build();

		LinkNodePrint.printlnListNode("list2:", list2);

		// 有序链表三
		ListNode list3 = LinkNodeManager.builder()
			.addNextNode(2)
			.addNextNode(6)
			.build();

		LinkNodePrint.printlnListNode("list3:", list3);

		ListNode[] lists = new ListNode[]{list1, list2, list3};


		Solution solution = new MergeKSortedLists().new Solution();

		ListNode mergeKLists = solution.mergeKLists(lists);


		LinkNodePrint.printlnListNode("mergeKLists:", mergeKLists);
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
		 * 两两合并
		 *
		 * @param lists k个升序链表
		 * @return ListNode
		 */
		public ListNode mergeKLists(ListNode[] lists) {

			// 队列存储
			LinkedBlockingQueue<ListNode> priorityQueue = new LinkedBlockingQueue<>();

			// 遍历链表集合
			for (ListNode listNode : lists) {
				if (listNode == null) {
					continue;
				}
				priorityQueue.add(listNode);
				// 当队列中链表数为2时，则开始合并，并将合并后的链表重新放回队列中
				if (priorityQueue.size() == 2) {
					ListNode list1 = priorityQueue.poll();
					ListNode list2 = priorityQueue.poll();
					ListNode mergeList = mergeTwoLists(list1, list2);
					priorityQueue.add(mergeList);
				}
			}

			// 此时队列中只有一个链表
			return priorityQueue.poll();
		}

		/**
		 * 合并两个有序链表
		 *
		 * @param list1 链表1
		 * @param list2 链表2
		 * @return ListNode
		 */
		private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			// 记录头节点位置
			ListNode dum = new ListNode(0);
			// 当前节点
			ListNode cur = dum;
			// 双指针遍历
			while (list1 != null && list2 != null) {
				if (list1.val < list2.val) {
					cur.next = list1;
					list1 = list1.next;
				} else {
					cur.next = list2;
					list2 = list2.next;
				}
				cur = cur.next;
			}
			// 剩下节点赋值
			cur.next = list1 != null ? list1 : list2;
			// 返回头节点
			return dum.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
