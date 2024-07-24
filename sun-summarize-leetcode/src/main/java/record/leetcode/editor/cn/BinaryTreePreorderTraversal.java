package record.leetcode.editor.cn;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树
//
// 👍 1258, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
		ArrayList<Integer> res = new ArrayList<>();

		public List<Integer> preorderTraversal(TreeNode root) {
			if (root == null) {
				return res;
			}

			res.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);

			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
