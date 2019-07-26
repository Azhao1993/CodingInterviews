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

		// ���������˼��
		for (int i = 1; i < array.length; i++) {
			if (!isEven(array[i])) {
				continue;
			}
			for (int j = i; j > 0; j--) {
				if (isEven(array[j - 1])) {
					break;
				} else {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	private boolean isEven(int i) {
		return i % 2 == 1;
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
