package CodingInterviews_07_ConstructBinaryTree;

import TreeNode.TreeNode;

/*
	面试题7：重建二叉树
		输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
		假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
		例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ConstructBinaryTree {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (in == null || in.length == 0) {
			return null;
		}
		return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in, int pre_left, int pre_right, int in_left, int in_right) {
		if (pre_left > pre_right) {
			return null;
		}
		int rootVal = pre[pre_left];
		TreeNode root = new TreeNode(rootVal);
		int rootIndex = 0;
		for (int i = in_left; i <= in_right; i++) {
			if (in[i] == rootVal) {
				rootIndex = i;
			}
		}
		int leftLength = rootIndex - in_left;
		// pre_left = pre_left+1
		// pre_right = pre_left+length
		// in_left = in_left
		// in_right = rootIndex-1
		root.left = reConstructBinaryTree(pre, in, pre_left + 1, pre_left + leftLength, in_left, rootIndex - 1);
		// pre_left = pre_right+1
		// pre_right = pre_right
		// in_left = rootIndex+1
		// in_right = in_right
		root.right = reConstructBinaryTree(pre, in, pre_left + leftLength + 1, pre_right, rootIndex + 1, in_right);
		return root;
	}

}
