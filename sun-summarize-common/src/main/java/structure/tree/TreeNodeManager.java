package structure.tree;

/**
 * 二叉树生成器
 *
 * @summary TreeNodeManager
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年09月01日 10:21:00
 */
public class TreeNodeManager {

	/**
	 * 当前二叉树
	 */
	private TreeNode currentTreeNode;

	/**
	 * 实例化
	 *
	 * @return TreeNodeManager
	 */
	public static TreeNodeManager builder() {
		return new TreeNodeManager();
	}

	/**
	 * @param rootVal  根节点
	 * @param leftVal  左子树
	 * @param rightVal 右子树
	 * @return TreeNodeManager
	 */
	public TreeNodeManager addTreeNode(Integer rootVal, Integer leftVal, Integer rightVal) throws Exception {
		if (rootVal == null) {
			throw new Exception("rootVal不能为空");
		}
		TreeNode left = leftVal == null ? null : new TreeNode(leftVal);
		TreeNode right = rightVal == null ? null : new TreeNode(rightVal);
		if (currentTreeNode == null) {
			currentTreeNode = new TreeNode(rootVal, left, right);
			return this;
		}
		preOrderTraverse(currentTreeNode, rootVal, left, right);
		return this;
	}

	/**
	 * 前序遍历二叉树
	 *
	 * @param root    二叉树
	 * @param rootVal 根的值
	 * @param left    左子树
	 * @param right   右子树
	 */
	private void preOrderTraverse(TreeNode root, Integer rootVal, TreeNode left, TreeNode right) {
		if (root == null) {
			return;
		}
		if (root.val == rootVal) {
			root.right = right;
			root.left = left;
		}
		preOrderTraverse(root.left, rootVal, left, right);
		preOrderTraverse(root.right, rootVal, left, right);
	}

	/**
	 * 获取当前二叉树
	 *
	 * @return ListNode
	 */
	public TreeNode build() {
		return this.currentTreeNode;
	}
}
