package record.leetcode.editor.cn;
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树
//
// 👍 2394, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import structure.tree.TreeNode;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		Solution solution = new ValidateBinarySearchTree().new Solution();
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

		Boolean res = Boolean.TRUE;
		String LEFT_FLAG = "Left";
		String RIGHT_FLAG = "Right";

		public boolean isValidBST(TreeNode root) {
			dfs(root);
			return res;
		}

		// 左子树上的所有节点值小于父节点，
		// 而右子树上的所有节点值大于父节点。
		// 这种性质保证了中序遍历该树时，节点值的顺序是有序的。
		private void dfs(TreeNode root) {
			if (root == null) {
				return;
			}
			// 检查左右子树是否符合要求
			dfsZiShu(root.left, root.val, LEFT_FLAG);
			dfsZiShu(root.right, root.val, RIGHT_FLAG);

			// 遍历根节点
			dfs(root.left);
			dfs(root.right);
		}

		private void dfsZiShu(TreeNode root, Integer rootVal, String flag) {
			if (root == null) {
				return;
			}
			if (LEFT_FLAG.equals(flag) && root.val >= rootVal) {
				res = Boolean.FALSE;
			}
			if (RIGHT_FLAG.equals(flag) && root.val <= rootVal) {
				res = Boolean.FALSE;
			}
			dfsZiShu(root.left, rootVal, flag);
			dfsZiShu(root.right, rootVal, flag);
		}


		// 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
		boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
			// base case
			if (root == null) return true;
			// 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
			if (min != null && root.val <= min.val) return false;
			if (max != null && root.val >= max.val) return false;
			// 限定左子树的最大值是 root.val，右子树的最小值是 root.val
			return isValidBST(root.left, min, root)
				&& isValidBST(root.right, root, max);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
