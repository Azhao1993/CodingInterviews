package CodingInterviews_57_ContinuousSquenceWithSum;

import java.util.ArrayList;

/*
	������57��һ������Ϊs����������
		����һ����������������һ������s���������в�����������ʹ������
		�ĺ�������s������ж�����ֵĺ͵���s���������һ�Լ��ɡ�
 */
public class TwoNumbersWithSum {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int min = 0;
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] + array[j] == sum) {
					if (result.size() == 0) {
						min = array[j];
						max = array[i];
						result.add(min);
						result.add(max);
					} else if (min * max > array[i] * array[j]) {
						min = array[j];
						max = array[i];
						result.clear();
						result.add(min);
						result.add(max);
					}
				}
			}
		}
		return result;
	}
}
