package CodingInterviews_53_FindNumberInSortedArray;

/*
	������53�������������в�������
		��Ŀһ�����������������еĴ���
			ͳ��һ�����������������г��ֵĴ�����
 */
public class NumberOfK {
	public int GetNumberOfK(int[] array, int k) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == k) {
				count++;
			}
			if (array[i] > k) {
				return count;
			}
		}
		return count;
	}
	// cpp�汾��д
	// ���ֲ��ҵ���һ��k
}
