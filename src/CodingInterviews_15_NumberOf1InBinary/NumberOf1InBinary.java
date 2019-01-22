package CodingInterviews_15_NumberOf1InBinary;

/*
	������15����������1�ĸ���
		����һ��������������������Ʊ�ʾ��1�ĸ�����
		���и����ò����ʾ��15����������1�ĸ���
 */
public class NumberOf1InBinary {

	// ����������ѭ���Ľⷨ
	public int NumberOf1(int n) {
		int result = 0;
		while (n != 0) {
			result += n & 1;
			n >>>= 1;
		}
		return result;
	}

	// cpp�����д
	// ����ⷨ
	public int NumberOf1_Solution1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	// �ܸ����Թٴ�����ϲ�Ľⷨ
	// n=(n - 1) & n����n���ұߵ�1���0
	public int NumberOf1_Solution2(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
}
