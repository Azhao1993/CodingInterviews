package CodingInterviews_04_FindInPartiallySortedMatrix;

/*
	������4��	��ά�����еĲ���
	��һ����ά�����У�ÿ��һά����ĳ�����ͬ����
	ÿһ�ж����մ����ҵ�����˳������
	ÿһ�ж����մ��ϵ��µ�����˳������
	�����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
*/
public class FindInPartiallySortedMatrix {
	// ������4��
	public boolean Find(int target, int[][] array) {
		if (array == null || array.length == 0 || array[0].length == 0) {
			return false;
		}
		int col = array.length;
		int row = array[0].length;
		int m = 0;
		int n = row - 1;
		while (m < col && n >= 0) {
			if (array[m][n] == target) {
				return true;
			} else if (array[m][n] < target) {
				m++;
			} else {
				n--;
			}
		}
		return false;
	}
}
