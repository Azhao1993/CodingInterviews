package CodingInterviews_67_StringToInt;

/*
	面试题67：把字符串转换成整数
		将一个字符串转换成一个整数
		(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
		要求不能使用字符串转换整数的库函数。
		 数值为0或者字符串不是一个合法的数值则返回0。
		输入描述:
			输入一个字符串,包括数字字母符号,可以为空
		输出描述:
			如果是合法的数值表达则返回该数字，否则返回0
		示例：
			输入：	
				+2147483647
				    1a33
			输出：		
				2147483647
				    0
 */
public class StringToInt {
	public int StrToInt(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] arr = str.toCharArray();
		boolean flag = false;
		if (arr[0] == '-' || arr[0] == '+') {
			flag = true;
		} else if (!isNum(arr[0])) {
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 && flag) {
				continue;
			}
			if (isNum(arr[i])) {
				sum = sum * 10 + (arr[i] - '0');
			} else {
				return 0;
			}
		}
		if (flag && arr[0] == '-') {
			return -1 * sum;
		}
		return sum;

	}

	//
	public boolean isNum(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}
	// cpp版本改写

}
