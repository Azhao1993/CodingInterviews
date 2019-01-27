package CodingInterviews_32_PrintTree;

import java.util.ArrayList;
import TreeNode.TreeNode;

/*
	面试题32（三）：之字形打印二叉树
		请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
		第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTreesInZigzag {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Print(pRoot, 0, result);
		return result;
	}

	public void Print(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> result) {
		if (pRoot == null) {
			return;
		}
		if (result.size() <= depth) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(pRoot.val);
			result.add(list);
		} else if (depth % 2 == 0) {
			result.get(depth).add(pRoot.val);
		} else {
			result.get(depth).add(0, pRoot.val);
		}
		Print(pRoot.left, depth + 1, result);
		Print(pRoot.right, depth + 1, result);
	}
}
