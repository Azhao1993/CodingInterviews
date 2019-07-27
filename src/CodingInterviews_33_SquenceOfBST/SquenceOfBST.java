package CodingInterviews_33_SquenceOfBST;

/*

 面试题33：二叉搜索树的后序遍历序列
	 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
	 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class SquenceOfBST {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}
		int length = sequence.length;
		return VerifySquenceOfBST(sequence, 0, length - 2, sequence[length - 1]);
	}

	private boolean VerifySquenceOfBST(int[] sequence, int start, int end, int val) {
		if (start > end) {
			return true;
		}
		int index = start;
		boolean flag = true;
		for (int i = start; i <= end; i++) {
			if (sequence[i] < val && flag) {
				index = i;
			} else {
				flag = false;
				if (sequence[i] < val) {
					return false;
				}
			}
		}
		if (!VerifySquenceOfBST(sequence, start, index - 1, sequence[index])) {
			return false;
		}
		if (!VerifySquenceOfBST(sequence, index + 1, end - 1, sequence[end])) {
			return false;
		}
		return true;
	}
}
