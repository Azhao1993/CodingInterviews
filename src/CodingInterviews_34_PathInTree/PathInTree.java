package CodingInterviews_34_PathInTree;

import java.util.ArrayList;

import TreeNode.TreeNode;

/*
	面试题34：二叉树中和为某一值的路径
		输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
		从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathInTree {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		getPath(root, target, new ArrayList<Integer>(), res);
		return res;
	}

	private void getPath(TreeNode root, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
		if (root == null || target < 0) {
			return;
		}
		if (root.left == null && root.right == null && root.val == target) {
			cur.add(root.val);
			res.add(new ArrayList<>(cur));
			cur.remove(cur.size() - 1);
			return;
		}

		cur.add(root.val);
		getPath(root.left, target - root.val, cur, res);
		getPath(root.right, target - root.val, cur, res);
		cur.remove(cur.size() - 1);
	}
}