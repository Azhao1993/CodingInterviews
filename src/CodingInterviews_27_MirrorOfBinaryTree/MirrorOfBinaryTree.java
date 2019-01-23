package CodingInterviews_27_MirrorOfBinaryTree;

import java.util.Stack;

import TreeNode.TreeNode;

/*
	面试题27：二叉树的镜像
		请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorOfBinaryTree {
	public void Mirror(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if (root.left != null) {
			Mirror(root.left);
		}
		if (root.right != null) {
			Mirror(root.right);
		}
	}

	// cpp版本改写
	// 递归
	public void MirrorRecursively(TreeNode pNode) {
		if ((pNode == null) || (pNode.left == null && pNode.right == null))
			return;

		TreeNode pTemp = pNode.left;
		pNode.left = pNode.right;
		pNode.right = pTemp;

		if (pNode.left != null)
			MirrorRecursively(pNode.left);

		if (pNode.right != null)
			MirrorRecursively(pNode.right);
	}

	// 迭代
	public void MirrorIteratively(TreeNode pRoot) {
		if (pRoot == null)
			return;

		Stack<TreeNode> stackTreeNode = new Stack<TreeNode>();
		stackTreeNode.push(pRoot);

		while (!stackTreeNode.isEmpty()) {
			TreeNode pNode = stackTreeNode.pop();

			TreeNode pTemp = pNode.left;
			pNode.left = pNode.right;
			pNode.right = pTemp;

			if (pNode.left != null)
				stackTreeNode.push(pNode.left);

			if (pNode.right != null)
				stackTreeNode.push(pNode.right);
		}
	}
}
