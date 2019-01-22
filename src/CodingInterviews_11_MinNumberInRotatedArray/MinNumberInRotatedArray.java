package CodingInterviews_11_MinNumberInRotatedArray;

/*
	������11����ת�������С����
		��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
		����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء� 
		��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
		NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
public class MinNumberInRotatedArray {
	public int minNumberInRotateArray(int[] array) {
		// �������СΪ0���뷵��0��
		if (array == null || array.length == 0) {
			return 0;
		}
		// ���鳤��Ϊ1
		if (array.length == 1) {
			return array[0];
		}
		// ������ת
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return array[i];
			}
		}
		// ��������ת
		return array[0];
	}

	// cpp�汾��д
	public int Min(int[] numbers, int length) {
		if (numbers == null || length <= 0) {
			return 0;
		}

		int index1 = 0;
		int index2 = length - 1;
		int indexMid = index1;
		while (numbers[index1] >= numbers[index2]) {
			// ���index1��index2ָ�����ڵ���������
			// ��index1ָ���һ����������������һ�����֣�
			// index2ָ��ڶ���������ĵ�һ�����֣�Ҳ���������е���С����
			if (index2 - index1 == 1) {
				indexMid = index2;
				break;
			}

			// ����±�Ϊindex1��index2��indexMidָ�������������ȣ�
			// ��ֻ��˳�����
			indexMid = (index1 + index2) / 2;
			if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1])
				return MinInOrder(numbers, index1, index2);

			// ��С���ҷ�Χ
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
