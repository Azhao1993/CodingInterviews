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

	// cpp版本改写
	public boolean HasSubtreeCpptoJava(TreeNode pRoot1, TreeNode pRoot2) {
		boolean result = false;

		if (pRoot1 != null && pRoot2 != null) {
			if (Equal(pRoot1.val, pRoot2.val))
				result = DoesTree1HaveTree2(pRoot1, pRoot2);
			if (!result)
				result = HasSubtreeCpptoJava(pRoot1.left, pRoot2);
			if (!result)
				result = HasSubtreeCpptoJava(pRoot1.right, pRoot2);
		}

		return result;
	}

	public boolean DoesTree1HaveTree2(TreeNode pRoot1, TreeNode pRoot2) {
		if (pRoot2 == null)
			return true;

		if (pRoot1 == null)
			return false;

		if (!Equal(pRoot1.val, pRoot2.val))
			return false;

		return DoesTree1HaveTree2(pRoot1.left, pRoot2.left) && DoesTree1HaveTree2(pRoot1.right, pRoot2.right);
	}

	public boolean Equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else
			return false;
	}
}
