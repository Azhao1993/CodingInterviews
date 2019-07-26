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

		// 存在旋转 O(N)
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return array[i];
			}
		}
		// 不存在旋转
		return array[0];
	}

	// 数据情况好的时候为 O(logN)
	public int minNumberInRotateArray2(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int left = 0;// 前半段（大）
		int right = array.length - 1;// 后半段（小）

		while (left <= right) {
			if (left + 1 == right) {
				// 此时left为前半段的最后一个，right为后半段的第一个
				return array[right];
			}
			int mid = (left + right) / 2;
			if (array[left] == array[mid] && array[right] == array[left]) {
				// 无法判断出在哪一段只能进行遍历查找
				return minInArray(array, left, right);
			}

			if (array[mid] >= array[left]) {
				// 最小值在后半段
				left = mid;
			}

			if (array[mid] <= array[right]) {
				// 最小值在前半段
				right = mid;
			}
		}
		return 0;
	}

	private int minInArray(int[] array, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			if (array[i] < array[i - 1]) {
				return array[i];
			}
		}
		return array[left];
	}
}
