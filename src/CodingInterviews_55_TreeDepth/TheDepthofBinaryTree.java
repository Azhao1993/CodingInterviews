package CodingInterviews_55_TreeDepth;

import TreeNode.TreeNode;

/*
	������55�������������
		����һ�ö����������������ȡ�
		�Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class TheDepthofBinaryTree {
	// ������55
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getTreeDepth(root, 1, 1);
	}

	// �ݹ�
	public int getTreeDepth(TreeNode root, int depth, int result) {
		if (root == null) {
			return Math.max(depth - 1, result);
		}
		result = Math.max(getTreeDepth(root.left, depth + 1, result), result);
		result = Math.max(getTreeDepth(root.right, depth + 1, result), result);
		return result;
	}

	// cpp���д
	public int TreeDepthCpptoJava(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		return (left > right) ? (left + 1) : (right + 1);
	}
}
