package CodingInterviews_10_Fibonacci;

/*
	���θ��ǣ�
		���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
		������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 */
public class RectCover {
	public int rectCover(int target) {
		if (target <= 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		int zero = 1;// f(n-2)
		int one = 1;// f(n-1)
		int result = 0;// f(n)
		for (int i = 2; i <= target; i++) {
			result = zero + one;
			zero = one;
			one = result;
		}
		return result;
	}
}
