package CodingInterviews_15_NumberOf1InBinary;

/*
	面试题15：二进制中1的个数
		输入一个整数，输出该数二进制表示中1的个数。
		其中负数用补码表示。15：二进制中1的个数
 */
public class NumberOf1InBinary {

	// 可能引起死循环的解法
	public int NumberOf1(int n) {
		int result = 0;
		while (n != 0) {
			result += n & 1;
			n >>>= 1;
		}
		return result;
	}

	// cpp代码改写
	// 常规解法
	public int NumberOf1_Solution1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	// 能给面试官带来惊喜的解法
	// n=(n - 1) & n：将n最右边的1变成0
	public int NumberOf1_Solution2(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
}
