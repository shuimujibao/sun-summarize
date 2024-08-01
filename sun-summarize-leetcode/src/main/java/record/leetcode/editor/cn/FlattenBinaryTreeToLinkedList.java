package record.leetcode.editor.cn;
//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
//
// Related Topics栈 | 树 | 深度优先搜索 | 链表 | 二叉树
//
// 👍 1703, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

import structure.tree.TreeNode;

public class FlattenBinaryTreeToLinkedList{
	public static void main(String[] args) {
		Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	/**
	 * 展开后的单链表应该与二叉树 先序遍历 顺序相同
	 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null
	 *
	 * @param root 根结点
	 */
    public void flatten(TreeNode root) {
	    // base case
	    if (root == null) return;

	    // 利用定义，把左右子树拉平
	    flatten(root.left);
	    flatten(root.right);

	    /**** 后序遍历位置 ****/
	    // 1、左右子树已经被拉平成一条链表
	    TreeNode left = root.left;
	    TreeNode right = root.right;

	    // 2、将左子树作为右子树
	    root.left = null;
	    root.right = left;

	    // 3、将原先的右子树接到当前右子树的末端
	    TreeNode p = root;
	    while (p.right != null) {
		    p = p.right;
	    }
	    p.right = right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
