package record;

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
import structure.tree.TreeNodeManager;

public class DiameterOfBinaryTree {

	public static void main(String[] args) throws Exception {
		TreeNode root = TreeNodeManager.builder()
			.addTreeNode(1, 3, 2)
//			.addTreeNode(3, 6, 9)
//			.addTreeNode(2, 7, 8)
			.build();

		DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
		diameterOfBinaryTree.dfs(root);
	}

	private int ans = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		dfs(root);
		return ans - 1;
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		dfs(root.left);
		dfs(root.right);
	}
}
