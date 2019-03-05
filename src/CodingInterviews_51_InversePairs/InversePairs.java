package CodingInterviews_51_InversePairs;

/*
	面试题51：数组中的逆序对
		在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
		输入一个数组，求出这个数组中的逆序对的总数。
		
	题目描述（牛客网）：		
		在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
		输入一个数组,求出这个数组中的逆序对的总数P。
		并将P对1000000007取模的结果输出。
		 即输出P%1000000007
	输入描述:
		题目保证输入的数组中没有的相同的数字
	
	数据范围：	
		对于%50的数据,size<=10^4	
		对于%75的数据,size<=10^5	
		对于%100的数据,size<=2*10^5
	
	示例1
		输入	
			1,2,3,4,5,6,7,0
		输出	
			7
 */
public class InversePairs {
	public int inversePairs(int[] array) {
		if (array == null || array.length <= 0) {
			return 0;
		}

		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}

		int count = InversPairsCore(array, copy, 0, array.length - 1);
		return count;
	}

	private int InversPairsCore(int[] array, int[] copy, int start, int end) {
		if (start == end) {
			copy[start] = array[start];
			return 0;
		}
		int length = (end - start) / 2;
		int left = InversPairsCore(copy, array, start, start + length);
		// int left = InversPairsCore(copy, array, start, start + length)%1000000007;
		int right = InversPairsCore(copy, array, start + length + 1, end);
		// int right = InversPairsCore(copy, array, start + length + 1, end)%1000000007;

		// i初始化为前半段最后一个数字的下标
		int i = start + length;
		// j初始化为后半段最后一个数字的下标
		int j = end;
		int indexCopy = end;
		int count = 0;
		while (i >= start && j >= start + length + 1) {
			if (array[i] > array[j]) {
				copy[indexCopy--] = array[i--];
				count += j - start - length;
//				if (count >= 1000000007) {
//					// 数值过大求余
//					count %= 1000000007;
//				}
			} else {
				copy[indexCopy--] = array[j--];
			}

		}
		for (; i >= start; --i) {
			copy[indexCopy--] = array[i];
		}
		for (; j >= start + length + 1; --j) {
			copy[indexCopy--] = array[j];
		}
		return left + right + count;
		// return (left + right + count)%1000000007;
	}
}
