package CodingInterviews_39_MoreThanHalfNumber;

import java.util.Arrays;

/*
	面试题39：数组中出现次数超过一半的数字
		数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
		例如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。
		由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */

public class MoreThanHalfNumber {
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null) {
			return 0;
		}
		if (array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		Arrays.sort(array);
		int result = array[array.length / 2];
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				count++;
			}
		}
		if (count > array.length / 2) {
			return result;
		} else {
			return 0;
		}

	}

	// cpp版本改写
	// ====================方法2====================
	// 要找的数字出现的次数比其他数字出现次数之和都多
	boolean g_bInputInvalid = false;

	int MoreThanHalfNum_Solution2(int[] numbers, int length) {
		if (CheckInvalidArray(numbers, length))
			return 0;

		int result = numbers[0];
		int times = 1;
		for (int i = 1; i < length; ++i) {
			if (times == 0) {
				result = numbers[i];
				times = 1;
			} else if (numbers[i] == result)
				times++;
			else
				times--;
		}

		if (!CheckMoreThanHalf(numbers, length, result))
			result = 0;

		return result;
	}

	boolean CheckMoreThanHalf(int[] numbers, int length, int number) {
		int times = 0;
		for (int i = 0; i < length; ++i) {
			if (numbers[i] == number)
				times++;
		}

		boolean isMoreThanHalf = true;
		if (times * 2 <= length) {
			g_bInputInvalid = true;
			isMoreThanHalf = false;
		}

		return isMoreThanHalf;
	}

	boolean CheckInvalidArray(int[] numbers, int length) {
		g_bInputInvalid = false;
		if (numbers == null && length <= 0)
			g_bInputInvalid = true;

		return g_bInputInvalid;
	}
}
