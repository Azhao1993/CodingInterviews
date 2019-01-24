package CodingInterviews_21_ReorderArray;

/*
	 ������21����������˳��ʹ����λ��ż��ǰ��
	 	����һ���������飬ʵ��һ�����������������������ֵ�˳��
	 	ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
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

	// cpp�汾��д
	// ��ĿҪ��������ͬ������һ���������飬ʵ��һ�����������������������ֵ�˳��
	// ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
	// ====================����һ====================
	public void ReorderOddEven_1(int[] pData) {
		int length = pData.length;
		if (pData == null || length == 0)
			return;

		int pBegin = 0;
		int pEnd = length - 1;

		while (pBegin < pEnd) {
			// ����ƶ�pBegin��ֱ����ָ��ż��
			while (pBegin < pEnd && (pData[pBegin] & 0x1) != 0)
				pBegin++;

			// ��ǰ�ƶ�pEnd��ֱ����ָ������
			while (pBegin < pEnd && (pData[pEnd] & 0x1) == 0)
				pEnd--;

			if (pBegin < pEnd) {
				int temp = pData[pBegin];
				pData[pBegin] = pData[pEnd];
				pData[pEnd] = temp;
			}
		}
	}

	// ====================������(������Ϊ��������)====================
	// �����ڷǸ���ǰ��
	// �ܱ�3�������ڲ��ܱ�3������ǰ��
	

}
