package record.leetcode.editor.cn;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树 深度优先搜索 二叉树
// 👍 1060 👎 0

import structure.tree.TreeNode;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		Solution solution = new DiameterOfBinaryTree().new Solution();

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

		private int ans = 0;

		public int diameterOfBinaryTree(TreeNode root) {
			ans = 1;
			depth(root);
			return ans - 1;
		}


		private int depth(TreeNode node) {
			if (node == null) {
				return 0; // 访问到空节点了，返回0
			}
			int L = depth(node.left); // 左儿子为根的子树的深度
			int R = depth(node.right); // 右儿子为根的子树的深度
			ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
			return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
