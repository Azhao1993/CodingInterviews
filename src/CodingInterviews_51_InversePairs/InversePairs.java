package CodingInterviews_51_InversePairs;

/*
	������51�������е������
		�������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
		����һ�����飬�����������е�����Ե�������
		
	��Ŀ������ţ��������		
		�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
		����һ������,�����������е�����Ե�����P��
		����P��1000000007ȡģ�Ľ�������
		 �����P%1000000007
	��������:
		��Ŀ��֤�����������û�е���ͬ������
	
	���ݷ�Χ��	
		����%50������,size<=10^4	
		����%75������,size<=10^5	
		����%100������,size<=2*10^5
	
	ʾ��1
		����	
			1,2,3,4,5,6,7,0
		���	
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

		// i��ʼ��Ϊǰ������һ�����ֵ��±�
		int i = start + length;
		// j��ʼ��Ϊ�������һ�����ֵ��±�
		int j = end;
		int indexCopy = end;
		int count = 0;
		while (i >= start && j >= start + length + 1) {
			if (array[i] > array[j]) {
				copy[indexCopy--] = array[i--];
				count += j - start - length;
//				if (count >= 1000000007) {
//					// ��ֵ��������
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
