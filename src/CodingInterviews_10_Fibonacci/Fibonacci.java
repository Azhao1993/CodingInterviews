package CodingInterviews_10_Fibonacci;

/*
	面试题10：斐波那契数列
		写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
		从0开始，第0项为0
		n<=39
 */
public class Fibonacci {
	// 注意：第0项是0
	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}

	// cpp版本改写
	// ====================方法1：递归====================
	public long Fibonacci_Solution1(int n) {
		if (n <= 0)
			return 0;

		if (n == 1)
			return 1;

		return Fibonacci_Solution1(n - 1) + Fibonacci_Solution1(n - 2);
	}

	// ====================方法2：循环====================
	public long Fibonacci_Solution2(int n) {
		int[] result = { 0, 1 };
		if (n < 2)
			return result[n];

		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fibN = 0;
		for (int i = 2; i <= n; ++i) {
			fibN = fibNMinusOne + fibNMinusTwo;

			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}

		return fibN;
	}

	// ====================方法3：基于矩阵乘法====================

}
