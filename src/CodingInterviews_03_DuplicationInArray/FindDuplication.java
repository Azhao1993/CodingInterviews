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
}
