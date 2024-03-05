package tree;

import structure.tree.TreeNode;
import structure.tree.TreeNodeManager;
import structure.tree.TreeNodePrint;
import tree.breadth.BreadthTraversal;
import tree.deep.DeepTraversal;

/**
 * 二叉树遍历
 *
 * @summary Traverse
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年09月02日 09:53:00
 */
public class Traverse {
	public static void main(String[] args) throws Exception {

		TreeNode root = TreeNodeManager.builder()
			.addTreeNode(1, 2, 3)
			.addTreeNode(3, 4, 5)
			.addTreeNode(2, 6, 7)
			.build();


		TreeNodePrint.levelTraverse(root);
		System.out.println("");
		System.out.println("=====");
		DeepTraversal.deepTraversal(DeepTraversal.PRE_ORDER_TRAVERSAL,root);
		System.out.println("=====");
		DeepTraversal.deepTraversal(DeepTraversal.POST_ORDER_TRAVERSAL,root);
		System.out.println("=====");
		DeepTraversal.deepTraversal(DeepTraversal.IN_ORDER_TRAVERSAL,root);

//		BreadthTraversal.levelTraversal(root);
	}
}
