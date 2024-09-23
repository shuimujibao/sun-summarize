package record.leetcode.editor.cn;

import structure.tree.TreeNode;

import java.util.*;

public class KthLargestSumInABinaryTree {
	public static void main(String[] args) {
		Solution solution = new KthLargestSumInABinaryTree().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode() {}
	 * TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) {
	 * this.val = val;
	 * this.left = left;
	 * this.right = right;
	 * }
	 * }
	 */
	class Solution {
		public long kthLargestLevelSum(TreeNode root, int k) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			ArrayList<Long> levelSums = new ArrayList<>();

			while (!queue.isEmpty()) {
				int curLevelNums = queue.size();
				long curSum = 0L;

				for (int m = 0; m < curLevelNums; m++) {
					TreeNode node = queue.poll();

					if (Objects.isNull(node)) {
						continue;
					}

					curSum += node.val;
					TreeNode leftNode = node.left;

					if (leftNode != null) {
						queue.add(leftNode);
					}
					TreeNode rightNode = node.right;
					if (rightNode != null) {
						queue.add(rightNode);
					}
				}

				levelSums.add(curSum);
			}

			if (levelSums.size() < k) {
				return -1;
			}

			Collections.sort(levelSums);

			return levelSums.get(levelSums.size() - k);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
