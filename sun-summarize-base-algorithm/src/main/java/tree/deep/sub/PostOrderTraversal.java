package tree.deep.sub;

import structure.tree.TreeNode;

/**
 * 后续遍历
 *
 * @summary PostOrderTraversal
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年09月02日 10:22:00
 */
public class PostOrderTraversal {

	/**
	 * 递归完成后序遍历
	 *
	 * @param root 树
	 */
	public static void recursion(TreeNode root) {
		if (root == null) {
			return;
		}
		recursion(root.left);
		recursion(root.right);
		System.out.println(root.val);
	}
}
