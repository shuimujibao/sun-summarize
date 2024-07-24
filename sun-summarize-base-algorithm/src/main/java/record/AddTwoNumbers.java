package record;

import structure.link.LinkNodeManager;
import structure.link.LinkNodePrint;
import structure.link.ListNode;

import java.util.Objects;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 7944 👎 0
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode list1 = LinkNodeManager.builder()
			.addNextNode(2)
			.addNextNode(4)
			.addNextNode(3)
			.build();
		LinkNodePrint.printlnListNode("list1:",list1);

		ListNode list2 = LinkNodeManager.builder()
			.addNextNode(5)
			.addNextNode(6)
			.addNextNode(4)
			.build();
		LinkNodePrint.printlnListNode("list2:",list2);

		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

		ListNode listNode = addTwoNumbers.addTwoNumbers(list1, list2);

		LinkNodePrint.printlnListNode("listNode:",listNode);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode pre = new ListNode(-1);

		ListNode currentNode = pre;

		// 进位
		int carry = 0;

		while (l1 != null || l2 != null) {

			int l1Value = Objects.isNull(l1) ? 0 : l1.val;
			int l2Value = Objects.isNull(l2) ? 0 : l2.val;

			// 商
			int sum = (l1Value + l2Value + carry) % 10;
			currentNode.next = new ListNode(sum);

			// 余数
			carry = (l1Value + l2Value) / 10;

			currentNode = currentNode.next;

			l1 = Objects.isNull(l1) ? null : l1.next;
			l2 = Objects.isNull(l2) ? null : l2.next;
		}

		if (carry == 1) {
			currentNode.next = new ListNode(1);
		}

		return pre.next;
	}
}
