package record.leetcode.editor.cn;

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
// 示例 2：
//
//
//
//
//输入：root = [2,1,3]
//输出：[2,3,1]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 1392 👎 0

import structure.tree.TreeNode;
import structure.tree.TreeNodeManager;
import structure.tree.TreeNodePrint;

public class InvertBinaryTree {
	public static void main(String[] args) throws Exception {
		Solution solution = new InvertBinaryTree().new Solution();

		TreeNode root1 = TreeNodeManager.builder()
			.addTreeNode(1, 3, 2)
			.addTreeNode(3, 6, 9)
			.addTreeNode(2, 7, 8)
			.build();

		TreeNodePrint.levelTraverse(root1);


		TreeNode treeNode = solution.invertTree(root1);

		TreeNodePrint.levelTraverse(treeNode);
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
		public TreeNode invertTree(TreeNode root) {
			if (root == null) {
				return null;
			}

			TreeNode tmp = root.right;
			root.right = root.left;
			root.left = tmp;

			invertTree(root.left);
			invertTree(root.right);
			return root;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
