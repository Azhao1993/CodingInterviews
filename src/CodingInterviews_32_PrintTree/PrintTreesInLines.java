package CodingInterviews_32_PrintTreeFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;

/*
	������32���������Ѷ�������ӡ�ɶ���
		���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
*/
public class PrintTreesInLines {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		return Print(pRoot, 0, result);

	}

	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> result) {
		if (pRoot == null) {
			return result;
		}
		if (depth >= result.size()) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(pRoot.val);
			result.add(temp);
		} else {
			result.get(depth).add(pRoot.val);
		}
		if (pRoot.left != null) {
			result = Print(pRoot.left, depth + 1, result);
		}
		if (pRoot.right != null) {
			result = Print(pRoot.right, depth + 1, result);
		}
		return result;
	}

	// cpp�汾��д

	// ͳ��ÿ��ĸ���
	public void PrintCppToJava(TreeNode pRoot) {
		if (pRoot == null)
			return;

		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.offer(pRoot);
		int nextLevel = 0;
		int toBePrinted = 1;
		while (!nodes.isEmpty()) {
			TreeNode pNode = nodes.peek();
			System.out.println(pNode.val);

			if (pNode.left != null) {
				nodes.offer(pNode.left);
				++nextLevel;
			}
			if (pNode.right != null) {
				nodes.offer(pNode.right);
				++nextLevel;
			}

			nodes.poll();
			--toBePrinted;
			if (toBePrinted == 0) {
				System.out.println();
				toBePrinted = nextLevel;
				nextLevel = 0;
			}
		}
	}
}
