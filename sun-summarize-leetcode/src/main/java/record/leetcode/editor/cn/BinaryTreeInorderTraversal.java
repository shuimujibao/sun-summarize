package record.leetcode.editor.cn;

//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树
// 👍 1548 👎 0

import structure.tree.TreeNode;
import structure.tree.TreeNodeManager;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) throws Exception {
		Solution solution = new BinaryTreeInorderTraversal().new Solution();

		TreeNode root = TreeNodeManager.builder()
			.addTreeNode(1, 2, 3)
			.addTreeNode(3, 4, 5)
			.addTreeNode(2, 6, 7)
			.build();

		List<Integer> integers = solution.inorderTraversal(root);

		System.out.println(integers);
	}

//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode() {}
	 * TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) {
	 * this.val = val;
	 * this.left = left;
	 * this.right = right;
	 * }
	 * }
	 */
	class Solution {
		List<Integer> result = new ArrayList<>();
		public List<Integer> inorderTraversal(TreeNode root) {
			if (root == null) {
				return result;
			}
			inorderTraversal(root.left);
			result.add(root.val);
			inorderTraversal(root.right);
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
