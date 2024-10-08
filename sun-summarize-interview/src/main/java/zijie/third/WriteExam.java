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

	/**
	 * 需翻转的层数
	 */
	int k;

	/**
	 * 当前层数
	 */
	int curLevel;

	public TreeNode revert(TreeNode root, int k) {
		this.k = k;
		curLevel = 1;
		traverse(root.left, root.right,curLevel);
		return root;
	}
	
	void traverse(TreeNode node1, TreeNode node2, int curLevel) {

		if (node1 == null || node2 == null) {
			return;
		}

		if (curLevel == k) {
			int temp = node1.val;
			node1.val = node2.val;
			node2.val = temp;
		}

		traverse(node1.left, node2.right, curLevel + 1);
		traverse(node1.right, node2.left,curLevel+1);
	}
}
