package tree.learn;

import structure.tree.TreeNode;

import java.util.Objects;

/**
 * @description: 学习树
 * @author: xy.sun06
 * @create: 2024-07-29 19:48
 * @Copyright (c) 2024, © 神州租车（北京）科技有限公司
 */
public class Learn {

	/**
	 * 二叉树遍历函数
	 *
	 * @param root  根节点
	 * @param level 层级
	 */
	public static void traverse(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		// 前序位置
		System.out.printf("节点 %s 在第 %d 层%n", root, level);
		traverse(root.left, level + 1);
		traverse(root.right, level + 1);
	}

	/**
	 * 输入一棵二叉树，返回这棵二叉树的节点总数
	 *
	 * @param root 根节点
	 * @return 节点总数
	 */
	public static int count(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftCount = count(root.left);
		int rightCount = count(root.right);

		// 后序位置
		System.out.printf("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点",
			root, leftCount, rightCount);
		System.out.println();

		return leftCount + rightCount + 1;
	}

	/**
	 * 打印出遍历这棵二叉树的过程
	 *
	 * @param root 根节点
	 */
	public static void traverse(TreeNode root) {
		if (root == null) return;

		//=========================
//		System.out.printf("前序=======从节点 %s 进入节点 %s", root.val, Objects.isNull(root.left) ? "NULL" : root.left.val);
//		System.out.println();

		traverse(root.left);

		System.out.printf("中序====从节点 %s 回到节点 %s", Objects.isNull(root.left) ? "NULL" : root.left.val, root.val);
		System.out.println();

		//=========================
		System.out.printf("中序====从节点 %s 进入节点 %s", root.val, Objects.isNull(root.right) ? "NULL" : root.right.val);
		System.out.println();

		traverse(root.right);

//		System.out.printf("后序=从节点 %s 回到节点 %s", Objects.isNull(root.right) ? "NULL" : root.right.val, root.val);
//		System.out.println();
	}
}
