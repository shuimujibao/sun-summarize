package tree.deep;

import org.apache.commons.lang3.StringUtils;
import structure.tree.TreeNode;
import tree.deep.sub.InOrderTraversal;
import tree.deep.sub.PostOrderTraversal;
import tree.deep.sub.PreOrderTraversal;

/**
 * 深度优先遍历
 *
 * @summary DeepTraversal
 * @author: sunxiaoyu016
 * @Copyright (c) 2022, © 神州租车（北京）科技有限公司
 * @since: 2022年09月02日 10:12:00
 */
public class DeepTraversal {
	/**
	 * 中序
	 */
	public static final String IN_ORDER_TRAVERSAL = "InOrderTraversal";

	/**
	 * 后序
	 */
	public static final String POST_ORDER_TRAVERSAL = "PostOrderTraversal";

	/**
	 * 先序
	 */
	public static final String PRE_ORDER_TRAVERSAL = "PreOrderTraversal";

	/**
	 * 发起遍历
	 */
	public static void deepTraversal(String type, TreeNode root) throws Exception {

		if (StringUtils.isBlank(type)) {
			throw new Exception("遍历类型不能为空.");
		}

		if (IN_ORDER_TRAVERSAL.equals(type)) {
			InOrderTraversal.recursion(root);
		}

		if (POST_ORDER_TRAVERSAL.equals(type)) {
			PostOrderTraversal.recursion(root);
		}

		if (PRE_ORDER_TRAVERSAL.equals(type)) {
			PreOrderTraversal.recursion(root);
		}
	}
}
