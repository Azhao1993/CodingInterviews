package CodingInterviews_03_DuplicationInArray;

/*
	������3��һ�����ҳ��������ظ�������
		��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�
		������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ�
		���ҳ�����������һ���ظ������֡�
		���磬������볤��Ϊ7������{2, 3, 1, 0, 2, 5, 3}����ô��Ӧ��������ظ�������2����3��
 */
public class FindDuplication {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		int i = 0;
		while (i < length) {
			if (numbers[i] == i) {
				i++;
			} else {
				int temp = numbers[i];
				if (numbers[i] == numbers[temp]) {
					duplication[0] = numbers[i];
					return true;
				} else {
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
			}
		}
		return false;
	}

	// cpp�汾��д

	// ����:
	// numbers: һ����������
	// length: ����ĳ���
	// duplication: (���) �����е�һ���ظ�������
	// ����ֵ:
	// true - ������Ч�����������д����ظ�������
	// false - ������Ч������������û���ظ�������
	public boolean duplicateCppToJava(int[] numbers, int length, int[] duplication) {
		if (numbers == null || length <= 0)
			return false;

		for (int i = 0; i < length; ++i) {
			if (numbers[i] < 0 || numbers[i] > length - 1)
				return false;
		}

		for (int i = 0; i < length; ++i) {
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				}

				// ����numbers[i]��numbers[numbers[i]]
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}

		return false;
	}

}
