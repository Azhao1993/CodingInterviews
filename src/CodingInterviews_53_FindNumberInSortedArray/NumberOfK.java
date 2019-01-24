package CodingInterviews_53_FindNumberInSortedArray;

/*
	面试题53：在排序数组中查找数字
		题目一：数字在排序数组中的次数
			统计一个数字在排序数组中出现的次数。
 */
public class NumberOfK {
	public int GetNumberOfK(int[] array, int k) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == k) {
				count++;
			}
			if (array[i] > k) {
				return count;
			}
		}
		return count;
	}
	// cpp版本改写
	// 二分查找到第一个k
}
