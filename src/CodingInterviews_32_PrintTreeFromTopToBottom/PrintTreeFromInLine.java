package CodingInterviews_32_PrintTreeFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	面试题32（一）：不分行从上往下打印二叉树
		从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
public class PrintTreeFromInLine {
	// 队列
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
	// cpp版本改写
	// 同上
}
