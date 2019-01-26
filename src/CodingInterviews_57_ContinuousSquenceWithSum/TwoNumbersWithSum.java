package CodingInterviews_57_ContinuousSquenceWithSum;

import java.util.ArrayList;

/*
	面试题57（一）：和为s的两个数字
		输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
		的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 */
public class TwoNumbersWithSum {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int min = 0;
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] + array[j] == sum) {
					if (result.size() == 0) {
						min = array[j];
						max = array[i];
						result.add(min);
						result.add(max);
					} else if (min * max > array[i] * array[j]) {
						min = array[j];
						max = array[i];
						result.clear();
						result.add(min);
						result.add(max);
					}
				}
			}
		}
		return result;
	}
}
