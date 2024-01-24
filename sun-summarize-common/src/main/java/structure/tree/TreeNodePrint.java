package structure.tree;

import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

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
	 * 当前所在行数
	 */
	public static Integer treeHeightNow;


	/**
	 * 当前二叉树高度
	 */
	public static Integer treeHeight;

	/**
	 * 二叉树的层次遍历
	 *
	 * @param root 当前二叉树
	 */
	public static void levelTraverse(TreeNode root) {
		if (root == null) {
			return;
		}

		// 当前二叉树高度
		treeHeight = getTreeHeight(root);

		// 当前二叉树输出节点个数
		int printNodeNums = 0;

		// 输出当前行后，输出的节点总数。初始化第一行
		HashMap<Integer, Integer> rowsNumsMap = new HashMap<>();
		rowsNumsMap.put(1, 1);
		for (int i = 2; i <= treeHeight; i++) {
			// 当前所在层数 i
			// 获取当前层数的上一层 i-1
			// 当前层数换行节点阈值，为上一次节点数量乘2
			rowsNumsMap.put(i, rowsNumsMap.get(i - 1) + (i - 1) * 2);
		}

		// 统计换行节点阈值
		Collection<Integer> needWrapCollection = rowsNumsMap.values();

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			System.out.print(String.format("%s%s", printNodeSpace(), Objects.isNull(node) ? null : node.val));
			printNodeNums++;

			// 输出最后一层后，结束遍历
			treeHeightNow = getTreeHeightNow(printNodeNums, rowsNumsMap);
			if (treeHeightNow.equals(treeHeight)) {
				break;
			}

			// 到达换行阈值，则进行换行，并输出路径
			if (needWrapCollection.contains(printNodeNums)) {
				System.out.println("\n");

				for (int i = 0; i < treeHeightNow; i++) {
					System.out.print(printPathSpace() + printFlag());
				}
				System.out.println();
			}

			// 层次遍历
			if (Objects.nonNull(node) && node.left != null) {
				queue.offer(node.left);
			} else {
				queue.offer(null);
			}

			if (Objects.nonNull(node) && node.right != null) {
				queue.offer(node.right);
			} else {
				queue.offer(null);
			}
		}
	}

	private static String printFlag() {
		return "/ \\";
	}

	private static String printPathSpace() {
		StringBuilder sb = new StringBuilder();

		for (int i = Objects.isNull(treeHeightNow) ? 0 : treeHeightNow; i < treeHeight; i++) {
			sb.append("    ");
		}
		return sb.toString();
	}

	private static String printNodeSpace() {
		StringBuilder sb = new StringBuilder();

		for (int i = Objects.isNull(treeHeightNow) ? 0 : treeHeightNow; i < treeHeight; i++) {
			sb.append("   ");
		}
		return sb.toString();
	}

	/**
	 * 获取此时所在行数
	 *
	 * @param printNodeNums
	 * @param rowsNumsMap
	 * @return
	 */
	private static Integer getTreeHeightNow(int printNodeNums, HashMap<Integer, Integer> rowsNumsMap) {
		final Integer nums = printNodeNums;
		List<Integer> collect = rowsNumsMap.entrySet()
			.stream()
			.filter(e -> nums.equals(e.getValue()))
			.map(Map.Entry::getKey).collect(Collectors.toList());

		return collect.isEmpty() ? treeHeightNow : collect.get(0);
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
