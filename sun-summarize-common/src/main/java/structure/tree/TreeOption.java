package structure.tree;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeOption
 *
 * @summary TreeOption
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月21日 17:47:00
 */
public class TreeOption {

	/**
	 * 创建一棵树
	 *
	 * @param arrays 数组
	 * @return 树
	 */
	public static TreeNode createTree(int[] arrays) {

		// 当前树
		TreeNode treeNode = new TreeNode();

		// 将数组的值转化为树的节点便于操作
		List<TreeNode> nodes = new ArrayList<>();
		for (int value : arrays) {
			nodes.add(new TreeNode(value));
		}

		if (CollectionUtils.isEmpty(nodes)) {
			return treeNode;
		}

		// 获取树的根
		TreeNode root = nodes.get(0);
		nodes.remove(0);

		while (CollectionUtils.isNotEmpty(nodes)) {

			for (int i = 0; i < nodes.size(); i++) {
			}
		}

		return treeNode;
	}
}
