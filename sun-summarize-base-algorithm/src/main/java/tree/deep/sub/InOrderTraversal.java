package tree.deep.sub;

import structure.tree.TreeNode;

/**
 * 中序遍历
 *
 * @summary InOrderTraversal
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年09月02日 10:21:00
 */
public class InOrderTraversal {

	/**
	 * 递归完成中序遍历
	 *
	 * @param root 树
	 */
	public static void recursion(TreeNode root) {
		if (root == null) {
			return;
		}
		recursion(root.left);
		System.out.println(root.val);
		recursion(root.right);
	}
}
