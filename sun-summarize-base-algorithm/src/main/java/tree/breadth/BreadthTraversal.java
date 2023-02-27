package tree.breadth;

import structure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 *
 * @summary BreadthTraversal
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年09月02日 10:14:00
 */
public class BreadthTraversal {

	/**
	 * 层次遍历
	 *
	 * @param root 树
	 */
	public static void levelTraversal(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			System.out.println(node.val);

			if (node.left != null) {
				queue.offer(node.left);
			}

			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
}
