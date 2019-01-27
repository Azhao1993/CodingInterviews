package CodingInterviews_03_DuplicationInArray;

/*
	������3�����������޸������ҳ��ظ�������
		��һ������Ϊn+1����������������ֶ���1��n�ķ�Χ�ڣ�����������������һ���������ظ��ġ�
		���ҳ�����������һ���ظ������֣��������޸������ ���顣
		���磬������볤��Ϊ8������{2, 3, 5, 4, 3, 2, 6, 7}����ô��Ӧ��������ظ�������2����3��
 */
public class FindDuplicationNoEdit {
	// cpp�汾��д
	// ����:
	//  numbers:     һ����������
	//  length:      ����ĳ���
	//����ֵ:             
	//  ����  - ������Ч�����������д����ظ������֣�����ֵΪ�ظ�������
	//  ����  - ������Ч������������û���ظ�������
	public int getDuplication(int[] numbers, int length) {
		if (numbers == null || length <= 0)
			return -1;

		int start = 1;
		int end = length - 1;
		while (end >= start) {
			int middle = ((end - start) >> 1) + start;
			int count = countRange(numbers, length, start, middle);
			if (end == start) {
				if (count > 1)
					return start;
				else
					break;
			}

			if (count > (middle - start + 1))
				end = middle;
			else
				start = middle + 1;
		}
		return -1;
	}

	public int countRange(int[] numbers, int length, int start, int end) {
		if (numbers == null)
			return 0;

		int count = 0;
		for (int i = 0; i < length; i++)
			if (numbers[i] >= start && numbers[i] <= end)
				++count;
		return count;
	}
}
