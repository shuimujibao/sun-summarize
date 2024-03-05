package structure.tree;

/**
 * Test
 *
 * @summary Test
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年09月01日 11:00:00
 */
public class Test {
	public static void main(String[] args) throws Exception {
		TreeNode root = TreeNodeManager.builder()
			.addTreeNode(1, 2, 3)
			.addTreeNode(2, 4, 5)
			.addTreeNode(3, 6, 7)
			.build();

		TreeNodePrint.levelTraverse(root);
	}
}
