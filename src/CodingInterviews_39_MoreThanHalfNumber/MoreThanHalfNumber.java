package CodingInterviews_39_MoreThanHalfNumber;

import java.util.Arrays;

/*
	������39�������г��ִ�������һ�������
		��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
		��������һ������Ϊ9������{1, 2, 3, 2, 2, 2, 5, 4, 2}��
		��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
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

	// cpp�汾��д
	// ====================����2====================
	// Ҫ�ҵ����ֳ��ֵĴ������������ֳ��ִ���֮�Ͷ���
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
