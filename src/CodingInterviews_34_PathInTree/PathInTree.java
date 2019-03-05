package CodingInterviews_34_PathInTree;

import java.util.ArrayList;

import TreeNode.TreeNode;

/*
	面试题34：二叉树中和为某一值的路径
		输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
		从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathInTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node12 = new TreeNode(12);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		root.left = node5;
		root.right = node12;
		node5.left = node4;
		node5.right = node7;
		int target = 22;
		new PathInTree().FindPath(root, target);

	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		FindPath(root, target, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void FindPath(TreeNode root, int target, int sum, ArrayList<Integer> arrayList,
			ArrayList<ArrayList<Integer>> result) {

		if (root == null && sum != target)
			return;

		if (sum < target) {
			arrayList.add(root.val);
			sum += root.val;
			if (root.left == null && root.right == null) {
				if (sum == target) {
					result.add(new ArrayList(arrayList));					
				}
				arrayList.remove(arrayList.size()-1);
				sum -= root.val;
				return;
			}
			FindPath(root.left, target, sum, arrayList, result);
			FindPath(root.right, target, sum, arrayList, result);
			arrayList.remove(arrayList.size()-1);
		}

	}
}