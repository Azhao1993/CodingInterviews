package CodingInterviews_56_NumbersAppearOnce;

/*
	������56��һ����������ֻ����һ�ε���������
		һ�����������������������֮�⣬���������ֶ����������Ρ�
		��д�����ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
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

	// cpp�汾��д
	public void FindNumsAppearOnceCppToJava(int[] data, int[] num1, int[] num2) {
		int length = data.length;
		if (data == null || length < 2)
			return;
		// flag
		int resultExclusiveOR = 0;
		for (int i = 0; i < length; ++i)
			resultExclusiveOR ^= data[i];
		// ������һ��1��λ��
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

	// �ҵ�num���ұ������һ����1��λ
	public int FindFirstBitIs1(int num) {
		int indexBit = 0;
		// while(((num & 1) == 0) && (indexBit < 8 * sizeof(int)))
		while (((num & 1) == 0) && (indexBit < 31)) {
			num = num >> 1;
			++indexBit;
		}

		return indexBit;
	}

	// �ж�����num�ĵ�indexBitλ�ǲ���1
	boolean IsBit1(int num, int indexBit) {
		num = num >> indexBit;
		return ((num & 1) == 1);
	}

}
