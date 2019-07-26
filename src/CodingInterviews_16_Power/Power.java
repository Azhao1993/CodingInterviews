package CodingInterviews_16_Power;

/*
	������16����ֵ�������η�
		����һ��double���͵ĸ�����base��int���͵�����exponent��
		��base��exponent�η���
 */
public class Power {
	// ע��:0^0������
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
		// ������
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

	// cpp�����д
	public double powerCpptoJava(double base, int exponent) {
		// g_InvalidInput��־�����ǲ���0
		boolean g_InvalidInput = false;
		// ����Ϊ0�����0��
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

	// �ݹ�ʵ��
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

	// �ж��Ƿ���Ϊ0
	public boolean equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else
			return false;
	}
}
