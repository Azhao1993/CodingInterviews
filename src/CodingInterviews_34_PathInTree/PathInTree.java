package CodingInterviews_34_PathInTree;

import java.util.ArrayList;

import TreeNode.TreeNode;

/*
	������34���������к�Ϊĳһֵ��·��
		����һ�ö�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
		�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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