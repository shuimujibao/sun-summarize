package record.leetcode.editor.cn;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 1000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树
// 👍 1906 👎 0

import structure.tree.TreeNode;

public class SymmetricTree {
	public static void main(String[] args) {
		Solution solution = new SymmetricTree().new Solution();

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
		public boolean isSymmetric(TreeNode root) {
			return check(root.left, root.right);
		}

		public boolean check(TreeNode left, TreeNode right) {
			if (left == null || right == null) {
				return left == right;
			}
			// 两个根节点需要相同
			if (left.val != right.val) return false;

			// 左右子树也需要镜像对称
			return check(left.right, right.left) && check(left.left, right.right);

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
