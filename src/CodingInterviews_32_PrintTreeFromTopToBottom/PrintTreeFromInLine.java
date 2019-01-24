package CodingInterviews_32_PrintTreeFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	������32��һ���������д������´�ӡ������
		�������´�ӡ����������ÿ����㣬ͬһ��Ľ�㰴�մ����ҵ�˳���ӡ��
 */
public class PrintTreeFromInLine {
	// ����
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			result.add(cur.val);
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
		return result;
	}
	// cpp�汾��д
	// ͬ��
}
