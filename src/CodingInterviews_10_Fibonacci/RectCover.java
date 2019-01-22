package CodingInterviews_10_Fibonacci;

/*
	矩形覆盖：
		我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
		请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
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
