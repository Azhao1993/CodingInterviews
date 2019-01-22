package CodingInterviews_10_Fibonacci;

/*
	������10��쳲���������
		дһ������������n����쳲�������Fibonacci�����еĵ�n�
		��0��ʼ����0��Ϊ0
		n<=39
 */
public class Fibonacci {
	// ע�⣺��0����0
	public int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// cpp�汾��д
	// ====================����1���ݹ�====================
	// Ч�ʺܵ͵Ľⷨ�����޵����Թٲ���ϲ��
	public long Fibonacci_Solution1(int n) {
		if (n <= 0)
			return 0;

		if (n == 1)
			return 1;

		return Fibonacci_Solution1(n - 1) + Fibonacci_Solution1(n - 2);
	}

	// ====================����2��ѭ��====================
	// ���Թ��ڴ���ʵ�ýⷨ
	public long Fibonacci_Solution2(int n) {
		int[] result = { 0, 1 };
		if (n < 2)
			return result[n];

		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fibN = 0;
		// f(n)=f(n-1)+f(n-2)
		// f(n-2)=f(n-1)
		// f(n-1)=f(n)
		for (int i = 2; i <= n; ++i) {
			fibN = fibNMinusOne + fibNMinusTwo;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
	}

	// ====================����3�����ھ���˷�====================
	// ʱ�临�Ӷ�O��log n������ʵ�õĽⷨ

}
