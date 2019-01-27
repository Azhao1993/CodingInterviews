package CodingInterviews_32_PrintTree;

import java.util.ArrayList;
import TreeNode.TreeNode;

/*
	������32��������֮���δ�ӡ������
		��ʵ��һ����������֮����˳���ӡ������������һ�а��մ����ҵ�˳���ӡ��
		�ڶ��㰴�մ��ҵ����˳���ӡ���������ٰ��մ����ҵ�˳���ӡ���������Դ����ơ�
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
