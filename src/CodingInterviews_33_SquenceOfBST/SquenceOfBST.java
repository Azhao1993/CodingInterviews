package CodingInterviews_33_SquenceOfBST;

/*

 ������33�������������ĺ����������
	 ��Ŀ������һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
	 ������򷵻�true�����򷵻�false���������������������������ֶ�������ͬ��
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
