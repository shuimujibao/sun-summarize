package structure.tree;

import lombok.Builder;
import lombok.Data;

/**
 * 二叉树输出
 *
 * @summary TreeNodePrint
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年09月01日 10:22:00
 */
public class TreeNodePrint {

	/**
	 * 占位符
	 */
	private static final String SPACE = "  ";

	/**
	 * 二叉树的层次遍历
	 *
	 * @param root 当前二叉树
	 */
	public static void levelTraverse(TreeNode root) {
		if (root == null) {
			return;
		}

		int treeHeight = getTreeHeight(root);

		System.out.println("");
	}

	/**
	 * 节点初始化
	 *
	 * @param root       树
	 * @param isLeftNode 是否为左节点
	 * @return TreeNodeDetail
	 */
	private static TreeNodeDetail initNode(TreeNode root, Boolean isLeftNode, int row) {
		return TreeNodeDetail
			.builder()
			.isLeftNode(isLeftNode)
			.row(row)
			.node(root).build();
	}

	/**
	 * 节点详情
	 */
	@Data
	@Builder
	private static class TreeNodeDetail {
		private TreeNode node;
		private Boolean isLeftNode;
		private Integer row;
	}

	/**
	 * 获取当前二叉树的高度
	 *
	 * @param root 树
	 * @return int
	 */
	private static int getTreeHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getTreeHeight(root.left);
		int right = getTreeHeight(root.right);
		return left > right ? left + 1 : right + 1;
	}
}
