package CodingInterviews_16_Power;

/*
	面试题16：数值的整数次方
		给定一个double类型的浮点数base和int类型的整数exponent。
		求base的exponent次方。
 */
public class Power {
	// 注意:0^0无意义
	public double power(double base, int exponent) {
		Math.pow(base, exponent);
		double res = 1;
		if (exponent == 0) {
			return res;
		}
		boolean flag = exponent < 0;
		if (flag) {
			exponent = -exponent;
		}
		// 快速幂
		while (exponent > 0) {
			if ((exponent & 1) == 1) {
				res *= base;
			}
			base *= base;
			exponent >>= 1;
		}
		if (flag) {
			res = 1 / res;
		}
		return res;
	}

	// cpp代码改写
	public double powerCpptoJava(double base, int exponent) {
		// g_InvalidInput标志输入是不是0
		boolean g_InvalidInput = false;
		// 输入为0，输出0；
		if (equal(base, 0.0) && exponent < 0) {
			g_InvalidInput = true;
			return 0.0;
		}

		int absExponent = (int) (exponent);
		if (exponent < 0)
			absExponent = (int) (-exponent);

		double result = PowerWithUnsignedExponent1(base, absExponent);
		if (exponent < 0)
			result = 1.0 / result;

		return result;
	}

	public double PowerWithUnsignedExponent1(double base, int exponent) {
		double result = 1.0;

		for (int i = 1; i <= exponent; ++i)
			result *= base;
		return result;
	}

	// 递归实现
	double PowerWithUnsignedExponent2(double base, int exponent) {
		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return base;

		double result = PowerWithUnsignedExponent2(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1)
			result *= base;

		return result;
	}

	// 判断是否是为0
	public boolean equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else
			return false;
	}
}
