package record.leetcode.editor.cn;
//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
//
//
// 示例 2：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [0,1000]
//
// -10⁹ <= Node.val <= 10⁹
// -1000 <= targetSum <= 1000
//
//
// Related Topics树 | 深度优先搜索 | 二叉树
//
// 👍 1886, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import structure.tree.TreeNode;

import java.util.Objects;

public class PathSumIii {
	public static void main(String[] args) {
		Solution solution = new PathSumIii().new Solution();
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
		// 路径和
		private int pathSum = 0;
		// 路径和结果集
		private int result = 0;
		// 目标值
		private int targetSum = 0;

		public int pathSum(TreeNode root, int targetSum) {
			if (Objects.isNull(root)) {
				return 0;
			}
			this.targetSum = targetSum;
			backtrack(root);
			pathSum(root.left, targetSum);
			pathSum(root.right, targetSum);
			return result;
		}

		/**
		 * 计算根节点到叶子节点的路径和
		 *
		 * @param root 根节点
		 */
		void backtrack(TreeNode root) {
			if (Objects.isNull(root)) {
				return;
			}
			pathSum = pathSum + root.val;
			// 到达叶子节点，并且路径和为期望值
			if (pathSum == this.targetSum) {
				result++;
			}
			backtrack(root.left);
			backtrack(root.right);
			pathSum = pathSum - root.val;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
