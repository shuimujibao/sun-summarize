package record.leetcode.editor.cn;
//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。
//
// 路径和 是路径中各节点值的总和。
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
//
// 示例 2：
//
//
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
//
//
//
//
// 提示：
//
//
// 树中节点数目范围是 [1, 3 * 10⁴]
// -1000 <= Node.val <= 1000
//
//
// Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树
//
// 👍 2251, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import structure.tree.TreeNode;

public class BinaryTreeMaximumPathSum {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeMaximumPathSum().new Solution();
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
		int res = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			if (root == null) {
				return 0;
			}
			// 计算单边路径和时顺便计算最大路径和
			oneSideMax(root);
			return res;
		}

		// 定义：计算从根节点 root 为起点的最大单边路径和
		int oneSideMax(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int leftMaxSum = Math.max(0, oneSideMax(root.left));
			int rightMaxSum = Math.max(0, oneSideMax(root.right));
			// 后序遍历位置，顺便更新最大路径和
			int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
			res = Math.max(res, pathMaxSum);
			// 实现函数定义，左右子树的最大单边路径和加上根节点的值
			// 就是从根节点 root 为起点的最大单边路径和
			return Math.max(leftMaxSum, rightMaxSum) + root.val;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
