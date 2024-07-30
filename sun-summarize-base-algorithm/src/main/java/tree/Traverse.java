package tree;

import structure.tree.TreeNode;
import structure.tree.TreeNodeManager;
import structure.tree.TreeNodePrint;

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
		System.out.println();


		// ===============================深度优先遍历=================================================================
//		DeepTraversal.deepTraversal(DeepTraversal.IN_ORDER_TRAVERSAL,root);
//		System.out.println("=====");
//		DeepTraversal.deepTraversal(DeepTraversal.POST_ORDER_TRAVERSAL,root);
//		System.out.println("=====");
//		DeepTraversal.deepTraversal(DeepTraversal.IN_ORDER_TRAVERSAL,root);

		// ===============================如果把根节点看做第 1 层，如何打印出每一个节点所在的层数===============================

//		System.out.println("==========如果把根节点看做第 1 层，如何打印出每一个节点所在的层数============");
//		Learn.traverse(root,1);
//
//		System.out.println("======================");
//		System.out.println("=========输入一棵二叉树，返回这棵二叉树的节点总数=============");
//		// ===============================输入一棵二叉树，返回这棵二叉树的节点总数===============================
//		Learn.count(root);

//		System.out.println("======================");
//		System.out.println("=========打印出遍历这棵二叉树的过程=============");
//		// =============================== 打印出遍历这棵二叉树的过程===============================
//		Learn.traverse(root);

		Traverse.sumPath(root);

		System.out.println(sum);
	}

	/**
	 * 路径和
	 *
	 * @param root 根节点
	 * @return 节点总数
	 */
	private static int sum = 0;

	public static void sumPath(TreeNode root) {
		if (root == null) {
			return;
		}
		sum = sum + root.val;

		if (root.left == null && root.right == null) {
			System.out.println("路径和："+sum);
		}
		sumPath(root.left);
		sumPath(root.right);
		sum = sum - root.val;
	}


}
