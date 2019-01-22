package CodingInterviews_10_Fibonacci;

/*
	��̬��̨�ף�
		һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
		�����������һ��n����̨���ܹ��ж�����������
 */
public class JumpFloorII {
	// f(n)=2^(n-1)
	public int JumpFloor2(int target) {
		if (target < 0) {
			return 0;
		}
		if (target < 1) {
			return 1;
		}
		int[] result = new int[target + 1];
		result[0] = 1;

		for (int i = 1; i <= target; i++) {
			int res = 0;
			for (int j = 0; j < i; j++) {
				res += result[j];
			}
			result[i] = res;
		}
		return result[target];

	}
}
