package CodingInterviews_55_TreeDepth;

import TreeNode.TreeNode;

/*
	面试题55:
		输入一棵二叉树，求该树的深度。
		从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TheDepthofBinaryTree {
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getTreeDepth(root, 1, 1);
	}
	//递归
	public int getTreeDepth(TreeNode root, int depth, int result) {
		if (root == null) {
			return Math.max(depth - 1, result);
		}
		result = Math.max(getTreeDepth(root.left, depth + 1, result), result);
		result = Math.max(getTreeDepth(root.right, depth + 1, result), result);
		return result;
	}
}
