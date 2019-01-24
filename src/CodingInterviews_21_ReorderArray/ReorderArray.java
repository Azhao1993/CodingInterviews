package CodingInterviews_21_ReorderArray;

/*
	 面试题21：调整数组顺序使奇数位于偶数前面
	 	输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	 	使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class ReorderArray {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		new ReorderArray().reOrderArray(array);
	}

	public void reOrderArray(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int right = array.length - 1;
		while (right > 0) {
			while (array[right] % 2 == 0) {
				right--;
			}
			for (int j = right - 1; j >= 0; j--) {
				if (array[j] % 2 == 0) {
					for (int t = j; t < right; t++) {
						int temp = array[t];
						array[t] = array[t + 1];
						array[t + 1] = temp;
					}
					break;
				}
				if (j == 0) {
					return;
				}
			}
		}
	}

	// cpp版本改写
	// 题目要求有所不同：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	// 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
	// ====================方法一====================
	public void ReorderOddEven_1(int[] pData) {
		int length = pData.length;
		if (pData == null || length == 0)
			return;

		int pBegin = 0;
		int pEnd = length - 1;

		while (pBegin < pEnd) {
			// 向后移动pBegin，直到它指向偶数
			while (pBegin < pEnd && (pData[pBegin] & 0x1) != 0)
				pBegin++;

			// 向前移动pEnd，直到它指向奇数
			while (pBegin < pEnd && (pData[pEnd] & 0x1) == 0)
				pEnd--;

			if (pBegin < pEnd) {
				int temp = pData[pBegin];
				pData[pBegin] = pData[pEnd];
				pData[pEnd] = temp;
			}
		}
	}

	// ====================方法二(函数做为参数传递)====================
	// 负数在非负数前面
	// 能被3整除的在不能被3整除的前面
	

}
