package CodingInterviews_45_SortArrayForMinNumber;

import java.util.Arrays;

/*
	面试题45：把数组排成最小的数
		输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
		打印能拼接出的所有数字中最小的一个。
		例如输入数组{3, 32, 321}，
		则打印出这3个数字能排成的最小数字321323。
 */
public class SortArrayForMinNumber {
	public static void main(String[] args) {
		SortArrayForMinNumber safmn = new SortArrayForMinNumber();
		int[] numbers = { 3, 32, 321 };
		System.out.println(safmn.PrintMinNumber(numbers));
	}

	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return null;
		}
		Arrays.sort(numbers);
		String result = String.valueOf(numbers[0]);
		if (numbers.length == 1) {
			return result;
		}
		for (int i = 1; i < numbers.length; i++) {
			String temp = String.valueOf(numbers[i]);
			result = compare(result, temp);
		}
		return result;

	}

	public String compare(String result, String temp) {
		String a = result + temp;
		String b = temp + result;
		if (a.compareTo(b) < 0) {
			return a;
		} else {
			return b;
		}
	}
}
