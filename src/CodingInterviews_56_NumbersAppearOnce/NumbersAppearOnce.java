package CodingInterviews_56_NumbersAppearOnce;

/*
	面试题56（一）：数组中只出现一次的两个数字
		一个整型数组里除了两个数字之外，其他的数字都出现了两次。
		请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class NumbersAppearOnce {
	public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
		int flag = array[0];
		for (int i = 1; i < array.length; i++) {
			flag ^= array[i];
		}
		int count = 1;
		while (flag > 0) {
			if (flag % 2 == 1) {
				break;
			} else {
				flag /= 2;
				count *= 2;
			}
		}

		for (int i = 0; i < array.length; i++) {
			if ((array[i] & count) == count) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	// cpp版本改写
	public void FindNumsAppearOnceCppToJava(int[] data, int[] num1, int[] num2) {
		int length = data.length;
		if (data == null || length < 2)
			return;
		// flag
		int resultExclusiveOR = 0;
		for (int i = 0; i < length; ++i)
			resultExclusiveOR ^= data[i];
		// 倒数第一个1的位置
		int indexOf1 = FindFirstBitIs1(resultExclusiveOR);

		num1[0] = 0;
		num2[0] = 0;

		for (int j = 0; j < length; ++j) {
			if (IsBit1(data[j], indexOf1))
				num1[0] ^= data[j];
			else
				num2[0] ^= data[j];
		}
	}

	// 找到num从右边数起第一个是1的位
	public int FindFirstBitIs1(int num) {
		int indexBit = 0;
		// while(((num & 1) == 0) && (indexBit < 8 * sizeof(int)))
		while (((num & 1) == 0) && (indexBit < 31)) {
			num = num >> 1;
			++indexBit;
		}

		return indexBit;
	}

	// 判断数字num的第indexBit位是不是1
	boolean IsBit1(int num, int indexBit) {
		num = num >> indexBit;
		return ((num & 1) == 1);
	}

}
