package CodingInterviews_65_AddTwoNumbers;

/*
	面试题65：不用加减乘除做加法
		写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
		四则运算符号。
 */
public class AddTwoNumbers {
	public int Add(int num1, int num2) {
		// 不进位求和
		int sum = num1 ^ num2;// 异或：不同为0
		// 进位计算
		int carry = (num1 & num2) << 1;// 右移右侧添0
		while (carry != 0) {
			num1 = sum;
			num2 = carry;
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
		}
		return sum;
	}
	// cpp版本改写
	// 同上
}
