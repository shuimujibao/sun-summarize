package record.leetcode.editor.cn;
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
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
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
//
// Related Topics树 | 广度优先搜索 | 二叉树
//
// 👍 1990, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import structure.tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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

		public List<List<Integer>> levelOrder(TreeNode root) {
			// 结果
			ArrayList<List<Integer>> result = new ArrayList<>();
			if (Objects.isNull(root)) {
				return result;
			}

			// 广度优先遍历
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				// 当前层级的节点数量
				int curLevelNum = queue.size();

				// 当前层结果集
				List<Integer> levelResult = new ArrayList<>();

				// 按层遍历
				for (int i = 0; i < curLevelNum; i++) {

					TreeNode node = queue.poll();
					if (Objects.isNull(node)) {
						continue;
					}
					levelResult.add(node.val);
					TreeNode leftNode = node.left;
					TreeNode rightNode = node.right;

					if (Objects.nonNull(leftNode)) {
						queue.add(leftNode);
					}
					if (Objects.nonNull(rightNode)) {
						queue.add(rightNode);
					}
				}
				result.add(levelResult);
			}

			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
