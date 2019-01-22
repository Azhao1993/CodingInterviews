package CodingInterviews_11_MinNumberInRotatedArray;

/*
	面试题11：旋转数组的最小数字
		把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
		输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
		例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
		NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotatedArray {
	public int minNumberInRotateArray(int[] array) {
		// 若数组大小为0，请返回0。
		if (array == null || array.length == 0) {
			return 0;
		}
		// 数组长度为1
		if (array.length == 1) {
			return array[0];
		}
		// 存在旋转
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return array[i];
			}
		}
		// 不存在旋转
		return array[0];
	}

	// cpp版本改写
	public int Min(int[] numbers, int length) {
		if (numbers == null || length <= 0) {
			return 0;
		}

		int index1 = 0;
		int index2 = length - 1;
		int indexMid = index1;
		while (numbers[index1] >= numbers[index2]) {
			// 如果index1和index2指向相邻的两个数，
			// 则index1指向第一个递增子数组的最后一个数字，
			// index2指向第二个子数组的第一个数字，也就是数组中的最小数字
			if (index2 - index1 == 1) {
				indexMid = index2;
				break;
			}

			// 如果下标为index1、index2和indexMid指向的三个数字相等，
			// 则只能顺序查找
			indexMid = (index1 + index2) / 2;
			if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1])
				return MinInOrder(numbers, index1, index2);

			// 缩小查找范围
			if (numbers[indexMid] >= numbers[index1])
				index1 = indexMid;
			else if (numbers[indexMid] <= numbers[index2])
				index2 = indexMid;
		}

		return numbers[indexMid];
	}

	public int MinInOrder(int[] numbers, int index1, int index2) {
		int result = numbers[index1];
		for (int i = index1 + 1; i <= index2; ++i) {
			if (result > numbers[i])
				result = numbers[i];
		}

		return result;
	}
}
