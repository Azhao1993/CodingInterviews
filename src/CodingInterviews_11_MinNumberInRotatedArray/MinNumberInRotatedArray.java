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

		// ������ת O(N)
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return array[i];
			}
		}
		// ��������ת
		return array[0];
	}

	// ��������õ�ʱ��Ϊ O(logN)
	public int minNumberInRotateArray2(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int left = 0;// ǰ��Σ���
		int right = array.length - 1;// ���Σ�С��

		while (left <= right) {
			if (left + 1 == right) {
				// ��ʱleftΪǰ��ε����һ����rightΪ���εĵ�һ��
				return array[right];
			}
			int mid = (left + right) / 2;
			if (array[left] == array[mid] && array[right] == array[left]) {
				// �޷��жϳ�����һ��ֻ�ܽ��б�������
				return minInArray(array, left, right);
			}

			if (array[mid] >= array[left]) {
				// ��Сֵ�ں���
				left = mid;
			}

			if (array[mid] <= array[right]) {
				// ��Сֵ��ǰ���
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
