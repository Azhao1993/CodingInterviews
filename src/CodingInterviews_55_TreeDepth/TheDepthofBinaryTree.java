package CodingInterviews_55_TreeDepth;

import TreeNode.TreeNode;

/*
	������55:
		����һ�ö����������������ȡ�
		�Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class TheDepthofBinaryTree {
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getTreeDepth(root, 1, 1);
	}
	//�ݹ�
	public int getTreeDepth(TreeNode root, int depth, int result) {
		if (root == null) {
			return Math.max(depth - 1, result);
		}
		result = Math.max(getTreeDepth(root.left, depth + 1, result), result);
		result = Math.max(getTreeDepth(root.right, depth + 1, result), result);
		return result;
	}
}
