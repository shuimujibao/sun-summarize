package zijie.third;

import structure.tree.TreeNode;

/**
 * @author sunxiaoyu3
 * @description 算法
 * @createTime 2021/01/27 10:20:00
 */
public class WriteExam {

	/**
	 * 二叉树的深度为m,翻转第k层的节点，其他节点数据不变，返回这个二叉树
	 *
	 * <p>
	 * 源第k层为 ：1 2 3 4
	 * 结果第k层 ：4 3 2 1
	 *
	 * @param root 树
	 * @return TreeNode
	 */

	int k;

	public TreeNode revert(TreeNode root, int k) {
		this.k = k;
		traverse(root.left, root.right);
		return root;
	}

	void traverse(TreeNode node1, TreeNode node2) {

		if (node1 == null || node2 == null) {
			return;
		}

		traverse(node1.left, node1.right);
		traverse(node2.left, node2.right);
	}
}
