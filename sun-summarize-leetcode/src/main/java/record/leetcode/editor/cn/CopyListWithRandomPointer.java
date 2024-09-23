package record.leetcode.editor.cn;
//给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
//
// 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
//指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
//
// 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random
//--> y 。
//
// 返回复制链表的头节点。
//
// 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
//
//
// val：一个表示 Node.val 的整数。
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
//
//
// 你的代码 只 接受原链表的头节点 head 作为传入参数。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// 示例 2：
//
//
//
//
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
//
//
// 示例 3：
//
//
//
//
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//
//
//
//
// 提示：
//
//
// 0 <= n <= 1000
//
// -10⁴ <= Node.val <= 10⁴
// Node.random 为 null 或指向链表中的节点。
//
//
//
//
// Related Topics哈希表 | 链表
//
// 👍 1432, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import java.util.HashMap;

public class CopyListWithRandomPointer {
	public static void main(String[] args) {
		Solution solution = new CopyListWithRandomPointer().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

	class Solution {
		// 对于数据结构复制，甭管他怎么变，你就记住最简单的方式：一个哈希表 + 两次遍历。
		public Node copyRandomList(Node head) {
			HashMap<Node, Node> originToClone = new HashMap<>();

			// 第一次遍历，先把所有节点克隆出来
			// key为原链表节点，value为copy后的新节点
			for (Node p = head; p != null; p = p.next) {
				originToClone.put(p, new Node(p.val));
			}

			// 第二次遍历，把克隆节点的结构连接好
			/**
			 * 获取当前原节点，copy后的节点==>originToClone.get(p)
			 * 获取当前原节点的下一个节点，copy后的节点==>originToClone.get(p.next)
			 * 通过p与p.next的关系，确定深拷贝后链表的next关系
			 * random同理
			 */
			for (Node p = head; p != null; p = p.next) {
				// 连接next维度
				if (p.next != null) {
					originToClone.get(p).next = originToClone.get(p.next);
				}
				// 连接random维度
				if (p.random != null) {
					originToClone.get(p).random = originToClone.get(p.random);
				}
			}
			return originToClone.get(head);
		}

		class Node {
			int val;
			Node next;
			Node random;

			public Node(int val) {
				this.val = val;
				this.next = null;
				this.random = null;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
