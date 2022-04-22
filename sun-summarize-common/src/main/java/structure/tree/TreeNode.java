package structure.tree;

import lombok.Data;

/**
 * 树
 *
 * @summary TreeNode
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 贝壳找房（北京）科技有限公司
 * @since: 2022年04月21日 17:30:00
 */
@Data
public class TreeNode {
	/**
	 * 节点值
	 */
	public int val;

	/**
	 * 左子树
	 */
	public TreeNode left;

	/**
	 * 右子树
	 */
	public TreeNode right;


	/**
	 * 初始化
	 *
	 * @param val 根节点值
	 */
	TreeNode(int val) {
		this.val = val;
	}

	/**
	 * 无参构造器
	 */
	public TreeNode() {
	}
}
