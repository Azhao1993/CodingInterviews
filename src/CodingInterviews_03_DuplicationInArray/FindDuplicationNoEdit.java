package CodingInterviews_03_DuplicationInArray;

/*
	面试题3（二）：不修改数组找出重复的数字
		在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。
		请找出数组中任意一个重复的数字，但不能修改输入的 数组。
		例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
 */
public class FindDuplicationNoEdit {
	// cpp版本改写
	// 参数:
	//  numbers:     一个整数数组
	//  length:      数组的长度
	//返回值:             
	//  正数  - 输入有效，并且数组中存在重复的数字，返回值为重复的数字
	//  负数  - 输入无效，或者数组中没有重复的数字
	public int getDuplication(int[] numbers, int length) {
		if (numbers == null || length <= 0)
			return -1;

		int start = 1;
		int end = length - 1;
		while (end >= start) {
			int middle = ((end - start) >> 1) + start;
			int count = countRange(numbers, length, start, middle);
			if (end == start) {
				if (count > 1)
					return start;
				else
					break;
			}

			if (count > (middle - start + 1))
				end = middle;
			else
				start = middle + 1;
		}
		return -1;
	}

	public int countRange(int[] numbers, int length, int start, int end) {
		if (numbers == null)
			return 0;

		int count = 0;
		for (int i = 0; i < length; i++)
			if (numbers[i] >= start && numbers[i] <= end)
				++count;
		return count;
	}
}
