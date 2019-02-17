package CodingInterviewChinese_40_KLeastNumbers;

import java.util.ArrayList;

/*
	面试题40：最小的k个数
		输入n个整数，找出其中最小的k个数。
		例如输入4、5、1、6、2、7、3、8
		这8个数字，则最小的4个数字是1、2、3、4。
 */

public class KLeastNumbers {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (k > input.length) {
			return result;
		}

		for (int i = 0; i < k && i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] > input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
			result.add(input[i]);
		}
		return result;
	}
}
