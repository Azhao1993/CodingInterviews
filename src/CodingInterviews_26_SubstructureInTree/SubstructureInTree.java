package CodingInterviews_26_SubstructureInTree;

import TreeNode.TreeNode;

/*
	面试题26：树的子结构
		输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class SubstructureInTree {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		String s1 = Serialization(root1, "");
		StringBuilder sb = new StringBuilder(s1);
		String s2 = Serialization(root2, "");

		return sb.indexOf(s2) != -1;
	}

	// 序列化二叉树
	public String Serialization(TreeNode root, String result) {
		if (root == null) {
			return result;
		}

		result += String.valueOf(root.val);
		result += ",";
		result = Serialization(root.left, result);
		result = Serialization(root.right, result);
		return result;
	}

	// 递归
	public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
		boolean res = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				res = isSame(root1, root2);
			}
			if (!res) {
				res = HasSubtree(root1.left, root2);
			}
			if (!res) {
				res = HasSubtree(root1.right, root2);
			}

		}
		return res;
	}

	private boolean isSame(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val == root2.val) {
			return isSame(root1.right, root2.right) && isSame(root1.left, root2.left);
		} else {
			return false;
		}

	}
}
